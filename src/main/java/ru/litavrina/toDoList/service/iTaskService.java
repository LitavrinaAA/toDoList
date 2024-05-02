package ru.litavrina.toDoList.service;

import ru.litavrina.toDoList.model.Task;
import ru.litavrina.toDoList.model.TaskStatus;

import java.util.List;

public interface iTaskService {
    List<Task> getAllTasks();

    Task getTaskById(long id);

    Task addTask(Task task);

    Task updateTaskByStatus(Long id, Task task);

    List<Task> getTaskByStatus(TaskStatus status);

    void deleteTask(long id);
}
