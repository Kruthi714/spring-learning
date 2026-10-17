package in.sp.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.model.User;
import in.sp.main.repo.UserRepo;
import in.sp.main.service.userService;

@RestController
public class UserController {
	@Autowired
	private userService userService;
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	@PostMapping("/register")
	public User registerUser(@RequestBody User u1) {
		u1.setPassword(encoder.encode(u1.getPassword()));
		return userService.saveUser(u1);
	}
	@GetMapping("/retrieve")
	public List<User> getAllUser(){
		return userService.allUserDetails();
	}

}
