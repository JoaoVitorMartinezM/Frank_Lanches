package com.franklanches.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, String identifier) {
        super("Recurso " + resource +" com identificador " + identifier + " não encontrado.");
    }
}
