package com.franklanches.dto.responses;


import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.franklanches.models.Payment;
import com.franklanches.models.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    @NotBlank(message = "{field.required}")
    private String customerId;

    @NotNull(message = "{field.required}")
    private List<String> salesItemIds = new ArrayList<>();

    @NotNull(message = "{field.required}")
    private Payment payment;

    @NotNull(message = "{field.required}")
    private Status status;

    private Double total;
}
