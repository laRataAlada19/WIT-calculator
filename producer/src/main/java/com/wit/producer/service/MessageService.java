package com.wit.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${topic.test}")
    private String test;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sum(int a, int b) {
        int sum = a + b;
        logger.info("Sum of {} and {} is {}", a, b, sum);
        this.kafkaTemplate.send(test, "Sum: " + sum);
    }

    public void subtract(int a, int b) {
        int difference = a - b;
        logger.info("Difference of {} and {} is {}", a, b, difference);
        this.kafkaTemplate.send(test, "Difference: " + difference);
    }

    public void multiply(int a, int b) {
        int product = a * b;
        logger.info("Product of {} and {} is {}", a, b, product);
        this.kafkaTemplate.send(test, "Product: " + product);
    }

    public void divide(int a, int b) {
        if (b == 0) {
            logger.error("Division by zero is not allowed.");
            return;
        }
        double quotient = (double) a / b;
        logger.info("Quotient of {} and {} is {}", a, b, quotient);
        this.kafkaTemplate.send(test, "Quotient: " + quotient);
    }
}