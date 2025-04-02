package com.companyname.projectname.modulename.oopsConcepts.encapsulation;

public class TestEncapsulation { // Bank Executive

	public static void main(String[] args) {
		
		HDFC_Bank hdfc = new HDFC_Bank(5353345353535353l);
		
	//hdfc.setAccount_No(5353345353535353l);
		
	hdfc.setAccount_balance(5000); // Deposit 5k
	
	System.out.println(hdfc.getAccount_balance()); // User
	
	hdfc.setEmail("test1234@gmail.com");// Bank
	
	System.out.println(hdfc.getEmail());// User 
	
	}
	
	

}
