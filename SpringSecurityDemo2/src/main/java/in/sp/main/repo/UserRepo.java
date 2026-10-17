package in.sp.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.model.Student;
@Repository
public interface UserRepo extends JpaRepository<Student, Integer>{
	 Student findByName(String name);
}
