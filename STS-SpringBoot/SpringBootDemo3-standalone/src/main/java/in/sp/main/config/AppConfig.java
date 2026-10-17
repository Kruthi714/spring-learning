package in.sp.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.sp.main.beans.Student;

@Configuration
public class AppConfig {
	@Bean
	public CommandLineRunner cmdRunner() {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				studentDetails().display();
				System.out.println("--------------------");
				studentDetails1().display();
				
			}
		};
	}
		
	@Bean
	public Student studentDetails() {
		Student std=new Student("kruthi",24,94.8f);
		return std;
	}
	
	@Bean
	public Student studentDetails1() {
		return new Student("Shivangi",54,92.8f);
		
	}

}



