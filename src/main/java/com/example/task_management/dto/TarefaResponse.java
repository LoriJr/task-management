package com.example.task_management.dto;

import com.example.task_management.enums.Priority;
import com.example.task_management.enums.Status;

import java.time.LocalDate;

public record TarefaResponse (
        Long id,
        String title,
        String description,
        Status status,
        Priority priority,
        LocalDate endDate,
        LocalDate createdAt
){
}
