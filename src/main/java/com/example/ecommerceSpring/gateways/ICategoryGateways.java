package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateways {
    List<CategoryDTO> getAllCategories() throws IOException;
}
