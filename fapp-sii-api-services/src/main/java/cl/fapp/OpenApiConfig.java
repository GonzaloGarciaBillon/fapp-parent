package cl.fapp;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenAPI() {
        Server server = new Server().url("/").description("Generated server url");
        return new OpenAPI()
                .addServersItem(server)
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                    .addSecuritySchemes("bearerAuth", new SecurityScheme()
                        .name("bearerAuth")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")))
                .info(new Info()
                		.title("FAPP Application API")
                		.version("1.0")
                		.description("Especificacion de servicios FAPP utilizando OpenAPI 3.")
                		.termsOfService("http://swagger.io/terms")
                		.license(new License()
                				.name("Apache 2.0")
                				.url("http://springdoc.org")));
    }

	@Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("login")
                .pathsToMatch("/fapp/v1/auth/login") // Asegúrate de que esta ruta sea la correcta
                .build();
    }

    @Bean
    public GroupedOpenApi privateApi() {
        return GroupedOpenApi.builder()
                .group("private")
                .pathsToExclude("/fapp/v1/auth/login") // Excluye el endpoint de login
                .build();
    }
}

