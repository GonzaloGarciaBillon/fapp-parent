package cl.fapp.restapi.controller.rvd.mapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.common.domain.Rango;
import cl.fapp.common.domain.RangosResumenRVD;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.docs.DocumentoBOLETADefType;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.BOLETADefType.Documento.Encabezado.Totales;
import cl.fapp.sii.jaxb.ConsumoFolios;
import cl.fapp.sii.jaxb.ObjectFactory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VentasDiariasMapper {
	@Autowired
	DteRepository repoDTE;

	ObjectFactory jaxbFactory = new ObjectFactory();

	/**
	 * Busca todos los dte que seran informados en el resumen de ventas diarias, para un determinado emisor
	 * 
	 * @param fechaDesde desde que dia se buscaran dte's no informadas
	 * @param fechaHasta hasta que dia se buscaran dte's no informadas
	 * @param rutemisor  rut del emisor al que corresponden los folios que se informaran
	 * @param estado     estado en que deben encontrarse las boletas para ser consideradas
	 * @param List<tipoDocumento> tipos de documento a incluir en el RVD
	 */
	public Map<Integer, Resumen> cacularTotales(Date fechaDesde, Date fechaHasta, String rutemisor, EntityDTEStatuses estado, List<Integer> tipoDocumento) {
		try {
			// busca dte's en la fecha indicada
			List<Dte> dtes = repoDTE.findAllByEmisoreRutemisorAndCreatedatBetweenAndEstadoAndTipoDocumentoIn(rutemisor, fechaDesde, fechaHasta, estado.toString(), tipoDocumento);

			//-->List<Dte> dtes = repoDTE.findAllByCreatedatBetweenAndEstadoAndTipoDocumentoIn(fechaDesde, fechaHasta, estado.toString(), tipoDocumento);

			//List<Dte> dtes = repoDTE.findByEmisoreRutemisorAndEstado(rutemisor, estado.toString());
			if (dtes == null || dtes.size() <= 0) {
				log.error("No se encontraron boletas para el Emisor=" + rutemisor + ", en el periodo=[" + fechaDesde + ", " + fechaHasta + "]");
				throw new Exception("No hay boletas que informar");
			}

			// obtiene una instancia del documento BOLETADefType
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DocumentoBOLETADefType docxml = (DocumentoBOLETADefType) provider.getInstance("BOLETADEFTYPE");
			if (docxml == null) {
				log.error("No fue posible crear instancia de BOLETADEFTYPE");
				throw new Exception("No es posible crear instancia de BOLETADEFTYPE");
			}

			// contadores por tipo de documento
			Map<Integer, Resumen> freq = new HashMap<Integer, Resumen>();

			// revisa los dte del emisor
			for (Dte dte : dtes) {
				log.debug("Procesando dte=" + dte.getIdDocumento());
				BOLETADefType unmarshallxml = docxml.unmarshallXml(dte.getDocumentoXml(), BOLETADefType.class);
				Totales totales = unmarshallxml.getDocumento().getEncabezado().getTotales();
				log.debug("- Unmarshall documento ID=" + unmarshallxml.getDocumento().getID());

				// contador de totales por tipo de documento
				Integer key = unmarshallxml.getDocumento().getEncabezado().getIdDoc().getTipoDTE().intValue();

				// recupera el contador referenciado por tipo de documento
				Resumen element = freq.get(key);
				if (element == null) {
					Resumen resumen = new Resumen();
					resumen.setDocEmitidos(resumen.getDocEmitidos() + 1);
					resumen.setTotalExento(totales.getMntExe() == null ? BigInteger.ZERO : totales.getMntExe());
					resumen.setTotalIVA(totales.getIVA() == null ? BigInteger.ZERO : totales.getIVA());
					resumen.setTotalNeto(totales.getMntNeto() == null ? BigInteger.ZERO : totales.getMntNeto());
					resumen.setMontoTotal(totales.getMntTotal() == null ? BigInteger.ZERO : totales.getMntTotal());

					// establece el primer folio
					resumen.getListaFolios().add(BigInteger.valueOf(dte.getFolioAsignado()));

					// pone el nuevo contador de totales
					freq.put(key, resumen);

				} else {
					Resumen resumen = new Resumen();
					resumen.setDocEmitidos(element.getDocEmitidos() + 1);
					resumen.setTotalExento(element.getTotalExento().add(totales.getMntExe() == null ? BigInteger.ZERO : totales.getMntExe()));
					resumen.setTotalIVA(element.getTotalIVA().add(totales.getIVA() == null ? BigInteger.ZERO : totales.getIVA()));
					resumen.setTotalNeto(element.getTotalNeto().add(totales.getMntNeto() == null ? BigInteger.ZERO : totales.getMntNeto()));
					resumen.setMontoTotal(element.getMontoTotal().add(totales.getMntTotal() == null ? BigInteger.ZERO : totales.getMntTotal()));

					// actualiza lista de folios
					element.getListaFolios().add(BigInteger.valueOf(dte.getFolioAsignado()));
					resumen.getListaFolios().addAll(element.getListaFolios());

					// actualiza el contador de totales
					freq.put(key, resumen);
				}
			}

			// una vez terminado el proceso de las dte por tipo, se calculan los rangos
			freq.forEach((k, v) -> {
				log.debug("** Tipo doc=" + k + " **");

				// ordena la lista de folios (necesario para calcular los gaps)
				Collections.sort(v.getListaFolios());
				log.debug("Lista total de folios (ordenada) (afectos + exentos)=" + v.getListaFolios());

				// crea un arreglo con la lista de folios (utilizada para calcular los gaps)
				BigInteger[] foliosArray = new BigInteger[v.getListaFolios().size()];
				foliosArray = v.getListaFolios().toArray(foliosArray);

				// genera la lista de folios por rango. Retorna los gaps intermedios como no utilizados
				RangosResumenRVD rangosResumenRVD = getRangoFoliosUtilizadosAnulados(foliosArray, foliosArray.length);
				v.setDocUtilizados(rangosResumenRVD.getTotalUtilizados());
				v.setFoliosAnulados(rangosResumenRVD.getTotalAnulados());

				// agrega todos los elementos en forma de rangos
				v.getListaAnulados().addAll(rangosResumenRVD.getFoliosAnulados());
				v.getListaUtilizados().addAll(rangosResumenRVD.getFoliosUtilizados());
			});

			log.debug("RESUMEN=" + freq);

			return freq;

		} catch (Exception ex) {
			log.error("Se produjo un error construyendo el Resumen de Ventas Diarias. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * De un conjunto de numeros, obtiene en forma de {@link Rango} la lista de numeros que aparecen en el conjunto y aquellos que no aparecen considerando que es una secuencia
	 * 
	 * @param arreglo arreglo de numeros
	 * @param N       numero de elementos a analizar
	 * @return rango de numeros que aparecen en el arreglo de entrada y los que no aparecen (considerando una secuencia)
	 */
	public RangosResumenRVD getRangoFoliosUtilizadosAnulados(BigInteger arreglo[], int N) {

		// recorre el arreglo y va creando los rangos
		List<Rango> rangoFoliosUtilizados = new ArrayList<Rango>();
		List<Rango> rangoFoliosAnulados = new ArrayList<Rango>();

		// inicia a partir del elemento mas pequeño
		boolean folioUtilizadoEscrito = false;
		BigInteger inicio = null;
		BigInteger fin = null;
		BigInteger diff = arreglo[0].subtract(BigInteger.ZERO);
		for (BigInteger i = BigInteger.ZERO; i.compareTo(BigInteger.valueOf(N)) == -1; i = i.add(BigInteger.ONE)) {

			// verifica si diff y arr[i]-i son iguales o no (=>hay un gap)
			BigInteger valor = arreglo[i.intValue()].subtract(i);
			if (!valor.equals(diff)) {

				// crea un rango para los utilizados
				Rango folioUtilizado = new Rango(inicio, fin); //inicio == fin ? null : fin);
				rangoFoliosUtilizados.add(folioUtilizado);
				folioUtilizadoEscrito = true;

				// establece el nuevo rango de inicio/fin para los utilizados
				inicio = i.add(arreglo[i.intValue()].subtract(i));
				fin = inicio;
				folioUtilizadoEscrito = false;

				// crea un nuevo rango para llenar el gap
				BigInteger inicioAnulado = i.add(diff);
				BigInteger finAnulado = i.add(arreglo[i.intValue()].subtract(i)).subtract(BigInteger.ONE);
				Rango folioAnulado = new Rango(inicioAnulado, finAnulado.compareTo(inicioAnulado) == 0 ? /*null*/finAnulado : finAnulado);

				// aumenta el valor base
				diff = arreglo[i.intValue()].subtract(i);

				// agrega el rango a la lista
				rangoFoliosAnulados.add(folioAnulado);

			} else {
				folioUtilizadoEscrito = false;
				if (inicio == null) {
					inicio = arreglo[i.intValue()];
					fin = arreglo[i.intValue()];
				} else {
					fin = arreglo[i.intValue()];
				}
			}
		}

		if (!folioUtilizadoEscrito) {
			// escribe el ultimo elemento
			Rango folioUtilizado = new Rango(inicio, fin);
			rangoFoliosUtilizados.add(folioUtilizado);
		}

		RangosResumenRVD rdv = new RangosResumenRVD();
		rdv.setFoliosAnulados(rangoFoliosAnulados);
		rdv.setFoliosUtilizados(rangoFoliosUtilizados);

		BigInteger totalAnulados = BigInteger.ZERO;
		for (Rango rango : rangoFoliosAnulados) {
			BigInteger cardinalidad = rango.getFin().subtract(rango.getInicio());
			totalAnulados = totalAnulados.add(cardinalidad).add(BigInteger.ONE);
		}
		rdv.setTotalAnulados(totalAnulados.intValue());

		BigInteger totalUtilizados = BigInteger.ZERO;
		for (Rango rango : rangoFoliosUtilizados) {
			BigInteger cardinalidad = rango.getFin().subtract(rango.getInicio());
			totalUtilizados = totalUtilizados.add(cardinalidad).add(BigInteger.ONE);
		}
		rdv.setTotalUtilizados(totalUtilizados.intValue());

		return rdv;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	@ToString
	public class Resumen {
		private Integer docEmitidos = 0;
		private BigInteger totalNeto;
		private BigInteger totalIVA;
		private BigInteger totalExento;
		private BigInteger montoTotal;
		private Integer foliosAnulados;
		private Integer docUtilizados;
		private List<BigInteger> listaFolios = new ArrayList<BigInteger>();
		private List<Rango> listaUtilizados = new ArrayList<Rango>();
		private List<Rango> listaAnulados = new ArrayList<Rango>();

		public ConsumoFolios.DocumentoConsumoFolios.Resumen toJAXBResumen(BigInteger tipodoc, BigDecimal tasaIVA) {
			ConsumoFolios.DocumentoConsumoFolios.Resumen resumen = jaxbFactory.createConsumoFoliosDocumentoConsumoFoliosResumen();
			if (this.foliosAnulados != null) {
				resumen.setFoliosAnulados(BigInteger.valueOf(this.foliosAnulados));
			}

			if (this.docEmitidos != null) {
				resumen.setFoliosEmitidos(BigInteger.valueOf(this.docEmitidos));
			}

			if (this.docUtilizados != null) {
				resumen.setFoliosUtilizados(BigInteger.valueOf(this.docUtilizados));
			}

			for (Rango rango : this.listaUtilizados) {
				ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoUtilizados rangoUtilizados = jaxbFactory.createConsumoFoliosDocumentoConsumoFoliosResumenRangoUtilizados();
				rangoUtilizados.setInicial(rango.getInicio());
				rangoUtilizados.setFinal(rango.getFin());
				resumen.getRangoUtilizados().add(rangoUtilizados);
			}

			for (Rango rango : this.listaAnulados) {
				ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoAnulados rangoAnulados = jaxbFactory.createConsumoFoliosDocumentoConsumoFoliosResumenRangoAnulados();
				rangoAnulados.setInicial(rango.getInicio());
				rangoAnulados.setFinal(rango.getFin());
				resumen.getRangoAnulados().add(rangoAnulados);
			}

			resumen.setMntExento(this.totalExento);
			resumen.setMntIva(this.totalIVA);
			resumen.setMntNeto(this.totalNeto);
			resumen.setMntTotal(this.montoTotal);
			resumen.setTasaIVA(tasaIVA);
			resumen.setTipoDocumento(tipodoc);

			return resumen;
		}

	}
}
