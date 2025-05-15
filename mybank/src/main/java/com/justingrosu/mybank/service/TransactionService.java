package com.justingrosu.mybank.service;

import com.justingrosu.mybank.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TransactionService {

    final private List<Transaction> transactions = new CopyOnWriteArrayList<>();

    final private String slogan;

    public TransactionService(@Value("${bank.slogan}") final String slogan) {
        this.slogan = slogan;
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(final int amount, final LocalDateTime timestamp, final String reference) {
        final Transaction transaction = new Transaction(UUID.randomUUID().toString(), amount, timestamp, reference, slogan);
        transactions.add(transaction);
        return transaction;
    }
}
