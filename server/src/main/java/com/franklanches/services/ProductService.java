package com.franklanches.services;

import com.franklanches.dto.requests.ProductRequest;
import com.franklanches.dto.responses.ProductDto;
import com.franklanches.exceptions.ResourceNotFoundException;
import com.franklanches.models.Product;
import com.franklanches.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    @Transactional
    public ProductDto register(ProductRequest request) {
        Product model = mapper.map(request, Product.class);
        model = repository.save(model);
        ProductDto dto = mapper.map(model, ProductDto.class);
        return dto;
    }

    public Boolean deleteById(Long id) {
        if(!repository.existsById(id))
            throw new ResourceNotFoundException("Produto", id.toString());

        repository.deleteById(id);
        return Boolean.TRUE;
    }

    public List<ProductDto> getProducts() {
        List<Product> products = repository.findAll();
        List<ProductDto> productsDto = products.stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());


        return productsDto;
    }

    public ProductDto getProdutById(Long id) {
        if(!repository.existsById(id))
            throw new ResourceNotFoundException("Produto", id.toString());

        Optional<Product> opt = repository.findById(id);
        ProductDto dto = mapper.map(opt, ProductDto.class);
        return dto;
    }

    public ProductDto edit(Long id, ProductRequest request) {
        if(!repository.existsById(id))
            throw new ResourceNotFoundException("Produto", id.toString());

        Product model = repository.getReferenceById(id);

        model.setName(request.getName());
        model.setDescription(request.getDescription());
        model.setPrice(request.getPrice());
        model.setImageUrl(request.getImageUrl());
        repository.save(model);
        ProductDto dto = mapper.map(model, ProductDto.class);

        return dto;
    }
}
