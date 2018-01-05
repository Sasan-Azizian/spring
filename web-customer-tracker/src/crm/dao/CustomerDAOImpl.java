package crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibenate session
		Session curentSession=sessionFactory.getCurrentSession();
		
		//create query
		
		Query<Customer> theQuey=curentSession.createQuery("from Customer", 
														 Customer.class);
		
		//execute query and get the result list
		List<Customer> customers=theQuey.getResultList();
		
		//return the result
		return customers;
	}

}
