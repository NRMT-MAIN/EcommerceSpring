package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.configurations.OkHTTPConfig;
import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.io.IOException;


@Component
public class FakeStoreSingleProductGateways implements ISingleProductGateways{
    private final OkHTTPConfig okHTTPConfig ;
    private final Environment env ;
    private final ObjectMapper objectMapper ;

    public FakeStoreSingleProductGateways(OkHTTPConfig okHTTPConfig , Environment env , ObjectMapper objectMapper){
        this.okHTTPConfig = okHTTPConfig ;
        this.env = env ;
        this.objectMapper = objectMapper ;
    }

    @Override
    public SingleProductResponseDTO getSingleProduct(String id) throws IOException {
        String baseUrl = env.getProperty("FAKESTOREAPI") + "products/" ;
        String json = okHTTPConfig.synchrounousGetRequest(baseUrl + id) ;

        if (json == null || json.isEmpty()) {
            throw new IOException("Failed to fetch product from FakeStore API");
        }

        return objectMapper.readValue(json , SingleProductResponseDTO.class) ;
    }
}
