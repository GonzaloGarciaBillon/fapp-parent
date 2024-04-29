package cl.fapp.restapi.controller.dte.notacredito.mapper.set;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.domain.mapper.ConvertRequestToEnvioDTEResponse;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTERequest;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.sii.jaxb.EnvioDTE;
import cl.fapp.sii.jaxb.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GenerarDtesSetDTEControllerMapper {
	ObjectFactory objectfactory = new ObjectFactory();

	@Autowired
	DteRepository repoDte;

	@Autowired
	SetDTERepository repoSetDTE;

	/**
	 * Mapea el objeto de entrada en la api a un {@link EnvioDTE.SetDTE}
	 * 
	 * @param emisor              emisor del documento
	 * @param rutfirmante         rut que firma el documento
	 * @param request             request a la api
	 * @param tiposDocumentoEnSet tipos de documento que se incluiran en el set
	 * @return el setdte de tipo jaxb {@link EnvioDTE.SetDTE}, y la lista de id de los dte que forman parte del set
	 */
	public ConvertRequestToEnvioDTEResponse toEnvioDTESetDTE(Emisores emisor, String rutfirmante, GenerarSetDTERequest request, List<Integer> tiposDocumentoEnSet) {

		Date ahora = new Date();
		ConvertRequestToEnvioDTEResponse response = new ConvertRequestToEnvioDTEResponse();
		String rutemisor = request.getRutEmisor();

		try {
			JAXBContext context = JAXBContext.newInstance(DTE.class);
			List<DTE> listaDtes = new ArrayList<DTE>();

			// busca en la base de datos los dte listos para ser empaquetados y enviados (CREADOFIRMADO)
			List<Dte> listDte = repoDte.findByEmisoreRutemisorAndEstadoAndTipoDocumentoIn(rutemisor, EntityDTEStatuses.CREADOFIRMADO.toString(), tiposDocumentoEnSet);

			// contadores por tipo de documento
			Map<BigInteger, Integer> freq = new HashMap<BigInteger, Integer>();

			// lista de id's de los dte que se estan agrupando
			List<Long> dteList = new ArrayList<Long>();
			StringWriter xmlTodosLosDTE = new StringWriter();
			log.debug("Procesando lista de DTE's");
			for (Dte dte : listDte) {
				log.debug("IdDTE=" + dte.getIdDte());
				try {
					// hace el unmarshall del xml contenido en la entidad dte
					DTE unmarshallDte = (DTE) context.createUnmarshaller().unmarshal(new StringReader(dte.getDocumentoXml()));

					// toda boleta almacenada, tiene un identificador
					DTE.Documento.Encabezado.IdDoc iddoc = unmarshallDte.getDocumento().getEncabezado().getIdDoc();

					// incrementa un contador por tipoDTE
					BigInteger key = iddoc.getTipoDTE();
					int count = freq.containsKey(key) ? freq.get(key) : 0;
					freq.put(key, count + 1);

					// quita la parte del DTE que esta contenida en los xml ya generados y firmados
					unmarshallDte.setSignature(null);
					unmarshallDte.getDocumento().setEncabezado(null);
					unmarshallDte.getDocumento().setTED(null);
					unmarshallDte.getDocumento().setTmstFirma(null);
					unmarshallDte.getDocumento().getDetalles().clear();
					unmarshallDte.getDocumento().getDscRcgGlobals().clear();
					unmarshallDte.getDocumento().getReferencias().clear();
					unmarshallDte.getDocumento().getSubTotInfos().clear();

					// agrega el DTE a la lista de DTEs
					listaDtes.add(unmarshallDte);
					dteList.add(dte.getIdDte());

					// concatena cada xml que forma parte del set. reemplaza por el encabezado que espera setdte
					String xx = new String(dte.getDocumentoXml().getBytes("ISO-8859-1")); // modificado 28072023...getBytes("ISO-8859-1"));
					//String xmlboleta = xx.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?><BOLETADefType version=\"1.0\">", SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<DTE version=\"1.0\">");
					String xmlboleta = xx.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><DTE version=\"1.0\">",  SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<DTE version=\"1.0\">");
					xmlboleta = xmlboleta.replace("</DTE>", "</DTE>");
					xmlTodosLosDTE.write(xmlboleta);

					log.debug("unmarshall entidad DTE id=" + dte.getIdDte() + ", jaxbobject.documento.id=" + unmarshallDte.getDocumento().getID());
				} catch (JAXBException e) {
					log.error("[SKIP]Ocurrio un error realizando unmarshall para DTE id=" + dte.getIdDte() + ". Error=" + e.getMessage());
					continue;
				}
			}

			if (listDte.size() <= 0) {
				log.warn("No existen dtes para crear un set.");
				response.setDteList(dteList);
				response.setJaxbsetdte(null);
				return response;
			}

			// forma la caratula
			EnvioDTE.SetDTE.Caratula caratula = objectfactory.createEnvioDTESetDTECaratula();

			// estos datos son para el set de pruebas
			caratula.setFchResol(emisor.getFechaResolucion());
			caratula.setNroResol(new BigInteger(emisor.getCodigoResolucion()));
			caratula.setRutReceptor(SiiDocumentFactoryConfiguration.SII_RUT_RECEPTOR); //emisor.getRutemisor());

			caratula.setRutEmisor(emisor.getRutemisor());
			caratula.setRutEnvia(rutfirmante);
			caratula.setTmstFirmaEnv(ahora);
			caratula.setVersion(BigDecimal.valueOf(1.0));

			// calcula subtotales por tipo de dte
			List<EnvioDTE.SetDTE.Caratula.SubTotDTE> subtotdtes = new ArrayList<EnvioDTE.SetDTE.Caratula.SubTotDTE>();
			for (Map.Entry<BigInteger, Integer> tupla : freq.entrySet()) {
				EnvioDTE.SetDTE.Caratula.SubTotDTE subtotdte = objectfactory.createEnvioDTESetDTECaratulaSubTotDTE();// new EnvioDTE.SetDTE.Caratula.SubTotDTE();
				subtotdte.setNroDTE(BigInteger.valueOf(tupla.getValue()));
				subtotdte.setTpoDTE(tupla.getKey());
				subtotdtes.add(subtotdte);
			}

			// agrega todos los subtotales a la caratula
			caratula.getSubTotDTEs().addAll(subtotdtes);

			// crea el nuevo setDTE
			EnvioDTE.SetDTE newSetDte = objectfactory.createEnvioDTESetDTE(); // objectfactory.createEnvioBOLETASetDTE();
			newSetDte.setCaratula(caratula);
			newSetDte.setID(BuilderXmlID.getIDforSetDte());
			newSetDte.getDTES().addAll(listaDtes);

			// prepara el objeto de respuesta (lista de id dte en el set y el setdte en jaxb)
			response.setDteList(dteList);
			response.setJaxbsetdte(newSetDte);
			response.setXmldtes(xmlTodosLosDTE.toString());

			return response;

		} catch (Exception ex) {
			log.error("Se proujo un error creando la entidad EnvioDTE.SetDTE. Error=" + ex.getMessage());
			ex.printStackTrace();
		}

		return null;
	}
}
