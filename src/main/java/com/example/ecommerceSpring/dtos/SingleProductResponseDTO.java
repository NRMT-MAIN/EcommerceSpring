package com.example.ecommerceSpring.dtos;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SingleProductResponseDTO {
    private String status ;
    private String message ;
    private SingleProductDTO product ;
}
