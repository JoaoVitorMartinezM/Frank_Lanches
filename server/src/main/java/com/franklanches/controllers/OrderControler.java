package com.franklanches.controllers;

import com.franklanches.dto.responses.OrderDto;
import com.franklanches.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/requests")
@RestController
public class OrderControler {

    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getRequests(){
        return ResponseEntity.ok(service.getRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getRequestById(@PathVariable Long id){
        return ResponseEntity.ok(service.getRequestByID(id));
    }

    @PostMapping
    public OrderDto register(@RequestBody @Valid OrderDto request){
        return service.placeOrder(request);
    }
}
