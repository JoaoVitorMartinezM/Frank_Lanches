package com.franklanches.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.franklanches.models.Customer;
import com.franklanches.models.Payment;
import com.franklanches.models.SalesItem;
import com.franklanches.models.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//Alterar para não devolver o customer model inteiro
public class OrdersResponse {
    @NotBlank(message = "{field.required}")
    private String customerId;

    @NotNull(message = "{field.required}")
    private List<SalesItem> salesItems;

    @NotNull(message = "{field.required}")
    private Payment payment;

    @NotNull(message = "{field.required}")
    private Status status;

    private Double total;
}
