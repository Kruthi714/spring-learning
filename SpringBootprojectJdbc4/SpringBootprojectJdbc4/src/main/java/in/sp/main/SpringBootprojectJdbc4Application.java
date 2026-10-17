package in.sp.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootprojectJdbc4Application implements CommandLineRunner{
	@Autowired
	private UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootprojectJdbc4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//User user=new User();
//		user.setName("nethra");
//		user.setEmail("nethra@gmail.com");
//		user.setGender("female");
//		user.setCity("kateel");
//		//or userDao.insertUser("kru","kru@gmail.com,"f","udupi");//in user.java generate constructor
//		boolean status=userDao.insertUser(user);
//		if(status) {
//			System.out.println("inserted sucessfully");
//		}
//		else {
//			System.out.println("inserted failed");
//		}
		//----update---
		User user=new User("kruthi","nethra@gmail.com","male","chandigarh");
		boolean status=userDao.updateUser(user);
		if(status) {
			System.out.println("update sucess");
		}
		else {
			System.out.println("update failed");
		}
		
		
	}

}
