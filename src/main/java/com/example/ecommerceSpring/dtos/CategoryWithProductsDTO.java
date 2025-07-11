package com.example.ecommerceSpring.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithProductsDTO {
    private Long id ;
    private String name ;
    private List<SingleProductDTO> products ;
}
