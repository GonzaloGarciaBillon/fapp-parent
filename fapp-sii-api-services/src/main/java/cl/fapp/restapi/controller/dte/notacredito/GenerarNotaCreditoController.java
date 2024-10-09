package cl.fapp.restapi.controller.dte.notacredito;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.docs.DTERoot;
import cl.fapp.repository.model.Bitacora;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.BitacoraRepository;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.dte.dto.DTEAndVerbatimCAF;
import cl.fapp.restapi.controller.dte.notacredito.mapper.GenerarNotaCreditoDTEControllerMapper;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.restapi.dte.domain.DTEEmisor;
import cl.fapp.restapi.dte.dto.GenerarNotaCreditoRequest;
import cl.fapp.sii.jaxb.DTE;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "GENERAR-NC", description = "API para generacion de documentos de tipo Nota de Credito")
public class GenerarNotaCreditoController {

	@Autowired
	DteRepository repoDte;

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	GenerarNotaCreditoDTEControllerMapper mapperToDTE;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	BitacoraRepository bitacoraRepository;

	/**
	 * Genera notas de credito jaxb a partir del request a la api, y las escribe en la base de datos.
	 * 
	 * @param payload request para generar notas de credito
	 * @return objeto {@link JSend} simple
	 */
	//-->@RequestMapping(method = RequestMethod.POST, value = "/generarnc", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarNotaCredito(@Validated @RequestBody GenerarNotaCreditoRequest payload) {
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
			List<DTEAndVerbatimCAF> documentos = mapperToDTE.toDTEDocumento(payload, ConstantesTipoDocumento.NOTA_CREDITO.getValue());
			if (documentos == null) {
				log.error("No fue posible generar DTE");
				return ResponseEntity.badRequest().body(JSend.error("No fue posible generar DTE"));
			}
			
			// guarda los documentos jaxb en la base de datos
			for (DTEAndVerbatimCAF jaxbBOLETADefType : documentos) {
				Dte newdte = createEntityDteFromJaxbDTE(emisor.get(), jaxbBOLETADefType, rutemisor, rutfirmante);
				log.debug("Se crea el dte en la base de datos con id=" + newdte.getIdDte());
			}
			log.debug("Request procesado correctamente");

