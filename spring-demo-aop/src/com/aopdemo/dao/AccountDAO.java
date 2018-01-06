package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	


	public void addAcount() {
		System.out.println(getClass() + ":   Doing MY Work: Adding An Account.");
	}

}
