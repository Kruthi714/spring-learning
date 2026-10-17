package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
