package cl.fapp.restapi.controller.dte.notacredito.mapper.set;

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

import com.fasterxml.jackson.databind.ObjectMapper;

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
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GenerarDtesSetDTEControllerMapper {
    ObjectFactory objectfactory = new ObjectFactory();

    @Autowired
    DteRepository repoDte;

    @Autowired
    SetDTERepository repoSetDTE;

    public ConvertRequestToEnvioDTEResponse toEnvioDTESetDTE(Emisores emisor, String rutfirmante, GenerarSetDTERequest request, Integer tipoDocumentoEnSet) {
        Date ahora = new Date();
        ConvertRequestToEnvioDTEResponse response = new ConvertRequestToEnvioDTEResponse();
        String rutemisor = request.getRutEmisor();

        try {
            JAXBContext context = JAXBContext.newInstance(DTE.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            List<DTE> listaDtes = new ArrayList<>();

            List<Dte> listDte = repoDte.findByEmisoreRutemisorAndEstadoAndTipoDocumento(rutemisor, EntityDTEStatuses.CREADOFIRMADO.toString(), tipoDocumentoEnSet);

            Map<BigInteger, Integer> freq = new HashMap<>();
            List<Long> dteList = new ArrayList<>();
            StringWriter xmlTodosLosDTE = new StringWriter();
            log.debug("Procesando lista de DTE's");
            if (listDte.isEmpty()) {
                log.warn("No existen dtes para crear un set.");
                response.setDteList(dteList);
                response.setJaxbsetdte(null);
                return response;
            }
            for (Dte dte : listDte) {
                log.debug("IdDTE=" + dte.getIdDte());
                try {
                    String xmlContent = dte.getDocumentoXml();
                    log.debug("XML a deserializar: " + xmlContent);
                    log.debug("Iniciando unmarshalling del documento DTE con ID=" + dte.getIdDte());
                    DTE unmarshallDte = (DTE) unmarshaller.unmarshal(new StringReader(dte.getDocumentoXml()));
                    DTE.Documento documento = unmarshallDte.getDocumento();
                    // Loguear el documento completo como JSON
                    if (documento != null) {
                        try {
                            ObjectMapper objectMapper = new ObjectMapper();
                            String documentoJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(documento);
                            log.debug("Contenido completo del objeto Documento: " + documentoJson);
                        } catch (Exception e) {
                            log.error("Error al convertir el objeto Documento a JSON: " + e.getMessage());
                        }
                    } else {
                        log.error("El documento es nulo para el DTE con ID=" + dte.getIdDte());
                    }
                    if (unmarshallDte.getDocumento().getEncabezado() == null) {
                        log.error("El encabezado es nulo después de deserializar el documento DTE con ID=" + dte.getIdDte());
                        log.debug("Contenido completo del XML deserializado: " + dte.getDocumentoXml());
                    }
                    log.debug("Finalizado unmarshalling del documento DTE con ID=" + unmarshallDte.getDocumento().getID());
                    // Verificar si el encabezado es nulo antes de continuar
                    if (unmarshallDte.getDocumento().getEncabezado() == null) {
                        log.error("El encabezado es nulo después de deserializar el documento DTE con ID=" + dte.getIdDte());
                    } else {
                        log.debug("El encabezado se deserializó correctamente para el documento DTE con ID=" + dte.getIdDte());
                    }
                    log.debug("unmarshallDte=" + unmarshallDte.getDocumento().getID());

                    if (unmarshallDte == null || unmarshallDte.getDocumento() == null) {
                        log.error("El documento DTE es nulo para el idDTE=" + dte.getIdDte());
                        continue;
                    }

                    log.debug("Encabezado: "+unmarshallDte.getDocumento().getEncabezado());
                    log.debug("Encabezado-emisor: "+unmarshallDte.getDocumento().getEncabezado().getEmisor());
                    log.debug("Encabezado-receptor: "+unmarshallDte.getDocumento().getEncabezado().getReceptor());
                    log.debug("Encabezado-idDoc: "+unmarshallDte.getDocumento().getEncabezado().getIdDoc());
                    log.debug("Encabezado-totales: "+unmarshallDte.getDocumento().getEncabezado().getTotales());
                    log.debug("Encabezado-ted: "+unmarshallDte.getDocumento().getTED());
                    log.debug("Encabezado-tmstFirma: "+unmarshallDte.getDocumento().getTmstFirma());
                    log.debug("Detalles: "+unmarshallDte.getDocumento().getDetalles());
                    log.debug("DscRcgGlobals: "+unmarshallDte.getDocumento().getDscRcgGlobals());
                    log.debug("Referencias: "+unmarshallDte.getDocumento().getReferencias());
                    log.debug("SubTotInfos: "+unmarshallDte.getDocumento().getSubTotInfos());

                    DTE.Documento.Encabezado.IdDoc iddoc = unmarshallDte.getDocumento().getEncabezado().getIdDoc();
                    BigInteger key = iddoc.getTipoDTE();
                    int count = freq.containsKey(key) ? freq.get(key) : 0;
                    freq.put(key, count + 1);

                    unmarshallDte.setSignature(null);
                    unmarshallDte.getDocumento().setEncabezado(null);
                    unmarshallDte.getDocumento().setTED(null);
                    unmarshallDte.getDocumento().setTmstFirma(null);
                    unmarshallDte.getDocumento().getDetalles().clear();
                    unmarshallDte.getDocumento().getDscRcgGlobals().clear();
                    unmarshallDte.getDocumento().getReferencias().clear();
                    unmarshallDte.getDocumento().getSubTotInfos().clear();

                    listaDtes.add(unmarshallDte);
                    dteList.add(dte.getIdDte());

                    String xx = new String(dte.getDocumentoXml().getBytes("ISO-8859-1"));
                    String xmlboleta = xx.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><DTE version=\"1.0\">", SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<DTE version=\"1.0\">");
                    xmlboleta = xmlboleta.replace("</DTE>", "</DTE>");
                    xmlTodosLosDTE.write(xmlboleta);

                    log.debug("unmarshall entidad DTE id=" + dte.getIdDte() + ", jaxbobject.documento.id=" + unmarshallDte.getDocumento().getID());
                } catch (JAXBException e) {
                    log.error("[SKIP] Ocurrio un error realizando unmarshall para DTE id=" + dte.getIdDte() + ". Error=" + e.getMessage());
                    continue;
                }
            }

            EnvioDTE.SetDTE.Caratula caratula = objectfactory.createEnvioDTESetDTECaratula();
            caratula.setFchResol(emisor.getFechaResolucion());
            caratula.setNroResol(new BigInteger(emisor.getCodigoResolucion()));
            caratula.setRutReceptor(SiiDocumentFactoryConfiguration.SII_RUT_RECEPTOR);
            caratula.setRutEmisor(emisor.getRutemisor());
            caratula.setRutEnvia(rutfirmante);
            caratula.setTmstFirmaEnv(ahora);
            caratula.setVersion(BigDecimal.valueOf(1.0));

            List<EnvioDTE.SetDTE.Caratula.SubTotDTE> subtotdtes = new ArrayList<>();
            for (Map.Entry<BigInteger, Integer> tupla : freq.entrySet()) {
                EnvioDTE.SetDTE.Caratula.SubTotDTE subtotdte = objectfactory.createEnvioDTESetDTECaratulaSubTotDTE();
                subtotdte.setNroDTE(BigInteger.valueOf(tupla.getValue()));
                subtotdte.setTpoDTE(tupla.getKey());
                subtotdtes.add(subtotdte);
            }

            caratula.getSubTotDTEs().addAll(subtotdtes);

            EnvioDTE.SetDTE newSetDte = objectfactory.createEnvioDTESetDTE();
            newSetDte.setCaratula(caratula);
            newSetDte.setID(BuilderXmlID.getIDforSetDte());
            newSetDte.getDTES().addAll(listaDtes);

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
