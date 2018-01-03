package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import entity.Student;

public class AddCoursesForMarryDemo {

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
			
			// get the student Mary from database
			Student tempStudent=session.get(Student.class, 2);
			System.out.println("Mary Student: "+tempStudent);
			System.out.println("Courses: "+tempStudent.getCourses());
			
			//create more course
			Course tempCourse1=new Course("C#");
			Course tempCourse2=new Course("Python");
			Course tempCourse3=new Course("Atary 2600");
			
			//add student tocourse
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			
			//save th2 courses
			System.out.println("\n Saving the Courses...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
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
