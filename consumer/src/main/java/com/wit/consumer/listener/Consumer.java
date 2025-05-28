package com.wit.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${topic.test}", groupId = "group_id") //vai buscar todas as mensagens do topico
    public void consume(String message) throws IOException {
        logger.info(String.format("### Consuming message -> %s", message));
    }
}