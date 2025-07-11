package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.CategoryWithProductsDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException ;
    CategoryDTO getByNameCategory(String name) throws IOException ;
    CategoryWithProductsDTO getCategoryWithProduct(Long id) throws IOException ;
}
