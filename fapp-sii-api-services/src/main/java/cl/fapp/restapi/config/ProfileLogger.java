package cl.fapp.restapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
public class ProfileLogger {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @PostConstruct
    public void logActiveProfile() {
        log.info("Perfil activo: " + activeProfile);
    }
}
