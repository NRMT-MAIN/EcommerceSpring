package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.ProductCategoryResponseDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryProductService {
    ProductCategoryResponseDTO getCategoryProduct(String type) throws IOException ;
}
