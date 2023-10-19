package cl.fapp.repository.agg;

/**
 * Agregacion para resultado de @Query nativas y no nativas para CAF por Emisor
 */
public interface IAggCafPorEmisor {
	public Long getIdCaf();
	public String getRutEmisor();
	public Integer getTipoDocumento();
	public Integer getDisponibles();
	public String getTipoAlarma();
}
