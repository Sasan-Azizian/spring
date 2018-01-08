package com.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring containter
		TrafficFortuneService theTrafficFortuneService=
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		System.out.println("\n Main Program: AroundDempApp");
		
		System.out.println("Calling getFortune");
		
		String data=theTrafficFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: "+data);
		
		System.out.println("Finished");
		
	
		
		
		
		
		
		//close the context
		context.close();

	}

}
