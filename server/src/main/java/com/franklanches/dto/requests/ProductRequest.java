package com.franklanches.dto.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    @NotBlank(message = "{field.required}")
    private String name;
    @NotBlank(message = "{field.required}")
    private String description;

    //        @NotNull(message = "{field.required}")
    private Float price;
    @NotBlank(message = "{field.required}")
    private String imageUrl;
}
