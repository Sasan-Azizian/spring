package springdemoconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springdemoconfig.SportConfig;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config file
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(SportConfig.class);
		//get the bean from spring container
		SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		
		
		//call a method on the bean
				System.out.println(theCoach.getDailyWorkout());
				System.out.println(theCoach.getDailyFortune());
				System.out.println(theCoach.getEmail());
				System.out.println(theCoach.getEmail());
				
//				
				
				
		//close the context
		context.close();

	}

}
