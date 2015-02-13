package by.bsu.project.mvc;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.ErrorsMessages;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

@Controller
public class AccessController {

    @RequestMapping("/e-Testing/Login")
    public String login(Model model, @RequestParam(required = false) String message,
                        @RequestParam(required = false) String alert) {
        model.addAttribute(ETestingConstants.MODEL_MESSAGE, message);
        model.addAttribute(ETestingConstants.MODEL_ALERT, alert);

        return "access/login";
    }

    @RequestMapping(value = "/e-Testing/Denied")
    public String denied() {
        return "access/denied";
    }

    @RequestMapping(value = "/e-Testing/Login/Failure")
    public String loginFailure() {
        return "redirect:/e-Testing/Login.html?message=" + ErrorsMessages.INVALID_USERNAME;
    }

    @RequestMapping(value = "/e-Testing/Logout/Success")
    public String logoutSuccess() {
        return "redirect:/e-Testing/Login.html";
    }


    @RequestMapping(value = "/e-Testing/ForgotPassword")
    public ModelAndView forgotPassword(
            @RequestParam(required = false) String email
    ) throws Exception {
        if (StringUtils.isBlank(email)) {
            return new ModelAndView("redirect:/e-Testing/Login.html?message=" + "Please, enter email");
        }
        Map<String, Object> params = new HashMap<>();
        params.put(ETestingConstants.MODEL_ALERT, "Activation link was sent! Check email.");

        final String username = "irina.ason@gmail.com";
        final String password = "am891t_IRYNA";

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
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("asonirina@mail.ru"));
            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler,"
                    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return new ModelAndView("redirect:/e-Testing/Login.html", params);
    }
}