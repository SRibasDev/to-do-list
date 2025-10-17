package com.example.task.flow.controller;

import com.example.task.flow.model.TaskModel;
import com.example.task.flow.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TaskController {

    private final TaskRepository taskRepository;
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @PostMapping
    public ResponseEntity<TaskModel> adicionarTarefa(@RequestBody TaskModel taskModel){
        TaskModel novoTaskModel = taskRepository.save(taskModel);
        return ResponseEntity.status(201).body(novoTaskModel);
    }
    @GetMapping
    public List<TaskModel> exibirInformacoes(){
        return taskRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> atualizarTarefa(@PathVariable Long id, @RequestBody TaskModel taskModel){
        return taskRepository.findById(id)
                .map(tarefaExistente -> {
                    tarefaExistente.setTarefa(tarefaExistente.getTarefa());
                    tarefaExistente.setStatus(tarefaExistente.getStatus());
                    TaskModel atualizado = taskRepository.save(tarefaExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
