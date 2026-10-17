package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public boolean registerUser(User user) {
		boolean status=false;
		try {
			userRepository.save(user);
			status=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}
	@Override
	public User Retrive1User(String email,String password) {
		User Validuser=userRepository.findByEmail(email);
		if(Validuser!=null && Validuser.getPassword().equals(password)) {
			return Validuser;
		}
		return null;
	}

}
