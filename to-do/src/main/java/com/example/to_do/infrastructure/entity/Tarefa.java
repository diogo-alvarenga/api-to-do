package com.example.to_do.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tarefa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="emailUsuario", nullable = false)
    private String emailUsuario;

    @Column(name="titulo", nullable = false)
    private String titulo;

    @Column(name="descricao", nullable = false)
    private String descricao;

    @Column(name="adicionadoEm", nullable = false)
    private LocalDateTime adicionadoEm = LocalDateTime.now();

    @Column(name="atualizadoEm", nullable = false)
    private LocalDateTime atualizadoEm = LocalDateTime.now();

    @Column(name="terminaEm", nullable = false)
    private LocalDateTime terminaEm;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference
    private Usuario usuario;
}
