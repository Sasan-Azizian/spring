package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	//this is where we add all of our related advices for logging
	
	//let's strat with an @Before advice
	
	@Before("execution(public void addAcount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>  Executing @Before advice on addAccount()");
	}
	
}
