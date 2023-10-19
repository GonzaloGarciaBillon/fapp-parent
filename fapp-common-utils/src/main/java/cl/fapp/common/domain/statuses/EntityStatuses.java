package cl.fapp.common.domain.statuses;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Estados posibles de un registro en la entidad CAF
 */
public class EntityStatuses {

	/**
	 * Lista de nombres que pueden ser utilizados para cada subclase de tipo EntityStatuses.
	 * En definitiva, retorna la lista de estados disponibles para una determinada clase
	 * 
	 * @param clazz nombre de la clase
	 * @return lista de nombres ({@link List}) de los atributos declarados en la clase
	 */
	public static List<String> getStatuses(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();
		Collections.addAll(fields, clazz.getFields());
		List<String> response = new ArrayList<String>();
		fields.forEach(f -> response.add(f.getName()));
		return response;
	}

	/**
	 * Estados posibles de un registro en la entidad CAF
	 */
	public class CAF {
		public static StatusesRecord UTILIZADO = new StatusesRecord(1, "UTILIZADO", "UTILIZADO");
		public static StatusesRecord ACTIVO = new StatusesRecord(2, "ACTIVO", "ACTIVO");
		public static StatusesRecord DISPONIBLE = new StatusesRecord(3, "DISPONIBLE", "DISPONIBLE");
	}

	/**
	 * Estados posibles de un registro en la entidad DTE
	 */
	public class DTE {
		public static StatusesRecord CREADOFIRMADO = new StatusesRecord(1, "CREADOFIRMADO", "CREADOFIRMADO");
		public static StatusesRecord CREADONOFIRMADO = new StatusesRecord(2, "CREADONOFIRMADO", "CREADONOFIRMADO");
		public static StatusesRecord SETDTENOASIGNADO = new StatusesRecord(3, "SETDTENOASIGNADO", "SETDTENOASIGNADO");
		public static StatusesRecord SETDTEASIGNADO = new StatusesRecord(4, "SETDTEASIGNADO", "SETDTEASIGNADO");
	}

	/**
	 * Estados posibles de un registro en la entidad EMISORES
	 */
	public class EMISORES {
		public static StatusesRecord ACTIVO = new StatusesRecord(1, "ACTIVO", "ACTIVO");
		public static StatusesRecord SUSPENDIDO = new StatusesRecord(2, "SUSPENDIDO", "SUSPENDIDO");
		public static StatusesRecord SINVALIDAR = new StatusesRecord(3, "SINVALIDAR", "SINVALIDAR");
		public static StatusesRecord ELIMINADO = new StatusesRecord(4, "ELIMINADO", "ELIMINADO");
	}

	/**
	 * Estados posibles de un registro en la entidad FIRMANTES
	 */
	public class FIRMANTES {
		public static StatusesRecord ACTIVO = new StatusesRecord(1, "ACTIVO", "ACTIVO");
		public static StatusesRecord SUSPENDIDO = new StatusesRecord(2, "SUSPENDIDO", "SUSPENDIDO");
		public static StatusesRecord SINVALIDAR = new StatusesRecord(3, "SINVALIDAR", "SINVALIDAR");
		public static StatusesRecord ELIMINADO = new StatusesRecord(4, "ELIMINADO", "ELIMINADO");
	}

	/**
	 * Estados posibles de un registro en la entidad SETDTE
	 */
	public class SETDTE {
		public static StatusesRecord ENVIOPENDIENTE = new StatusesRecord(1, "ENVIOPENDIENTE", "ENVIOPENDIENTE");
		public static StatusesRecord ENVIADO = new StatusesRecord(2, "ENVIADO", "ENVIADO");
		public static StatusesRecord FIRMAPENDIENTE = new StatusesRecord(3, "FIRMAPENDIENTE", "FIRMAPENDIENTE");
	}
}
