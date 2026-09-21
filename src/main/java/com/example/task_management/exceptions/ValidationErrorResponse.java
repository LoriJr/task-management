package com.example.task_management.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
        LocalDateTime stimestamp,
        int status,
        List<String> message,
        String path
) {
}
