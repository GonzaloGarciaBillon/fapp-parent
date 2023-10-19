package cl.fapp;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                		.title("FAPP Application API")
                		.version("1.0")
                		.description("Especificacion de servicios FAPP utilizando OpenAPI 3.")
                		.termsOfService("http://swagger.io/terms")
                		.license(new License()
                				.name("Apache 2.0")
                				.url("http://springdoc.org")));
    }
}

