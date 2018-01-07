package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	//this is where we add all of our related advices for logging
	
	//let's strat with an @Before advice
	
	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {		
		System.out.println("\n=====>>  Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytices() {
		System.out.println("\n******>>> Performing API analytics");
	}
	
}
