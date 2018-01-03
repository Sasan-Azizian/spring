package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start new transaction
			session.beginTransaction();
			//Hibernate query with HQl
			Query<Instructor> query=
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses where i.id=:theInstructorId",
							Instructor.class);
			query.setParameter("theInstructorId", 1);
			
			//execute query and get instructor
			Instructor tempInstructor=query.getSingleResult();
			
			
			System.out.println("Sasan: Instructor: "+tempInstructor);
			
			
			
			//commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\nSAsan: The session is now closed!\n");
			
			//get courses for the instructor
			System.out.println("Sasan: Courses: "+tempInstructor.getCourses());
			
			System.out.println("Sasan: Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
