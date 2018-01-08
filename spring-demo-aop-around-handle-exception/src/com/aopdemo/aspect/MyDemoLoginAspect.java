package com.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	//this is where we add all of our related advices for logging
	
	//let's strat with an @Before advice

	@Before("com.aopdemo.aspect.AopExperations.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint thehJoinPoint) {		
		
		myLogger.info("\n=====>>  Executing @Before advice on addAccount()");
		
		//display the mehtod signature
		MethodSignature methodSig=(MethodSignature)thehJoinPoint.getSignature();
		myLogger.info("Signature: "+methodSig);
		
		//display method arguments
		
		//get args
		Object[] args= thehJoinPoint.getArgs();
		
		//loop hrow args
		for(Object o:args) {
			myLogger.info(o.toString());
			
			if(o instanceof Account) {
				Account tempAccount=(Account)o;
				myLogger.info("\n\n Account nName:"+((Account) o).getName());
				myLogger.info(" Account Level:"+((Account) o).getLevel());
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
		myLogger.info("\n=====>>> Executing @AQfterReturning on method: "+method);
		
		// print out the result of the method call
		myLogger.info("\n=====>>> result is: "+result);
		
		
		//let's post-process teh data... let's modify it :)
		
		//convert the account name to uppercase
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n The result is: "+result);
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
	
	
	
	@AfterThrowing(
					pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
					throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
							JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advicing
		String method=theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @AfterThrowing on method: "+method);
		
		//log the execption
		myLogger.info("\n------------>>>> the Exception is: "+theExc);
	}
	
	
	
	@After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advicing
				String method=theJoinPoint.getSignature().toShortString();
				myLogger.info("\n=====>>> Executing @After (Finally) on method: "+method);
		
		
		
	}
	
	
	@Around("execution(* com.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint )throws Throwable {
		
		//print out method we are advicing on
		String method=theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @Around on method: "+method);

		//get begin timestamp
		long begin=System.currentTimeMillis();
		
		//now, let's execute the method
		Object result=null;
		try {
			result=theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			//log the exception
			myLogger.warning(e.getMessage());
			
			throw e;
		}
		myLogger.info("result: ** "+result);
		
		//get end timestamp
		long end=System.currentTimeMillis();
		
		// compute duration and display it
		
		long duration=end-begin;
		myLogger.info("\n=====> Duration: "+ duration/1000.0+" second");
		
		return result;
	}
	
	
}
