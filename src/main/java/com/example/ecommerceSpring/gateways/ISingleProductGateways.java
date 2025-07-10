package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;

import java.io.IOException;

public interface ISingleProductGateways {
    SingleProductResponseDTO getSingleProduct(String id) throws IOException;
}
