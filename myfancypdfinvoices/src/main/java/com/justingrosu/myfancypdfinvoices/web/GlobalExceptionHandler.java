package com.justingrosu.myfancypdfinvoices.web;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        // TODO you can choose to return your custom object here, which will then get transformed to json/xml etc.
        return "Sorry, that was not quite right: " + ex.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintValidation(ConstraintViolationException ex) {
        // TODO you can choose to return your custom object here, which will then get transformed to json/xml etc.
        return "Sorry, that was not quite right: " + ex.getMessage();
    }
}
