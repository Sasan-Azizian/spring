package com.aopdemo.aspect;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoginAspect {

	//this is where we add all of our related advices for logging
	
	//let's strat with an @Before advice

	@Before("com.aopdemo.aspect.AopExperations.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint thehJoinPoint) {		
		
		System.out.println("\n=====>>  Executing @Before advice on addAccount()");
		
		//display the mehtod signature
		MethodSignature methodSig=(MethodSignature)thehJoinPoint.getSignature();
		System.out.println("Signature: "+methodSig);
		
		//display method arguments
		
		//get args
		Object[] args= thehJoinPoint.getArgs();
		
		//loop hrow args
		for(Object o:args) {
			System.out.println(o);
			
			if(o instanceof Account) {
				Account tempAccount=(Account)o;
				System.out.println("\n\n Account nName:"+((Account) o).getName());
				System.out.println(" Account Level:"+((Account) o).getLevel());
			}
		}
			
	}
	
	
	
	
	
}
