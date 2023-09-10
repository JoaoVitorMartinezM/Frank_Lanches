package com.franklanches.dto.requests;

<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
import jakarta.validation.constraints.NotNull;


public record CustomerRequest(
<<<<<<< HEAD
        @NotNull(message = "Nome não pode ser nulo")
        String name,
        @NotNull(message = "Telefone não pode ser nulo")
        String phone,
        @NotNull(message = "CEP não pode ser nulo")
        Long cep,
        @NotNull(message = "Número da casa não pode ser nulo")
=======
        @NotBlank(message = "{field.required}")
        String name,
        @NotBlank(message = "{field.required}")
        String phone,
        @NotNull(message = "{field.required}")
        Long cep,
        @NotBlank(message = "{field.required}")
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
        String number
) {
}
