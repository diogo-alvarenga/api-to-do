package com.example.to_do.infrastructure.repository;

import com.example.to_do.infrastructure.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    List<Tarefa> findAllByUsuarioEmail(String email);}
