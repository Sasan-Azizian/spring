package crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
		
		System.out.println("Binding Result: "+theBindingResult);
		if(theBindingResult.hasErrors()) {
			return "customer-form";
		}else {
			// save the customer using our service
			customerService.saveCustome(theCustomer);
			return "redirect:/cust/list";
		}

	}
	
	@GetMapping("/delete")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		//delete customer from service
		customerService.deleteCustomer(theId);
		
		//send over to our form
		return "redirect:/cust/list";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String sdelete(@RequestParam("customerId") int theId,
									Model theModel) {
		
		//get customer from service
		Customer theCustomer=customerService.getCustomers(theId);
		
		//set customer as model attribute
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		return "customer-form";
		
	}
	
    @PostMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor str=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, str);
		
	}
}
