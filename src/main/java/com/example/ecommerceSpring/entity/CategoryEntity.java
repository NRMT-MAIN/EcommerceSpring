package com.example.ecommerceSpring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "category")
public class CategoryEntity extends BaseEntity {
    @Column(nullable = false , unique = true)
    private String name ;

    //This does not mean that you're trying to store a list of products inside category table
    //Telling JPA , the relationship is already owned by the product entity. So, just read from there.
    @OneToMany(mappedBy = "category" , fetch = FetchType.LAZY)
    private List<ProductEntity> products ;
}
