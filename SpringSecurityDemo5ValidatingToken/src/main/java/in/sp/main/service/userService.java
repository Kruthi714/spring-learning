package in.sp.main.service;

import java.net.Authenticator;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import in.sp.main.model.User;
import in.sp.main.repo.UserRepo;

@Service
public class userService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JWTService jwtService;
	public User saveUser(User u1) {
		return userRepo.save(u1);
	}
	public List<User> allUserDetails(){
		return userRepo.findAll();
	}
	public String verify(User u1) {
		Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(u1.getName(), u1.getPassword()));
		if(authentication.isAuthenticated())//returns true or false
		{
			return jwtService.generateToken(u1.getName());
		}
		else {
			return "failure";
		}
	}

}
