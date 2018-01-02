package demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start new transaction
			session.beginTransaction();
			
			//Query students
			List<Student> theStudents=session.createQuery("from Student").getResultList();
			
			//display students
			displayStudents(theStudents);
			
			System.out.println("\n\n query student whose last naem is Azizian:");
			
			//query student whose last naem is Azizian
			theStudents=session.createQuery("from Student s where s.firstName='Sasan' OR s.firstName='Elham'").getResultList();

			//display students
			displayStudents(theStudents);
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temp:theStudents)
			System.out.println(temp);
	}

}
