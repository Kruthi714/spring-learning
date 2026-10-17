package in.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemo1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		myclass().printName("kruthi");
		
	}
	@Bean
	public MyClass myclass() {
		return new MyClass();
	}

}
//CommandLineRunner is used to execute code after the spring application context is initialized.It allows to run additional tasks or setup logic at startup
