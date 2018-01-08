package com.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger=
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		
		
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring containter
		TrafficFortuneService theTrafficFortuneService=
				context.getBean("trafficFortuneService",TrafficFortuneService.class);
		
		myLogger.info("\n Main Program: AroundDempApp");
		
		myLogger.info("Calling getFortune");
		
		String data=theTrafficFortuneService.getFortune();
		
		myLogger.info("\nMy fortune is: "+data);
		
		myLogger.info("Finished");
		
	
		
		
		
		
		
		//close the context
		context.close();

	}

}
