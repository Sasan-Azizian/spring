package com.aopdemo;

import javax.xml.transform.sax.TemplatesHandler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;

public class MAinDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean form spring containter
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the bussiness
		theAccountDAO.addAcount(new Account(),true);
		theAccountDAO.doWork();
		
		//call teh AccountDAO getter/setter
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name=theAccountDAO.getName();
		String code=theAccountDAO.getServiceCode();
		
		//call teh membership business
		theMembershipDAO.addSillyMember();
		theMembershipDAO.gorToSleeo();
		
		
		
		
		
		//close the context
		context.close();

	}

}
