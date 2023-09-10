package com.franklanches.models;


import com.gtbr.domain.Cep;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class  Customer {

    @Id
    private String phone;

    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Address> addresses;


}
