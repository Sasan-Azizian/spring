package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory=new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();

				//create session
				Session session=factory.getCurrentSession();
				
				try {
					System.out.println("Creating 3 new student objec...");
					Student theStudent1=new Student("Saman","Azizian","saman.azizian@gmail.com");
					Student theStudent2=new Student("Salar","Azizian","salar.azizian@gmail.com");
					Student theStudent3=new Student("Elham","Azizian","erastegari@gmail.com");
					
					//start new transaction
					session.beginTransaction();
					
					//save object
					System.out.println("Saving the students...");
					session.save(theStudent1);
					session.save(theStudent2);
					session.save(theStudent3);
					
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
