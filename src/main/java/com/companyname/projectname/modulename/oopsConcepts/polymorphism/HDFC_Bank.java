package com.companyname.projectname.modulename.oopsConcepts.polymorphism;

public class HDFC_Bank extends RBI_Bank { // Inheritance
	
	public double homeloanROI() {
		
		System.out.println("I am into HDFC_Bank ROI homeloan method");
		
		return 8.1; // 1.75% HDFC bank
	}
	
	public double personalloanROI() {
		
		System.out.println("I am into HDFC_Bank ROI personal-loan method");
		
		return 12.5; 
	}

}
