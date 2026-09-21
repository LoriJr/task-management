package com.example.task_management.exceptions;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime stimestamp,
        int status,
        String message,
        String path
) {
}
