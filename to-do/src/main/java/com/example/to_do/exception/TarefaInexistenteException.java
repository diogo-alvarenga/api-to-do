package com.example.to_do.exception;

public class TarefaInexistenteException extends RuntimeException {
    public TarefaInexistenteException() {
        super("Tarefa inexistente.");
    }
}
