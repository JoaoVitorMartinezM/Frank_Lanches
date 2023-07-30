package com.franklanches.services;


import com.franklanches.dto.responses.OrderDto;
import com.franklanches.exceptions.ResourceNotFoundException;
import com.franklanches.models.Customer;
import com.franklanches.models.Order;
import com.franklanches.models.Product;
import com.franklanches.repositories.CustomerRepository;
import com.franklanches.repositories.OrderRepository;
import com.franklanches.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    public List<OrderDto> getRequests(){
        List<Order> orders = repository.findAll();
        List<OrderDto> requestsDto = orders.stream()
                .map(order -> mapper.map(order, OrderDto.class))
                .collect(Collectors.toList());

        return requestsDto;
    }
    
    public OrderDto getRequestByID(Long id){
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("Pedido", id.toString());
        Optional<Order> opt = repository.findById(id);
        OrderDto dto = mapper.map(opt, OrderDto.class);
        return dto;
    }

    public OrderDto placeOrder(OrderDto request) {

        Customer customer = customerRepository.findById(request.getCustomerId()).get();

        Product product = productRepository.findById(request.getProductsIds().get(0)).get();

        Order order = mapper.map(request, Order.class);

        order.getProducts().add(product);
        order.setCustomer(customer);

        order = repository.save(order);

        OrderDto dto = mapper.map(order, OrderDto.class);

        return dto;
    }
}
