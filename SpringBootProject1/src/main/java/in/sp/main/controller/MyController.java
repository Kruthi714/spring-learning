package in.sp.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//on- in.sp.main right click and click on class and then fill package and class name
@Controller
public class MyController {
	@GetMapping("/")
	@ResponseBody
	public String PrintHello() {
		return "hello kru";
		
	}

}
