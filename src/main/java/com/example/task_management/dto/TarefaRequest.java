package com.example.task_management.dto;

import com.example.task_management.enums.Status;

import java.time.LocalDate;

public record TarefaRequest(
        String title,
        String description,
        Status status,
        LocalDate endDate
) {
}
