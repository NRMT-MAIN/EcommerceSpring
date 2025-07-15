package com.example.ecommerceSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

public class GeneralExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handleProductNotFound(ProductNotFoundException exception){
        ErrorResponse  errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value() ,
                exception.getMessage(),
                LocalDateTime.now()
        ) ;
        return errorResponse ;
    }


}
