package com.franklanches.models;

<<<<<<< HEAD
=======
import jakarta.persistence.*;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {


=======
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
    private Long cep;

    private String street;

    private String neighborhood;

    private String city;

    private String number;

<<<<<<< HEAD
    public String getAddress() {
        return city + ", " + neighborhood + ", " + street + ", Nº" + number;
    }
=======
    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;

>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
}

