package cl.fapp.restapi.dte.mapper;

import org.mapstruct.Mapper;

import cl.fapp.restapi.dte.domain.DTEDescuentoRecargo;
import cl.fapp.restapi.dte.domain.DTEDetalle;
import cl.fapp.restapi.dte.domain.DTEDocumento;
import cl.fapp.restapi.dte.domain.DTEEmisor;
import cl.fapp.restapi.dte.domain.DTEReferencia;
import cl.fapp.restapi.dte.dto.GenerarDTERequest;
import cl.fapp.restapi.dte.dto.GenerarNotaDebitoRequest;

@Mapper
public abstract class NotaDebitoMapper {
	public abstract GenerarDTERequest toGenerarDTERequest(GenerarNotaDebitoRequest notacredito);

	public abstract DTEEmisor toDTEEmisor(DTEEmisor emisor);

	public abstract DTEDocumento toDTEDocumento(DTEDocumento documento);

	public abstract DTEDetalle toDTEDetalle(DTEDetalle detalle);

	public abstract DTEDescuentoRecargo toDTEDescuentoRecargo(DTEDescuentoRecargo descuentoRecargo);

	public abstract DTEReferencia toDTEReferencia(DTEReferencia referencia);
}
