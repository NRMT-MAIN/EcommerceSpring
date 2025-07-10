package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.dtos.SingleProductResponseDTO;
import com.example.ecommerceSpring.entity.ProductEntity;
import com.example.ecommerceSpring.mappers.ProductMapper;
import com.example.ecommerceSpring.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Primary
public class ProductService implements ISingleProductService {
    private final ProductRepository productRepository ;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository ;
    }

    @Override
    public SingleProductResponseDTO getSingleProduct(String id) throws IOException {
        return null ;
    }

    @Override
    public SingleProductDTO createProduct(SingleProductDTO dto) throws IOException {
        ProductEntity product = productRepository.save(ProductMapper.toEntity(dto)) ;

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
}
