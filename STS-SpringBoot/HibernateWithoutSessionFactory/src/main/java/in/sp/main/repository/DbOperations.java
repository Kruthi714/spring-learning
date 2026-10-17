package in.sp.main.repository;

import in.sp.main.entity.Student;

public interface DbOperations {
	public void insertDetails(Student std);
	public Student getStudentDetails(int id);
}
