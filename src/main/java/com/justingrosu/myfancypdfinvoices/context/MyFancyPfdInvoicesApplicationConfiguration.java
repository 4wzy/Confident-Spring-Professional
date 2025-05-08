package com.justingrosu.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.justingrosu.myfancypdfinvoices.service.InvoiceService;
import com.justingrosu.myfancypdfinvoices.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MyFancyPfdInvoicesApplicationConfiguration {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public InvoiceService invoiceService(UserService userService) {
        return new InvoiceService(userService);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
