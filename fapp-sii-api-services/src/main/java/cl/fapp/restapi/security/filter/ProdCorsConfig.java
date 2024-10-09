package cl.fapp.restapi.security.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@Profile("prod")
public class ProdCorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Permitir cualquier subdominio de billonapp.cl
        configuration.setAllowedOriginPatterns(List.of("https://*.billonapp.cl"));
        
        // Métodos HTTP permitidos
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        
        // Headers permitidos
        configuration.setAllowedHeaders(List.of("*"));
        
        // Permitir envío de cookies o credenciales
        // configuration.setAllowCredentials(true);
        
        // Registrar la configuración para todas las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }
}
