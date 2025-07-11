package com.example.ecommerceSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    //In this Until required it will not show the join table properties
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id" ,nullable = false)
    private CategoryEntity category ;
}
