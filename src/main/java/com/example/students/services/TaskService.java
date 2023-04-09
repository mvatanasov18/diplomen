package com.example.students.services;

import com.example.students.models.Task;
import com.example.students.repositories.TaskRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class TaskService implements Service<Task>{

    private final TaskRepository taskRepository;

    @Override
    public Task save(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public void delete(Task entity) {
        taskRepository.delete(entity);
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }


}
