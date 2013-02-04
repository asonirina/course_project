package by.bsu.project.mvc;

import by.bsu.project.entity.UserInfoEntity;
import by.bsu.project.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccessController {

	@RequestMapping("/e-Testing/Login")
	public String login(Model model, @RequestParam(required=false) String message) {
		model.addAttribute("message", message);

		return "access/login";
	}
	
	@RequestMapping(value = "/e-Testing/Denied")
 	public String denied() {
		return "access/denied";
	}
	
	@RequestMapping(value = "/e-Testing/Login/Failure")
 	public String loginFailure() {
		String message = "Login Failure!";
		return "redirect:/e-Testing/Login.html?message="+message;
	}
	
	@RequestMapping(value = "/e-Testing/Logout/Success")
 	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/e-Testing/Login.html?message="+message;
	}
}