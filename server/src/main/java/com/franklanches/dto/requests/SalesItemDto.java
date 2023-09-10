package com.franklanches.dto.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesItemDto {

    private Integer quantity;
    private Long productId;
    private String details;

}
