package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
