package com.franklanches.models;


import com.gtbr.domain.Cep;
<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import java.util.List;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
<<<<<<< HEAD
public class Customer {
=======
@Builder
public class  Customer {
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544

    @Id
    private String phone;

    private String name;

<<<<<<< HEAD
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
=======

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Address> addresses;


>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
}
