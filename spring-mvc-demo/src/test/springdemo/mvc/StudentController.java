package test.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String processForm(
			@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult) {
		
		theStudent.setFirstName(theStudent.getFirstName().toUpperCase());
		theStudent.setLastName(theStudent.getLastName().toUpperCase());
		
		System.out.println("the Student: "+theStudent.getFirstName()+ "  "
				+theStudent.getLastName());
		if(theBindingResult.hasErrors()){
			return "student-form";
		}else {
			return "student-configuration";
		}
		
		
	}

}
