package com.example.ecommerceSpring.gateways;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.dtos.FakeStoreCategoryResponseDTO;
import com.example.ecommerceSpring.gateways.api.FakeStoreCategoryApi;
import com.example.ecommerceSpring.mappers.GetAllCategoryMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryGateways")
public class FakeStoreCategoryGateways implements ICategoryGateways{
    private final FakeStoreCategoryApi fakeStoreCategoryApi  ;

    public FakeStoreCategoryGateways(FakeStoreCategoryApi fakeStoreCategoryApi){
        this.fakeStoreCategoryApi = fakeStoreCategoryApi ;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApi.getAllFakeCategories().execute().body() ;

        if(response == null){
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        return GetAllCategoryMapper.toCategoryDto(response) ;
    }
}
