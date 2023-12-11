package cl.fapp.restapi.controller.dte;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.common.jsend.JSendStatus;
import cl.fapp.docs.DTERoot;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.dte.dto.DTEAndVerbatimCAF;
import cl.fapp.restapi.controller.dte.mapper.GenerarDTEControllerMapper;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.restapi.dte.domain.DTEEmisor;
import cl.fapp.restapi.dte.dto.GenerarDTERequest;
import cl.fapp.restapi.dte.dto.GenerarNotaCreditoRequest;
import cl.fapp.restapi.dte.dto.GenerarNotaDebitoRequest;
import cl.fapp.restapi.dte.mapper.NotaCreditoMapper;
import cl.fapp.restapi.dte.mapper.NotaDebitoMapper;
import cl.fapp.sii.jaxb.DTE;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "GENERAR-DTE", description = "API para generacion de DTE de diferentes tipos")
public class GenerarDteController {

	@Autowired
	DteRepository repoDte;

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	GenerarDTEControllerMapper mapperToDTE;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	/**
	 * Genera nota de credito a partir del request a la api y la escribe en la base de datos.
	 * 
	 * @param payload request para generar notas de credito
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generarnc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarNotaCredito(@Validated @RequestBody GenerarNotaCreditoRequest payload) {
		try {
			// establece tipo de documento a generar
			Integer tipoDocumento = ConstantesTipoDocumento.NOTA_CREDITO.getValue();
			
			// transforma el payload particular para nota de debito al general de documento dte
			NotaCreditoMapper mapper = Mappers.getMapper(NotaCreditoMapper.class);
			GenerarDTERequest dtePayload = mapper.toGenerarDTERequest(payload);
			
			// utiliza el metodo generico de construccion de DTE indicando el tipo de documento a generar
			JSend result = internalGenerarDTE(dtePayload, tipoDocumento);
			if (result.getStatus() == JSendStatus.error) {
				log.debug("Error generando tipoDocumento=" + tipoDocumento + ". Message=" + result.getMessage());
				return ResponseEntity.badRequest().body(result);

			} else {
				log.debug("Request procesado correctamente");
				return ResponseEntity.ok().body(result);
			}
		} catch (Exception ex) {
			log.error("Se produjo un error generando DTE tipo=" + ConstantesTipoDocumento.NOTA_CREDITO + ". Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
	
	/**
	 * Genera nota de debito a partir del request a la api y la escribe en la base de datos.
	 * 
	 * @param payload request para generar notas de debito
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generar-nota-debito", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarNotaDebito(@Validated @RequestBody GenerarNotaDebitoRequest payload) {
		try {
			// establece tipo de documento a generar
			Integer tipoDocumento = ConstantesTipoDocumento.NOTA_DEBITO.getValue();
			
			// transforma el payload particular para nota de debito al general de documento dte
			NotaDebitoMapper mapper = Mappers.getMapper(NotaDebitoMapper.class);
			GenerarDTERequest dtePayload = mapper.toGenerarDTERequest(payload);
			
			// utiliza el metodo generico de construccion de DTE indicando el tipo de documento a generar
			JSend result = internalGenerarDTE(dtePayload, tipoDocumento);
			if (result.getStatus() == JSendStatus.error) {
				log.debug("Error generando tipoDocumento=" + tipoDocumento + ". Message=" + result.getMessage());
				return ResponseEntity.badRequest().body(result);

			} else {
				log.debug("Request procesado correctamente");
				return ResponseEntity.ok().body(result);
			}
		} catch (Exception ex) {
			log.error("Se produjo un error generando DTE tipo=" + ConstantesTipoDocumento.NOTA_DEBITO + ". Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
	
	/**
	 * Genera Factura-AFECTA a partir del request a la api y la escribe en la base de datos.
	 * 
	 * @param payload request para generar Factura AFECTA
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generar-factura-afecta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarFacturaAfecta(@Validated @RequestBody GenerarDTERequest payload) {
		try {
			// establece tipo de documento a generar
			Integer tipoDocumento = ConstantesTipoDocumento.FACTURA_AFECTA.getValue();
			
			// utiliza el metodo generico de construccion de DTE indicando el tipo de documento a generar
			JSend result = internalGenerarDTE(payload, tipoDocumento);
			if (result.getStatus() == JSendStatus.error) {
				log.debug("Error generando tipoDocumento=" + tipoDocumento + ". Message=" + result.getMessage());
				return ResponseEntity.badRequest().body(result);

			} else {
				log.debug("Request procesado correctamente");
				return ResponseEntity.ok().body(result);
			}
		} catch (Exception ex) {
			log.error("Se produjo un error generando DTE tipo=" + ConstantesTipoDocumento.FACTURA_AFECTA + ". Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}	
	
	/**
	 * Genera Factura-EXENTA a partir del request a la api y la escribe en la base de datos.
	 * 
	 * @param payload request para generar Factura EXENTA
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generar-factura-exenta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarFacturaExenta(@Validated @RequestBody GenerarDTERequest payload) {
		try {
			// establece tipo de documento a generar
			Integer tipoDocumento = ConstantesTipoDocumento.FACTURA_EXENTA.getValue();
			
			// utiliza el metodo generico de construccion de DTE indicando el tipo de documento a generar
			JSend result = internalGenerarDTE(payload, tipoDocumento);
			if (result.getStatus() == JSendStatus.error) {
				log.debug("Error generando tipoDocumento=" + tipoDocumento + ". Message=" + result.getMessage());
				return ResponseEntity.badRequest().body(result);

			} else {
				log.debug("Request procesado correctamente");
				return ResponseEntity.ok().body(result);
			}
		} catch (Exception ex) {
			log.error("Se produjo un error generando DTE tipo=" + ConstantesTipoDocumento.FACTURA_EXENTA + ". Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}	
	
	/**
	 * Genera DTE, lo firma y escribe en la base de datos.
	 * 
	 * @param payload       request para generar DTE
	 * @param tipoDocumento tipo de DTE a generar
	 * @return objeto {@link JSend} simple
	 */
	private JSend internalGenerarDTE(GenerarDTERequest payload, Integer tipoDocumento) {
		try {
			// completo la parte emisor del mensaje
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante() == null ? rutemisor : payload.getRutFirmante();

			Optional<Emisores> emisor = repoEmisores.findById(rutemisor);
			if (!emisor.isPresent()) {
				log.error("El Emisor rut=" + rutemisor + " no existe en la base de datos");
				throw new Exception("El Emisor no existe");

			} else {
				log.debug("El emisor rut=" + rutemisor + " existe");
				Emisores record = emisor.get();
				DTEEmisor emisorDTE = new DTEEmisor();
				emisorDTE.setCiudadEmisor(record.getCiudad());
				emisorDTE.setComunaEmisor(record.getComuna());

				emisorDTE.setCorreoEmisor(record.getEmail());
				emisorDTE.setCodigoSucursalEmisor(record.getCodigoSucursal());
				emisorDTE.setTelefonoEmisor(record.getTelefono());

				// codigos de actividad economica indicados en el input
				for (Integer acteco : payload.getActividadEconomica()) {
					emisorDTE.getActecos().add(BigInteger.valueOf(acteco));
				}

				//emisorBoleta.setCodigoResolucion(record.getCodigoResolucion());
				//emisorBoleta.setFechaResolucion(record.getFechaResolucion());
				emisorDTE.setCodigoSii(record.getCodigoSii());
				emisorDTE.setCorreoEmisor(record.getEmail());

				emisorDTE.setDireccionEmisor(record.getDireccion());
				emisorDTE.setGiroEmisor(record.getGiro());
				emisorDTE.setRazonSocialEmisor(record.getRazonSocial());
				emisorDTE.setRutEmisor(record.getRutemisor());
				//-->emisorBoleta.setLogo(record.getLogoboleta());

				payload.setEmisor(emisorDTE);
			}

			// obtiene los documentos jaxb a partir del request a la api
			List<DTEAndVerbatimCAF> documentos = mapperToDTE.toDTEDocumento(payload, tipoDocumento);
			if (documentos == null) {
				log.error("No fue posible generar DTE");
				return JSend.error("No fue posible generar DTE");
			}
			// Declarar la variable fuera del bucle
			Dte newdte = null;
			// guarda los documentos jaxb en la base de datos
			for (DTEAndVerbatimCAF jaxbDTEtype : documentos) {
				String xmlDTESigned = signJaxbDTE(jaxbDTEtype, rutemisor, rutfirmante);
				newdte = saveNewDteEntity(emisor.get(), rutfirmante, jaxbDTEtype, xmlDTESigned);
				log.debug("Se crea el dte en la base de datos con id=" + newdte.getDteUuid());
			}
			log.debug("Request procesado correctamente");
			
			return JSend.success(newdte.getDteUuid());

		} catch (Exception ex) {
			log.error("Se produjo un error generando nota de credito. Error=" + ex.getMessage());
			return JSend.error(ex.getMessage());
		}
	}

