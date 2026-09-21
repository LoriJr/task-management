package com.example.task_management.service;

import com.example.task_management.domain.Task;
import com.example.task_management.dto.TaskRequest;
import com.example.task_management.dto.TaskResponse;
import com.example.task_management.exceptions.ValidationFieldsException;
import com.example.task_management.mapper.TaskMapper;
import com.example.task_management.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskResponse addTask(TaskRequest request){
        if(request == null){
            throw new ValidationFieldsException("Fields is required");
        }

        Task task = mapper.toEntity(request);
        task.setCreatedAt(LocalDate.now());

        return mapper.toDto(repository.save(task));
    }

}
