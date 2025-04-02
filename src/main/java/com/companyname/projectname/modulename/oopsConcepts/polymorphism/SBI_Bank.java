package com.companyname.projectname.modulename.oopsConcepts.polymorphism;

public class SBI_Bank extends RBI_Bank { // Inheritance
	
	public double homeloanROI() {
		
		System.out.println("I am into SBI_Bank ROI homeloan method");
		
		return 7.5; // 1 % SBI_Bank bank
	}
	
	public double personalloanROI() {
		
		System.out.println("I am into SBI_Bank ROI personal-loan method");
		
		return 10.5; 
	}

}
