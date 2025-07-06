package com.example.ecommerceSpring;

import com.example.ecommerceSpring.configurations.DotenvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceSpringApplication {

	public static void main(String[] args) {

		DotenvConfig.getDotenv().entries().forEach(entry -> {
			System.setProperty(entry.getKey() , entry.getValue()) ;
		});
		//Set system properties from environment variable

		SpringApplication.run(EcommerceSpringApplication.class, args);
	}

}
