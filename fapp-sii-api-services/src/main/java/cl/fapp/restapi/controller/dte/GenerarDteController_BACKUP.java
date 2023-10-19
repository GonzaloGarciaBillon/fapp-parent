package cl.fapp.restapi.controller.dte;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.docs.DTERoot;
import cl.fapp.domain.mapper.FromBoletaEnvioRequestToDTEDocumento;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.boleta.domain.BoletaEmisor;
import cl.fapp.restapi.controller.boleta.dto.GenerarBoletaRequest;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.sii.jaxb.DTE;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.base-path}")
@Tag(name = "GENERAR", description = "API para generacion de DTE")
public class GenerarDteController_BACKUP {

	@Autowired
	DteRepository repoDte;

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	FromBoletaEnvioRequestToDTEDocumento mapperToDTEDocumento;

	/**
	 * Genera dte jaxb a partir del request a la api, y las escribe en la base de datos
	 * 
	 * @param payload request para generar boletas. Utiliza objetos de tipo {@link DTE}
	 * @return objeto {@link JSend} simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/generardte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarDTE(@RequestBody GenerarBoletaRequest payload) {
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
				BoletaEmisor emisorBoleta = new BoletaEmisor();
				emisorBoleta.setCiudadEmisor(record.getCiudad());
				emisorBoleta.setComunaEmisor(record.getComuna());
				emisorBoleta.setDireccionEmisor(record.getDireccion());
				emisorBoleta.setGiroEmisor(record.getGiro());
				emisorBoleta.setRazonSocialEmisor(record.getRazonSocial());
				emisorBoleta.setRutEmisor(record.getRutemisor());

				emisorBoleta.setCorreoEmisor(record.getEmail());
				emisorBoleta.setCodigoSucursalEmisor(record.getCodigoSucursal());
				emisorBoleta.setTelefonoEmisor(record.getTelefono());
				emisorBoleta.setCodigoResolucion(record.getCodigoResolucion());
				emisorBoleta.setFechaResolucion(record.getFechaResolucion());
				emisorBoleta.setCodigoSii(record.getCodigoSii());
				//-->emisorBoleta.setLogo(record.getLogoboleta());

				payload.setEmisor(emisorBoleta);
			}

			// obtiene los documentos jaxb a partir del request a la api
			List<DTE> documentos = mapperToDTEDocumento.toDTEDocumento(payload);
			if (documentos == null) {
				log.error("No fue posible generar documentos.");
				return ResponseEntity.badRequest().body(JSend.error("No fue posible generar documentos."));
			}

			// guarda los documentos jaxb en la base de datos
			for (DTE jaxbDTE : documentos) {
				Dte newdte = generateDteFromJaxbDTE(emisor.get(), jaxbDTE, rutemisor, rutfirmante);
				log.debug("Se crea el dte en la base de datos con id=" + newdte.getIdDte());
			}
			log.debug("Request procesado correctamente");

			return ResponseEntity.ok().body(JSend.success("DocumentosGenerados=" + documentos.size()));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
		}
	}

	/**
	 * Crea una instancia de la entidad {@link Dte} a partir de un objeto jaxb de tipo {@link cl.fapp.sii.jaxb.DTE}<br>
	 * Almacena el dte con los datos de jaxbDTE, lo firma y guarda en el repositorio
	 * 
	 * @param emisor emisor de la boleta
	 * @param jaxbDTE objeto con los datos de la boleta
	 * @param rutemisor rut del emisor
	 * @param rutfirmante rut del firmante
	 * @return
	 */
	private Dte generateDteFromJaxbDTE(Emisores emisor, DTE jaxbDTE, String rutemisor, String rutfirmante) {
		try {
			if (rutemisor == null) {
				// no se indica el rut del emisor => no es posible construir una boleta
				throw new Exception("No se indica rut del emisor");
			}

			// nuevo estado del dte, dependiendo si se encuentra con datos para firmar
			Date ahora = new Date();

			// nueva instancia
			Dte newdte = new Dte();
			newdte.setCreatedat(ahora);
			newdte.setUpdatedat(ahora);
			newdte.setEmisore(emisor);

			// obtiene el folio
			newdte.setFolioAsignado(jaxbDTE.getDocumento().getEncabezado().getIdDoc().getFolio().longValue());

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DTERoot docxml = (DTERoot) provider.getInstance("DTE");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DocumentoBOLETADefTypeDocumento");
				throw new Exception("No es posible crear instancia de DocumentoBOLETADefTypeDocumento");
			}
			String xmlcontent = docxml.toXml(jaxbDTE, null);

			// si es posible, lo firma
			KeyinfoFindResponse kinfo;
			if (rutfirmante == null) {
				// no se indica rutfirmante => se puede generar la boleta, pero no firmar
				log.info("No se indica rut firmante, solo se creara el documento de la boleta");
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
					//-->String xmlcontentSigned = docxml.sign(new ByteArrayInputStream(xmlcontent.getBytes()), "DTE", "Documento", jaxbDTE.getDocumento().getID(), kinfo.getCertificate(), kinfo.getPrivatekey());
					//-->newdte.setDocumentoXml(xmlcontentSigned);
					newdte.setDocumentoXml(xmlcontent);
				}
			}

			// escribe la nueva instancia en la base de datos
			Dte newrecord = repoDte.save(newdte);

			// recupera y muestra el id
			log.info("Dte creado con id=" + newrecord.getIdDte());

			// retorna el registro recien insertado
			return newrecord;

		} catch (Exception ex) {
			log.error("No fue posible crear el registro en DTE. Error=" + ex.getMessage());
			return null;
		}
	}
}
