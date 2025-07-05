package com.example.ecommerceSpring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @GetMapping
    public String getCategory(){
        return "Electronics" ;
    }

    @GetMapping("/count") //get request on /api/v1/categories/count
    public int getCount(){
        return 5 ;
    }

    @PostMapping
    public String postProduct(){
        return "Electronic Product" ;
    }
}
