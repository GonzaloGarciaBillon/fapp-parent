package cl.fapp.siiclient.axis;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.kernel.http.HTTPConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import cl.fapp.siiclient.axis.domain.reclamo.DteIngresarAceptacionReclamoRequest;
import cl.fapp.siiclient.axis.domain.reclamo.DteListarEventosHistDocRequest;
import cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub;
import cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub.DteEventoDocTo;
import cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub.IngresarAceptacionReclamoDoc;
import cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub.ListarEventosHistDoc;
import cl.fapp.siiclient.axis.registroreclamodte.RegistroReclamoDteServiceEndpointServiceStub.RespuestaTo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Configuration
@PropertySource("classpath:soap-siiclient.properties")
public class SOAPClientSIIRegistroReclamoDTE {

	@Value("${soap.dte.registro.reclamo.url}")
	private String soapDteRegistroReclamoUrl;

	/**
	 * Ingresa un reclamo para un DTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeIngresarAceptacionReclamoDocService(String token, DteIngresarAceptacionReclamoRequest params) {
		log.debug("Parametros para SOAP-DTE-IngresarAceptacionReclamo=" + params);
		try {
			RegistroReclamoDteServiceEndpointServiceStub stub = new RegistroReclamoDteServiceEndpointServiceStub(soapDteRegistroReclamoUrl);

			// se configura el cliente soap
			ServiceClient client = stub._getServiceClient();
			configureServiceClient(client, token);

			// prepara el request
			IngresarAceptacionReclamoDoc request = new IngresarAceptacionReclamoDoc();
			request.setAccionDoc(params.getAccionDoc());
			request.setDvEmisor(params.getDvEmisor());
			request.setFolio(params.getFolio());
			request.setRutEmisor(params.getRutEmisor());
			request.setTipoDoc(params.getTipoDoc());

			RegistroReclamoDteServiceEndpointServiceStub.IngresarAceptacionReclamoDocResponse response = stub.ingresarAceptacionReclamoDoc(request);
			log.debug("Response=" + response);
			RespuestaTo yy = response.get_return();

			log.debug("RespuestaTo.getCodResp()=" + yy.getCodResp());
			log.debug("RespuestaTo.getDescResp()=" + yy.getDescResp());
			log.debug("RespuestaTo.getRutToken()=" + yy.getRutToken());

			DteEventoDocTo[] xx = response.get_return().getListaEventosDoc();

			if (xx != null) {
				int i = 0;
				for (DteEventoDocTo doc : xx) {
					i++;
					log.debug("doc[" + i + "].getCodEvento()      =" + doc.getCodEvento());
					log.debug("doc[" + i + "].getDescEvento()     =" + doc.getDescEvento());
					log.debug("doc[" + i + "].getDvResponsable()  =" + doc.getDvResponsable());
					log.debug("doc[" + i + "].getFechaEvento()    =" + doc.getFechaEvento());
					log.debug("doc[" + i + "].getRutResponsable() =" + doc.getRutResponsable());
				}
			}

			return response.get_return().getDescResp();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Historico de eventos de un DTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeListarEventosHistDocService(String token, DteListarEventosHistDocRequest params) {
		log.debug("Parametros para SOAP-DTE-ListarEventosHistDoc=" + params);
		try {
			// instancia del stub a utilizar
			RegistroReclamoDteServiceEndpointServiceStub stub = new RegistroReclamoDteServiceEndpointServiceStub(soapDteRegistroReclamoUrl);

			// se configura el cliente soap
			ServiceClient client = stub._getServiceClient();
			configureServiceClient(client, token);

			// prepara el Request
			ListarEventosHistDoc request = new ListarEventosHistDoc();
			request.setDvEmisor(params.getDvEmisor());
			request.setFolio(params.getFolio());
			request.setRutEmisor(params.getRutEmisor());
			request.setTipoDoc(params.getTipoDoc());

			// utiliza el servicio
			RegistroReclamoDteServiceEndpointServiceStub.ListarEventosHistDocResponse response = stub.listarEventosHistDoc(request);
			log.debug("Response=" + response);

			RespuestaTo yy = response.get_return();

			log.debug("RespuestaTo.getCodResp()=" + yy.getCodResp());
			log.debug("RespuestaTo.getDescResp()=" + yy.getDescResp());
			log.debug("RespuestaTo.getRutToken()=" + yy.getRutToken());

			DteEventoDocTo[] xx = response.get_return().getListaEventosDoc();

			if (xx != null) {
				int i = 0;
				for (DteEventoDocTo doc : xx) {
					i++;
					log.debug("doc[" + i + "].getCodEvento()      =" + doc.getCodEvento());
					log.debug("doc[" + i + "].getDescEvento()     =" + doc.getDescEvento());
					log.debug("doc[" + i + "].getDvResponsable()  =" + doc.getDvResponsable());
					log.debug("doc[" + i + "].getFechaEvento()    =" + doc.getFechaEvento());
					log.debug("doc[" + i + "].getRutResponsable() =" + doc.getRutResponsable());
				}
			}

			return response.get_return().getDescResp();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Define el header a utilizar por el cliente
	 * 
	 * @param client instancia del cliente del servicio
	 * @param token  token a utilizar
	 */
	private void configureServiceClient(ServiceClient client, String token) {

		// referencia a las opciones del cliente del stub
		Options options = client.getOptions();

		// header propios
		if (token != null) {
			List<org.apache.axis2.context.NamedValue> headers = new ArrayList<org.apache.axis2.context.NamedValue>();
			headers.add(new org.apache.axis2.context.NamedValue("Cookie", "TOKEN=" + token));
			options.setProperty(HTTPConstants.HTTP_HEADERS, headers);
		}

		// establece otras propiedades
		options.setProperty(org.apache.axis2.Constants.Configuration.DISABLE_SOAP_ACTION, true);
	}
}
