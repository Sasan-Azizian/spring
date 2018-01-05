package crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import crm.entity.Customer;
import crm.service.CustomerService;

@Controller
@RequestMapping("/cust")
public class CustomerController {
	
	//need toinject our customer service
	@Autowired
	private CustomerService customerService;

	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customer from the service
	 	List<Customer>theCustomers=customerService.getCustomers();
	 	
	 	for(Customer c:theCustomers)
	 		System.out.println(c);
		
		// add the customer to the model
		theModel.addAttribute("customers",theCustomers);
		
		
		return "list-customers";
	}
}
