package cl.fapp.services.mail;

import java.io.File;

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

import lombok.extern.slf4j.Slf4j;

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
		String text = String.format(template.getText(), (Object[])templateModel);
		sendSimpleMessage(to, subject, text);
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String filename, String pathToAttachment) {
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

		}catch(Exception ex) {
			log.error("Se produjo un error accediendo a [" + email +"]. Error=" + ex.getMessage());
			return;
		}
	}
	private void readInbox(String email) {
		try {

		}catch(Exception ex) {
			log.error("Se produjo un error accediendo a [" + email +"]. Error=" + ex.getMessage());
			return;
		}
	}
}
