package test.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptionjs;
	
	public Student() {
		countryOptionjs=new LinkedHashMap<>();
		countryOptionjs.put("BR", "Brazile");
		countryOptionjs.put("FR", "France");
		countryOptionjs.put("IR", "Iran");
		countryOptionjs.put("US", "USA");		
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public LinkedHashMap<String, String> getCountryOptionjs() {
		return countryOptionjs;
	}


	public void setCountryOptionjs(LinkedHashMap<String, String> countryOptionjs) {
		this.countryOptionjs = countryOptionjs;
	}
	
	
	
	
	
	
}
