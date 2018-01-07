package com.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring containter
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		//call tehmethod to find the accounts
		List<Account> theAccounts=theAccountDAO.findAccounts();
		
		//display the account
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("-----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n");
		
		
		
		
		
		//close the context
		context.close();

	}

}
