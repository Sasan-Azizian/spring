package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Instructor;
import entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();

		//create session
		Session session=factory.getCurrentSession();
		
		try {
			
			//start new transaction
			session.beginTransaction();
			int theId=3;
			InstructorDetail tempID=session.get(InstructorDetail.class, theId);
			
			System.out.println("The Instructor Detaile: "+tempID);
			
			System.out.println("The Instructor is:  "+tempID.getInstructor());
			
			System.out.println("\n\n Deleting Instructor Detail: "+tempID);
			
			//we need to break the bi-directional refrence
			tempID.getInstructor().setInstructorDetail(null);
			session.delete(tempID);
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
