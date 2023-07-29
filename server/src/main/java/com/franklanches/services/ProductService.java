package com.franklanches.services;

import com.franklanches.dto.requests.ProductRequest;
import com.franklanches.dto.responses.ProductDto;
import com.franklanches.models.Product;
import com.franklanches.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ModelMapper mapper;

    public ProductDto register(ProductRequest request) {
        Product model = mapper.map(request, Product.class);
        model = repository.save(model);
        ProductDto dto = mapper.map(model, ProductDto.class);
        System.out.println(dto);
        return dto;
    }
}
