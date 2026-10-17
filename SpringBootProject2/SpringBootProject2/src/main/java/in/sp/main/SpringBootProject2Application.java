package in.sp.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
//standalone -no dependencies are created
@SpringBootApplication
public class SpringBootProject2Application{
//“After application starts, run my code automatically”
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootProject2Application.class, args);
		MyClass m=context.getBean(MyClass.class);
		m.printMessage("kruthii");
	}
//	@SpringBootApplication
//	public class SpringBootProject2Application implements CommandLineRunner{
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBootProject2Application.class, args);
//	@Override
//	public void run(String... args) throws Exception {
//		
//		myclass().printMessage("Shakila");
//	}
//	@Bean
//	public MyClass myclass() {
//		return new MyClass();
//	}
	

}
