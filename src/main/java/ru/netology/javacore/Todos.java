package ru.netology.javacore;

import java.util.Set;
import java.util.TreeSet;

public class Todos {
    private static final int SIZE_ALL_TASKS = 7;
    protected Set<String> setTasks = new TreeSet<>();

    public void addTask(String task) {
        if (setTasks.size() < SIZE_ALL_TASKS) {
            setTasks.add(task);
        }
    }

    public void removeTask(String task) {
        setTasks.remove(task);
    }

    public String getAllTasks() {
        return String.join(" ", setTasks);
    }
}
