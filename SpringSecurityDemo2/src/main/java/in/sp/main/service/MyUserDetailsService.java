package in.sp.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.sp.main.model.Student;
import in.sp.main.model.UserPrincipal;
import in.sp.main.repo.UserRepo;
@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student std=userRepo.findByName(username);
		if(std==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		System.out.println("Username from DB: " + std.getName());
	    System.out.println("Password from DB: " + std.getPassword());
		return new UserPrincipal(std);
	}
	

}
