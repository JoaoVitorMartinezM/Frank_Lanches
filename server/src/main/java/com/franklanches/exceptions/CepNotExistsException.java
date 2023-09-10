package com.franklanches.exceptions;

public class CepNotExistsException extends RuntimeException {
    public CepNotExistsException(String identificador) {
        super("Recurso CEP" + " com identificador " + identificador + " não encontrado!");
    }
}
