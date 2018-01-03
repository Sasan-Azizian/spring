package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start new transaction
			session.beginTransaction();
			
			//create the course
			Course tempCourse=new Course("java");
			
			//add some review
			tempCourse.addReview(new Review("Greate Course... loved it"));
			tempCourse.addReview(new Review("Cool Course, job well done"));
			tempCourse.addReview(new Review("what a dumb course, you are idiot"));
			
			//save the course
			System.out.println("\nSaving the course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
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
