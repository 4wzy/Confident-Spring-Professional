package com.justingrosu.mybank.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
public class TransactionDto {

    @Min(0)
    private int amount;

    @NotBlank
    private String reference;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
