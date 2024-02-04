package br.com.study.vendasproject.exception;

public class ClienteCannotBeDeletedException extends RuntimeException {

    public ClienteCannotBeDeletedException(String message) {
        super(message);
    }
}