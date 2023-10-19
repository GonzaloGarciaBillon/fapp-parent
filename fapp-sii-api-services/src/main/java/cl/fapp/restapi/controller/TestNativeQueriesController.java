package cl.fapp.restapi.controller;

import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.EntitySetDteTipoSet;
import cl.fapp.common.domain.EntityTicketTypes;
import cl.fapp.common.domain.statuses.EntitySetDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.common.jsend.JSendStatus;
import cl.fapp.repository.agg.IAggCafPorEmisor;
import cl.fapp.repository.agg.IAggNumeroDtePorEmisor;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Firmantes;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.CAFRepository;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.FirmantesRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.EnviarBoletaSetDTEController;
import cl.fapp.restapi.controller.boleta.GenerarBoletasSetDTEController;
import cl.fapp.restapi.controller.boleta.dto.EnviarBoletaSetDTERequest;
import cl.fapp.restapi.controller.boleta.dto.EnviarBoletaSetDTEResponse;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTERequest;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTEResponse;
import cl.fapp.restapi.controller.caf.dto.TestNativeQueriesRequest;
import cl.fapp.restapi.freshdesk.FreshdeskCreateTicketRequest;
import cl.fapp.restapi.freshdesk.FreshdeskCreateTicketResponse;
import cl.fapp.restapi.freshdesk.FreshdeskHelpers;
import cl.fapp.restapi.freshdesk.FreshdeskPriorityEnum;
import cl.fapp.restapi.freshdesk.FreshdeskStatusEnum;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.EnvioBOLETA;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBContext;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "CAF", description = "API para operaciones relacionadas al CAF")
public class TestNativeQueriesController {

	@Autowired
	CAFRepository repository;

	@Autowired
	EmisoresRepository emisoresRepo;

	@Autowired
	FirmantesRepository firmantesRepo;

	@Autowired
	DteRepository dteRepo;
	
	@Autowired
	SetDTERepository setdteRepo;

	@Autowired
	FreshdeskHelpers freshdesk;

	@Autowired
	GenerarBoletasSetDTEController controllerGenerarSet;
	
	@Autowired
	EnviarBoletaSetDTEController controllerEnviarSet;
	
	@Value("${fapp.task.setboletas.partition.size:1}")
	private Integer TAMANO_PARTICION;
	
	@Value("${fapp.task.setboletas.group.remainder:true}")
	private Boolean GROUP_REMAINDER;

