package in.sp.main.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;

//crud operations
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
//	public boolean insertUser(User user) {
//		boolean status=false;
//		try {
//		String insert_sql_query="insert into users(name,email,gender,city)values(?,?,?,?)";
//		int c=jdbcTemplate.update(insert_sql_query,user.getName(),user.getEmail(),user.getGender(),user.getCity());
//		if(c>0) {
//			status=true;
//		}
//		else {
//			status=false;
//		}
//		}
//		catch(Exception e){
//			status=false;
//			e.printStackTrace();
//		}
//		return status;
//	}
	
	
	
	//update
	public boolean updateUser(User user) {
		boolean status=false;
		try {
			String update_sql_query="update users set name=?,gender=?,city=? where email=?";
			int c=jdbcTemplate.update(update_sql_query,user.getName(),user.getGender(),user.getCity(),user.getEmail());
			if(c>0) {
				status=true;
				
			}
			else {
				status=false;
				
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return status;
	}

}
