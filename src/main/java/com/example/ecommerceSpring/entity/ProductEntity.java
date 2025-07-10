package com.example.ecommerceSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity{
    private String title;
    private String image;
    private double price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private boolean popular;
    private int discount;

    @JoinColumn(name="category_Id" ,nullable = false)
    @ManyToOne
    private CategoryEntity category ;
}
