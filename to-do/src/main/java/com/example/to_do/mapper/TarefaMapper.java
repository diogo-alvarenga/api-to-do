package com.example.to_do.mapper;

import com.example.to_do.dto.TarefaAtualizacaoDTO;
import com.example.to_do.infrastructure.entity.Tarefa;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class TarefaMapper {

    public Tarefa atualizarTarefa(TarefaAtualizacaoDTO atl, Tarefa tarefaAntiga){
        return Tarefa.builder()
                .id(tarefaAntiga.getId())
                .atualizadoEm(LocalDateTime.now())
                .titulo(atl.titulo()!=null?atl.titulo(): tarefaAntiga.getTitulo())
                .descricao(atl.descricao()!=null? atl.descricao() : tarefaAntiga.getDescricao())
                .adicionadoEm(tarefaAntiga.getAdicionadoEm())
                .terminaEm(atl.terminaEm()!=null?atl.terminaEm(): tarefaAntiga.getTerminaEm())
                .emailUsuario(atl.emailUsuario())
                .build();
    }
}
