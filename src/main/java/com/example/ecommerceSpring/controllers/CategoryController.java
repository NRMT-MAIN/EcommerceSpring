package com.example.ecommerceSpring.controllers;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        CategoryDTO category = this.categoryService.createCategory(categoryDTO) ;
        return ResponseEntity.ok(category) ;
    }
}
