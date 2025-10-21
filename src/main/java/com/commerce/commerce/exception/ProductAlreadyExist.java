package com.commerce.commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ProductAlreadyExist extends RuntimeException {
    public ProductAlreadyExist(String message) {
        super(message);
    }
}
