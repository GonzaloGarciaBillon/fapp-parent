package cl.fapp;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

@Configuration
@EnableScheduling
public class SiiDocumentFactoryConfiguration {

	/**
	 * Encoding por defecto para todos los objetos
	 */
	public static final String DEFAULT_ENCODING = "ISO-8859-1";
	public static final Double TASA_IVA = 19d;
	public static final String SII_RUT_RECEPTOR = "60803000-K";
	
	// windows
	// public static final String CARRIAGE_RETURN = "\r\n";
	
	// linux
	public static final String CARRIAGE_RETURN = "\n";

	/**
	 * Configuracion de opciones que se aplican a los xml
	 */
	public class XML {
	}
	
	public class DD {
		/**
		 * Algoritmo utilizado en la firma del DD
		 */
		public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";
	}

    @Bean
    KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}
