package in.sp.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.User;
import in.sp.main.service.UserService;
import in.sp.main.service.UserServiceImpl;

@RestController
public class MyController {
	@Autowired
	private UserService userService;
	@PostMapping("/user")
	//internally User user = new User();
//	user.setName("kruthi");
//	user.setPassword("kru@123");
//	user.setCity("kudla");
	public User AddUserDetails(@RequestBody User user) {
		return userService.createUser(user);
		
	}
	@GetMapping("/getUser")
	public List<User> getUsersList(){
		return userService.getAllUsers();
	}
	/*
	 * @GetMapping("/getUserById/{id}") public Optional<User>
	 * getUserDetailsById(@PathVariable int id){ return userService.getUserById(id);
	 * }
	 */
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getUserDetailsById(@PathVariable int id){
		User user=userService.getUserById(id).orElse(null);
		if(user!=null) {
			return ResponseEntity.ok().body(user);
			//if ok then in body i will snd user details
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
//	@PutMapping("/user/{id}")
//	public User updateUserById(@PathVariable int id) {
//		Optional<User> optional=userService.getUserById(id);
//		if(optional.isPresent()) {
//			User user=optional.get();
//			user.setCity("kolkata");
//			User u1=userService.createUser(user);
//			return u1;
//		}
//		else {
//			return null;
//		}
//	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id,@RequestBody User user) {
		User updatedUser=userService.updateUserDetails(id, user);
		if(updatedUser!=null) {
			return ResponseEntity.ok(updatedUser);
		}
		return ResponseEntity.notFound().build();
	}
	@DeleteMapping("DeleteUser/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable int id){
		boolean deleted=userService.deleteUser(id);
		if(deleted==true) {
		return ResponseEntity.ok("User deleted successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: "+id);
	}
		
	

}
//ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with id: "+id);
//ResponseEntity in Spring API represents the entire HTTP response, including status code,headers, and body.It allows for greater control over the response sent to the client,enhancing API flexibility
//pathVariable is used to extract values from uri templates in requests URLs,allowing dynamic data retrieval from the url for handling requests
//in SpringBoot @ResponseBody is for to print String not to render view page whereas @RequestBody is used in RESTful API to bind the HTTP request body(usually in JSON or XML format) directly to methods parameter,converting it into a java object
//in SpringBoot ,the @RestController annotation is used to create RESTful web services.It combines @Controller and @ResponseBody, meaning the controller methods return data(like JSON or XML) directly instead of rendering a view,making it suitable for APIs
//in springBoot web app,controllers return view page names(eg., index.html) But in RESTful web services,controllers return data(like JSON or XML) for API responses instead of rendering views
//Then Controller returns that User:
//
//public User AddUserDetails(...)
//
//Because your Controller has:
//
//@RestController
//
//Spring automatically converts the returned Java object into JSON.