package in.sp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringStarterProgram1JdbcApplication implements CommandLineRunner{
	@Autowired
	private UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringStarterProgram1JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user1=new User();
//		user1.setName("Thanvi J shetty");
//		user1.setEmail("thanvishetty@gmail.com");
//		user1.setGender("Female");
//		user1.setCity("Mulki");
//		boolean status=userDao.insertUser(user1);
//		if(status) {
//			System.out.println("inserted successfully");
//		}
//		else {
//			System.out.println("insertion failed");
//		}
//-------------------updation operation1----------------------
		
//		User user1=new User("Thanvi J shetty","thanvishetty@gmail.com","Female","Mangalore");
//		boolean status=userDao.UpdateUser(user1);
//		if(status) {
//			System.out.println("updated successfully");
//		}
//		else {
//			System.out.println("updation failed");
//		}
//-------------------updation operation2----------------------
		
		User user1=userDao.getUserByEmail("thanvishetty@gmail.com");
		user1.setCity("Kinnigoli");
		boolean status=userDao.UpdateUser(user1);
		if(status) {
			System.out.println("updated successfully");
		}
		else {
			System.out.println("updation failed");
		}
		
		
		
//-------------------deletion operation----------------------
//		String email="thanvishetty@gmail.com";
//		boolean status=userDao.DeleteUser(email);
//		if(status) {
//			System.out.println("Deleted successfully");
//		}
//		else {
//			System.out.println("Deletion failed");
//		}
		
//---------------------Select operation----------		
		
//		String email="mandiramahendra@gmail.com";
//		User user1=userDao.getUserByEmail(email);
//		System.out.println("Name: "+user1.getName());
//		System.out.println("Email: "+user1.getEmail());
//		System.out.println("Gender: "+user1.getGender());
//		System.out.println("City: "+user1.getCity());
//--------------------Select Operation------------
		
		List<User> list=userDao.getAllUsers();
		for(User u1:list) {
		System.out.println("Name: "+u1.getName());
		System.out.println("Email: "+u1.getEmail());
		System.out.println("Gender: "+u1.getGender());
		System.out.println("City: "+u1.getCity());
		System.out.println("-------------------------------------------------");
		}
		
	}

}
