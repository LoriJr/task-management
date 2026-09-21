package com.example.task_management.dto;

import com.example.task_management.enums.Priority;
import com.example.task_management.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskRequest(

        @NotBlank(message = "Title is required")
        @Size(max = 300, message = "Title should be max 100 character")
        String title,

        @NotBlank(message = "Description is required")
        @Size(max = 500, message = "Description should be max 500 character")
        String description,

        @NotBlank(message = "Status is required")
        Status status,

        @NotBlank(message = "Priority is required")
        Priority priority,

        @NotBlank(message = "EndDate is required")
        LocalDate endDate
) {
}
