package com.example.ecommerceSpring.controllers;

import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;
import com.example.ecommerceSpring.services.ISingleProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/products")
public class SingleProductController {
    private final ISingleProductService singleProductService ;

    SingleProductController(ISingleProductService singleProductService){
        this.singleProductService = singleProductService ;
    }

    @GetMapping("/{id}") //this spring style to this
    public SingleProductResponseDTO getSingleProduct(@PathVariable String id) throws IOException {
        return this.singleProductService.getSingleProduct(id) ;
    }
}
