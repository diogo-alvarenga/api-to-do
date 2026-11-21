package com.example.to_do.dto;

import lombok.Builder;

@Builder
public record UsuarioAtualizacaoDTO(String nome, String email, String senha) {
}
