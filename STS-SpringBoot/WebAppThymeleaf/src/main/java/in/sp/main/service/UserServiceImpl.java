package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Repository.UserRepository;
import in.sp.main.entity.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;
	@Override
	public boolean RegisterUser(User user) {
		boolean status=false;
		try {
			userRepo.save(user);
			status=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			status=true;
		}
				
		return status;
	}
	@Override
	public User ValidateUser(String email, String password) {
		User user=userRepo.findByEmail(email);
		if(user!=null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

}