	/**
	 * Firma un objeto {@link cl.fapp.sii.jaxb.DTE} con los datos del firmante. La relacion emisor/firmante debe existir
	 * 
	 * @param jaxbDTEAndVerbatimCAF objeto que contiene el DTE a firmar
	 * @param rutemisor             rut del Emisor
	 * @param rutfirmante           rut del Firmante
	 * @return string xml del documento firmado
	 */
	private String signJaxbDTE(DTEAndVerbatimCAF jaxbDTEAndVerbatimCAF, String rutemisor, String rutfirmante) {
		try {
			if (rutemisor == null) {
				// no se indica el rut del emisor => no es posible construir un dte
				throw new Exception("No se indica rut del emisor");
			}

			if (rutfirmante == null) {
				// no se indica el rut del firmante => no es posible firmar el dte
				throw new Exception("No se indica rut del firmante");
			}

			log.debug("Se indica relacion Emisor/Firmante, se recuperan datos para firmar: rutemisor=" + rutemisor + ", rutfirmante=" + rutfirmante);

			// recupera datos con los cuales firmar
			KeyinfoFindResponse kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
			if (kinfo == null) {
				log.error("Se indica firmante, pero no es posible acceder a los datos del keystore: rutemisor=" + rutemisor + ", rutfirmante=" + rutfirmante);
				throw new Exception("No se encuentran datos del keystore");
			}

			// recupera el dte sobre el que se trabajara
			DTE jaxbDTE = jaxbDTEAndVerbatimCAF.getDte();

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DTERoot docxml = (DTERoot) provider.getInstance("DTE");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DTEDocumento");
				throw new Exception("No es posible crear instancia de DTEDocumento");
			}

			// hace el marshall
			String xmlcontent = docxml.toXml(jaxbDTE, null);

			// quita declaracion xmldsig que esta demas en DTE
			xmlcontent = xmlcontent.replace(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "");

			// reemplaza cada ocurrencia del caf, por el texto 'como es' entregado por el sii
			// se reemplaza el caf en el xml, con la copia verbatim del caf almacenado en la base
			String emptyTagCAF = "<CAF/>";
			String replaceByCAF = jaxbDTEAndVerbatimCAF.getVerbatimcaf();
			xmlcontent = xmlcontent.replace(emptyTagCAF, replaceByCAF);
			log.debug("xmlcontent despues de agregar CAF al DTE=" + xmlcontent);

			log.info("Se firma el DTE id=" + jaxbDTE.getDocumento().getID() + ". Se almacena xml firmado");

			// firma el DTE
			ByteArrayInputStream bais = new ByteArrayInputStream(xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING));
			String xmlDTESigned = docxml.sign(bais, "DTE", "Documento", jaxbDTE.getDocumento().getID(), kinfo.getCertificate(), kinfo.getPrivatekey());

