package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import in.sp.main.model.User;
import in.sp.main.model.UserPrincipal;
import in.sp.main.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u1=userRepo.findByName(username);
		if(u1==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		System.out.println("Username from DB: " + u1.getName());
	    System.out.println("Password from DB: " + u1.getPassword());
		return new UserPrincipal(u1);
	}
	

}
