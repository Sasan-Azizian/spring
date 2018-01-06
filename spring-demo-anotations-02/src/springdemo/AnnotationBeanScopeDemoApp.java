package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		//	load spring config file
		ClassPathXmlApplicationContext context=new
				ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring container
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach=context.getBean("tennisCoach",Coach.class);
		
		//check if the same object
		boolean result=(theCoach==alphaCoach);
		
		//print out the results
		System.out.println("\nPointing to the same object: "+result);
		System.out.println("\n Memorty for theCOach: "+theCoach);
		System.out.println("\n Memorty for theCOach: "+theCoach);
		System.out.println("\n Memorty for alphaCOach: "+alphaCoach);
		
		context.close();
		
		

	}

}
