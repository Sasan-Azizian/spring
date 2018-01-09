package crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLogginAspect {
	
	//setup  logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	
	//setup pointcut declaration
	@Pointcut("execution(* crm.controller.*.*(..))")
	private	void forControllerPackage() {}
	
	// do same for service package
	@Pointcut("execution(* crm.service.*.*(..))")
	private	void forServicePackage() {}
	
	@Pointcut("execution(* crm.dao.*.*(..))")
	private	void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	

	
	//add  @Befor advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method we are calling
		String theMehod=theJoinPoint.getSignature().toLongString();
		myLogger.info("======>>>>>>> in @Before: caling method: "+theMehod);
		
		//display the arguments
		
		//get the arguments
		Object[] args=theJoinPoint.getArgs();
		
		//loop thru and display args
		for(Object tempArg: args) {
			myLogger.info("=====>> argument: "+ tempArg);
		}
	}
	
	
	
	
	//add @After

	@AfterReturning(pointcut="forAppFlow()", returning="theResult")
	public void after(JoinPoint theJoinPoint, Object theResult) {
		//display method
		String theMehod=theJoinPoint.getSignature().toLongString();
		myLogger.info("======>>>>>>> in @AfterReturning: caling method: "+theMehod);
		
		//display data
		myLogger.info("====>>> result: "+theResult);
	}
}
