package com.finGuard.transactionapi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transaction {
    private String id;
    private String userId;
    private double amount;
    private String currency;
    private int mcc;
    private String timestamp;

    // Getters and setters omitted for brevity

    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
