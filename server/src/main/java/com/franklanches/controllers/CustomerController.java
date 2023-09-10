package com.franklanches.controllers;

import com.franklanches.dto.requests.CustomerRequest;
import com.franklanches.dto.responses.CustomerResponse;
import com.franklanches.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;


    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers(){
        return ResponseEntity.ok(service.getCustomers());
    }

    @GetMapping("{phone}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String phone){
        return ResponseEntity.ok(service.getCustomerById(phone));
    }

    @PostMapping
    public ResponseEntity<Boolean> register(@RequestBody @Valid CustomerRequest request){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("api/customer").build().toUri();
        return ResponseEntity.created(uri).body(service.register(request));
    }
}
