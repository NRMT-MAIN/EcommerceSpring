package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.ProductWithCategoryDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;
import com.example.ecommerceSpring.gateways.ISingleProductGateways;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FakeSingleProductService implements ISingleProductService {
    private final ISingleProductGateways singleProductGateways ;

    public FakeSingleProductService(ISingleProductGateways singleProductGateways){
        this.singleProductGateways = singleProductGateways ;
    }

    @Override
    public SingleProductResponseDTO getSingleProduct(String id) throws IOException {
        return this.singleProductGateways.getSingleProduct(id) ;
    }

    @Override
    public SingleProductDTO createProduct(SingleProductDTO dto) throws IOException {
        return null;
    }

    @Override
    public SingleProductDTO getProductById(Long id) throws IOException {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws IOException {
        return null;
    }
}
