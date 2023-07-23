package com.franklanches.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {


    private Long cep;

    private String street;

    private String neighborhood;

    private String city;

    private String number;

    public String getAddress() {
        return city + ", " + neighborhood + ", " + street + ", Nº" + number;
    }
}

