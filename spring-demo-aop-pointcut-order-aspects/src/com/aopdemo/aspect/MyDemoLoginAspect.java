package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {

	//this is where we add all of our related advices for logging
	
	//let's strat with an @Before advice

	@Before("com.aopdemo.aspect.AopExperations.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {		
		System.out.println("\n=====>>  Executing @Before advice on addAccount()");
	}
	
	
	
	
	
}
