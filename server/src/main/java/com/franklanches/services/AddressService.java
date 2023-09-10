package com.franklanches.services;


import com.franklanches.dto.AddressDto;
import com.franklanches.exceptions.AddressAlreadyRegisteredException;
import com.franklanches.exceptions.CepNotExistsException;
import com.franklanches.models.Address;
import com.franklanches.repositories.AddressRepository;
import com.gtbr.ViaCepClient;
import com.gtbr.domain.Cep;
import com.gtbr.utils.CEPUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;
    private final ModelMapper mapper;

    public Address register(AddressDto dto){
        String cep = dto.getCep().toString();
        CEPUtils.validaCep(cep);
        Cep address = ViaCepClient.findCep(cep);
        if (address.getCep() == null)
            throw new CepNotExistsException(cep);
        if (repository.existsByCepAndNumber(dto.getCep(), dto.getNumber()))
            throw new AddressAlreadyRegisteredException(cep, dto.getNumber());

        dto.setCity(address.getLocalidade());
        dto.setNeighborhood(address.getBairro());
        dto.setStreet(address.getLogradouro());

        Address model = repository.save(mapper.map(dto, Address.class));


        return model;

    }
}
