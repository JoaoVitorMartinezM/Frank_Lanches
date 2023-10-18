package com.franklanches.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProductWithObservations(
        @NotBlank(message = "{field.required}")
        String name,
        @NotBlank(message = "{field.required}")
        String description,
        @NotBlank(message = "{field.required}")
        Double price,
        @NotBlank(message = "{field.required}")
        @Pattern(regexp = "^(http|https)://(.*)")
        String imageUrl,

        String observations
) {
}
