package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMember() {
		System.out.println(getClass()+"  : DOING STUFF: AADDING A MEMBERSHIP ACCOUNT");
		return true;
	}

	public void gorToSleeo() {
		System.out.println(getClass()+"  : I am going to sleep...");
	}
}
