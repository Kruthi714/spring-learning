package in.sp.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MyController {
	@GetMapping("/")
	public String greet(HttpServletRequest req) {
		return "Welcome to myWebsite " + req.getSession().getId();
	}

}
