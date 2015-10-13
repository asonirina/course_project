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
public class AccessController extends BaseController {

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


}