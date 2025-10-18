package com.commerce.commerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductGlobalException {

    @ExceptionHandler({ProductNotFoundException.class,
    InvalidProductInfoException.class,
    ProductAlreadyExistException.class})
    public ResponseEntity<ApiError> handleProductExceptions(RuntimeException ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex instanceof ProductNotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (ex instanceof ProductAlreadyExistException) {
            status = HttpStatus.CONFLICT;
        } else if (ex instanceof InvalidProductInfoException) {
            status = HttpStatus.BAD_REQUEST;
        }

        ApiError apiError = new ApiError(status.value(), status.getReasonPhrase(), ex.getMessage());
        return ResponseEntity.status(status).body(apiError);
    }

}
