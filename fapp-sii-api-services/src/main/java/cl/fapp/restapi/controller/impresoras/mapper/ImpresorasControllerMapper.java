package cl.fapp.restapi.controller.impresoras.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.repository.repos.ImpresorasRepository;
import cl.fapp.sii.jaxb.ObjectFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImpresorasControllerMapper {
	ObjectFactory objectfactory = new ObjectFactory();
    
    @Autowired
	ImpresorasRepository repoImpresoras;

    
}