			return ResponseEntity.ok().body(JSend.success("DocumentosGenerados=" + documentos.size()));

		} catch (Exception ex) {
			log.error("Se produjo un error generando nota de credito. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Crea una instancia de la entidad {@link Dte}<br>
	 * Almacena el dte con datos de tipo {@link DTE}, lo firma y guarda en el repositorio
	 * 
	 * @param emisor                datos del emisor
	 * @param jaxbDTEAndVerbatimCAF objeto con los datos de la boleta y el caf <b>tal como</b> lo entrego el sii
	 * @param rutemisor             rut del emisor
	 * @param rutfirmante           rut del firmante
	 * @return una instancia de la entidad {@link Dte}
	 */
	private Dte createEntityDteFromJaxbDTE(Emisores emisor, DTEAndVerbatimCAF jaxbDTEAndVerbatimCAF, String rutemisor, String rutfirmante) {
		try {
			if (rutemisor == null) {
				// no se indica el rut del emisor => no es posible construir un dte
				throw new Exception("No se indica rut del emisor");
			}

			// recupera el dte sobre el que se trabajara
			DTE jaxbDTE = jaxbDTEAndVerbatimCAF.getDte();

			// nuevo estado del dte, dependiendo si se encuentra con datos para firmar
			Date ahora = new Date();

			// nueva instancia
			Dte newdte = new Dte();
			newdte.setCreatedat(ahora);
			newdte.setUpdatedat(ahora);
			newdte.setEmisore(emisor);
			newdte.setIdDocumento(jaxbDTE.getDocumento().getID());
			newdte.setMonto(jaxbDTE.getDocumento().getEncabezado().getTotales().getMntTotal());
			newdte.setDteUuid(BuilderXmlID.genDTEUUIDv4());

			// obtiene el folio
			newdte.setFolioAsignado(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getFolio().longValue());

			// establece el tipo de documento
			newdte.setTipoDocumento(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getTipoDTE().intValue());

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DTERoot docxml = (DTERoot) provider.getInstance("DTE");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DTEDocumento");
				throw new Exception("No es posible crear instancia de DTEDocumento");
			}

			// hace el marshall
			String xmlcontent = docxml.toXml(jaxbDTE, null);

			// TODO: quita declaracion xmldsig que esta demas en BOLETADefType
			xmlcontent = xmlcontent.replace(" xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\"", "");

			// TODO: reemplaza cada ocurrencia del caf, por el texto 'como es' entregado por el sii
			// se reemplaza el caf en el xml, con la copia verbatim del caf almacenado en la base
			String emptyTagCAF = "<CAF/>";
			String replaceByCAF = jaxbDTEAndVerbatimCAF.getVerbatimcaf();
			xmlcontent = xmlcontent.replace(emptyTagCAF, replaceByCAF);
			log.debug("xmlcontent despues de agregar CAF al DTE=" + xmlcontent);

			// si es posible, lo firma. En caso contrario lo guarda no firmado
			KeyinfoFindResponse kinfo;
			if (rutfirmante == null) {
				// no se indica rutfirmante => se puede generar el DTE, pero no firmar
				log.info("No se indica rut firmante, solo se creara el documento del DTE");
				newdte.setEstado(EntityDTEStatuses.CREADONOFIRMADO.toString());
				newdte.setDocumentoXml(xmlcontent);
				kinfo = null;
			} else {
				// si se indica rutfirmante => obtiene datos con los cuales firmar
				log.debug("Se indica relacion Emisor/Firmante, se recuperan datos para firmar");
				kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
				if (kinfo == null) {
					log.error("Se indica firmante, pero no es posible acceder a los datos del keystore.");
					throw new Exception("No se encuentran datos del keystore");

				} else {
					log.info("Se firma el documento. Se almacena xml firmado");
					newdte.setEstado(EntityDTEStatuses.CREADOFIRMADO.toString());

					// firma el DTE
					String xmlboletaSigned = docxml.sign(new ByteArrayInputStream(xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING)), "DTE", "Documento", jaxbDTE.getDocumento().getID(), kinfo.getCertificate(), kinfo.getPrivatekey());

					// se establece en la instancia de la entidad
					newdte.setDocumentoXml(xmlboletaSigned);
				}
			}

			// escribe la nueva instancia en la base de datos
			Dte newrecord = repoDte.save(newdte);

			// Se guarda registro en bitacora
            Bitacora bitacora = new Bitacora();
            bitacora.setEstado(newrecord.getEstado());
            bitacora.setProceso("/generarboleta");
            bitacora.setFechaActualizacion(ahora);
            bitacora.setModelo("DTE");
			bitacora.setIdModelo(newrecord.getIdDte().toString());
			bitacoraRepository.save(bitacora);

			// recupera y muestra el id
			log.info("DTE creado con id=" + newrecord.getIdDte());

			// retorna el registro recien insertado
			return newrecord;

		} catch (Exception ex) {
			log.error("No fue posible crear el registro en DTE. Error=" + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Firma un objeto {@link cl.fapp.sii.jaxb.DTE} con los datos del firmante. La relacion emisor/firmante debe existir
	 * @param jaxbDTEAndVerbatimCAF objeto que contiene el DTE a firmar
	 * @param rutemisor rut del Emisor
	 * @param rutfirmante rut del Firmante
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

			// quita declaracion xmldsig que esta demas en BOLETADefType
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
			String xmlboletaSigned = docxml.sign(bais, "DTE", "Documento", jaxbDTE.getDocumento().getID(), kinfo.getCertificate(), kinfo.getPrivatekey());

			// retorna el string del documento firmado
			return xmlboletaSigned;

		} catch (Exception ex) {
			log.error("No fue posible firmar el DTE. Error=" + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Almacena una instancia del DTE en la entidad Dte
	 * @param emisor Emisor del documento
	 * @param jaxbDTEAndVerbatimCAF objeto que contiene el DTE
	 * @param xmlDteSigned string xml del DTE firmado
	 * @return la nueva instancia del Dte almacenada en la base de datos
	 */
	private Dte saveNewDteEntity(Emisores emisor, DTEAndVerbatimCAF jaxbDTEAndVerbatimCAF, String xmlDteSigned, String usuario) {
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
			newdte.setIdDocumento(jaxbDTE.getDocumento().getID());
			newdte.setMonto(jaxbDTE.getDocumento().getEncabezado().getTotales().getMntTotal());
			newdte.setDteUuid(BuilderXmlID.genDTEUUIDv4());

			// Establecer el usuario
			newdte.setUsuario(usuario);

			// obtiene el folio
			newdte.setFolioAsignado(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getFolio().longValue());

			// establece el tipo de documento
			newdte.setTipoDocumento(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getTipoDTE().intValue());

			newdte.setEstado(EntityDTEStatuses.CREADOFIRMADO.toString());

			// se establece en la instancia de la entidad
			newdte.setDocumentoXml(xmlDteSigned);

			// escribe la nueva instancia en la base de datos
			Dte newrecord = repoDte.save(newdte);

			// Se guarda registro en bitacora
            Bitacora bitacora = new Bitacora();
            bitacora.setEstado(newrecord.getEstado());
            bitacora.setProceso("saveNewDteEntity");
            bitacora.setFechaActualizacion(ahora);
            bitacora.setModelo("DTE");
			bitacora.setIdModelo(newrecord.getIdDte().toString());
			bitacoraRepository.save(bitacora);

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
