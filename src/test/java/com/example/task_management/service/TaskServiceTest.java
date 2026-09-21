package com.example.task_management.service;

import com.example.task_management.domain.Task;
import com.example.task_management.dto.TaskRequest;
import com.example.task_management.dto.TaskResponse;
import com.example.task_management.enums.Priority;
import com.example.task_management.enums.Status;
import com.example.task_management.mapper.TaskMapper;
import com.example.task_management.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository repository;

    @Mock
    private TaskMapper mapper;

    @InjectMocks
    private TaskService service;

    @Test
    @DisplayName("Deve salvar tarefa")
    public void shouldSaveTask(){

        TaskRequest request = new TaskRequest(
                "titulo tarefa",
                "descricao tarefa",
                Status.IN_PROGRESS,
                Priority.HIGH,
                LocalDate.of(2026,9,30)
        );

        Task task = new Task();
        TaskResponse response = new TaskResponse(
                1L,
                "titulo tarefa",
                "descricao tarefa",
                Status.IN_PROGRESS,
                Priority.HIGH,
                LocalDate.of(2026,9,30),
                LocalDate.now()
        );

        when(mapper.toEntity(request)).thenReturn(task);
        when(mapper.toDto(task)).thenReturn(response);
        when(repository.save(task)).thenReturn(task);

        TaskResponse result = service.addTask(request);

        assertNotNull(result);
        assertEquals(Status.IN_PROGRESS, result.status());

        verify(repository, times(1)).save(task);

    }
}
