package com.example.task_management.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationFieldsException.class)
    public ErrorResponse validationExceptionHandler(ValidationFieldsException ex, HttpServletRequest request){
        LocalDateTime date = LocalDateTime.now();
        int status = HttpStatus.BAD_REQUEST.value();
        String message = ex.getMessage();
        String path = request.getRequestURI();

        return new ErrorResponse(date, status,message, path);
    }

}
