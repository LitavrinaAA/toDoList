package ru.litavrina.toDoList.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.litavrina.toDoList.exeption.TasksNoDataFoundException;
import ru.litavrina.toDoList.model.Task;
import ru.litavrina.toDoList.model.TaskStatus;
import ru.litavrina.toDoList.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements iTaskService {
    private final TaskRepository repository;

    /* Создание задачи */
    public Task addTask(Task task) {
        return repository.save(task);
    }

    /* Чтение задач из БД:
     * все задачи, по id, по статусу */

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new TasksNoDataFoundException("NoData found")
        );
    }

    @Override
    public List<Task> getTaskByStatus(TaskStatus status) {
        return repository.findByStatus(status);
    }

    /*обновление задачи*/
    @Override
    public Task updateTaskByStatus(Long id, Task task) {
        Task existingTask = getTaskById(id);
        existingTask.setStatus(task.getStatus());
        existingTask.setCompletionTime(LocalDateTime.now());
        return repository.save(existingTask);
    }

    /*удаление задачи*/
    @Override
    public void deleteTask(long id) {
        Task existedTask = getTaskById(id);
        repository.delete(existedTask);
    }
}
