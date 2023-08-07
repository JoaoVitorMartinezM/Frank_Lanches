package com.franklanches.services;


import com.franklanches.dto.requests.SalesItemDto;
import com.franklanches.dto.responses.OrderDto;
import com.franklanches.dto.responses.SalesItemResponse;
import com.franklanches.exceptions.ResourceNotFoundException;
import com.franklanches.models.Customer;
import com.franklanches.models.Order;
import com.franklanches.models.SalesItem;
import com.franklanches.repositories.CustomerRepository;
import com.franklanches.repositories.OrderRepository;
import com.franklanches.repositories.ProductRepository;
import com.franklanches.repositories.SalesItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final SalesItemRepository salesItemRepository;
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

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", request.getCustomerId()));

        List<SalesItem> salesItems = request.getSalesItemId().stream().map(item -> salesItemRepository.findById(item).get()).toList();

        Double total = salesItems.stream().mapToDouble(item -> (item.getQuantity() * item.getProduct().getPrice())).sum();

        Order order = mapper.map(request, Order.class);
        order.setTotal(total);
        order.setSalesItems(salesItems);
        order.setCustomer(customer);
        order = repository.save(order);

        OrderDto dto = mapper.map(order, OrderDto.class);

        return dto;
    }

    @Transactional
    public SalesItemResponse placeSalesItem(SalesItemDto request) {
        if(!productRepository.existsById(request.getProductId()))
            throw new ResourceNotFoundException("Produto", request.getProductId().toString());

        SalesItem model = mapper.map(request, SalesItem.class);
        model.setProduct(productRepository.getReferenceById(request.getProductId()));
        model.setId(UUID.randomUUID().toString());
        salesItemRepository.save(model);

        SalesItemResponse dto = mapper.map(model, SalesItemResponse.class);
        return dto;
    }
}
