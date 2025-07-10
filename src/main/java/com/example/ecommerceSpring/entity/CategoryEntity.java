package com.example.ecommerceSpring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryEntity extends BaseEntity {
    @Column(nullable = false , unique = true)
    private String name ;

    @OneToMany(mappedBy = "category")
    List<ProductEntity> products ;
}
