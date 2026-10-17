package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entity.User;
import in.sp.main.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	@PostMapping("/regForm")
	public String submitRegisterationForm(@ModelAttribute("user") User u1,Model model) {
		boolean status=userServiceImpl.RegisterUser(u1);
		if(status==true) {
			model.addAttribute("success_msg", "user registered successfully");
		
		}
		else {
			model.addAttribute("error_msg", "user not registered successfully");
		}
		return "register";
	}
	@GetMapping("/logPage")
	public String openLogPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	@PostMapping("/logForm")
	public String MatchingRegLogSame(@ModelAttribute("user") User u1,Model model) {
		User user=userServiceImpl.ValidateUser(u1.getEmail(), u1.getPassword());
		if(user!=null) {
			model.addAttribute("user_name", user.getName());
			return "profile";
		}
		else {
			model.addAttribute("error_msg", "user not found");
		}
		return "login";
	}
	@GetMapping("/logout")
	public String openlogPage1(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
	    if (session != null) {
	        session.invalidate();
	    }
		return "redirect:/logPage";
	}
	
}
//model interface is used to pass the data from controller to the view,allowing attributes to be added and accessed during rendering of the view(eg HTML page)
//@ModelAttribute is used to bind form data to a model object.It helps to pass the data from HTML form to the controller and also populates the model with data,it helps to pass the data from html form to the controller and also populates the model with data,making it available to the view like thymeleaf template
//here form data is user and we are binding it to u1