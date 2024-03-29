package py.com.progweb.prueba.ejb;


import py.com.progweb.prueba.model.UsoPuntos;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import java.util.Properties;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class EnviaCorreos {
    private static final Logger logger =
            Logger.getLogger(EnviaCorreos.class.getName());

    @Asynchronous
    public Future<String> sendMessage(String to, UsoPuntos usoPuntos) {
        String status;
        String from = System.getProperty("email.mail_sender.from");
        String emailPassword = System.getProperty("email.mail_sender.password");
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, emailPassword);
            }
        });
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Comprobante de Uso de Puntos");

            message.setContent(emailBodyBuilder(usoPuntos),"text/html");
            System.out.println("Enviando correo!");
            // Send message
            Transport.send(message);
            logger.info("Mensaje enviado a: " + to);
            status = "Sent";
        } catch (MessagingException mex) {
            mex.printStackTrace();
            status = "Error";
        }
        return new AsyncResult<>(status);
    }

    private static String emailBodyBuilder(UsoPuntos usoPuntos) {
        return "<b>Puntos Utilizados: </b>" + usoPuntos.getPuntajeUtilizado() + "<br/>" +
                "<b>Concepto de uso: </b>" + usoPuntos.getConcepto().getDescripcion() + "<br/>" +
                "<b>Fecha de uso: </b>" + usoPuntos.getFecha() + "<br/>";

    }
}
