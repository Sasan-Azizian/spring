package crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import crm.dao.CustomerDAO;
import crm.entity.Customer;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	
	//need to inject the Customer DAo
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		System.out.println("\n\n**************************************\n\n\n");
		//get customer from the dao
	 	List<Customer>theCustomers=customerDAO.getCustomers();
	 	
	 	for(Customer c:theCustomers)
	 		System.out.println(c);
		
		// add the customer to the model
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
	}
}
