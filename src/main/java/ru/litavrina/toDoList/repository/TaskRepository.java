package ru.litavrina.toDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.litavrina.toDoList.model.Task;
import ru.litavrina.toDoList.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
