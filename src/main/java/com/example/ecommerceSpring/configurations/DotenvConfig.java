package com.example.ecommerceSpring.configurations;

import io.github.cdimascio.dotenv.Dotenv;

public class DotenvConfig {
    public static final Dotenv dotenv = Dotenv.configure().load() ;

    public static Dotenv getDotenv() {
        return dotenv;
    }
}
