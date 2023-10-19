package cl.fapp.dte.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa un campo perteneciente a un documento
 * 
 * @param <T> tipo del dato que almacena la columna
 */
@Setter
@Getter
@AllArgsConstructor
public class CampoDocumento<T> {

	/**
	 * Identificador (ordinal) del campo dentro de la estructura que lo contiene
	 */
	private Integer id;
	
	/**
	 * Tag que representa al campo
	 */
	private String tag;
	
	/**
	 * Descripcion del campo
	 */
	private String descripcion;
	
	/**
	 * Tipo de dato que almacena el campo
	 */
	private String tipo = null;
	
	/**
	 * Si aplica, largo minimo del campo
	 */
	private Integer largomin = null;
	
	/**
	 * Si aplica, largo maximo del campo
	 */
	private Integer largomax = null;
	
	/**
	 * Flag para indicar si el campo: 
	 * <li><b>(I)</b> debe estar impreso</li>
	 * <li><b>(P)</b> se imprime traduciendo el codigo a glosa</li>
	 * <li><b>(N)</b> no es obligatoria su impresion</li>
	 */
	private String impresion;
	
	/**
	 * Lista de valores posibles que puede tomar el campo
	 */
	private List<T> valorposible = null;
	
	/**
	 * Tipo de documento en los que esta presente el campo
	 */
	private List<String> tipodocumento;
}
