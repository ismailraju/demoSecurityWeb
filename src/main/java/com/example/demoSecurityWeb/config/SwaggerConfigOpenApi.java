package com.example.demoSecurityWeb.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Map;

@Configuration
public class SwaggerConfigOpenApi {


    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(
                        new Info()
                                .title("Spring boot 3.0.2 MVC  Application")
                                .description("Backend APIs for Spring boot 3.0.2 MVC ")
                                .version("v1.0.0")
                                .contact(new Contact().name("Ismail Hossain").url("https://www.linkedin.com/in/ismail-hossain-raju-b21945bb/").email("ismailhossainraju74@gmail.com"))
                                .license(new License().name("License").url("/"))
                )
                .externalDocs(
                        new ExternalDocumentation().description("Spring boot 3.0.2 MVC pp Documentation")
                                .url("http://localhost:8080/swagger-ui/index.html")


                )
                .servers(
                        Arrays.asList(
                                new Server().url("http://localhost:8080").description("Development server"),
                                new Server().url("http://localhost:8080/v1").description("Staging server"),
                                new Server().url("http://localhost:8080/v1").description("Production server")
                        )
                )

                ;
    }
}
