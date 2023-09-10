package com.franklanches.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
=======
import jakarta.validation.constraints.Pattern;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Float price;

<<<<<<< HEAD
=======
    @Pattern(regexp = "^(http|https)://(.*)", message = "Url inválida")
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
    private String imageUrl;

}
