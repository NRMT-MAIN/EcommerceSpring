package com.example.ecommerceSpring.controllers;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.services.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    //private CategoryService categoryService ;
    //This is the violation of DIP , where two concrete class should not be depend on each other

    private ICategoryService categoryService ;

    CategoryController(ICategoryService _categoryService){
        this.categoryService = _categoryService ;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException {

        return this.categoryService.getAllCategories() ;
    }
}
