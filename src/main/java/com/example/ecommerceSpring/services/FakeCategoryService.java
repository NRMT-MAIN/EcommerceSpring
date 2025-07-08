package com.example.ecommerceSpring.services;

import com.example.ecommerceSpring.dtos.CategoryDTO;
import com.example.ecommerceSpring.gateways.ICategoryGateways;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeCategoryService implements ICategoryService {

    private final ICategoryGateways categoryGateways ;

    public FakeCategoryService(@Qualifier("fakeStoreCategoryGateways") ICategoryGateways _categoryGateways){
        this.categoryGateways = _categoryGateways ;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateways.getAllCategories() ;
    }
}
