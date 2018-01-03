package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;

public class CreateCoursesDemo {

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
			Instructor tempInstructor=session.get(Instructor.class, 1);
			
			Course theCourse1=new Course("Java");
			Course theCourse2=new Course("C#");
			Course theCourse3=new Course("Python");
			
			tempInstructor.addCourse(theCourse1);
			tempInstructor.addCourse(theCourse2);
			tempInstructor.addCourse(theCourse3);
			
			session.save(theCourse1);
			session.save(theCourse2);
			session.save(theCourse3);
			
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
