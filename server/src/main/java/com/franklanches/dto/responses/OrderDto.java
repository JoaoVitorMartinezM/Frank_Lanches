package com.franklanches.dto.responses;


import com.franklanches.models.Payment;
import com.franklanches.models.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String customerId;

    private List<Long> productsIds;

    private Payment payment;

    private Status status;

    private String details;
}
