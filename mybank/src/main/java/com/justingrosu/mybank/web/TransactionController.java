package com.justingrosu.mybank.web;

import com.justingrosu.mybank.dto.TransactionDto;
import com.justingrosu.mybank.model.Transaction;
import com.justingrosu.mybank.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return this.transactionService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody @Valid final TransactionDto transactionDto) {
        return transactionService.create(transactionDto.getAmount(), transactionDto.getReference());

    }
}
