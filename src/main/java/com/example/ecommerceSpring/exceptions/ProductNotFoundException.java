package com.example.ecommerceSpring.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message){
        super(message) ;
    }
}
