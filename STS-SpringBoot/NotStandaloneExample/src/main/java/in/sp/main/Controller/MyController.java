package in.sp.main.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/")
	@ResponseBody
	public String open() {
		return "hello kruthi";
	}
	//remember since it will return an jsp or html page to avoid and written just string use @ResponseBody
//localhost:8080,
//spring web -dependency
}
