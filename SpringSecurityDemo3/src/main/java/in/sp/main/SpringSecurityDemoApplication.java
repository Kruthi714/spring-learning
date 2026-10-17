package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

}
//bcrypt password generator-browsing
//In JWT.io->whatever the card has is payload eg name,expiry date,issue date etc
//header contains algorithm and type
//signature-signature of manager and that is verified here
