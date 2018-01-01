package test.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		String result="YES!  "+request.getParameter("studentName").toUpperCase();
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVErsionThree(@RequestParam("studentName") String theName,
			Model model) {
		String result="@ReqestParam() version 3 !  "+theName;
		model.addAttribute("message",result);
		return "helloworld";
	}
}
