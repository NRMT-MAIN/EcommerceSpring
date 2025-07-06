package com.example.ecommerceSpring.configurations;

import com.example.ecommerceSpring.gateways.api.FakeStoreCategoryApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    String FAKESTOREAPI = DotenvConfig.getDotenv().get("FAKESTOREAPI") ;

    //This bean is applicable on method for creating the object of it.
    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(FAKESTOREAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build() ;
    }

    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        return  retrofit.create(FakeStoreCategoryApi.class) ;
    }
}
