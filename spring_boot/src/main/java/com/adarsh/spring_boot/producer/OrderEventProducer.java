package com.adarsh.spring_boot.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.adarsh.spring_boot.events.OrderEvent;
import com.adarsh.spring_boot.kafka.KafkaProducerService;

@Service
public class OrderEventProducer {
    private final KafkaProducerService kafkaProducerService;
    private final String orderCreatedTopic;

    public OrderEventProducer(KafkaProducerService kafkaProducerService,
            @Value("${app.kafka.topics.order-created}") String orderCreatedTopic) {
        this.kafkaProducerService = kafkaProducerService;
        this.orderCreatedTopic = orderCreatedTopic;
    }

    public void sendOrderCreated(OrderEvent event) {
        kafkaProducerService.produce(orderCreatedTopic, event.orderId(), event);
    }
}
