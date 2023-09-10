package com.franklanches.models;


import com.gtbr.domain.Cep;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    private String phone;

    private String name;

    private String address;

    public Customer(String phone, String name, Cep cep) {
        this.phone = phone;
        this.name = name;
        addressBuild(cep);
    }

    public void addressBuild(Cep cep) {
        this.address = cep.getLogradouro() + ", nº"
                + cep.getComplemento()
                + ", " + cep.getBairro()
                + ", " + cep.getLocalidade()
                + " - " + cep.getCep();
    }
}
