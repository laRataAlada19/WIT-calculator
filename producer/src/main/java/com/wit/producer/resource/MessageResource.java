package com.wit.producer.resource;

import com.wit.producer.service.MessageService;
import org.apache.kafka.common.protocol.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MessageResource {
    @Autowired
    private MessageService messageService;

    @PostMapping("/sum")
    public ResponseEntity<String> sum(@RequestParam("a") int a, @RequestParam("b") int b) {
        messageService.sum(a, b);
        return ResponseEntity.ok("Sum sent successfully, " + a + " + " + b + " = " + (a + b));
    }

    @PostMapping("/subtract")
    public ResponseEntity<String> subtract(@RequestParam("a") int a, @RequestParam("b") int b) {
        messageService.subtract(a, b);
        return ResponseEntity.ok("Difference sent successfully, " + a + " - " + b + " = " + (a - b));
    }

    @PostMapping("/multiply")
    public ResponseEntity<String> multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        messageService.multiply(a, b);
        return ResponseEntity.ok("Product sent successfully, " + a + " * " + b + " = " + (a * b));
    }

    @PostMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam("a") int a, @RequestParam("b") int b) {
        messageService.divide(a, b);
        return ResponseEntity.ok("Quotient sent successfully, " + a + " / " + b + " = " + (b != 0 ? (double) a / b : "undefined (division by zero)"));
    }
}