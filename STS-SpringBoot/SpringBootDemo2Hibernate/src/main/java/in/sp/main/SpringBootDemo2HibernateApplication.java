package in.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.entities.User;



@SpringBootApplication
public class SpringBootDemo2HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo2HibernateApplication.class, args);
		Configuration cfg=new Configuration();
		cfg.configure("/in/sp/main/config/hibernate.cfg.xml");
		SessionFactory sessionFactory=cfg.buildSessionFactory();
		Session session=sessionFactory.openSession();
		//Transaction transaction=session.beginTransaction();
		try {
			User user=session.get(User.class,1L);
			if(user!=null) {
			System.out.println(user.getEmail());
			System.out.println(user.getName());
			}
			else {
				System.out.println("user not found");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("user details not retrived successfully");
		}
	}

}
