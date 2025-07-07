package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.configurations.OkHTTPConfig;
import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.ProductCategoryResponseDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FakeStoreCategoryProductGateway implements ICategoryProductsGateway{
    private final OkHTTPConfig okHTTPConfig ;
    private final Environment env ;
    private final ObjectMapper objectMapper ;

    FakeStoreCategoryProductGateway(OkHTTPConfig okHTTPConfig , Environment env , ObjectMapper objectMapper){
        this.okHTTPConfig = okHTTPConfig ;
        this.env = env ;
        this.objectMapper = objectMapper ;
    }

    @Override
    public ProductCategoryResponseDTO getCategoryProductResponse(String type) throws IOException {
        String baseUrl = env.getProperty("FAKESTOREAPI") + "/products/category?type=";
        String json = okHTTPConfig.synchrounousGetRequest(baseUrl + type) ;

        if (json == null || json.isEmpty()) {
            throw new IOException("Failed to fetch product from FakeStore API");
        }

        ProductCategoryResponseDTO response =  objectMapper.readValue(json, ProductCategoryResponseDTO.class) ;

        return response ;
    }
}
