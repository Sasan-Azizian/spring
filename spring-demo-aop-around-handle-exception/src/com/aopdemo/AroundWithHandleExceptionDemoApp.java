package com.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundWithHandleExceptionDemoApp {

	private static Logger myLogger=
			Logger.getLogger(AroundWithHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		
		
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring containter
		TrafficFortuneService theTrafficFortuneService=
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n Main Program: AroundDempApp");
		
		myLogger.info("Calling getFortune");
		
		
		boolean tripwire=true;
		String data=theTrafficFortuneService.getFortune(tripwire);
		
		myLogger.info("\nMy fortune is: "+data);
		
		myLogger.info("Finished");
		
	
		
		
		
		
		
		//close the context
		context.close();

	}

}
