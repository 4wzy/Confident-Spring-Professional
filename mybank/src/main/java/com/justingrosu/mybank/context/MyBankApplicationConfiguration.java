package com.justingrosu.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.justingrosu.mybank.ApplicationLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
@ComponentScan(basePackageClasses = ApplicationLauncher.class)
@PropertySource("classpath:/application.properties")
public class MyBankApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        final JavaTimeModule javaTimeModule = new JavaTimeModule();
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(javaTimeModule);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }

}
