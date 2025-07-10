package com.example.ecommerceSpring.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleProductDTO {
    private Long id;
    private String title;
    private String image;
    private double price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private String category;
    private boolean popular;
    private int discount;
}
