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
	
	
	//creat pointcut for gether methd
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	//create pointcut for setter method
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	//create pointcute: include package...exclude getter/setter
	@Pointcut("forDaoPackage() &&  !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {		
		System.out.println("\n=====>>  Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytices() {
		System.out.println("\n******>>> Performing API analytics");
	}
	
}
