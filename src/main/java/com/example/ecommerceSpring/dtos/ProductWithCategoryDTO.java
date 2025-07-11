package com.example.ecommerceSpring.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDTO {
    private Long id;
    private String title;
    private String image;
    private double price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private boolean popular;
    private int discount;
    private CategoryDTO category ;
}
