package cl.fapp.services.mail;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Attachments;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;

import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import lombok.extern.slf4j.Slf4j;
import java.util.Base64;

@Service("EmailService")
@Slf4j
public class EmailServiceImpl implements IEmailService {

	private static final String NOREPLY_ADDRESS = "noreply@dev.transformapp.cl";

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SimpleMailMessage template;

	@Value("classpath:/mail-fapp-logo.png")
	private Resource logoFile;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(NOREPLY_ADDRESS);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(text);

			emailSender.send(message);
		} catch (MailException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel) {
		String text = String.format(template.getText(), (Object[]) templateModel);
		sendSimpleMessage(to, subject, text);
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String filename,
			String pathToAttachment) {
		try {
			MimeMessage message = emailSender.createMimeMessage();

			// true indica que es multipart
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(NOREPLY_ADDRESS);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);

			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
			helper.addAttachment(filename, file);

			emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void sendHtmlMessage(String to, String subject, String htmlBody) throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setFrom(NOREPLY_ADDRESS);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(htmlBody, true);
		helper.addInline("attachment.png", logoFile);
		emailSender.send(message);
	}

	public void monitorInbox(String email) {
		try {

		} catch (Exception ex) {
			log.error("Se produjo un error accediendo a [" + email + "]. Error=" + ex.getMessage());
			return;
		}
	}

	private void readInbox(String email) {
		try {

		} catch (Exception ex) {
			log.error("Se produjo un error accediendo a [" + email + "]. Error=" + ex.getMessage());
			return;
		}
	}

	@Override
	public boolean sendHtmlMessageWithSendGrid(String to, String subject, String htmlBody, String attachmentFilename,
			byte[] attachmentContent, Dte dte, Emisores emisor) {
		try {
			// Validación de entradas
			if (to == null || subject == null || htmlBody == null || attachmentFilename == null
					|| attachmentContent == null) {
				log.error("Parámetros de entrada no válidos.");
				return false;
			}
			// Contacto: 2020-04-09
			Email from = new Email("contacto@billonapp.cl");
			String templateId = "d-0984fad3478c48c09d14241b65e1fd48";
			String sendGridApiKey = "";

			Email toEmail = new Email(to);

			// Crear un nuevo objeto Mail sin contenido
			Mail mail = new Mail();
			mail.setFrom(from);
			Personalization personalization = new Personalization();
			personalization.addTo(toEmail);
			log.debug(dte.getTipoDocumento().toString());
			String tipoDoc = "";
			switch (dte.getTipoDocumento()) {
				case 33:
					tipoDoc = "Factura Electrónica";
					break;
				case 34:
					tipoDoc = "Factura Exenta Electrónica";
					break;
				case 39:
					tipoDoc = "Boleta Electrónica";
					break;
				case 41:
					tipoDoc = "Boleta Exenta Electrónica";
					break;
				case 46:
					tipoDoc = "Factura de Compra Electrónica";
					break;
				case 52:
					tipoDoc = "Guía de Despacho Electrónica";
					break;
				case 56:
					tipoDoc = "Nota de Débito Electrónica";
					break;
				case 61:
					tipoDoc = "Nota de Crédito Electrónica";
					break;
				case 110:
					tipoDoc = "Factura de Exportación Electrónica";
					break;
				case 111:
					tipoDoc = "Nota de Débito de Exportación Electrónica";
					break;
				case 112:
					tipoDoc = "Nota de Crédito de Exportación Electrónica";
					break;
				default:
					break;
			}
			personalization.addDynamicTemplateData("tipoDocumento", tipoDoc);
			personalization.addDynamicTemplateData("subject", tipoDoc + " adjunta N°" + dte.getFolioAsignado());
			personalization.addDynamicTemplateData("folio", dte.getFolioAsignado());
			mail.addPersonalization(personalization);

			// Establecer el ID del Template de SendGrid// Reemplaza con el ID real de tu
			// template
			mail.setTemplateId(templateId);

			// Agregar adjuntos si es necesario
			Attachments attachments = new Attachments();
			Base64.Encoder encoder = Base64.getEncoder();
			String encodedAttachment = encoder.encodeToString(attachmentContent);
			attachments.setContent(encodedAttachment);
			attachments.setType("application/pdf");
			attachments.setFilename(attachmentFilename);
			attachments.setDisposition("attachment");
			mail.addAttachments(attachments);

			// Configuración de SendGrid
			SendGrid sg = new SendGrid(sendGridApiKey);
			Request request = new Request();
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());

			// Envo y Respuesta
			Response response = sg.api(request);
			if (response.getStatusCode() == 202) {
				log.info("Correo enviado exitosamente a " + to);
				return true;
			} else {
				log.error("Error al enviar el correo. Código de estado: " + response.getStatusCode());
				return false;
			}
		} catch (IOException e) {
			log.error("Error al enviar el correo: " + e.getMessage());
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			log.error("Error inesperado al enviar el correo: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// @Override
	// public boolean sendHtmlMessageWithSendGrid(String to, String subject, String
	// htmlBody, String attachmentFilename,
	// byte[] attachmentContent, Dte dte, Emisores emisor) {
	// // TODO Auto-generated method stub
	// throw new UnsupportedOperationException("Unimplemented method
	// 'sendHtmlMessageWithSendGrid'");
	// }
}
