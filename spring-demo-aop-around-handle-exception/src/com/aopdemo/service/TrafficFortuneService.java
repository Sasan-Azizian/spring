package com.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		//simulate a delay
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//return a fortune
		
		return "Expect heavy traffic";
	}

	public String getFortune(boolean tripwire) {
		if(tripwire) {
			throw new RuntimeException("Major accident! highway is closed");
		}
		return getFortune();
	}
}
