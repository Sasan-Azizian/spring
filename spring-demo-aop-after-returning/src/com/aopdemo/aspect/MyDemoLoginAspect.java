package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
	//add a new advice for @AfterReturning on teh findAccount method
	@AfterReturning(
			pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(
				JoinPoint theJoinPoint, List<Account> result) {
		
		//print which method we are advising on
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AQfterReturning on method: "+method);
		
		// print out the result of the method call
		System.out.println("\n=====>>> result is: "+result);
		
		
		//let's post-process teh data... let's modify it :)
		
		//convert the account name to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n The result is: "+result);
	}


	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		//loop through account
		for(Account tempAccount:result) {
		
			//get uppercase version of name
			String theUpperName=tempAccount.getName().toUpperCase();
			
			//update the name on the account
			tempAccount.setName(theUpperName);
			
		}
	}
	
	
	
	
}
