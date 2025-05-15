package com.justingrosu.mybank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Transaction {

    private final int amount;
    private final LocalDateTime timestamp;
    private final String reference;
    private final String slogan;
    private final String id;

    public Transaction(final String id, final int amount, final LocalDateTime timestamp, final String reference, String slogan) {
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
        this.reference = reference;
        this.slogan = slogan;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getReference() {
        return reference;
    }

    public String getId() {
        return id;
    }

    @JsonProperty("bank_slogan")
    public String getSlogan() {
        return slogan;
    }
}
