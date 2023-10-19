package cl.fapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import lombok.extern.slf4j.Slf4j;

//--> @Component
@Slf4j
public class EndpointsListener {

	@EventListener
	public void handleContextRefresh(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		log.info("Endpoints definidos por la aplicacion: ");
		applicationContext.getBean(RequestMappingHandlerMapping.class)
		.getHandlerMethods()
		.forEach((key, value) -> {
			log.info("{} {}", key, value);	
		});
	}
}
