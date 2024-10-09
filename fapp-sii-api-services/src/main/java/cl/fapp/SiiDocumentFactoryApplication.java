package cl.fapp;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import cl.fapp.restapi.controller.libros.CSVUtils;
import cl.fapp.restapi.controller.libros.RegistroCompraVentaBean;
import cl.fapp.restapi.controller.libros.RegistroCompraVentaCSVPositionBean;

@SpringBootApplication
@EnableCaching
// @EnableJpaRepositories("cl.fapp.repository.repos")
// @EntityScan("cl.fapp.repository.model")
public class SiiDocumentFactoryApplication {

	private static final String TWO_COLUMN_CSV = "csv/twoColumn.csv";

	// Bean Examples
	public static List<RegistroCompraVentaBean> simpleSyncPositionBeanExample() throws Exception {
		Path path = twoColumnCsvPath();
		return CSVUtils.csvToRegistroCompraVentaBean(path, RegistroCompraVentaCSVPositionBean.class);
	}

	public static void main(String[] args) {
		try {
			// List<RegistroCompraVentaBean> csvList = simpleSyncPositionBeanExample();
			SpringApplication.run(SiiDocumentFactoryApplication.class, args);

		} catch (Exception ex) {
			throw new RuntimeException("Error durante el inicio. Error=" + ex.getMessage());
		}
	}

	public static Path twoColumnCsvPath() throws URISyntaxException {
		URI uri = ClassLoader.getSystemResource(TWO_COLUMN_CSV).toURI();
		return Paths.get(uri);
	}

}
