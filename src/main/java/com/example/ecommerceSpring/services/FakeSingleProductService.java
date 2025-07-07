package com.example.ecommerceSpring.services;

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
}
