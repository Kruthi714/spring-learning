package in.sp.main.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import in.sp.main.config.HibernateConfig;
import in.sp.main.entity.Student;
@Repository
public class DbOperationsImple implements DbOperations{

	@Override
	public Student getStudentDetails(int id) {
		Student std=null;
		try (Session session=HibernateConfig.getSessionFactory().openSession();){
			std=session.get(Student.class, 1);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return std;
	}

	@Override
	public void insertDetails(Student std) {
		Session session=HibernateConfig.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		try{
		session.persist(std);
		transaction.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		
	}

}
