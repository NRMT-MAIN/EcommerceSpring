package com.example.ecommerceSpring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleProductNotFound(NotFoundException exception){
        ErrorResponse  errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value() ,
                exception.getMessage(),
                LocalDateTime.now()
        ) ;
        return errorResponse ;
    }



}
