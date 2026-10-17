package in.sp.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.sp.main.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	 User findByName(String name);
}
