package com.adarsh.spring_boot.service;

import org.springframework.stereotype.Service;
import com.adarsh.spring_boot.events.OrderEvent;
import com.adarsh.spring_boot.producer.OrderEventProducer;

@Service
public class OrderCreationService {
    private final OrderEventProducer orderEventProducer;



    public OrderCreationService(OrderEventProducer orderEventProducer) {
        this.orderEventProducer = orderEventProducer;
    }

    public String createOrder(OrderEvent orderEvent) {
        orderEventProducer.sendOrderCreated(orderEvent);
        return orderEvent.orderId();
    }
}
