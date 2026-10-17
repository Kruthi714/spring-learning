package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import in.sp.main.entity.User;

public interface UserService {
	public User createUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUserById(int id);
	public User updateUserDetails(int id,User user);
	public boolean deleteUser(int id);

}
