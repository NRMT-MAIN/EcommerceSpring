package com.example.ecommerceSpring.mappers;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.FakeStoreCategoryResponseDTO;

import java.util.List;

public class GetAllCategoryMapper {
    public static List<CategoryDTO> toCategoryDto(FakeStoreCategoryResponseDTO dto){
        return dto.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build()).toList() ;
    }
}
