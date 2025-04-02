package com.companyname.projectname.modulename.oopsConcepts.polymorphism;

public class MethodOverrides {
	
	// Dynamic binding Or Run time polymorphism Or later binding
	
	// There should be inheritance relation between 2 classes
	// Child class should have a method with same name and same data type
	// Create Object of Child class and assign it to the Parent class reference variable
	
 public static void main(String[] args) {
		
	RBI_Bank rb_ICICI = new ICICI_Bank();
		
	System.out.println(rb_ICICI.homeloanROI());
	
	System.out.println(rb_ICICI.personalloanROI());
	
	rb_ICICI.creditCradOffer();
	
	System.out.println("#################################");
	
	RBI_Bank rb_HDFC = new HDFC_Bank();
	
	System.out.println(rb_HDFC.homeloanROI());
	
	System.out.println(rb_HDFC.personalloanROI());
		
	rb_HDFC.creditCradOffer();
	
	System.out.println("#################################");
	
	RBI_Bank rb_SBI = new SBI_Bank();
	
	System.out.println(rb_SBI.homeloanROI());
	
	System.out.println(rb_SBI.personalloanROI());
	
	rb_SBI.creditCradOffer();
	
	}
	
}
