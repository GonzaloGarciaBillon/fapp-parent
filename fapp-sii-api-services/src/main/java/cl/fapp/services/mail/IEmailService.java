package cl.fapp.services.mail;

/**
 * Interfaz del servicio de envio de correos
 */
public interface IEmailService {

	/**
	 * Envia correo utilizando un template
	 * 
	 * @param to            email de destino
	 * @param subject       asunto
	 * @param templateModel template a utilizar
	 */
	void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel);

	/**
	 * Envia un correo incluyendo un adjunto
	 * 
	 * @param to               email de destino
	 * @param subject          asunto
	 * @param text             texto alternativo
	 * @param pathToAttachment ubicacion del attachament
	 */
	void sendMessageWithAttachment(String to, String subject, String text, String filename, String pathToAttachment);

	/**
	 * Envia un correo
	 * 
	 * @param to      email de destino
	 * @param subject asunto
	 * @param text    texto del correo
	 */
	void sendSimpleMessage(String to, String subject, String text);

	/**
	 * Envia un correo
	 * 
	 * @param to      				email de destino
	 * @param subject 				asunto
	 * @param htmlBody 				texto del correo
	 * @param attachmentFilename 	nombre del archivo
	 * @param attachmentContent 	Contenido del archivo
	 */
	//void sendHtmlMessageWithSendGrid(String to, String subject, String htmlBody, String attachmentFilename, byte[] attachmentContent);
}
