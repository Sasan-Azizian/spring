package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class DeleteStudentDemo {

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
			Student theStudent=new Student("Sasan","Azizian","sasan.azizian@gmail.com");
			
			//start new transaction
			session.beginTransaction();
			
			//Delete object
			session.createQuery("delete from Student where id='4'").executeUpdate();
			
			//new code
			Student thestudent=session.get(Student.class, 3);
			session.delete(thestudent);
			
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
