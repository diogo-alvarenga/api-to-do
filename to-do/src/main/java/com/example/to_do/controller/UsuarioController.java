package com.example.to_do.controller;

import com.example.to_do.business.UsuarioService;
import com.example.to_do.dto.UsuarioAtualizacaoDTO;
import com.example.to_do.dto.UsuarioEntradaDTO;
import com.example.to_do.dto.UsuarioSaidaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioSaidaDTO> adicionarUsuario(@Valid @RequestBody UsuarioEntradaDTO entrada) {
        UsuarioSaidaDTO saida = service.adicionarUsuario(entrada);

        return ResponseEntity.status(HttpStatus.CREATED).body(saida);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSaidaDTO> buscarUsuario(@PathVariable Long id) {
        UsuarioSaidaDTO saida = service.buscarUsuario(id);

        return ResponseEntity.ok(saida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
        service.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioSaidaDTO> atualizarUsuario(@Valid @RequestBody UsuarioAtualizacaoDTO entrada, @PathVariable Long id) {
        UsuarioSaidaDTO saida = service.atualizarUsuario(entrada, id);

        return ResponseEntity.ok(saida);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioSaidaDTO>> listarUsuarios() {
        return ResponseEntity.ok(service.listarTodos());
    }
}
