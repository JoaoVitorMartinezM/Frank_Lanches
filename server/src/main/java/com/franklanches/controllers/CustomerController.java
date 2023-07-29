package com.franklanches.controllers;

import com.franklanches.dto.requests.CustomerRequest;
import com.franklanches.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;


    @CrossOrigin
    @PostMapping
    public ResponseEntity<Boolean> register(@RequestBody @Valid CustomerRequest request){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("api/customer").build().toUri();
        return ResponseEntity.created(uri).body(service.register(request));
    }
}
