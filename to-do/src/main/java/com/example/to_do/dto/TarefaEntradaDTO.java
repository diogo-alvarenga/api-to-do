package com.example.to_do.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TarefaEntradaDTO(@NotBlank String titulo,
                               @NotBlank String descricao,
                               @NotBlank LocalDateTime terminaEm) {
}
