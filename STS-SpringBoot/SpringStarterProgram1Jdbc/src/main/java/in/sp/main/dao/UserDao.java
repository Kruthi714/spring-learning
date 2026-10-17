package in.sp.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;
import in.sp.main.mapper.UserRowMapper;

@Repository
public class UserDao {
	//repository layer
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public boolean insertUser(User user) {
		boolean status=false;
		try {
		String insert_query="insert into users values(?,?,?,?)";
		int c=jdbcTemplate.update(insert_query,user.getName(),user.getEmail(),user.getGender(),user.getCity());
		if(c>0) {
			status=true;
		}
		else {
			status=false;
		}
		}
		catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	public boolean UpdateUser(User user) {
		boolean status=false;
		try {
		String update_query="update users set name=?,gender=?,city=? where email=?";
		int c=jdbcTemplate.update(update_query,user.getName(),user.getGender(),user.getCity(),user.getEmail());
		if(c>0) {
			status=true;
		}
		else {
			status=false;
		}
		}
		catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	public boolean DeleteUser(String email) {
		boolean status=false;
		try {
		String delete_query="delete from users where email=?";
		int c=jdbcTemplate.update(delete_query,email);
		if(c>0) {
			status=true;
		}
		else {
			status=false;
		}
		}
		catch(Exception e) {
			status=false;
			e.printStackTrace();
		}
		return status;
	}
	public User getUserByEmail(String email) {
		String select_query="select * from users where email=?";
		return jdbcTemplate.queryForObject(select_query,new UserRowMapper(),email);
		
	}
	public List<User> getAllUsers(){
		
		String select_query="select * from users";
		List l1=jdbcTemplate.query(select_query, new UserRowMapper());
		return l1;
		
	}
//	public static final class UserRowMapper implements RowMapper<User>{
//
//		@Override
//		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//			User user=new User();
//			user.setName(rs.getString("name"));
//			user.setEmail(rs.getString("email"));
//			user.setGender(rs.getString("gender"));
//			user.setCity(rs.getString("city"));
//			return user;
//		}
//	}

}
