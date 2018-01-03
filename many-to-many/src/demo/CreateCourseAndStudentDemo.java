package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			//create the course
			Course tempCourse=new Course("java");
			
			//save the course
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved teh Course: "+tempCourse);
			
			//create the student
			Student tempStudent1=new Student("John","Doe","j@gmail.com");
			Student tempStudent2=new Student("Mary","Public","j@gmail.com");
		
			//add student to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the student
			System.out.println("\nSaving Students...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			
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
