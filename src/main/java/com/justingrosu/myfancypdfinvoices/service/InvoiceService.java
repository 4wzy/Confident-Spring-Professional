package com.justingrosu.myfancypdfinvoices.service;

import com.justingrosu.myfancypdfinvoices.context.Application;
import com.justingrosu.myfancypdfinvoices.model.Invoice;
import com.justingrosu.myfancypdfinvoices.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    private final UserService userService;

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userID, Integer amount) {
        User user = userService.findById(userID);
        if (user == null) {
            throw new IllegalStateException("User not found");
        }

        Invoice invoice = new Invoice(userID, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }

}
