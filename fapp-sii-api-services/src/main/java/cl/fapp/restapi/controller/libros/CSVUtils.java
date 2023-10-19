package cl.fapp.restapi.controller.libros;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVUtils {

	/**
	 * Convierte datos tipo CSV, en una lista de bean de tipo {@link RegistroCompraVentaBean}
	 * 
	 * @param path  path al archivo que contiene los datos en formato CSV
	 * @param clazz bean al cual convertir cada registro CSV
	 * @return lista de bean de tipo <b>clazz</b> con el contenido del CSV
	 * @throws Exception
	 */
	public static List<RegistroCompraVentaBean> csvToRegistroCompraVentaBean(Path path, Class<? extends RegistroCompraVentaBean> clazz) throws Exception {
		CsvTransfer csvTransfer = new CsvTransfer();
		try (Reader reader = Files.newBufferedReader(path)) {
			// @formatter:off
			CsvToBean<RegistroCompraVentaBean> cb = new CsvToBeanBuilder<RegistroCompraVentaBean>(reader)
					.withSkipLines(1)
					.withSeparator(';')
					.withType(clazz)
					.build();
			// @formatter:on

			csvTransfer.setBeanList(cb.parse());
		}

		return csvTransfer.getBeanList();
	}
}
