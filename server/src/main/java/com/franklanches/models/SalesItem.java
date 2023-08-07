package com.franklanches.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.franklanches.dto.requests.SalesItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SalesItem {

    @Id
    private String id;
    private Float quantity;
    @ManyToOne
    private Product product;
    private String details;
}
