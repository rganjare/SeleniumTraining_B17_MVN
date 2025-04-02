package com.companyname.projectname.modulename.oopsConcepts.encapsulation;

public class HDFC_Bank { // encapsulation
	
	private long account_No;
	private String account_owner;
	private double account_balance;
	private String address;
	private String email;
	private long mobile_No;
	
	public HDFC_Bank (long account_No) { 
		this.account_No = account_No;
	}
	
//	public long getAccount_No() {
//		return account_No;
//	}
//	public void setAccount_No(long account_No) {
//		this.account_No = account_No;
//	}
	
	public String getAccount_owner() {
		return account_owner;
	}
	public void setAccount_owner(String account_owner) {
		this.account_owner = account_owner;
	}
	
	public double getAccount_balance() {
		// select balance from xyz table where account number = account_No;
		// 10000
		double balance = 10000 +account_balance;
		return balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
	//	email = select email from xyz where account no = account_No;
		email = "test@test.com";
		return email;
	}
	public void setEmail(String email) {
		
		// update email from xyz where account no = account_No set email= email
		
		this.email = email;
	}
	
	public long getMobile_No() {
		return mobile_No;
	}
	public void setMobile_No(long mobile_No) {
		this.mobile_No = mobile_No;
	}
	

}
