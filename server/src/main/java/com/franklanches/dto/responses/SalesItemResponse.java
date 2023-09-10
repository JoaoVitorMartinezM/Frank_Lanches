package com.franklanches.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.franklanches.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class SalesItemResponse {

    private String id ;
    private Integer quantity;
    private Product product;
    private String details;

}
