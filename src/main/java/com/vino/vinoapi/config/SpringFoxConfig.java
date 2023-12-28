package com.vino.vinoapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SpringFoxConfig {

    @Bean
    OpenAPI myOpenAPI() {

        Info info = new Info()
                .title("Vino API")
                .version("1.0.0")
                .description("This API exposes endpoints to interact with the Vino application.");

        return new OpenAPI().info(info);
    }
}
