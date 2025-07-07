package com.example.ecommerceSpring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryResponseDTO {
    private String status ;
    private String message ;
    private List<SingleProductDTO> products;
}
