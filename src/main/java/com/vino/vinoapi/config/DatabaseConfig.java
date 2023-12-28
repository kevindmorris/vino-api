package com.vino.vinoapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DatabaseConfig {

    @Bean
    CommandLineRunner initDatabase() {

        return args -> {

        };
    }
}
