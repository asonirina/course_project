package by.bsu.project.utils;

import org.apache.commons.configuration.PropertiesConfiguration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * User: iason
 * Date: 13.02.15
 */
public class MessageSender {
    final String username;
    final String password;

    public MessageSender() throws Exception {
        PropertiesConfiguration config = new PropertiesConfiguration("jms.properties");
        username = config.getString("email");
        password = config.getString("password");
    }

    public void sendActivationMessage(String email, String url) {
         sendMessage(email, generateText(LinkGenerator.getResetPasswordURL(url, email)));
    }

    private void sendMessage(String email, String text) {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username, "Etesting"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("ETesting Reset Password");
            message.setContent(text, "text/html; charset=utf-8");

            Transport.send(message);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateText(String link) {
       return String.format("<html><body>Dear User, <br/>" +
                "follow this link to reset password: <br>" +
                "<a href=\"%s\">Reset Password</a> <br/><br/>" +
                "Best Regards, <br/>" +
                "Etesting" +
               "<html><body>", link);
    }
}
