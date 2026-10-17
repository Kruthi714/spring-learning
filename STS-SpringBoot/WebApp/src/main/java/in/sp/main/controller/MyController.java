package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sp.main.entities.User;
import in.sp.main.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
//controller class is a class which manages web requests and responses.It handles user inputs,processes data, and returns views or other responses.
	@Autowired
	private UserServiceImpl userServiceImpl;
	@GetMapping("/regPage")
	public String openRegPage() {
		return "register";
	}
	@PostMapping("/regForm")
	public String SubmitRegForm(@ModelAttribute User user ,Model model) {
		boolean status=userServiceImpl.registerUser(user);
		if(status==true) {
			model.addAttribute("successMsg", "User registered successfully");
		}
		else {
			model.addAttribute("errorMsg", "User not registered due to some error");
		}
		return "register";
	}
	@GetMapping("/LoginPage")
	public String openLoginPage() {
		//model.addAttribute("user",new User());
		return "login";
	}
	@PostMapping("/LoginForm")
	//@ModelAttribute("user") User user
	public String SubmitLoginForm(@RequestParam("email1") String email,@RequestParam("password1") String password,Model model) {
		User user=userServiceImpl.Retrive1User(email,password);
		if(user!=null) {
			model.addAttribute("model_name", user.getName());
			return "profile";
		}
		else {
			model.addAttribute("errorMsg", "User not registered due to some error");
			return "login";
		}
		
	}
	@GetMapping("/Logout")
	public String logoutUser(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
		session.invalidate();
		}
		return "login";
		
	}
}
//to print error msg in jps we need dependency jstl maven dependency
//jstl tags include <c:if>,<c:choose>,<c:forEach>,and<c:out>
//since dispatcher servlet is provided by spring web but we need view Resolver dependency so add in application.properties
//since springBoot doesnt support jsp directly we need to add tomcat jasper dependency maven