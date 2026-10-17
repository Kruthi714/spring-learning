package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//request will come to controller and handler is used to handle the request inside the controller 
@Controller
public class MyController {
	//@RequestMapping(value="/helloPage", method=RequestMethod.GET)
	//@RequestMapping("/helloPage")
	@GetMapping("/helloPage")//this is handler which is handling the request and execute the method
	public ModelAndView openHelloPage() {
		System.out.println("method executed");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("hello")
		return null;
		
	}

}
