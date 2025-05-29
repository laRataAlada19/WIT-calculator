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

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String testTopic;

    public MessageService(KafkaTemplate<String, String> kafkaTemplate,
                          @Value("${topic.test}") String testTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.testTopic = testTopic;
    }

    public void sum(int a, int b) {
        int sum = a + b;
        logger.info("Sum of {} and {} is {}", a, b, sum);
        this.kafkaTemplate.send(testTopic, "Sum: " + sum);
    }

    public void subtract(int a, int b) {
        int difference = a - b;
        logger.info("Difference of {} and {} is {}", a, b, difference);
        this.kafkaTemplate.send(testTopic, "Difference: " + difference);
    }

    public void multiply(int a, int b) {
        int product = a * b;
        logger.info("Product of {} and {} is {}", a, b, product);
        this.kafkaTemplate.send(testTopic, "Product: " + product);
    }

    public void divide(int a, int b) {
        if (b == 0) {
            logger.error("Division by zero is not allowed.");
            return;
        }
        double quotient = (double) a / b;
        logger.info("Quotient of {} and {} is {}", a, b, quotient);
        this.kafkaTemplate.send(testTopic, "Quotient: " + quotient);
    }
}