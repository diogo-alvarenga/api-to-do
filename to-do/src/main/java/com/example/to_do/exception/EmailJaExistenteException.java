package com.example.to_do.exception;

public class EmailJaExistenteException extends RuntimeException {
    public EmailJaExistenteException() {
        super("Email já cadastrado.");
    }
}
