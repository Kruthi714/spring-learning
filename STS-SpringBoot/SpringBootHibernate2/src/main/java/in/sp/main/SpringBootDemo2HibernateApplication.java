package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entities.User;
import in.sp.main.repository.DbOperation;



@SpringBootApplication
public class SpringBootDemo2HibernateApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootDemo2HibernateApplication.class, args);
		
		DbOperation dbop=context.getBean(DbOperation.class);
		User user=dbop.getUserDetails(1L);
		if(user!=null) {
			System.out.println(user.getEmail());
			System.out.println(user.getName());
			}
			else {
				System.out.println("user not found");
			}
		
	}

}
