package by.bsu.project.mvc;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.ErrorsMessages;
import by.bsu.project.utils.MessageSender;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
            @RequestParam(required = false) String email,
            HttpServletRequest request
    ) throws Exception {
        if (StringUtils.isBlank(email)) {
            return new ModelAndView("redirect:/e-Testing/Login.html?message=" + "Please, enter email");
        }

        MessageSender sender = new MessageSender();
        String url = request.getRequestURL().toString();
        url = url.substring(0, url.lastIndexOf('/'));
        sender.sendActivationMessage(email, url);
        Map<String, Object> params = new HashMap<>();
        params.put(ETestingConstants.MODEL_ALERT, "Activation link was sent! Check email.");
        return new ModelAndView("redirect:/e-Testing/Login.html", params);
    }


}