package com.franklanches.repositories;

import com.franklanches.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


    boolean existsByCepAndNumber(Long cep, String number);
}
