package com.example.ecommerceSpring.configurations;

import com.example.ecommerceSpring.gateways.api.FakeStoreCategoryApi;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

//    String FAKESTOREAPI = dotenv.get("FAKESTOREAPI") ;
//    at class level, before the constructor is executed.
//    So env will be null at that point, causing a NullPointerException or misbehavior.
//    Move the usage of env inside the @Bean method, so it gets evaluated after constructor injection.

    private final Environment env ;

    public RetrofitConfig(Environment env){
        this.env = env ;
    }


    //This bean is applicable on method for creating the object of it.
    @Bean
    public Retrofit retrofit() {
        String FAKESTOREAPI = env.getProperty("FAKESTOREAPI") ;
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
