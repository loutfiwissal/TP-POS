package com.commerce.commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = ProductNotFound.class)
        public ResponseEntity<Object> handleProductNotFoundException(ProductNotFound exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());

    }
    @ExceptionHandler(value = ProductAlreadyExist.class)
    public ResponseEntity<Object> handleProductAlreadyExistException(ProductAlreadyExist exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());

    }
    @ExceptionHandler(value = InvalidProductInfo.class)
    public ResponseEntity<Object> handleInvalidProductInfoException(InvalidProductInfo exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());

    }
}
