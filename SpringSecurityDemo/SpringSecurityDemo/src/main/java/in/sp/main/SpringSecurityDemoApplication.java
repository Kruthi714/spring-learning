package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

}
//configuring name and password of our own
//csrf,console-network-cookies->sessiona nd its id
//at logout page-view page source there u will get attribute name from that u can fetch token through code or directly in that page itself u can copy the token