package com.example.task_management.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorResponse validationExceptionHandler(MethodArgumentNotValidException ex, HttpServletRequest request){
        LocalDateTime date = LocalDateTime.now();
        int status = HttpStatus.BAD_REQUEST.value();
        String path = request.getRequestURI();

        List<String> messages = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return new ValidationErrorResponse(date, status,messages, path);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorResponse resourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
        LocalDateTime date = LocalDateTime.now();
        int status = HttpStatus.NOT_FOUND.value();
        String path = request.getRequestURI();

        String messages = ex.getMessage();

        return new ErrorResponse(date, status,messages, path);
    }

}
