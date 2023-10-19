package cl.fapp.restapi.controller.boleta.mapper.set;

import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import cl.fapp.domain.mapper.ConvertRequestToEnvioBOLETAResponse;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.boleta.dto.GenerarSetDTERequest;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.EnvioBOLETA;
import cl.fapp.sii.jaxb.EnvioBOLETA.SetDTE.Caratula.SubTotDTE;
import cl.fapp.sii.jaxb.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GenerarBoletasSetDTEControllerMapper {
	ObjectFactory objectfactory = new ObjectFactory();
	
	@Autowired
	DteRepository repoDte;
	
	@Autowired
	SetDTERepository repoSetDTE;
	
	/**
	 * Mapea el objeto de entrada en la api a un {@link EnvioBOLETA.SetDTE}
	 * @param emisor emisor del documento
	 * @param rutfirmante rut que firma el documento
	 * @param request request a la api
	 * @param tiposDocumentoEnSet tipos de documento que se incluiran en el set
	 * @return el setdte de tipo jaxb {@link EnvioBOLETA.SetDTE}, y la lista de id de los dte que forman parte del set
	 */
	public ConvertRequestToEnvioBOLETAResponse toEnvioBOLETASetDTE(Emisores emisor, String rutfirmante, GenerarSetDTERequest request, List<Integer> tiposDocumentoEnSet) {

		Date ahora = new Date();
		ConvertRequestToEnvioBOLETAResponse response = new ConvertRequestToEnvioBOLETAResponse();
		String rutemisor = request.getRutEmisor();
		Integer nroMaximoDteEnSet = request.getNroMaxDteEnSet();
		
		try {
			JAXBContext context = JAXBContext.newInstance(BOLETADefType.class);
			List<BOLETADefType> listaBoletas = new ArrayList<BOLETADefType>();
			
			// busca en la base de datos las boletas listas para ser empaquetadas y enviadas (CREADOFIRMADO)
			List<Dte> listDte = repoDte.findByEmisoreRutemisorAndEstadoAndTipoDocumentoIn(rutemisor, EntityDTEStatuses.CREADOFIRMADO.toString(), tiposDocumentoEnSet);
						
			// contadores por tipo de documento
			Map<BigInteger, Integer> freq = new HashMap<BigInteger, Integer>();

			// lista de id's de los dte que se estan agrupando
			List<Long> dteList = new ArrayList<Long>();
			StringWriter xmlTodasLasBoletas = new StringWriter();
			
			log.debug("Procesando lista de DTE's");
			if( listDte.size() <= 0 ) {
				log.warn("No existen boletas para crear un set.");
				response.setDteList(dteList);
				response.setJaxbsetdte(null);
				return response;

			}else {
				
				// si no se indica numero maximo de dte, incluye todas las retornadas
				if( nroMaximoDteEnSet == null ) {
					nroMaximoDteEnSet = listDte.size();
				}
				
				// si el numero de dte es diferente (menor o mayor) al indicado como maximo para el set, incluye todas las retornadas
				if( listDte.size() < nroMaximoDteEnSet ) {
					log.warn("El numero de dte existentes (" + listDte.size() + ") es menor al indicado como parametro (" + nroMaximoDteEnSet + ")");
					nroMaximoDteEnSet = listDte.size();
				}
				
				log.debug("Se incluiran " + nroMaximoDteEnSet + " dte's en el set, para el emisor=" + rutemisor);
				for (int i = 0; i < nroMaximoDteEnSet; i++) {
					//for(Dte dbDte:listDte) {
					Dte dbDte = listDte.get(i);
					log.debug("IdDTE=" + dbDte.getIdDte());
					try {
						// hace el unmarshall del xml contenido en la entidad dte
						BOLETADefType unmarshallDbDte = (BOLETADefType) context.createUnmarshaller().unmarshal(new StringReader(dbDte.getDocumentoXml()));

						// toda boleta almacenada, tiene un identificador
						BOLETADefType.Documento.Encabezado.IdDoc iddoc = unmarshallDbDte.getDocumento().getEncabezado().getIdDoc();

						// incrementa un contador por tipoDTE
						BigInteger key = iddoc.getTipoDTE();
						int count = freq.containsKey(key) ? freq.get(key) : 0;
						freq.put(key, count + 1);

						// quita la parte de la boleta que esta contenida en los xml ya generados y firmados
						unmarshallDbDte.setSignature(null);
						unmarshallDbDte.getDocumento().setEncabezado(null);
						unmarshallDbDte.getDocumento().setTED(null);
						unmarshallDbDte.getDocumento().setTmstFirma(null);
						unmarshallDbDte.getDocumento().getDetalles().clear();
						unmarshallDbDte.getDocumento().getDscRcgGlobals().clear();
						unmarshallDbDte.getDocumento().getReferencias().clear();
						unmarshallDbDte.getDocumento().getSubTotInfos().clear();

						// agrega la boleta a la lista de boletas
						listaBoletas.add(unmarshallDbDte);
						dteList.add(dbDte.getIdDte());

						// concatena cada xml que forma parte del set. reemplaza por el encabezado que espera setdte
						String xx = new String(dbDte.getDocumentoXml().getBytes("UTF-8")); // modificado 21072023...getBytes("ISO-8859-1"));
						//String xmlboleta = xx.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?><BOLETADefType version=\"1.0\">", SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<DTE version=\"1.0\">");

						// @formatter:off
						// reemplaza encabezado y pie de cada documento xml de una boleta, para que pueda ser usado/referenciado en un set
						String xmlboleta = xx.replace(
								"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><BOLETADefType version=\"1.0\">", 
								SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<DTE version=\"1.0\">");
						
						//-->String xmlboleta = xx.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?><BOLETADefType version=\"1.0\">", SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<DTE version=\"1.0\">");
						xmlboleta = xmlboleta.replace("</BOLETADefType>", "</DTE>");		 
						// @formatter:on

						// escribe el xml de la boleta actual al acumulador de xml's de boletas
						xmlTodasLasBoletas.write(xmlboleta);

						log.debug("unmarshall entidad DTE id=" + dbDte.getIdDte() + ", jaxbobject.documento.id=" + unmarshallDbDte.getDocumento().getID());
					} catch (JAXBException e) {
						log.error("[SKIP]Ocurrio un error realizando unmarshall para DTE id=" + dbDte.getIdDte() + ". Error=" + e.getMessage());
						continue;
					}
				} // end-for
			}

			// forma la caratula
			EnvioBOLETA.SetDTE.Caratula caratula = objectfactory.createEnvioBOLETASetDTECaratula();
			
			// estos datos son para el set de pruebas
			caratula.setFchResol(emisor.getFechaResolucion() );
			caratula.setNroResol(new BigInteger(emisor.getCodigoResolucion()));
			caratula.setRutReceptor(SiiDocumentFactoryConfiguration.SII_RUT_RECEPTOR); //emisor.getRutemisor());

			caratula.setRutEmisor(emisor.getRutemisor());
			caratula.setRutEnvia(rutfirmante);
			caratula.setTmstFirmaEnv(ahora);
			caratula.setVersion(BigDecimal.valueOf(1.0));
			
			// calcula subtotales por tipo de dte
			List<SubTotDTE> subtotdtes = new ArrayList<SubTotDTE>();
			for(Map.Entry<BigInteger, Integer> tupla:freq.entrySet()) {
				SubTotDTE subtotdte = new SubTotDTE();
				subtotdte.setNroDTE(BigInteger.valueOf(tupla.getValue()));
				subtotdte.setTpoDTE(tupla.getKey());
				subtotdtes.add(subtotdte);
			}
			
			// agrega todos los subtotales a la caratula
			caratula.getSubTotDTEs().addAll(subtotdtes);
			
			// crea el nuevo setDTE
			EnvioBOLETA.SetDTE newSetDte = objectfactory.createEnvioBOLETASetDTE();
			newSetDte.setCaratula(caratula);
			newSetDte.setID(BuilderXmlID.getIDforSetDte());
			newSetDte.getDTES().addAll(listaBoletas);
			
			// prepara el objeto de respuesta (lista de id dte en el set y el setdte en jaxb)
			response.setDteList(dteList);
			response.setJaxbsetdte(newSetDte);
			response.setXmlboletas(xmlTodasLasBoletas.toString());
			
			return response;
			
		} catch (Exception ex) {
			log.error("Se produjo un error creando la entidad setDTE. Error=" + ex.getMessage());
			ex.printStackTrace();			
			return null;
		}
	}
}
