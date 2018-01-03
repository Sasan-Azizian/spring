package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import entity.Student;

public class DEleteCoursesForMarryDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start new transaction
			session.beginTransaction();
			
			// get the course from database
			Course tempCpourse=session.get(Course.class, 10);
			session.delete(tempCpourse);
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
