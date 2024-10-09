package cl.fapp.restapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("prod")
public class SwaggerSecurityConfig {

    @Bean
    public SecurityFilterChain swaggerFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**",
                                "/webjars/**")
                        .denyAll())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }
}