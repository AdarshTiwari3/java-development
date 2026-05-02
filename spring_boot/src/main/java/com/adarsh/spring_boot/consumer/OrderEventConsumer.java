package com.adarsh.spring_boot.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.adarsh.spring_boot.events.OrderEvent;


@Component
public class OrderEventConsumer {
    @KafkaListener(topics = "${app.kafka.topics.order-created}")
    public void consume(OrderEvent orderEvent) {
        System.out.println("\n\nConsumed order: " + orderEvent.orderId());
    }
}
