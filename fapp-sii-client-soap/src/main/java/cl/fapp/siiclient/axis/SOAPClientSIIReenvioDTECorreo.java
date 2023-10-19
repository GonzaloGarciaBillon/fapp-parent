package cl.fapp.siiclient.axis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import cl.fapp.siiclient.axis.domain.correo.DteCorreoRequest;
import cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub;
import cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.ReenvioCorreo;
import cl.fapp.siiclient.axis.wsdtecorreo.WsDTECorreoServiceStub.ReenvioCorreoResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Configuration
@PropertySource("classpath:soap-siiclient.properties")
public class SOAPClientSIIReenvioDTECorreo {

	@Value("${soap.dte.correo.url}")
	private String soapDteCorreoUrl;

	/**
	 * Solicita re-envio del correo con el estado del procesamiento relacionado a un trackid
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeReenvioCorreoService(String token, DteCorreoRequest params) {
		try {
			log.debug("Parametros para SOAP-DTE-ReenvioCorreo=" + params);
			WsDTECorreoServiceStub stub = new WsDTECorreoServiceStub(soapDteCorreoUrl);

			ReenvioCorreo request = new ReenvioCorreo();
			request.setToken(token);
			request.setDvEmpresa(params.getDvEmpresa());
			request.setRutEmpresa(params.getRutEmpresa());
			request.setTrackId(params.getTrackId());

			ReenvioCorreoResponse response = stub.reenvioCorreo(request);
			return response.getReenvioCorreoReturn();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

}
