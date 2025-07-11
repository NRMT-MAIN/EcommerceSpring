package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.CategoryWithProductsDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.entity.CategoryEntity;
import com.example.ecommerceSpring.mappers.CategoryMapper;
import com.example.ecommerceSpring.mappers.ProductMapper;
import com.example.ecommerceSpring.repository.CategoryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public CategoryDTO getByNameCategory(String name) throws IOException {
        CategoryEntity category = this.categoryRepository.findByName(name)
                                        .orElseThrow(() -> new IOException("Category Not Found"));
        return CategoryMapper.toDto(category) ;
    }

    @Override
    public CategoryWithProductsDTO getCategoryWithProduct(Long id) throws IOException {
        CategoryEntity category = this.categoryRepository.findById(id)
                                        .orElseThrow(() -> new IOException("Category Not Found")) ;

        List<SingleProductDTO> productDTOList = category.getProducts()
                .stream()
                .map(productEntity -> ProductMapper.toDto(productEntity))
                .collect(Collectors.toList());
        return CategoryWithProductsDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .products(productDTOList)
                .build() ;
    }
}
