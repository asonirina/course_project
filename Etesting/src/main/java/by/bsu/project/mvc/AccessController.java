package by.bsu.project.mvc;

import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.ErrorsMessages;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.service.UserInfoService;
import by.bsu.project.utils.MessageSender;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/e-Testing/Login")
    public String login(Model model, @RequestParam(required = false) String message,
                        @RequestParam(required = false) String alert) {
        model.addAttribute(ETestingConstants.MODEL_MESSAGE, message);
        model.addAttribute(ETestingConstants.MODEL_ALERT, alert);
        model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.LOGIN_PAGE);
        return "access/login";
    }

    @RequestMapping(value = "/e-Testing/Denied")
    public String denied() {
        return "access/denied";
    }

    @RequestMapping(value = "/e-Testing/Login/Failure")
    public String loginFailure(Model model) {
        model.addAttribute(ETestingConstants.MODEL_MESSAGE, ErrorsMessages.INVALID_USERNAME);
        model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.LOGIN_PAGE);
        return "redirect:/e-Testing/Login.html";
    }

    @RequestMapping(value = "/e-Testing/Logout/Success")
    public ModelAndView logoutSuccess() {
        return new ModelAndView("redirect:/e-Testing/Login.html", ETestingConstants.MODEL_TITLE, PageTitles.LOGIN_PAGE);
    }


    @RequestMapping(value = "/e-Testing/ForgotPassword")
    public ModelAndView forgotPassword(
            @RequestParam(required = false) String email,
            HttpServletRequest request) throws Exception {
        if (StringUtils.isBlank(email)) {
            return new ModelAndView("redirect:/e-Testing/Login.html?message=" + "Please, enter email");
        }
        if (!email.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")) {
            return new ModelAndView("redirect:/e-Testing/Login.html?message=" + "Please, enter correct email");
        }
        UserInfoEntity user = userInfoService.findStudentByLogin(email);
        if (user==null) {
            return new ModelAndView("redirect:/e-Testing/Login.html?message=" + "User doesn't exist!");
        }
        MessageSender sender = new MessageSender();
        String url = request.getRequestURL().toString();
        url = url.substring(0, url.lastIndexOf('/'));
        sender.sendActivationMessage(email, url);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put(ETestingConstants.MODEL_ALERT, "Activation link was sent! Check email.");
        params.put(ETestingConstants.MODEL_TITLE, PageTitles.LOGIN_PAGE);
        return new ModelAndView("redirect:/e-Testing/Login.html", params);
    }


}