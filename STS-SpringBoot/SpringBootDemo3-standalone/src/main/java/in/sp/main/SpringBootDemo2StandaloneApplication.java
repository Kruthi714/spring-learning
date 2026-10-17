package in.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import in.sp.main.beans.Student;

@SpringBootApplication
public class SpringBootDemo2StandaloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo2StandaloneApplication.class, args);
	}

}