package com.example.task_management.service;

import com.example.task_management.domain.Task;
import com.example.task_management.dto.TaskRequest;
import com.example.task_management.dto.TaskResponse;
import com.example.task_management.enums.Status;
import com.example.task_management.exceptions.ResourceNotFoundException;
import com.example.task_management.mapper.TaskMapper;
import com.example.task_management.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskResponse addTask(TaskRequest request){

        Task task = mapper.toEntity(request);
        task.setCreatedAt(LocalDate.now());

        return mapper.toDto(repository.save(task));
    }

    /*buscar tarefa por ID
    * GET /tarefa/{id}
    */
    public TaskResponse findById(Long id){
        Task task = repository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Resource Not Found with id: " + id));
        return mapper.toDto(task);
    }

    /*
    * Listar tarefas
    * GET /tarefas
    * */
    public List<TaskResponse> taskList(){
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /*
    * Filtrar Tarefas por status
    * GET /tarefas?status=DONE
    * */
    public List<TaskResponse> listStatus(String status){
        return repository.findByStatus(status)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /*
    * Listar Tarefas por data de vencimento
    * GET /tarefas/data?data=2026-09-30
    * */
    public List<TaskResponse> listByEndDate(LocalDate endDate){
        return repository.findByEndDate(endDate)
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    /*
    * Atualizar Tarefa
    * PUT /tarefas/{id}*/

    /*
    * Excluir Tarefa
    * DELETE /tarefas/{id}
    * */

}
