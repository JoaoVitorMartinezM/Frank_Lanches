package com.franklanches.controllers;

import com.franklanches.dto.requests.ProductRequest;
import com.franklanches.dto.responses.ProductDto;
import com.franklanches.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService service;


    @PostMapping
    public ResponseEntity<ProductDto> register(@RequestBody @Valid ProductRequest request){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("api/product").build().toUri();
        return ResponseEntity.created(uri).body(service.register(request));
    }
}