	/**
	 * Ejecuta consultas en el repositorio
	 * 
	 * @param payload request al servicio
	 * @return estructura JSend simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/testnativequeries", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> testNativeQueries(@Validated @ModelAttribute @RequestBody TestNativeQueriesRequest payload) {
		try {

			String rutemisor = "11222333-4";
			int tipoDocumento = 39;
			int foliosQuedan = 7;

			/*
			FreshdeskCreateTicketRequest fdrequest = new FreshdeskCreateTicketRequest();
			fdrequest.setName("Monitor de Folios");
			fdrequest.setDescription("El numero de folios disponibles (" + foliosQuedan + ") de tipo " + tipoDocumento + " para el Emisor " + rutemisor + " se estan agotando.");
			fdrequest.setEmail("monitor.folios@billonapp.com");
			fdrequest.setPriority(FreshdeskPriorityEnum.LOW.getValue());
			fdrequest.setStatus(FreshdeskStatusEnum.PENDING.getValue());
			fdrequest.setSubject("Folios tipo=" + tipoDocumento + " del Emisor=" + rutemisor);
			fdrequest.setGroupid(new BigInteger("153000047593"));
			fdrequest.setResponderid(new BigInteger("153000716188"));

			// recupera el primer firmante asociado a un emisor, cuyo certificado no ha expirado
			Optional<Firmantes> firstFirmante = firmantesRepo.findFirstByEmisoreRutemisorAndEstadoAndKeystoreFirmantesCertificateExpiryDateGreaterThanEqualOrderByKeystoreFirmantesCertificateExpiryDateDesc(payload.getRutEmisor(), "ACTIVO", new Date());
			if (firstFirmante.isPresent()) {
				Firmantes recordFirmante = firstFirmante.get();
				log.debug("Firmante=" + recordFirmante.getRutfirmante());
			} else {
				log.debug("No se encontro firmante");
			}

			// crea un ticket
			//-->FreshdeskCreateTicketResponse fdresponse = freshdesk.createTicket(fdrequest);

			// verifica que el emisor informado en el CAF existe en la base de datos
			Optional<Emisores> emisor = emisoresRepo.findById(payload.getRutEmisor());
			if (!emisor.isPresent()) {
				log.error("El emisor rut=" + payload.getRutEmisor() + " no existe en la base de datos");
				throw new Exception("El emisor no existe");
			} else {
				log.debug("El emisor rut=" + payload.getRutEmisor() + " existe");
			}

			Optional<List<IAggCafPorEmisor>> xx = repository.reportCafByEmisor(EntityTicketTypes.TYPE_FOLIO.getValue(), "CAF", payload.getEstadoEmisor(), payload.getEstadoCaf(), payload.getMinDisponibles());
			if (!xx.isPresent() || (xx.isPresent() && xx.get().isEmpty())) {
				log.error("No se encontraron caf que deban ser informados...");
			} else {
				for (IAggCafPorEmisor item : xx.get()) {
					log.debug("Item=" + item.getRutEmisor() + ", disponibles=" + item.getDisponibles() + ", tipoAlarma=" + item.getTipoAlarma() + ", tipoDocumento=" + item.getTipoDocumento());
				}
			}

			List<Integer> tiposDocumentoEnSet = new ArrayList<Integer>();
			tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_AFECTA.getValue());
			tiposDocumentoEnSet.add(ConstantesTipoDocumento.BOLETA_EXENTA.getValue());

			// test query dte
			List<SetDteDTO> listIdSetdte = new ArrayList<SetDteDTO>();
			Optional<List<IAggNumeroDtePorEmisor>> yy = dteRepo.reportNumeroDtePorEmisor(payload.getEstadoEmisor(), payload.getEstadoDte(), tiposDocumentoEnSet, /*payload.getTamanoParticion()* / TAMANO_PARTICION, new Date());
			if (!yy.isPresent() || (yy.isPresent() && yy.get().isEmpty())) {
				log.error("No se encontraron Dte que deban ser informados...");
				
			} else {
				boolean procesarRestos = GROUP_REMAINDER;
				for (IAggNumeroDtePorEmisor item : yy.get()) {
				
					log.debug("-----------------------------------------------------------");
					log.debug("Item=" + item.getRutEmisor() + ", numeroDtes=" + item.getNroDtes() + ", iteraciones=" + item.getNroIteraciones() + ", resto=" + item.getDtesRemanentes() + ", tamanoParticion=" + item.getTamanoParticion());
					for (int i = 0; i < item.getNroIteraciones(); i++) {
					
						GenerarSetDTERequest request = new GenerarSetDTERequest();
						request.setNroMaxDteEnSet(item.getTamanoParticion());
						request.setRutEmisor(item.getRutEmisor());
						request.setRutFirmante(item.getRutFirmante());

						GenerarSetDTEResponse idNewSetDte = execControllerGenerarBoletaSetDte(item, request);
						SetDteDTO setDtedto = new SetDteDTO();
						setDtedto.setRutEmisor(idNewSetDte.getRutEmisor());
						setDtedto.setIdSetdte(idNewSetDte.getIdSetBoletas());
						setDtedto.setNroDtes(idNewSetDte.getNroBoletas());
						
						listIdSetdte.add(setDtedto);
					}

					// verifica si debe agregar los remanentes
					if (procesarRestos && item.getDtesRemanentes() > 0) {
						GenerarSetDTERequest request = new GenerarSetDTERequest();
						request.setNroMaxDteEnSet(item.getDtesRemanentes());
						request.setRutEmisor(item.getRutEmisor());
						request.setRutFirmante(item.getRutFirmante());

						GenerarSetDTEResponse idNewSetDte = execControllerGenerarBoletaSetDte(item, request);
						SetDteDTO setDtedto = new SetDteDTO();
						setDtedto.setRutEmisor(idNewSetDte.getRutEmisor());
						setDtedto.setIdSetdte(idNewSetDte.getIdSetBoletas());
						setDtedto.setNroDtes(idNewSetDte.getNroBoletas());
						
						listIdSetdte.add(setDtedto);
					}
				}
			}
			*/
			//return ResponseEntity.ok().body(JSend.success(yy.get()));
			
