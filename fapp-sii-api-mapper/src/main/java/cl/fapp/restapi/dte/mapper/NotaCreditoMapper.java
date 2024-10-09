package cl.fapp.restapi.dte.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import cl.fapp.restapi.dte.domain.DTEDescuentoRecargo;
import cl.fapp.restapi.dte.domain.DTEDetalle;
import cl.fapp.restapi.dte.domain.DTEDocumento;
import cl.fapp.restapi.dte.domain.DTEEmisor;
import cl.fapp.restapi.dte.domain.DTEReferencia;
import cl.fapp.restapi.dte.dto.GenerarDTERequest;
import cl.fapp.restapi.dte.dto.GenerarNotaCreditoRequest;


@Mapper
public abstract class NotaCreditoMapper {
	@Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "rutEmisor", source = "rutEmisor")
    @Mapping(target = "rutFirmante", source = "rutFirmante")
    @Mapping(target = "emisor", source = "emisor")
    @Mapping(target = "actividadEconomica", source = "actividadEconomica")
    @Mapping(target = "dtes", source = "dtes")
    public abstract GenerarDTERequest toGenerarDTERequest(GenerarNotaCreditoRequest notacredito);

	public abstract DTEEmisor toDTEEmisor(DTEEmisor emisor);

	public abstract DTEDocumento toDTEDocumento(DTEDocumento documento);

	public abstract DTEDetalle toDTEDetalle(DTEDetalle detalle);

	public abstract DTEDescuentoRecargo toDTEDescuentoRecargo(DTEDescuentoRecargo descuentoRecargo);

	public abstract DTEReferencia toDTEReferencia(DTEReferencia referencia);
}
