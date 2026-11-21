package com.example.to_do.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UsuarioEntradaDTO(@NotBlank String nome,
                                @NotBlank String email,
                                @NotBlank String senha) {
}
