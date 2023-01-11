package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private static final int SIZE_ALL_TASKS = 7;
    protected List<String> allTasks = new ArrayList<>();

    public void addTask(String task) {
        if (allTasks.size() < SIZE_ALL_TASKS) {
            allTasks.add(task);
        }
    }

    public void removeTask(String task) {
        for (String job : allTasks) {
            if (job.equals(task)) {
                allTasks.remove(job);
                break;
            }
        }
    }

    public String getAllTasks() {
        return allTasks.stream().sorted().collect(Collectors.joining(" "));
    }
}
