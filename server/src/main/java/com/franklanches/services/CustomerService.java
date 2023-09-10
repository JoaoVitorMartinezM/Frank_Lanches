package com.franklanches.services;


<<<<<<< HEAD
import com.franklanches.dto.requests.CustomerRequest;
import com.franklanches.exceptions.CepNotExistsException;
=======
import com.franklanches.dto.AddressDto;
import com.franklanches.dto.requests.CustomerRequest;
import com.franklanches.dto.responses.CustomerResponse;
import com.franklanches.exceptions.CepNotExistsException;
import com.franklanches.exceptions.ResourceNotFoundException;
import com.franklanches.models.Address;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
import com.franklanches.models.Customer;
import com.franklanches.repositories.CustomerRepository;
import com.gtbr.ViaCepClient;
import com.gtbr.utils.CEPUtils;

import com.gtbr.domain.Cep;
<<<<<<< HEAD
=======
import jakarta.transaction.Transactional;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
<<<<<<< HEAD
=======
    private final AddressService addressService;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
    private final ModelMapper mapper;



<<<<<<< HEAD
    public Boolean register(@Valid CustomerRequest request) {

        CEPUtils.validaCep(request.cep().toString());
        Cep cep = ViaCepClient.findCep(request.cep().toString());
        if (cep.getCep() == null)
            throw new CepNotExistsException(request.cep().toString());

        cep.setComplemento(request.number());
        Customer customer = new Customer(request.phone(), request.name(), cep);
=======
    @Transactional
    public Boolean register(@Valid CustomerRequest request) {
        AddressDto addressDto = AddressDto
                .builder()
                .cep(request.cep())
                .number(request.number())
                .build();

        Address address = addressService.register(addressDto);

        Customer customer = new Customer(request.phone(), request.name(), List.of(address));
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
        repository.save(customer);

        return Boolean.TRUE;
    }
<<<<<<< HEAD
=======

    public CustomerResponse getCustomerById(String phone) {
        if (!repository.existsById(phone))
            throw new ResourceNotFoundException("Cliente", phone);
        CustomerResponse dto = mapper.map(repository.findById(phone).get(), CustomerResponse.class);
        return dto;
    }


    public List<CustomerResponse> getCustomers() {
        List<Customer> customerList = repository.findAll();
        List<CustomerResponse> customerResponseList = customerList.stream()
                .map(customer -> mapper.map(customer, CustomerResponse.class))
                .toList();
        return customerResponseList;
    }
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
}
