package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos todos = new Todos();
    String task = "Task";

    @Test
    public void addTaskTest() {
        todos.addTask(task);
        int sizeTasksExpected = 1;

        Assertions.assertEquals(sizeTasksExpected, todos.setTasks.size());
    }

    @Test
    public void removeTaskTest() {
        todos.addTask(task);
        todos.removeTask(task);
        int sizeTasksExpected = 0;

        Assertions.assertEquals(sizeTasksExpected, todos.setTasks.size());
    }

    @Test
    public void maxSizeTasksTest() {
        int sizeTasksExpected = 7;
        for (int i = 0; i < sizeTasksExpected + 1; i++) {
            todos.addTask(task + i);
        }
        Assertions.assertEquals(sizeTasksExpected, todos.setTasks.size());
    }
}
