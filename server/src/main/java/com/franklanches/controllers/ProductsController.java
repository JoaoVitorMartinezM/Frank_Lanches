package com.franklanches.controllers;



import com.franklanches.dto.requests.ProductRequest;
import com.franklanches.dto.responses.ProductDto;
import com.franklanches.services.ProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService service;


    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        return ResponseEntity.ok(service.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(service.getProdutById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDto> register(@RequestBody @Valid ProductRequest request){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("api/product").build().toUri();
        return ResponseEntity.created(uri).body(service.register(request));
    }

    @Transactional
    @PutMapping("/edit/{id}")
    public ResponseEntity<ProductDto> edit(@PathVariable Long id, @RequestBody @Valid ProductRequest request){
        return ResponseEntity.ok(service.edit(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteById(id));

    }
}
