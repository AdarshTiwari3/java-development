package com.adarsh.spring_boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adarsh.spring_boot.dto.OrderCreatedResponse;
import com.adarsh.spring_boot.events.OrderEvent;
import com.adarsh.spring_boot.service.OrderCreationService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/order")
public class OrderCreationController {

    private final OrderCreationService orderCreationService;

    public OrderCreationController(OrderCreationService orderCreationService) {
        this.orderCreationService = orderCreationService;

    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderCreatedResponse> createOrder(@Valid @RequestBody OrderEvent orderEvent) {
        String orderId = orderCreationService.createOrder(orderEvent);
        OrderCreatedResponse response =
                new OrderCreatedResponse(orderId, "Order created successfully", "CREATED");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



}
