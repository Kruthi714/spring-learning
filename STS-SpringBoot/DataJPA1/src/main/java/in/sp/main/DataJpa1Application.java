package in.sp.main;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entity.Student;
import in.sp.main.service.StudentService;
import in.sp.main.service.StudentServiceImpl;

@SpringBootApplication
public class DataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DataJpa1Application.class, args);
		StudentServiceImpl si=context.getBean(StudentServiceImpl.class);
//		Student std=new Student();
//		std.setName("shivangi");
//		std.setRollno(24);
//		std.setMarks(94.8f);
//		boolean status=si.addStudentDetails(std);
//		if(status==true) {
//			System.out.println("inserted successfully");
//		}
//		else {
//			System.out.println("not inserted successfully");
//		}
		List<Student> l1=si.getstudent();
		for(Student s1:l1) {
			System.out.println(s1.getId());
			System.out.println(s1.getName());
			System.out.println(s1.getRollno());
			System.out.println(s1.getMarks());
			System.out.println("-------------");
		}
		Student s2=si.getStdDetails(1L);
		if(s2!=null) {
		System.out.println(s2.getId());
		System.out.println(s2.getName());
		System.out.println(s2.getRollno());
		System.out.println(s2.getMarks());
		}
		else {
			System.out.println("student not found");
		}
		
	}

}
