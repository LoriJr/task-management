package com.example.task_management.domain;

import com.example.task_management.enums.Priority;
import com.example.task_management.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Status status;
    private Priority priority;
    private LocalDate endDate;
    private LocalDate startDate;
}
