package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.entity.CategoryEntity;
import com.example.ecommerceSpring.mappers.CategoryMapper;
import com.example.ecommerceSpring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository ;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository ;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> categoryDTOList = new ArrayList<>() ;
        List<CategoryEntity> categoryEntityList = this.categoryRepository.findAll() ;

        for(CategoryEntity categoryEntity : categoryEntityList){
            categoryDTOList.add(CategoryMapper.toDto(categoryEntity)) ;
        }
        return categoryDTOList ;
    }


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        CategoryEntity category = this.categoryRepository.save(CategoryMapper.toEntity(categoryDTO)) ;

        return CategoryMapper.toDto(category) ;
    }
}