			// retorna el string del documento firmado
			return xmlDTESigned;

		} catch (Exception ex) {
			log.error("No fue posible firmar el DTE. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Almacena una instancia del DTE en la entidad Dte
	 * 
	 * @param emisor                Emisor del documento
	 * @param rutfirmante Rut del firmante que se utiliza para la firma del dte
	 * @param jaxbDTEAndVerbatimCAF objeto que contiene el DTE
	 * @param xmlDTESigned          string xml del DTE firmado
	 * @return la nueva instancia del DTE almacenada en la base de datos
	 */
	private Dte saveNewDteEntity(Emisores emisor, String rutfirmante, DTEAndVerbatimCAF jaxbDTEAndVerbatimCAF, String xmlDTESigned) {
		try {
			// recupera el dte sobre el que se trabajara
			DTE jaxbDTE = jaxbDTEAndVerbatimCAF.getDte();

			// nuevo estado del dte, dependiendo si se encuentra con datos para firmar
			Date ahora = new Date();

			// nueva instancia
			Dte newdte = new Dte();
			newdte.setCreatedat(ahora);
			newdte.setUpdatedat(ahora);
			newdte.setEmisore(emisor);
			newdte.setRutfirmante(rutfirmante);
			newdte.setIdDocumento(jaxbDTE.getDocumento().getID());
			newdte.setMonto(jaxbDTE.getDocumento().getEncabezado().getTotales().getMntTotal());
			newdte.setDteUuid(BuilderXmlID.genDTEUUIDv4());

			// obtiene el folio
			newdte.setFolioAsignado(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getFolio().longValue());

			// establece el tipo de documento
			newdte.setTipoDocumento(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getTipoDTE().intValue());

			newdte.setEstado(EntityDTEStatuses.CREADOFIRMADO.toString());

			// se establece en la instancia de la entidad
			newdte.setDocumentoXml(xmlDTESigned);

			// escribe la nueva instancia en la base de datos
			Dte newrecord = repoDte.save(newdte);

			// recupera y muestra el id
			log.info("DTE creado con idDte=" + newrecord.getIdDte());

			// retorna el registro recien insertado
			return newrecord;

		} catch (Exception ex) {
			log.error("No fue posible crear el registro en DTE. Error=" + ex.getMessage());
			return null;
		}
	}
}
