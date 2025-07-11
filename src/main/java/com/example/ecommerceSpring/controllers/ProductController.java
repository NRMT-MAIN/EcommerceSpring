package com.example.ecommerceSpring.controllers;

import com.example.ecommerceSpring.dtos.ProductCategoryResponseDTO;
import com.example.ecommerceSpring.dtos.ProductWithCategoryDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;
import com.example.ecommerceSpring.services.ICategoryProductService;
import com.example.ecommerceSpring.services.ISingleProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ISingleProductService singleProductService ;
    private final ICategoryProductService categoryProductService ;

    ProductController(ISingleProductService singleProductService , ICategoryProductService categoryProductService){
        this.singleProductService = singleProductService ;
        this.categoryProductService = categoryProductService ;
    }

    @GetMapping("/fakestore/{id}") //this spring style to this
    public SingleProductResponseDTO getSingleProduct(@PathVariable String id) throws IOException {
        return this.singleProductService.getSingleProduct(id) ;
    }

    @GetMapping("/category")
    public ProductCategoryResponseDTO getCategoryProduct(@RequestParam("type") String type) throws IOException {
        return this.categoryProductService.getCategoryProduct(type) ;
    }

    @PostMapping
    public SingleProductDTO createProduct(@RequestBody SingleProductDTO dto) throws IOException {
        return this.singleProductService.createProduct(dto) ;
    }

    @GetMapping("/{id}")
    public SingleProductDTO getProductById(@PathVariable Long id) throws IOException {
        return this.singleProductService.getProductById(id) ;
    }

    @GetMapping("/{id}/category")
    public ProductWithCategoryDTO getProductWithCategoryById(@PathVariable Long id) throws IOException{
        return this.singleProductService.getProductWithCategory(id) ;
    }

}
