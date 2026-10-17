package in.sp.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping("/openprofile")
	public String openProfilePage(Model model) {
		String name="Kruthi Suvarna";
		model.addAttribute("model_name", name);
		return "profile";
	}
	@GetMapping("/openconditional")
	public String openConditionalPage(Model model) {
		int n1=10;
		int n2=20;
		model.addAttribute("num1", n1);
		model.addAttribute("num2", n2);
		return "conditional";
	}
	@GetMapping("/openlooping")
	public String openLoopingPage(Model model) {
		List<Integer> numbers=List.of(1,2,3,4,5);
		model.addAttribute("model_no", numbers);
		return "looping";
	}
}
