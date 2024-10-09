package cl.fapp.pdfmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.configuration.Configuration;
import org.apache.fop.configuration.ConfigurationException;
import org.apache.fop.configuration.DefaultConfigurationBuilder;
import org.apache.xmlgraphics.util.MimeConstants;
import org.xml.sax.SAXException;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.pdfmanager.domain.PdfRequest;
import cl.fapp.common.os.OsController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PDFBuilder {
	FopFactory fopFactory;
	TransformerFactory transformerFactory;
	OsController osController;

	public PDFBuilder() {
		this.osController = new OsController();
		log.debug("Sistema operativo: " + osController.getOperatingSystem());
		initializeFactories();
	}

	private void initializeFactories() {
		DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
		Configuration cfg;
		try {
			cfg = cfgBuilder.build(getFileFromResourceAsStream("fop/fop-config.xml"));
			FopFactoryBuilder builder = new FopFactoryBuilder(new File(".").toURI(), new ClasspathResolverURIAdapter());
			builder.setConfiguration(cfg);

			fopFactory = builder.build();
			transformerFactory = TransformerFactory.newInstance();
		} catch (IllegalArgumentException | ConfigurationException e) {
			log.error("Error inicializando fábricas de FOP", e);
		}
	}

	/**
	 * Genera el pdf. Lo retorna en el OutputStream indicado como parametro
	 * 
	 * @param request entrada al servicio
	 * @param out     stream del pdf generado
	 */
	public void generatePdf(PdfRequest request, OutputStream out) {

		try {

			// configure fopFactory
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			foUserAgent.setCreator("FAPP");
			foUserAgent.setTitle("Servicio facturación FAPP");

			try {

				// Construct fop with desired output format
				Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

				// Setup XSLT
				InputStream is = getFoXsl(request.getTipoDte());
				StreamSource xslt = new StreamSource(is);

				// crea un transformer de tipo xslt
				Transformer transformer = transformerFactory.newTransformer(xslt);

				// Set the value of a <param> in the stylesheet
				transformer.setParameter("versionParam", "2.0");
				if (request.getLogo() != null) {
					transformer.setParameter("logo", this.logoPrepared(request.getLogo()));
				} else {
					transformer.setParameter("logo", "");
				}
				transformer.setParameter("resolcode", request.getResolucionCodigo());
				transformer.setParameter("resoldate", request.getResolucionFecha());

				// Setup input for XSLT transformation

				// --------- agregada el 18072023 ---------------
				// la codificacion en la base es utf-8 (para manejar tildes en el caf)
				log.debug("request.getDte()=" + request.getDte());
				String str = new String(request.getDte().getBytes(StandardCharsets.UTF_8));
				Source src = new StreamSource(new StringReader(str));
				// ----------------------------------------------

				// Resulting SAX events (the generated FO) must be piped through to FOP
				Result res = new SAXResult(fop.getDefaultHandler());

				// Start XSLT transformation and FOP processing
				transformer.transform(src, res);

			} catch (Exception ex) {
				System.out.println("Error realizando la transformacion del documento. Error=" + ex.getMessage());
				System.out.println(ex);
			}

		} catch (Exception ex) {
			System.out.println("Error creando FOUserAgent. Error=" + ex.getMessage());
			System.out.println(ex);
		}
	}

	/**
	 * Obtiene el archivo *2fo.xsl
	 * 
	 * @param tipo
	 * @return file xsl
	 * @throws IOException
	 */
	private InputStream getFoXsl(Integer tipo) throws IOException {
		String osName = osController.getOperatingSystem().toLowerCase();
		String xslFileName = getTemplateFileName(ConstantesTipoDocumento.valueOf(tipo)); // Obtiene el nombre del
																							// archivo XSLT

		if (osName.contains("windows")) {
			// En Windows, usa ClassLoader para acceder al archivo dentro del classpath
			return getFileFromResourceAsStream("xml/xslt/" + xslFileName);
		} else {
			// En Linux, usa el sistema de archivos para acceder al archivo directamente
			String basePath = "/home/billon/workspace/templates-xslt/"; // Ruta para Linux
			Path xslFilePath = Paths.get(basePath, xslFileName); // Construye la ruta completa del archivo
			if (!Files.exists(xslFilePath)) {
				throw new IOException("Archivo XSLT no encontrado: " + xslFilePath.toString());
			}
			return Files.newInputStream(xslFilePath); // Abre un InputStream para el archivo
		}
	}

	private String getTemplateFileName(ConstantesTipoDocumento tipoDocumento) {
		switch (tipoDocumento) {
			case BOLETA_AFECTA:
				return "boleta_termica_2fo.xsl";
			case NOTA_CREDITO:
				return "notaCredito2fo.xsl";
			case NOTA_DEBITO:
				return "notaCredito2fo.xsl";
			case FACTURA_AFECTA:
				return "factura_estandar_2fo.xsl";
			default:
				log.error("No existe definición de FO para el tipo de documento: " + tipoDocumento);
				return "sinDefinicion2fo.xsl";
		}
	}

	/**
	 * Prepara el logo para su visualización
	 * 
	 * @param logoBinario
	 * @return
	 * @throws SAXException
	 */
	private String logoPrepared(byte[] logoBinario) throws SAXException {
		// -->String str = new String(logoBinario, StandardCharsets.UTF_8);
		String encodedString = Base64.getEncoder().encodeToString(logoBinario);
		return "data:image/png;base64," + encodedString;
	}

	/**
	 * Recupera un archivo desde la carpeta 'resource'
	 * 
	 * @param fileName nombre del archivo
	 * @return el contenido del archivo en un stream
	 * @throws IllegalArgumentException
	 */
	private InputStream getFileFromResourceAsStream(String fileName) throws IllegalArgumentException {

		// el classloader que ha cargado esta clase
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);

		// el stream mantiene el contenido del archivo
		if (inputStream == null) {
			throw new IllegalArgumentException("Archivo no encontrado=" + fileName);
		} else {
			return inputStream;
		}
	}
}
