package in.sp.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.sp.beans.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyController {
	@GetMapping("/hellopage")
	public ModelAndView hellopage() {
		ModelAndView mav=new ModelAndView("Hello");
		return mav;
		
	}
	@GetMapping("/AboutUs")
	public String aboutus() {
		return "about";
	}
	@GetMapping("/myForm")
	public String FormPage() {
		return "my-form";
	}
//	@PostMapping("/submitform")
//	public String handleMyForm(HttpServletRequest req,HttpServletResponse resp) {
//		String myname=req.getParameter("name1");
//		String myemail=req.getParameter("email1");
//		String myphno=req.getParameter("phno1");
//		System.out.println("Name: "+myname);
//		System.out.println("Email: "+myemail);
//		System.out.println("Phno: "+myphno);
//		return "profile";
//	}
	
//	@PostMapping("/submitform")
//	public String handleMyForm(@RequestParam("name1") String myname,@RequestParam("email1") String myemail,@RequestParam("phno1") String myphno,Model model) {
//		System.out.println("Name: "+myname);
//		System.out.println("Email: "+myemail);
//		System.out.println("Phno: "+myphno);
//		model.addAttribute("model_name",myname);
//		model.addAttribute("model_email",myemail);
//		model.addAttribute("model_phno",myphno);
//		return "profile";
//	}
	//if many user details are there then we can create class add in model we can pass that class object itself
	
	
//	@PostMapping("/submitform")
//	public String handleMyForm(@RequestParam("name1") String myname,@RequestParam("email1") String myemail,@RequestParam("phno1") String myphno,Model model) {
//		
//		System.out.println("Name: "+myname);
//		System.out.println("Email: "+myemail);
//		System.out.println("Phno: "+myphno);
//		User user=new User();
//		user.setName(myname);
//		user.setEmail(myemail);
//		user.setPhno(myphno);
//		model.addAttribute("model_user",user);
//		return "profile";
//	}
	
	// now if there is 50 attributes then everytime manually storing like @RequestParam("pass1") String mypass will be difficult so use @ModelAttribute-it will bind the request parameters or form data to java object properties
	

	
	
	@PostMapping("/submitform")
	public String handleMyForm(@ModelAttribute User user) {
		//here form data parameter and user class parameter must be same
		System.out.println("Name: "+user.getName());
		System.out.println("Email: "+user.getEmail());
		System.out.println("Phno: "+user.getPhno());
		return "profile";
	}
}
