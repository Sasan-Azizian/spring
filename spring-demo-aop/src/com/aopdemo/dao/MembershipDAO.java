package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAcount() {
		System.out.println(getClass()+"  : DOING STUFF: AADDING A MEMBERSHIP ACCOUNT");
	}

}
