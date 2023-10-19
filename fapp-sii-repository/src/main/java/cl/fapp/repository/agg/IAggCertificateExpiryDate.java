package cl.fapp.repository.agg;

import java.util.Date;

/**
 * Agregacion para resultado de @Query nativas y no nativas para certificados proximos a expirar
 */
public interface IAggCertificateExpiryDate {

	public Long getIdKeystore();
	
	public String getRutFirmante();
	
	public String getRutEmisor();
	
	public String getRazonSocial();
	
	public Date getExpiryDate();
}
