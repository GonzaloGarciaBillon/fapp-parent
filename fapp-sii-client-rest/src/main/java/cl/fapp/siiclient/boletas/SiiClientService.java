package cl.fapp.siiclient.boletas;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import org.springframework.core.io.FileSystemResource;

import cl.fapp.siiclient.boletas.domain.envio.BoletaEnvioRequest;
import cl.fapp.siiclient.boletas.domain.envio.BoletaEnvioResponse;
import cl.fapp.siiclient.boletas.domain.envio.DteEnvioRequest;
import cl.fapp.siiclient.boletas.domain.envio.DteEnvioResponse;
import cl.fapp.siiclient.boletas.domain.envio.status.BoletaEnvioStatusResponse;
import cl.fapp.siiclient.boletas.domain.status.BoletaStatusResponse;
import cl.fapp.siiclient.boletas.exception.SiiClientNotAuthorizeException;
import cl.fapp.siiclient.boletas.exception.SiiClientWebClientException;

public interface SiiClientService {

        String getToken(X509Certificate cert, PrivateKey privateKey);

        BoletaEnvioResponse sendBoletas(BoletaEnvioRequest boletaEnvioRequest, byte[] file, String fileName,
                        String token) throws SiiClientNotAuthorizeException;

        DteEnvioResponse sendBDte(DteEnvioRequest dteEnvioRequest, byte[] file, String fileName,
                String token) throws SiiClientNotAuthorizeException;

        BoletaEnvioResponse sendBoletas(BoletaEnvioRequest boletaEnvioRequest, FileSystemResource file, String token)
    			throws SiiClientNotAuthorizeException;
        
        BoletaEnvioStatusResponse envioStatus(String rut, String dv, String trackid, String token)
                        throws SiiClientNotAuthorizeException, SiiClientWebClientException;

        
        BoletaStatusResponse boletaStatus(String rutEmisor, String dvEmisor, Integer tipo, Long folio,
                        String rutReceptor, String dvReceptor, BigInteger monto, String fechaEmision, String token)
                        throws SiiClientNotAuthorizeException, SiiClientWebClientException;

}
