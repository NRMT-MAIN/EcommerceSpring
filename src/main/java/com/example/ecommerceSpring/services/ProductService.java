package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.ProductWithCategoryDTO;
import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;
import com.example.ecommerceSpring.entity.CategoryEntity;
import com.example.ecommerceSpring.entity.ProductEntity;
import com.example.ecommerceSpring.mappers.ProductMapper;
import com.example.ecommerceSpring.repository.CategoryRepository;
import com.example.ecommerceSpring.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Primary
public class ProductService implements ISingleProductService {
    private final ProductRepository productRepository ;
    private final CategoryRepository categoryRepository ;

    public ProductService(ProductRepository productRepository , CategoryRepository categoryRepository){
        this.productRepository = productRepository ;
        this.categoryRepository = categoryRepository ;
    }

    @Override
    public SingleProductResponseDTO getSingleProduct(String id) throws IOException {
        return null ;
    }

    @Override
    public SingleProductDTO createProduct(SingleProductDTO dto) throws IOException {
        CategoryEntity category = categoryRepository.findById(dto.getCategoryId())
                         .orElseThrow(() -> new IOException("Category Not Found")) ;

        ProductEntity product = productRepository.save(ProductMapper.toEntity(dto , category)) ;

        return ProductMapper.toDto(product) ;
    }

    @Override
    public SingleProductDTO getProductById(Long id) throws IOException {
        //        return repo.findById(id)
        //                .map(ProductMapper::toDto)
        //                .orElseThrow(() -> new Exception("Product not found"));`

        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new IOException("Product Not found"));

        return ProductMapper.toDto(product) ;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws IOException {
        ProductEntity product = this.productRepository.findById(id)
                .orElseThrow(() -> new IOException("Product not Found")) ;
        return ProductMapper.toProductWithCategoryDTO(product) ;
    }
}
