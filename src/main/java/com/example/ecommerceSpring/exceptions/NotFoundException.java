package com.example.ecommerceSpring.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message) ;
    }
}
