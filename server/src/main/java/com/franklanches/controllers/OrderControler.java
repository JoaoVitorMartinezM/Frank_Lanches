package com.franklanches.controllers;

import com.franklanches.dto.requests.SalesItemDto;
import com.franklanches.dto.responses.OrderDto;
import com.franklanches.dto.responses.OrdersResponse;
import com.franklanches.dto.responses.SalesItemResponse;
import com.franklanches.models.SalesItem;
import com.franklanches.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderControler {

    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getRequests(){
        return ResponseEntity.ok(service.getRequests());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getRequestById(@PathVariable Long id){
        return ResponseEntity.ok(service.getRequestByID(id));
    }

    @PostMapping("/sales")
    public ResponseEntity<SalesItemResponse> registerSalesItem(@RequestBody @Valid SalesItemDto request){
        return ResponseEntity.ok(service.placeSalesItem(request));
    }

    @PostMapping
    public ResponseEntity<OrdersResponse> registerOrder(@RequestBody @Valid OrderDto request){
        return ResponseEntity.ok(service.placeOrder(request));
    }



}
