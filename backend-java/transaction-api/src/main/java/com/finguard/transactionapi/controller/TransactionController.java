package com.finGuard.transactionapi.controller;

import com.finGuard.transactionapi.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "transactions";

    @PostMapping
    public String ingestTransaction(@RequestBody Transaction tx) {
        kafkaTemplate.send(TOPIC, tx.getId(), tx.toJson());
        return "{\"status\": \"ok\", \"tx_id\": \"" + tx.getId() + "\"}";
    }
}
