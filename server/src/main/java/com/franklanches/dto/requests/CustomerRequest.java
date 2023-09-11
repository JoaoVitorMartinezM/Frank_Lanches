package com.franklanches.dto.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record CustomerRequest(
        @NotBlank(message = "{field.required}")
        String name,
        @NotBlank(message = "{field.required}")
        String phone,
        @NotNull(message = "{field.required}")
        Long cep,
        @NotBlank(message = "{field.required}")
        String number
) {
}
