package com.justingrosu.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justingrosu.mybank.context.MyBankApplicationConfiguration;
import com.justingrosu.mybank.model.Transaction;
import com.justingrosu.mybank.service.TransactionService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class MyBankServlet extends HttpServlet {

    private TransactionService transactionService;
    private ObjectMapper objectMapper;

    @Override
    public void init() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyBankApplicationConfiguration.class);
        this.transactionService = context.getBean(TransactionService.class);
        this.objectMapper = context.getBean(ObjectMapper.class);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equals("/transactions")) {
            final int amount = Integer.parseInt(request.getParameter("amount"));
            final String timestamp = request.getParameter("timestamp");
            final String reference = request.getParameter("reference");
            final Transaction transaction = transactionService.create(amount, LocalDateTime.parse(timestamp), reference);

            response.setContentType("application/json");
            final String json = objectMapper.writeValueAsString(transaction);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equals("/transactions")) {
            final List<Transaction> transactions = transactionService.findAll();

            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(objectMapper.writeValueAsString(transactions));
        }
    }
}
