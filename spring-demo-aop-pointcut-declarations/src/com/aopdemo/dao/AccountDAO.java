package com.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Component
public class AccountDAO {
	


	public void addAcount(Account theAccount, boolean f) {
		System.out.println(getClass() + ":   Doing MY Work: Adding An Account.");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ":   doWork");
		return false;
	}

}
