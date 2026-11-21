package com.example.to_do.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TarefaAtualizacaoDTO(@NotBlank Long id,
                                   @NotBlank String emailUsuario,
                                   String titulo,
                                   String descricao,
                                   LocalDateTime terminaEm) {
}
