package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(22)
public class MyApiAnalyticsAspect {

	@Before("com.aopdemo.aspect.AopExperations.forDaoPackageNoGetterSetter()")
	public void performApiAnalytices() {
		System.out.println("\n******>>> Performing API analytics");
	}
}
