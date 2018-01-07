package com.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	

	private String name;
	private String serviceCode;

	
	//add a new methos: findAccounts()
	public List<Account> findAccounts(){
		List<Account> myAccounts=new ArrayList<>();
		
		//create some sample accounts
		Account temp1=new Account("Sasan","Silver");
		Account temp2=new Account("Saman","Platinum");
		Account temp3=new Account("Salar","Gold");
		
		//add them to our acconts
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		
		return myAccounts;
	}
	
	
	
	public void addAcount(Account theAccount, boolean f) {
		System.out.println(getClass() + ":   Doing MY Work: Adding An Account.");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ":   doWork");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+"  :  in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+"  :  in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+"  :  in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+"  :  in  setServiceCode");
		this.serviceCode = serviceCode;
	}

	
}
