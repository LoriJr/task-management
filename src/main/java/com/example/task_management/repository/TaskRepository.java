package com.example.task_management.repository;

import com.example.task_management.domain.Task;
import com.example.task_management.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByStatus(String status);
    Optional<Task> findById(Long id);
    List<Task> findByEndDate(LocalDate endDate);

}
