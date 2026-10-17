package in.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import in.sp.main.entity.Student;
import in.sp.main.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository sr;
	@Override
	public boolean addStudentDetails(Student std) {
		boolean status=false;
		try {
		sr.save(std);
		status=true;
		}
		catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		return status;
	}
	@Override
	public List<Student> getstudent() {
		return sr.findAll();
	}
	@Override
	public Student getStdDetails(Long id) {
		Optional<Student> optional=sr.findById(1L);
		if(optional.isPresent()) {
			return optional.get();	
		}
		return null;
	}

}
