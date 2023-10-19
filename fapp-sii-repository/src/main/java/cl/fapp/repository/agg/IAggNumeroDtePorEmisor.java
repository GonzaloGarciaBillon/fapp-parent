package cl.fapp.repository.agg;

/**
 * Agregacion para resultado de @Query nativas y no nativas para DTE por Emisor
 */
public interface IAggNumeroDtePorEmisor {

	public String getRutEmisor();
	
	public String getRutFirmante();
	
	public Integer getTamanoParticion();
	
	//public Integer getTipoDocumento();

	public Integer getNroDtes();
	
	public Integer getNroIteraciones();
	
	public Integer getDtesRemanentes();

	//public String getListaFolios();
}
