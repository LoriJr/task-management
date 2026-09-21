package com.example.task_management.mapper;

import com.example.task_management.domain.Task;
import com.example.task_management.dto.TaskRequest;
import com.example.task_management.dto.TaskResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TaskMapper {

    public TaskResponse toDto(Task entity){
        return new TaskResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getPriority(),
                entity.getEndDate(),
                entity.getCreatedAt()
        );
    }

    public Task toEntity(TaskRequest request){
        return Task.builder()
                .title(request.title())
                .description(request.description())
                .status(request.status())
                .priority(request.priority())
                .endDate(request.endDate())
                .build();
    }
}
