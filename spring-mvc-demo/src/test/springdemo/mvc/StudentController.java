package test.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("student", new Student());
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		theStudent.setFirstName(theStudent.getFirstName().toUpperCase());
		theStudent.setLastName(theStudent.getLastName().toUpperCase());
		
		System.out.println("the Student: "+theStudent.getFirstName()+ "  "
				+theStudent.getLastName());
		
		return "student-configuration";
	}

}
