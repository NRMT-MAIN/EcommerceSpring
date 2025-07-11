package com.example.ecommerceSpring.controllers;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.CategoryWithProductsDTO;
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
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws IOException {
        if(name != null && !name.isBlank()){
            CategoryDTO categoryDTO = this.categoryService.getByNameCategory(name) ;
            return ResponseEntity.ok(categoryDTO) ;
        }
        List<CategoryDTO> response = this.categoryService.getAllCategories() ;
        return ResponseEntity.ok(response) ;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        CategoryDTO category = this.categoryService.createCategory(categoryDTO) ;
        return ResponseEntity.ok(category) ;
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<CategoryWithProductsDTO> getCategoryWithProducts(@PathVariable Long id) throws IOException {
        CategoryWithProductsDTO category = this.categoryService.getCategoryWithProduct(id) ;
        return ResponseEntity.ok(category) ;
    }
}
