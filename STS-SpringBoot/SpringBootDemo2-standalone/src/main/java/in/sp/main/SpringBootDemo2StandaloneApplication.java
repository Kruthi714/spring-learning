package in.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import in.sp.main.beans.Student;

@SpringBootApplication
public class SpringBootDemo2StandaloneApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo2StandaloneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		studentDetails().display();
		studentDetails1().display();
		
	}
	@Bean
	public Student studentDetails() {
		Student std=new Student("kruthi",24,94.8f);
//		std.setName("Kruthi");
//		std.setRollno(24);
//		std.setMarks(94.8f);
		return std;
	}
	@Bean
	public Student studentDetails1() {
		return new Student("shivi",54,92.8f);
		
	}

}
