package com.franklanches.services;


import com.franklanches.dto.requests.CustomerRequest;
import com.franklanches.exceptions.CepNotExistsException;
import com.franklanches.models.Customer;
import com.franklanches.repositories.CustomerRepository;
import com.gtbr.ViaCepClient;
import com.gtbr.utils.CEPUtils;

import com.gtbr.domain.Cep;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final ModelMapper mapper;



    public Boolean register(@Valid CustomerRequest request) {

        CEPUtils.validaCep(request.cep().toString());
        Cep cep = ViaCepClient.findCep(request.cep().toString());
        if (cep.getCep() == null)
            throw new CepNotExistsException(request.cep().toString());

        cep.setComplemento(request.number());
        Customer customer = new Customer(request.phone(), request.name(), cep);
        repository.save(customer);

        return Boolean.TRUE;
    }
}
