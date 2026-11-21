package com.example.to_do.dto;

import lombok.*;


@Builder
public record UsuarioSaidaDTO(Long id, String nome, String email) {
}
