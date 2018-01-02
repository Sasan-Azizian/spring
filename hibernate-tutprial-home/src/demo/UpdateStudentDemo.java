package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class UpdateStudentDemo {

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
			
			Student myStudent=session.get(Student.class, 3);
			myStudent.setLastName("Rastegari");
			
			//commit transaction
			session.getTransaction().commit();
			
			//new cod for update
			Session session2=factory.getCurrentSession();
			session2.beginTransaction();
			
			System.out.println("\n\nUpdating email for all of the students..");
			session2.createQuery("update Student s  set s.email='foo@uno.edu.com'").executeUpdate();
			
			session2.getTransaction().commit();
			
			System.out.println("Done!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
