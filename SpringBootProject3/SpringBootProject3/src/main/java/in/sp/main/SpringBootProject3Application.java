package in.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import in.sp.main.beans.Student;

@SpringBootApplication
//remember this @SpringBootApplication will scan main package and sub packages outside the main it will not scan 
public class SpringBootProject3Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		student1().displayStdDetails();
		System.out.println("-------------------------------------------");
		student2().displayStdDetails();
		
	}
	@Bean
	public Student student1() {
		return new Student("kruthi",24,94.1f);
	}
	
	@Bean
	public Student student2() {
		return new Student("nethra",25,97.1f);
	}
	

}
