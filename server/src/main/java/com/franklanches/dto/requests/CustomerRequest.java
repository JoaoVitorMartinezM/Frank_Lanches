package com.franklanches.dto.requests;

import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        @NotNull(message = "Nome não pode ser nulo")
        String nome,
        @NotNull(message = "Telefone não pode ser nulo")
        String phone,
        @NotNull(message = "CEP não pode ser nulo")
        Long cep,
        @NotNull(message = "Número da casa não pode ser nulo")
        String number
) {
}
