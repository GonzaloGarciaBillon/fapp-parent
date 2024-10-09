package cl.fapp.restapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final Environment env;

    public SecurityConfig(UserDetailsService userDetailsService, JwtRequestFilter jwtRequestFilter, Environment env) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.env = env;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(requests -> {
                    if (env.acceptsProfiles("prod")) {
                        requests.antMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**", "/webjars/**").denyAll();
                    } else {
                        requests.antMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**", "/webjars/**").permitAll();
                    }
                    requests.antMatchers("/fapp/v1/auth/**").permitAll()
                            .anyRequest().authenticated();
                })
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http.authenticationProvider(daoAuthenticationProvider());
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
}