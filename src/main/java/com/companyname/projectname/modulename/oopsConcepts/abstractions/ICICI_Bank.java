package com.companyname.projectname.modulename.oopsConcepts.abstractions;

public abstract class ICICI_Bank { // Object creation is Not allowed 
	
	public ICICI_Bank() {
		System.out.println("I am in the default constructor");
	}
	
	public ICICI_Bank(String name) {
		System.out.println("I am in the parame constructor");
	}
	
	public abstract void transferMoney(long fromaccount, long toAccount);
	
	public abstract void receiveMoney();
	
	public abstract void checkYourAccountBalance(long account_no);
	
	public void transferMoney1() {
		
	}
	
	public void receiveMoney2() {
		
	}
	
	public void checkYourAccountBalance2() {
		
	}
	
	public static void transferMoney3() {
		
	}
	
	public static void receiveMoney3() {
		
	}
	
	public static void checkYourAccountBalance3() {
		
	}

}
