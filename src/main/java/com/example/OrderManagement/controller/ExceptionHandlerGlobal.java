package com.example.OrderManagement.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.OrderManagement.exception.CreditCardException;
import com.example.OrderManagement.exception.EmailException;
import com.example.OrderManagement.exception.ProductException;


@ControllerAdvice
public class ExceptionHandlerGlobal {
    private final static Logger logger = Logger.getLogger(ExceptionHandlerGlobal.class);
    @ExceptionHandler(Exception.class)
    public String error(Exception e){
        logger.error("Exception ",e);
        return "redirect:/";
    }
    @ExceptionHandler(value = {ProductException.class, EmailException.class})
    public ResponseEntity<?> ProductError(Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {CreditCardException.class})
    public ResponseEntity<?> CreditCardError(Exception e) {
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
