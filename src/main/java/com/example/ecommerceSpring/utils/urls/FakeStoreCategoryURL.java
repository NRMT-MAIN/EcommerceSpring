package com.example.ecommerceSpring.utils.urls;

import lombok.Getter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Getter
@Component
public class FakeStoreCategoryURL {
    private final Environment env;
    private String baseURL;
    private String Category;

    public FakeStoreCategoryURL(Environment env) {
        this.env = env;
        this.baseURL = env.getProperty("FAKESTOREAPI");
        this.Category = baseURL + "/products/category";
    }
}