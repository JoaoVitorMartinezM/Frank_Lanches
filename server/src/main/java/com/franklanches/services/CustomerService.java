package com.franklanches.services;


import com.franklanches.dto.requests.CustomerRequest;
import com.franklanches.exceptions.CepNotExistsException;
import com.franklanches.dto.AddressDto;
import com.franklanches.dto.requests.CustomerRequest;
import com.franklanches.dto.responses.CustomerResponse;
import com.franklanches.exceptions.CepNotExistsException;
import com.franklanches.exceptions.ResourceNotFoundException;
import com.franklanches.models.Address;
import com.franklanches.models.Customer;
import com.franklanches.repositories.CustomerRepository;
import com.gtbr.ViaCepClient;
import com.gtbr.utils.CEPUtils;
import com.gtbr.domain.Cep;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final AddressService addressService;
    private final ModelMapper mapper;




    @Transactional
    public Boolean register(@Valid CustomerRequest request) {
        AddressDto addressDto = AddressDto
                .builder()
                .cep(request.cep())
                .number(request.number())
                .build();

        Address address = addressService.register(addressDto);

        Customer customer = new Customer(request.phone(), request.name(), List.of(address));
        repository.save(customer);

        return Boolean.TRUE;
    }

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
}
