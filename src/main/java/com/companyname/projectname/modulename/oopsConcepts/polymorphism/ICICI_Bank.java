package com.companyname.projectname.modulename.oopsConcepts.polymorphism;

public class ICICI_Bank extends RBI_Bank { // Inheritance
	
	public double homeloanROI() {
		
		System.out.println("I am into ICICI_Bank ROI homeloan method");
		
		return 8.5; // 2% ICICI bank
	}
	
	public double personalloanROI() {
		
		System.out.println("I am into ICICI_Bank ROI personal-loan method");
		
		return 11.5;
	}

}
