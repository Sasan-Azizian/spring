package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExperations {

	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	
	//creat pointcut for getter methd
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//create pointcut for setter mettod
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//create pointcut: include package...exclude getter/setter
	@Pointcut("forDaoPackage() &&  !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
