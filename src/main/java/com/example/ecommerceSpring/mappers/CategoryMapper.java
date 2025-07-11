package com.example.ecommerceSpring.mappers;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.CategoryWithProductsDTO;
import com.example.ecommerceSpring.entity.CategoryEntity;

public class CategoryMapper {
    public static CategoryDTO toDto(CategoryEntity categoryEntity){
        return CategoryDTO.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build() ;
    }

    public static CategoryEntity toEntity(CategoryDTO categoryDTO) {
        return CategoryEntity.builder()
                .name(categoryDTO.getName())
                .build();
    }

}
