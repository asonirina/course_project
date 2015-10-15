package by.bsu.project.mvc;

import by.bsu.project.general.constants.ETestingConstants;
import by.bsu.project.general.constants.ErrorsMessages;
import by.bsu.project.general.constants.PageTitles;
import by.bsu.project.general.model.UserInfoEntity;
import by.bsu.project.utils.LinkGenerator;
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
public class PasswordController extends BaseController {

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
        Map<String, Object> params = new HashMap<>();
        params.put(ETestingConstants.MODEL_ALERT, "Activation link was sent! Check email.");
        params.put(ETestingConstants.MODEL_TITLE, PageTitles.LOGIN_PAGE);
        return new ModelAndView("redirect:/e-Testing/Login.html", params);
    }

    @RequestMapping(value = "/e-Testing/{admin|student}/ChangePassword")
    public ModelAndView changePassword(@RequestParam(value = "oldPassword", required = false) String oldPassword,
                                       @RequestParam(value = "password1", required = false) String password1,
                                       @RequestParam(value = "password2", required = false) String password2,
                                       HttpServletRequest request) {
        try {
            if (oldPassword != null) {
                String login = request.getRemoteUser();
                UserInfoEntity user = userInfoService.findStudentByLogin(login);
                if (oldPassword.equals(user.getPassword()) && password1.equals(password2)) {
                    user.setPassword(password1);
                    userInfoService.save(user);
                    if (user.getForm().equals(ETestingConstants.ADMIN_ROLE)) {
                        return new ModelAndView("redirect:/e-Testing/admin/MainPage.html");
                    } else return new ModelAndView("redirect:/e-Testing/student/MainPage.html");
                }
                return new ModelAndView("ChangePassword", ETestingConstants.MODEL_MESSAGE, ErrorsMessages.WRONG_PASSWORD);
            }
            return new ModelAndView("ChangePassword", ETestingConstants.MODEL_TITLE, PageTitles.CHANGE_PASSWORD);

        } catch (Exception ex) {
            logger.error("Unable to change password " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }

    @RequestMapping(value = "/e-Testing/ResetPassword")
    public ModelAndView resetPassword(
            @RequestParam(value = "hash", required = true) String hash,
            @RequestParam(value = "password1", required = false) String password1,
            @RequestParam(value = "password2", required = false) String password2,
            @RequestParam(value = "email", required = false) String email,
            Model model
    ) throws Exception {
        if (!LinkGenerator.checkHash(hash)) {
            return new ModelAndView("redirect:/e-Testing/error404.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }

        try {
            if (password1 != null) {
                UserInfoEntity user = userInfoService.findStudentByLogin(email);
                if (password1.equals(password2)) {
                    user.setPassword(password1);
                    userInfoService.save(user);
                    model.addAttribute(ETestingConstants.MODEL_TITLE, PageTitles.LOGIN_PAGE);
                    return new ModelAndView("redirect:/e-Testing/Login.html");
                }
                model.addAttribute(ETestingConstants.MODEL_MESSAGE, ErrorsMessages.WRONG_PASSWORD);
                return new ModelAndView("ResetPassword", ETestingConstants.MODEL_TITLE, PageTitles.CHANGE_PASSWORD );
            }
            return new ModelAndView("ResetPassword", ETestingConstants.MODEL_TITLE, PageTitles.CHANGE_PASSWORD);

        } catch (Exception ex) {
            logger.error("Unable to change password " + ex.getMessage());
            return new ModelAndView("redirect:/e-Testing/error503.html", ETestingConstants.MODEL_TITLE, PageTitles.ERROR);
        }
    }
}