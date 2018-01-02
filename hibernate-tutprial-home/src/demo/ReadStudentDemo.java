package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student objec...");
			Student theStudent=new Student("Daffy","Duck","daffy@gmail.com");
			
			//start new transaction
			session.beginTransaction();
			
			//save object
			System.out.println("Saving the student...");
			System.out.println(theStudent);
			session.save(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//find out the student's id: primary key
			System.out.println("\nSaved stydent. Generated Id: "+ theStudent.getId());
			
			// now get a new seesion
			session=factory.getCurrentSession();
			
			//start new transaction
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: "+theStudent.getId());
			theStudent=session.get(Student.class, theStudent.getId());
			
			System.out.println("\n\nGet Complete: "+ theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
