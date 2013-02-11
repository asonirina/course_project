package by.bsu.project.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "redirect:/e-Testing/Login.html?message="+"Invalid username or password or username is blocked";
	}
	
	@RequestMapping(value = "/e-Testing/Logout/Success")
 	public String logoutSuccess() {
		return "redirect:/e-Testing/Login.html";
	}
}