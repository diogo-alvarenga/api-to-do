package com.example.to_do.mapper;

import com.example.to_do.dto.UsuarioAtualizacaoDTO;
import com.example.to_do.dto.UsuarioEntradaDTO;
import com.example.to_do.dto.UsuarioSaidaDTO;
import com.example.to_do.infrastructure.entity.Usuario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public Usuario toEntity(UsuarioEntradaDTO entrada){
        return Usuario.builder()
                .email(entrada.email())
                .nome(entrada.nome())
                .build();
    }

    public UsuarioSaidaDTO toDto(Usuario usuario){
        return UsuarioSaidaDTO.builder()
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .id(usuario.getId())
                .build();
    }

    public Usuario atualizar(UsuarioAtualizacaoDTO atl, Usuario usuario){
        return Usuario.builder()
                .email(atl.email()!=null?atl.email():usuario.getEmail())
                .nome(atl.nome()!=null?atl.nome():usuario.getNome())
                .id(usuario.getId())
                .build();
    }
}
