package cl.fapp.restapi.controller.pdf;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.jsend.JSend;
import cl.fapp.pdfmanager.PDFBuilder;
import cl.fapp.pdfmanager.domain.PdfRequest;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.restapi.controller.impresoras.Print;
import cl.fapp.services.dtelocator.ServiceDTELocatorSimple;
import cl.fapp.services.dtelocator.dto.ServiceDTELocatorSimpleRequest;
import cl.fapp.services.dtelocator.dto.ServiceDTELocatorSimpleResponse;
import cl.fapp.services.mail.EmailServiceImpl;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.restapi.security.service.RateLimitingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "GENERAR-PDF-FROM-DTE", description = "API para generacion de documentos PDF a partir de datos de un DTE")
public class GenerarPDFController {

	@Autowired
	ServiceDTELocatorSimple dteLocator;

	@Autowired
	EmailServiceImpl emailService;

	@Autowired
	Print printService;

	@Autowired
	RateLimitingService rateLimitingService;
	// @formatter:off

	/**
	 * Genera un pdf a partir de los datos de un DTE. 
	 * Primero se realiza la busqueda del DTE, aplicando diferentes filtros. 
	 * Si se encuentra, se crea el PDF de este DTE. Si no se encuenta, retorna error. 
	 * Si en los parametros de entrada se indica el email del receptor, se envia el pdf generado a este correo.
	 * 
	 * @param payload datos a aplicar como filtros en la busqueda del DTE. Tambien se incluye email en donde enviar el PDF. Si no se indica, no se envia el PDF.
	 * @return la api retornara el pdf generado
	 */
	 
