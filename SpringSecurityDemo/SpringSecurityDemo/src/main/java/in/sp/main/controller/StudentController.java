package in.sp.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.Student;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	private List<Student> students=new ArrayList<Student>(List.of(new Student(1,"kruthi",94.8f),new Student(2,"kiran",98.6f)));
	@GetMapping("/students")
	public List<Student> getStudent(){
		return students;
		
	}
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken)req.getAttribute("_csrf");
	}
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}

}
