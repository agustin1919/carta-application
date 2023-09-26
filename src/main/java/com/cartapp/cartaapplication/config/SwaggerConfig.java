package com.cartapp.cartaapplication.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Swagger Link: http://localhost:8081/swagger-ui.html
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("0.0.02") String appVersion){
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicScheme",
                    new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic").name("ApiDoc")))
                .info(new Info()
                        .title("Documentación de aplicación de carta")
                        .description("Gestión de la funcionalidad de la aplicación del lado del servidor")
                        .version(appVersion));
    }
}
