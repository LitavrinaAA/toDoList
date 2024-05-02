package ru.litavrina.toDoList.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.litavrina.toDoList.model.Task;
import ru.litavrina.toDoList.model.TaskStatus;
import ru.litavrina.toDoList.service.TaskServiceImpl;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    public final TaskServiceImpl service;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getAllTasks(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return service.getTaskByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id,
                                 @RequestBody Task task) {
        return service.updateTaskByStatus(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }


}
