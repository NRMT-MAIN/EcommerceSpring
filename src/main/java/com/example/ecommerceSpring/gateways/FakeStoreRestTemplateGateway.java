package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.FakeStoreCategoryResponseDTO;
import com.example.ecommerceSpring.mappers.GetAllCategoryMapper;
import com.example.ecommerceSpring.utils.urls.FakeStoreCategoryURL;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
@Primary
public class FakeStoreRestTemplateGateway implements ICategoryGateways{
    private final RestTemplateBuilder restTemplateBuilder ;
    private final FakeStoreCategoryURL fakeStoreCategoryURL ;

    public FakeStoreRestTemplateGateway(
            RestTemplateBuilder restTemplateBuilder ,
            FakeStoreCategoryURL fakeStoreCategoryURL
    ){
        this.restTemplateBuilder = restTemplateBuilder ;
        this.fakeStoreCategoryURL = fakeStoreCategoryURL ;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build() ;
        String url = fakeStoreCategoryURL.getCategory() ;

        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate
                .getForEntity(url , FakeStoreCategoryResponseDTO.class) ;

        if(response.getBody() == null){
            throw new IOException("Failed to fetch the FakeStore Category API.")  ;
        }
        return GetAllCategoryMapper.toCategoryDto(response.getBody()) ;
    }
}
