package com.example.task.flow.controller;

import com.example.task.flow.model.TarefaModel;
import com.example.task.flow.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaRepository tarefaRepository;
    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
    @PostMapping
    public ResponseEntity<TarefaModel> adicionarTarefa(@RequestBody TarefaModel tarefaModel){
        TarefaModel novoTarefaModel = tarefaRepository.save(tarefaModel);
        return ResponseEntity.status(201).body(novoTarefaModel);
    }
    @GetMapping
    public List<TarefaModel> exibirInformacoes(){
        return tarefaRepository.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TarefaModel> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaModel tarefaModel){
        return tarefaRepository.findById(id)
                .map(tarefaExistente -> {
                    tarefaExistente.setTarefa(tarefaExistente.getTarefa());
                    tarefaExistente.setStatus(tarefaExistente.getStatus());
                    TarefaModel atualizado = tarefaRepository.save(tarefaExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