	// @formatter:on
	@RequestMapping(method = RequestMethod.POST, value = "/pdffromdte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarPDFfromDTE(@RequestBody ServiceDTELocatorSimpleRequest payload,
			HttpServletRequest request) {
		if (!rateLimitingService.isAllowed(request.getRemoteAddr(), request.getRequestURI())) {
			return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(JSend.error("Demasiadas solicitudes"));
		}
		try {
			ServiceDTELocatorSimpleResponse dtelocatorResponse = dteLocator.locatorSimple(payload);
			Dte dte = dtelocatorResponse.getDte();
			Emisores emisor = dtelocatorResponse.getEmisor();
			// verifica si se indico el correo en el input al servicio
			String emailReceptor = payload.getEmailReceptor();
			String impresora = payload.getImpresora();
			// String puerto = payload.getPuerto();
			// String tipoImpresora = payload.getTipoImpresora();
			if (dtelocatorResponse == null) {
				log.error("No fue posible localizar DTE utilizando los filtros indicados. Payload=" + payload);
				throw new Exception("No se localiza DTE");
			} else {
				log.debug("Localizado DTE=" + dtelocatorResponse.getDte().getIdDte());

				// crea el pdf
				PdfRequest pdfRequest = new PdfRequest();
				pdfRequest.setDte(dtelocatorResponse.getDte().getDocumentoXml());

				pdfRequest.setLogo(dtelocatorResponse.getEmisor().getLogo());
				pdfRequest.setResolucionCodigo(dtelocatorResponse.getEmisor().getCodigoResolucion());

				// -------------------------------------------------------------------------------
				// convierte la fecha de resolucion a string con formato dd-MM-yyyy
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				Instant instant = dtelocatorResponse.getEmisor().getFechaResolucion().toInstant();
				LocalDateTime ldt = instant.atZone(ZoneId.of("UTC")).toLocalDateTime();
				// -------------------------------------------------------------------------------

				pdfRequest.setResolucionFecha(ldt.format(formatter));
				pdfRequest.setRut(dtelocatorResponse.getEmisor().getRutemisor());
				pdfRequest.setTipoDte(dtelocatorResponse.getDte().getTipoDocumento());
				ByteArrayOutputStream osStream = new ByteArrayOutputStream();
				PDFBuilder builder = new PDFBuilder();
				builder.generatePdf(pdfRequest, osStream);
				String base64 = Base64.getEncoder().encodeToString(osStream.toByteArray());
				String bs = new String(base64.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);

				String filename = dtelocatorResponse.getDte().getIdDocumento() + ".pdf";

				// windows
				// String pathToAttachment = "c:/borrame/" + filename;

				// linux
				String pathToAttachment = "/home/billon/temp/" + filename;

				// Seccion para enviar pdf por correo
				if (emailReceptor != null && !emailReceptor.isBlank() && !emailReceptor.isEmpty()) {
					log.debug("Se indica correo => se enviara el pdf al correo indicado=" + emailReceptor);
					try {
						// emailService.sendMessageWithAttachment(emailReceptor, "Prueba boleta",
						// "Adjuntamos su boleta", filename, pathToAttachment);
						if (emailService.sendHtmlMessageWithSendGrid(emailReceptor, "Prueba boleta",
								"Adjuntamos su boleta", filename, osStream.toByteArray(), dte, emisor)) {
							log.debug("Correo enviado exitosamente a " + emailReceptor);
							return ResponseEntity.ok()
									.body(JSend.success("Correo enviado exitosamente a " + emailReceptor));
						} else {
							log.debug("Se produjo un error al enviar el correo a " + emailReceptor);
							return ResponseEntity.ok()
									.body(JSend.error("Se produjo un error al enviar el correo a " + emailReceptor));
						}
					} catch (Exception ex) {
						log.error("Se produjo un error enviando PDF por correo. Error=" + ex.getMessage());
						return ResponseEntity.ok()
								.body(JSend.error("PDF generado, pero no enviado a=" + emailReceptor));
					}
					// Seccion para imprimir pdf
				} else if ((impresora != null && !impresora.isBlank() && !impresora.isEmpty())) {
					try {
						log.debug("Se indica impresora => se enviara el pdf a la impresora: " + impresora);

						OutputStream outputStream = new FileOutputStream(pathToAttachment);
						osStream.writeTo(outputStream);
						outputStream.close();
						// Enviar la tarea de impresión
						printService.setFilePath(pathToAttachment);
						printService.print();
						// Delete the file after printing
						File fileToDelete = new File(pathToAttachment);
						if (fileToDelete.delete()) {
							log.debug("Archivo eliminado después de la impresión: " + pathToAttachment);
						} else {
							log.debug("No se pudo eliminar el archivo después de la impresión: " + pathToAttachment);
						}
						return ResponseEntity.ok().body(JSend.success("Impresión enviada")); // cambiar esto por sistema
																								// de impresion
					} catch (IllegalArgumentException e) {
						return ResponseEntity.ok().body(
								JSend.error("No se encontró la impresora con la dirección IP: " + e.getMessage()));
					} catch (Exception e) {
						return ResponseEntity.ok().body(JSend.error("No se pudo imprimir: " + e.getMessage()));
					}

					// Seccion para descargar/visualizar pdf
				} else {
					// se retorna el pdf como base64
					return ResponseEntity.ok().body(JSend.success(bs));
				}
			}
		} catch (Exception ex) {
			log.error("Ocurrio un error generando PDF. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Recupera el xml de un DTE, realiza unmarshall, y retorna un objeto json que
	 * contiene los datos del xml
	 * 
	 * @param payload datos a aplicar como filtros en la busqueda del DTE.
	 * @return la api retornara los datos del DTE que se encuentran en el xml
	 */
	@PostMapping(value = "/datosboleta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> getDataFromDTE(@RequestBody GetDataFromDTERequest payload,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		String requestPath = request.getRequestURI();
		if (!rateLimitingService.isAllowed(clientIp, requestPath)) {
			return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(JSend.error("Demasiadas solicitudes"));
		}
		try {
			ServiceDTELocatorSimpleRequest newRequest = new ServiceDTELocatorSimpleRequest();
			newRequest.setEmailReceptor(null);
			newRequest.setDteFolioAsignado(payload.getDteFolioAsignado());
			newRequest.setDteMonto(payload.getDteMonto());
			newRequest.setDteRutEmisor(payload.getDteRutEmisor());
			newRequest.setDteTipoDocumento(payload.getDteTipoDocumento());
			newRequest.setDteUUID(payload.getDteUUID());

			// ubica un dte en base al request
			String logo = null;
			ServiceDTELocatorSimpleResponse dtelocatorResponse = dteLocator.locatorSimple(newRequest);
			if (dtelocatorResponse == null) {
				log.error("No fue posible localizar DTE utilizando los filtros indicados. Payload=" + payload);
				throw new Exception("No se localiza Boleta");

			} else {
				log.debug("Localizado DTE=" + dtelocatorResponse.getDte().getIdDte());
				byte[] logoArray = dtelocatorResponse.getEmisor().getLogo();
				if (logoArray != null && logoArray.length > 0) {
					// obtiene y cambia el tamano al logo
					BufferedImage originalImage = ImageIO
							.read(new ByteArrayInputStream(dtelocatorResponse.getEmisor().getLogo()));
					if (originalImage != null) {
						BufferedImage resizedImage = resizeImage(originalImage, 350, 350);

						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						ImageIO.write(resizedImage, "png", bos);
						byte[] encoded = Base64.getEncoder().encode(bos.toByteArray());
						logo = new String(encoded);
					} else {
						logo = "";
					}
				} else {
					logo = "";
				}

				// obtiene el ted
				// patron de busqueda que se aplica en el string xml para obtener el ted
				Pattern tedPattern = Pattern.compile("<TED version=\"1.0\">(.*?)<\\/TED>", Pattern.DOTALL);

				// busca coincidencias del tag <TED></TED>
				String ted = null;
				Matcher matcher = tedPattern.matcher(dtelocatorResponse.getDte().getDocumentoXml());
				if (matcher.find()) {
					ted = Base64.getEncoder().encodeToString(matcher.group().getBytes());
				}

				try {
					GetDataFromDTEResponse response = new GetDataFromDTEResponse();
					int tipoDocumento = payload.getDteTipoDocumento();
					Object unmarshalledType = null;
					if (tipoDocumento == ConstantesTipoDocumento.BOLETA_AFECTA.getValue()
							|| tipoDocumento == ConstantesTipoDocumento.BOLETA_EXENTA.getValue()) {
						// hace el unmarshall del xml contenido en la entidad dte
						JAXBContext context = JAXBContext.newInstance(BOLETADefType.class);
						BOLETADefType unmarshallDbDte = (BOLETADefType) context.createUnmarshaller()
								.unmarshal(new StringReader(dtelocatorResponse.getDte().getDocumentoXml()));
						unmarshallDbDte.getDocumento().setTED(null);
						unmarshalledType = unmarshallDbDte;

					} else {
						if (tipoDocumento == ConstantesTipoDocumento.NOTA_CREDITO.getValue()) {
							// hace el unmarshall del xml contenido en la entidad dte
							JAXBContext context = JAXBContext.newInstance(DTE.class);
							DTE unmarshallDbDte = (DTE) context.createUnmarshaller()
									.unmarshal(new StringReader(dtelocatorResponse.getDte().getDocumentoXml()));
							unmarshallDbDte.getDocumento().setTED(null);
							unmarshalledType = unmarshallDbDte;
						} else {
							log.error("Tipo de documento no soportado. Tipo=" + tipoDocumento);
							throw new Exception("Tipo de documento no soportado");
						}
					}

					// se retornan los datos de la boleta
					response.setDte(unmarshalledType);
					response.setTed(ted);
					response.setLogo((logo == null ? "R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=" : logo));

					return ResponseEntity.ok().body(JSend.success(response));

				} catch (Exception ex) {
					log.error("Ocurrio un error realizando unmarshalling del xml. Error=" + ex.getMessage());
					return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
				}
			}
		} catch (Exception ex) {
			log.error("Ocurrio un error extrayendo data del xml. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Modifica el tamano de una imagen
	 * 
	 * @param image      imagen
	 * @param areaWidth  nuevo ancho
	 * @param areaHeight nuevo alto
	 * @return imagen original escalada al nuevo tamano
	 */
	@SuppressWarnings("unused")
	public BufferedImage resizeImage2(BufferedImage originalImage, int targetWidth, int targetHeight)
			throws IOException {
		Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);

		BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

		return outputImage;
	}

	/**
	 * Modifica el tamano de una imagen
	 * 
	 * @param image      imagen
	 * @param areaWidth  nuevo ancho
	 * @param areaHeight nuevo alto
	 * @return imagen original escalada al nuevo tamano
	 */
	public static BufferedImage resizeImage(BufferedImage image, int areaWidth, int areaHeight) {
		float scaleX = (float) areaWidth / image.getWidth();
		float scaleY = (float) areaHeight / image.getHeight();
		float scale = Math.min(scaleX, scaleY);
		int w = Math.round(image.getWidth() * scale);
		int h = Math.round(image.getHeight() * scale);

		int type = image.getTransparency() == Transparency.OPAQUE ? BufferedImage.TYPE_INT_RGB
				: BufferedImage.TYPE_INT_ARGB;

		boolean scaleDown = scale < 1;

		if (scaleDown) {
			// multi-pass bilinear div 2
			int currentW = image.getWidth();
			int currentH = image.getHeight();
			BufferedImage resized = image;
			while (currentW > w || currentH > h) {
				currentW = Math.max(w, currentW / 2);
				currentH = Math.max(h, currentH / 2);

				BufferedImage temp = new BufferedImage(currentW, currentH, type);
				Graphics2D g2 = temp.createGraphics();
				g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				g2.drawImage(resized, 0, 0, currentW, currentH, null);
				g2.dispose();
				resized = temp;
			}
			return resized;

		} else {
			Object hint = scale > 2 ? RenderingHints.VALUE_INTERPOLATION_BICUBIC
					: RenderingHints.VALUE_INTERPOLATION_BILINEAR;

			BufferedImage resized = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resized.createGraphics();
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, hint);
			g2.drawImage(image, 0, 0, w, h, null);
			g2.dispose();
			return resized;
		}
	}
}
