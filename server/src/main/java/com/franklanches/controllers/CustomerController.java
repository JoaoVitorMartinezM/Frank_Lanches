package com.franklanches.controllers;

import com.franklanches.dto.requests.CustomerRequest;
<<<<<<< HEAD
=======
import com.franklanches.dto.responses.CustomerResponse;
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
import com.franklanches.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
<<<<<<< HEAD

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
=======
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
public class CustomerController {

    private final CustomerService service;


<<<<<<< HEAD
    @CrossOrigin
=======
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers(){
        return ResponseEntity.ok(service.getCustomers());
    }

    @GetMapping("{phone}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable String phone){
        return ResponseEntity.ok(service.getCustomerById(phone));
    }

>>>>>>> 34651a8d87d07169c4e4922cbea3d96044974544
    @PostMapping
    public ResponseEntity<Boolean> register(@RequestBody @Valid CustomerRequest request){
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8080").path("api/customer").build().toUri();
        return ResponseEntity.created(uri).body(service.register(request));
    }
}
