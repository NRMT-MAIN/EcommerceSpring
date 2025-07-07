package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.ProductCategoryResponseDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.gateways.ICategoryProductsGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeCategoryProductService implements ICategoryProductService{
    private final ICategoryProductsGateway iCategoryProductsGateway ;

    FakeCategoryProductService(ICategoryProductsGateway iCategoryProductsGateway){
        this.iCategoryProductsGateway = iCategoryProductsGateway ;
    }

    @Override
    public ProductCategoryResponseDTO getCategoryProduct(String type) throws IOException {
        return this.iCategoryProductsGateway.getCategoryProductResponse(type);
    }
}
