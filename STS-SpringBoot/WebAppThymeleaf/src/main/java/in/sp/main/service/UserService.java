package in.sp.main.service;

import org.springframework.stereotype.Service;

import in.sp.main.entity.User;
@Service

public interface UserService {
	public boolean RegisterUser(User user);
	public User ValidateUser(String email,String password);
}
