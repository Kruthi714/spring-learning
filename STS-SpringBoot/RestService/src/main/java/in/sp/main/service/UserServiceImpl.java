package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Repository.UserRepository;
import in.sp.main.entity.User;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}
	@Override
	public User updateUserDetails(int id, User newUser) {
		
		User u1=userRepository.findById(id).orElse(null);
		if(u1!=null) {
			return userRepository.save(newUser);
		}
		else {
		 throw new RuntimeException("User not found with id: "+id);
		}
	}
	@Override
	public boolean deleteUser(int id) {
		Optional<User> optional=userRepository.findById(id);
	    if(optional.isPresent()) {
	        userRepository.deleteById(id);
	        return true;
	    }
	    return false;
		
	}
	

}
