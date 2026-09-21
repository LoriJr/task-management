package com.example.task_management.dto;

import com.example.task_management.enums.Priority;
import com.example.task_management.enums.Status;

import java.time.LocalDate;

public record TaskRequest(
        String title,
        String description,
        Status status,
        Priority priority,
        LocalDate endDate
) {
}
