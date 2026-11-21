package com.example.to_do.controller;

import com.example.to_do.business.TarefaService;
import com.example.to_do.dto.TarefaAtualizacaoDTO;
import com.example.to_do.infrastructure.entity.Tarefa;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService service;

    @PostMapping
    public ResponseEntity<Tarefa> adicionarTarefa(@Valid @RequestBody Tarefa tarefa){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarTarefa(tarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarTarefa(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id){
        service.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Tarefa>  atualizarTarefa(@Valid @RequestBody TarefaAtualizacaoDTO atl){
        return ResponseEntity.ok(service.atualizarTarefa(atl));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefa(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{email}")
    public ResponseEntity<List<Tarefa>> buscarTarefaPorEmail(@PathVariable String email){
        return ResponseEntity.ok(service.listarTodasTarefasPorEmail(email));
    }
}
