package in.sp.main;

import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.sp.main.entity.Student;
import in.sp.main.repository.DbOperations;

@SpringBootApplication
public class HibernateWithoutSessionFactoryApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(HibernateWithoutSessionFactoryApplication.class, args);
		DbOperations dbop=context.getBean(DbOperations.class);
//		Student std1=new Student();
//		std1.setName("Sourav");
//		std1.setGender("male");
//		std1.setCity("Moodbidri");
//		dbop.insertDetails(std1);
		Student std=dbop.getStudentDetails(1);	
		if(std!=null) {
			System.out.println(std.getId());
			System.out.println(std.getName());
			System.out.println(std.getGender());
			System.out.println(std.getCity());
		}
		else {
			System.out.println("user not found");
		}
	}

}
