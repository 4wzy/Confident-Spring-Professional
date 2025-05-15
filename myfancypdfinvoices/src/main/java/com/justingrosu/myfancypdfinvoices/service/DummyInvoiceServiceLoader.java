package com.justingrosu.myfancypdfinvoices.service;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DummyInvoiceServiceLoader {

    private final InvoiceService invoiceService;

    public DummyInvoiceServiceLoader(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostConstruct
    public void setup() {
        System.out.println("Creating dev invoices...");
        invoiceService.create("freddieFoxDev", 100);
        invoiceService.create("silviaSquirrelDev", 200);
    }
}
