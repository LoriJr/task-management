package com.example.task_management.controller;

import com.example.task_management.dto.TaskRequest;
import com.example.task_management.dto.TaskResponse;
import com.example.task_management.enums.Status;
import com.example.task_management.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskResponse> addTask(@Valid @RequestBody TaskRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addTask(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> listById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> listAll(){
        return ResponseEntity.ok().body(service.taskList());
    }

//    @GetMapping("/status")
//    public ResponseEntity<List<TaskResponse>> listByStatus(@RequestParam String status){
//        return ResponseEntity.ok().body(service.listStatus(status));
//    }

    @GetMapping("/endDate")
    public ResponseEntity<List<TaskResponse>> listByEndDate(@RequestParam LocalDate endDate){
        return ResponseEntity.ok().body(service.listByEndDate(endDate));
    }
}
