package in.sp.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.model.User;
import in.sp.main.repo.UserRepo;

@Service
public class userService {
	@Autowired
	private UserRepo userRepo;
	public User saveUser(User u1) {
		return userRepo.save(u1);
	}
	public List<User> allUserDetails(){
		return userRepo.findAll();
	}

}
