package in.sp.main.service;

import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
@Service
public interface UserService {
	public boolean registerUser(User user);
	public User Retrive1User(String email,String password);

}
