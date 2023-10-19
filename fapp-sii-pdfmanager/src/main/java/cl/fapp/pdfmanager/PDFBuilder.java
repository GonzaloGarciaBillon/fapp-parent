package cl.fapp.pdfmanager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
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

public class PDFBuilder {
	FopFactory fopFactory;
	TransformerFactory transformerFactory;
	{
		DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
		Configuration cfg;
		try {
			cfg = cfgBuilder.build(getFileFromResourceAsStream("fop/fop-config.xml"));
			FopFactoryBuilder builder = new FopFactoryBuilder(new File(".").toURI(), new ClasspathResolverURIAdapter());
			builder = builder.setConfiguration(cfg);

			fopFactory = builder.build();
			transformerFactory = TransformerFactory.newInstance();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				}
				transformer.setParameter("resolcode", request.getResolucionCodigo());
				transformer.setParameter("resoldate", request.getResolucionFecha());

				// Setup input for XSLT transformation
				
				// --------- agregada el 18072023 ---------------
				 // la codificacion en la base es utf-8 (para manejar tildes en el caf)
				String str = new String(request.getDte().getBytes("UTF-8"));
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

		String foXml = "";
		ConstantesTipoDocumento tipoDocumento = ConstantesTipoDocumento.valueOf(tipo);

		switch (tipoDocumento) {

		case BOLETA_AFECTA:
			foXml = "xml/xslt/boleta2fo.xsl";
			break;

		case NOTA_CREDITO:
			foXml = "xml/xslt/notaCredito2fo.xsl";
			break;

		default:
			System.out.println("No existe definición de FO para el tipo de documento: " + tipo);
			foXml = "xml/xslt/sinDefinicion2fo.xsl";
			break;

		}

		//-->Resource testFoFileResource = this.resourceLoader.getResource(foXml);
		//-->return testFoFileResource.getInputStream();
		return getFileFromResourceAsStream(foXml);
	}

	/**
	 * Prepara el logo para su visualización
	 * 
	 * @param logoBinario
	 * @return
	 * @throws SAXException
	 */
	private String logoPrepared(byte[] logoBinario) throws SAXException {
		//-->String str = new String(logoBinario, StandardCharsets.UTF_8);
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
