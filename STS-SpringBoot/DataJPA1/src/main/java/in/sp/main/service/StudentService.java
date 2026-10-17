package in.sp.main.service;

import java.util.List;

import in.sp.main.entity.Student;

public interface StudentService {
	public boolean addStudentDetails(Student std);
	public List<Student> getstudent();
	public Student getStdDetails(Long id);

}
