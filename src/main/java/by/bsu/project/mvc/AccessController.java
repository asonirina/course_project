package by.bsu.project.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccessController {

	@RequestMapping("/login")
	public String login(Model model, @RequestParam(required=false) String message) {
		model.addAttribute("message", message);

		return "access/login";
	}
	
	@RequestMapping(value = "/denied")
 	public String denied() {
		return "access/denied";
	}
	
	@RequestMapping(value = "/login/failure")
 	public String loginFailure() {
		return "redirect:/login.html?message="+"Invalid username or password or username is blocked";
	}
	
	@RequestMapping(value = "/logout/success")
 	public String logoutSuccess() {
		String message = "Logout Success!";
		return "redirect:/login.html?message="+message;
	}
}