			//-->return ResponseEntity.ok().body(JSend.success(listIdSetdte));
			
			//executeTaskEnvioSetBoletas();
			updateSetDteRecords();
			return ResponseEntity.ok().body(JSend.success("OK"));

		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
		}
	}
	
	/**
	 * Util para completar de datos las nuevas columnas. Los valores se obtienen del xml almacenado.
	 */
	private void updateSetDteRecords() {
		try {
			Optional<List<Setdte>> xx = setdteRepo.findByEstadoAndTipoSetAndRutemisorIsNullAndRutfirmanteIsNullOrderByIntentosEnvioDesc(EntitySetDTEStatuses.ENVIOPENDIENTE.getValue(), EntitySetDteTipoSet.BOLETA.getValue());
			if(!xx.isPresent() || (xx.isPresent() && xx.get().isEmpty())) {
				log.error("No se encontraron SetDte que deban ser enviados...");

			} else {
				JAXBContext context = JAXBContext.newInstance(EnvioBOLETA.class);
				for(Setdte item:xx.get()) {
					log.debug("Procesando idSetDte=" + item.getIdSetdte());
					
					String xmlcontent = item.getDocumentoXml();
					String buscar= "EnvioBOLETA xmlns=\"http://www.sii.cl/SiiDte\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"1.0\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte EnvioBOLETA_v11.xsd\"";
					String cambiarPor = "EnvioBOLETA";
					xmlcontent = xmlcontent.replace(buscar, cambiarPor);
					
					EnvioBOLETA unmarshallDbDte = (EnvioBOLETA) context.createUnmarshaller().unmarshal(new StringReader(xmlcontent));
					item.setRutemisor(unmarshallDbDte.getSetDTE().getCaratula().getRutEmisor());
					item.setRutfirmante(unmarshallDbDte.getSetDTE().getCaratula().getRutEnvia());
					item.setNroDtes(unmarshallDbDte.getSetDTE().getDTES().size());
					
					log.debug("Actualizando registro setdteid=" + item.getIdSetdte() + ", a rutemisor: " + item.getRutemisor() + ", rutfirmante=" + item.getRutfirmante() + ", nrodtes=" + item.getNroDtes());
					setdteRepo.save(item);
				}
			}

		}catch(Exception ex) {
			log.error("Ocurrio un error actualizando los registros. Message=" + ex.getMessage());
		}
	}
	
	private void executeTaskEnvioSetBoletas() {
		
		try {
		// test query dte
		List<SetDteDTO> listIdSetdte = new ArrayList<SetDteDTO>();
		
		Optional<List<Setdte>> xx = setdteRepo.findByEstadoAndTipoSetOrderByIntentosEnvioDesc(EntitySetDTEStatuses.ENVIOPENDIENTE.getValue(), EntitySetDteTipoSet.BOLETA.getValue());
		if(!xx.isPresent() || (xx.isPresent() && xx.get().isEmpty())) {
			log.error("No se encontraron SetDte que deban ser enviados...");
		} else {
			for(Setdte item:xx.get()) {
				log.debug("Procesando idSetDte=" + item.getIdSetdte());
				EnviarBoletaSetDTERequest zz = new EnviarBoletaSetDTERequest();
				zz.setIdSetDte(item.getIdSetdte());
				zz.setRutEmisor(item.getRutemisor());
				zz.setRutFirmante(item.getRutfirmante());
				
				EnviarBoletaSetDTEResponse envioSetResponse = controllerEnviarSet.internalEnviarBoletaSetDte(zz);
				log.info("envioSetResponse=" + envioSetResponse);
			}
		}
		}catch(Exception ex) {
			log.error("Error parseand xml setdte. Message=" + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private GenerarSetDTEResponse execControllerGenerarBoletaSetDte(IAggNumeroDtePorEmisor item, GenerarSetDTERequest request) {

		GenerarSetDTEResponse resp = controllerGenerarSet.internalGenerarBoletasSetDte(request);
		if (resp.getIdSetBoletas()==null) {
			log.error("Se produjo un error invocando el controller...");
			
		} else {
			log.debug("Se genero el set sin problemas. Response=" + resp);
		}
		
		return resp;
	}
	
	@Getter
	@Setter
	@NoArgsConstructor
	private class SetDteDTO{
		private String rutEmisor;
		private Long idSetdte;
		private Integer nroDtes;
	}

}
