package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ISingleProductGateways {
    SingleProductResponseDTO getSingleProduct(String id) throws IOException;
}
