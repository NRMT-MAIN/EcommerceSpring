package com.example.ecommerceSpring.mappers;

import com.example.ecommerceSpring.dtos.SingleProductDTO;
import com.example.ecommerceSpring.entity.ProductEntity;


public class ProductMapper {
    public static SingleProductDTO toDto(ProductEntity productEntity){
        return SingleProductDTO.builder()
                .id(productEntity.getId())
                .image(productEntity.getImage())
                .color(productEntity.getColor())
                .price(productEntity.getPrice())
                .description(productEntity.getDescription())
                .discount(productEntity.getDiscount())
                .model(productEntity.getModel())
                .title(productEntity.getTitle())
                .brand(productEntity.getBrand())
                .popular(productEntity.isPopular())
                .build();
    }

    public static ProductEntity toEntity(SingleProductDTO singleProductDTO){
        return ProductEntity.builder()
                .image(singleProductDTO.getImage())
                .color(singleProductDTO.getColor())
                .price(singleProductDTO.getPrice())
                .description(singleProductDTO.getDescription())
                .discount(singleProductDTO.getDiscount())
                .model(singleProductDTO.getModel())
                .title(singleProductDTO.getTitle())
                .brand(singleProductDTO.getBrand())
                .popular(singleProductDTO.isPopular())
                .build() ;

    }
}
