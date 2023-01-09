package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;

public class TodoServer {
    protected int port;
    protected Todos todos;
    protected Deque<Request> requestsDeq = new ArrayDeque<>();

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        System.out.println("Starting server at " + port + " port.");
        try (ServerSocket serverSocket = new ServerSocket(port)) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream())
                ) {
                    String strRequest = in.readLine();
                    Request request = gson.fromJson(strRequest, Request.class);
                    processing(request);
                    out.println((todos.getAllTasks()));
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

    public void processing(Request request){
        switch (request.getType()){
            case "ADD":
                todos.addTask(request.getTask());
                requestsDeq.offerLast(request);
                break;
            case "REMOVE":
                todos.removeTask(request.getTask());
                requestsDeq.offerLast(request);
                break;
            case "RESTORE":
                request = requestsDeq.pollLast();
                if(request.getType().equals("ADD")){
                    todos.removeTask(request.getTask());
                } else{
                    todos.addTask(request.getTask());
                }
                break;
        }
    }
}
