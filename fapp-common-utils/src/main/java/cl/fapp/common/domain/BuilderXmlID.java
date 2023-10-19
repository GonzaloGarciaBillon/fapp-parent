package cl.fapp.common.domain;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BuilderXmlID {
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * Retorna el ID de un setdte. Este ID es utilizado como identificador del SETDTE en el archivo xml
	 * 
	 * @return id basado en la hora
	 */
	public static String getIDforSetDte() {
		synchronized (sdf) {
			return "S" + sdf.format(new Date());
		}
	}

	/**
	 * Retorna el ID de un dte. Este ID es utilizado como identificador del DTE en el archivo xml
	 * 
	 * @param folio numero de folio del documento
	 * @return
	 */
	public static String getIDforDte(Long folio) {
		synchronized (sdf) {
			return "D" + sdf.format(new Date()) + String.format("%010d", folio);
		}
	}

	/**
	 * Retorna el ID de una boleta. Este ID es utilizado como identificador de la boleta en el archivo xml
	 * 
	 * @param folio numero de folio del documento
	 * @return
	 */
	public static String getIDforBoleta(Long folio) {
		synchronized (sdf) {
			return "B" + sdf.format(new Date()) + String.format("%010d", folio);
		}
	}

	/**
	 * Retorna el ID para un RVD. Este ID es utilizado como identificador del RVD en el archivo xml
	 * 
	 * @return
	 */
	public static String getIDforRVD() {
		synchronized (sdf) {
			return "RVD" + sdf.format(new Date());
		}
	}

	/**
	 * Retorna el ID para una factura afecta. Este ID es utilizado como identificador de la factura afecta en el archivo xml
	 * 
	 * @param folio numero de folio del documento
	 * @return
	 */
	public static String getIDforFacturaAfecta(Long folio) {
		synchronized (sdf) {
			return "FA" + sdf.format(new Date()) + String.format("%010d", folio);
		}
	}

	/**
	 * Retorna el ID para una factura exenta. Este ID es utilizado como identificador de la factura exenta en el archivo xml
	 * 
	 * @param folio numero de folio del documento
	 * @return
	 */
	public static String getIDforFacturaExenta(Long folio) {
		synchronized (sdf) {
			return "FE" + sdf.format(new Date()) + String.format("%010d", folio);
		}
	}

	/**
	 * Retorna el ID para una nota de credito. Este ID es utilizado como identificador de la nota de credito en el archivo xml
	 * 
	 * @param folio numero de folio del documento
	 * @return
	 */
	public static String getIDforNotaCredito(Long folio) {
		synchronized (sdf) {
			return "NC" + sdf.format(new Date()) + String.format("%010d", folio);
		}
	}

	/**
	 * Retorna el ID para una nota de debito. Este ID es utilizado como identificador de la nota de debito en el archivo xml
	 * 
	 * @param folio numero de folio del documento
	 * @return
	 */
	public static String getIDforNotaDebito(Long folio) {
		synchronized (sdf) {
			return "ND" + sdf.format(new Date()) + String.format("%010d", folio);
		}
	}

	/**
	 * Retorna el ID para un libro de compra/venta. Este ID es utilizado como identificador del libro de compra/venta en el archivo xml
	 * @return
	 */
	public static String getIDforLibroCompraVenta() {
		synchronized (sdf) {
			return "LCV" + sdf.format(new Date());
		}
	}

	/**
	 * Genera un UUID v4, para ser asignado a un DTE. Utiliza SHA-256 y un random UUID
	 * 
	 * @return
	 */
	public static String genDTEUUIDv4() {
		try {
			MessageDigest salt = MessageDigest.getInstance("SHA-256");
			salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
			String digest = bytesToHex(salt.digest());
			return digest;

		} catch (Exception ex) {
			log.error("No fue posible generar UUID. Error=" + ex.getMessage());
			return null;
		}
	}

	private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

	/**
	 * Convierte un byte array en un string hexadecimal
	 * 
	 * @param bytes arreglo de bytes
	 * @return representacion hexadecimal del arreglo de bytes
	 */
	private static String bytesToHex(byte[] bytes) {
		final char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			final int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
