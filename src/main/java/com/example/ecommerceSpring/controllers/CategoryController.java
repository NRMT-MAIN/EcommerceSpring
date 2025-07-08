package com.example.ecommerceSpring.controllers;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {

        List<CategoryDTO> response = this.categoryService.getAllCategories() ;

        return ResponseEntity.ok(response) ;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(CategoryDTO categoryDTO){
        throw new UnsupportedOperationException("Not Yet Implemented") ;
    }
}
