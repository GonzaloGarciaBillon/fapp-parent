package cl.fapp.siiclient.axis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import cl.fapp.siiclient.axis.domain.consultas.EstadoDteAVRequest;
import cl.fapp.siiclient.axis.domain.consultas.EstadoDteRequest;
import cl.fapp.siiclient.axis.domain.consultas.EstadoUploadRequest;
import cl.fapp.siiclient.axis.query.estdte.QueryEstDteServiceStub;
import cl.fapp.siiclient.axis.query.estdte.QueryEstDteServiceStub.GetEstDte;
import cl.fapp.siiclient.axis.query.estdte.QueryEstDteServiceStub.GetEstDteResponse;
import cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub;
import cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv;
import cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse;
import cl.fapp.siiclient.axis.query.estup.QueryEstUpServiceStub;
import cl.fapp.siiclient.axis.query.estup.QueryEstUpServiceStub.GetEstUp;
import cl.fapp.siiclient.axis.query.estup.QueryEstUpServiceStub.GetEstUpResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Configuration
@PropertySource("classpath:soap-siiclient.properties")
public class SOAPClientSIIConsultas {

	@Value("${soap.query.estado.dte.url}")
	private String soapEstadoDteUrl;

	@Value("${soap.query.estado.dte.av.url}")
	private String soapEstadoDteAvanzadaUrl;

	@Value("${soap.query.estado.upload.url}")
	private String soapEstadoUploadUrl;

	/**
	 * Invoca servicio SOAP de consulta de estado de un DTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeEstadoDteService(String token, EstadoDteRequest params) {
		try {
			log.debug("Parametros para SOAP-DTE-ConsultaEstado=" + params);
			QueryEstDteServiceStub stub = new QueryEstDteServiceStub(soapEstadoDteUrl);

			GetEstDte request = new GetEstDte();
			request.setToken(token);
			request.setDvCompania(params.getDvCompania());
			request.setDvConsultante(params.getDvConsultante());
			request.setDvReceptor(params.getDvReceptor());
			request.setFechaEmisionDte(params.getFechaEmisionDte());
			request.setFolioDte(params.getFolioDte());
			request.setMontoDte(params.getMontoDte());
			request.setRutCompania(params.getRutCompania());
			request.setRutConsultante(params.getRutConsultante());
			request.setRutReceptor(params.getRutReceptor());
			request.setTipoDte(params.getTipoDte());
			request.setToken(token);

			GetEstDteResponse response = stub.getEstDte(request);
			return response.getGetEstDteReturn();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Invoca servicio SOAP de consulta de estado avanzada de un DTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeEstadoDteAVService(String token, EstadoDteAVRequest params) {
		try {
			log.debug("Parametros para SOAP-DTE-ConsultaEstadoAvanzada=" + params);
			QueryEstDteAvServiceStub stub = new QueryEstDteAvServiceStub(soapEstadoDteAvanzadaUrl);

			GetEstDteAv request = new GetEstDteAv();
			request.setToken(token);
			request.setDvEmpresa(params.getDvEmpresa());
			request.setDvReceptor(params.getDvReceptor());
			request.setFechaEmisionDte(params.getFechaEmisionDte());
			request.setFirmaDte(params.getFirmaDte());
			request.setFolioDte(params.getFolioDte());
			request.setMontoDte(params.getMontoDte());
			request.setRutEmpresa(params.getRutEmpresa());
			request.setRutReceptor(params.getRutReceptor());
			request.setTipoDte(params.getTipoDte());

			GetEstDteAvResponse response = stub.getEstDteAv(request);
			return response.getGetEstDteAvReturn();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Invoca servicio SOAP de consulta el estado de un EnvioDTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeEstadoUploadService(String token, EstadoUploadRequest params) {
		try {
			log.debug("Parametros para SOAP-DTE-ConsultaEstadoUpload=" + params);
			QueryEstUpServiceStub stub = new QueryEstUpServiceStub(soapEstadoUploadUrl);

			GetEstUp request = new GetEstUp();
			request.setToken(token);
			log.debug(token);
			request.setDvCompania(params.getDvCompania());
			request.setRutCompania(params.getRutCompania());
			request.setTrackId(params.getTrackId());

			GetEstUpResponse response = stub.getEstUp(request);
			return response.getGetEstUpReturn();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}
}
