package com.adarsh.spring_boot.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducerService {

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<Object, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String topic, String key, Object event) {
        kafkaTemplate.send(topic, key, event);

    }
}
