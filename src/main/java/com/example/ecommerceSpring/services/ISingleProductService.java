package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;

import java.io.IOException;

public interface ISingleProductService {
    SingleProductResponseDTO getSingleProduct(String id) throws IOException ;
    SingleProductDTO createProduct(SingleProductDTO dto) throws IOException ;
    SingleProductDTO getProductById(Long id) throws IOException ;
}
