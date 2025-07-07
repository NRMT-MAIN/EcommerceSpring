package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.dtos.ProductCategoryResponseDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryProductsGateway {
    ProductCategoryResponseDTO getCategoryProductResponse(String type) throws IOException;
}
