package com.franklanches.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long cep;

    private String street;

    private String neighborhood;

    private String city;

    private String number;

    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;

}

