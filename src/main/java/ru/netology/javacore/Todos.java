package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private final int sizeAllTasks = 7;
    protected List<String> allTasks = new ArrayList<>();

    public void addTask(String task) {
        if (allTasks.size() < sizeAllTasks) {
            allTasks.add(task);
        }
    }

    public void removeTask(String task) {
        for (String s : allTasks) {
            if (s.equals(task)) {
                allTasks.remove(s);
                break;
            }
        }
    }

    public String getAllTasks() {
        return allTasks.stream().sorted().collect(Collectors.joining(" "));
    }
}
