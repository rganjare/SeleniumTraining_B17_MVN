package com.companyname.projectname.modulename.oopsConcepts.abstractions;

public class PayTM extends ICICI_Bank {
	
	public PayTM(){
		super();
	}
	
	@Override
	public void transferMoney(long fromaccount, long toAccount) {
		// TODO Auto-generated method stub
		System.out.println("API call");
		System.out.println("API call to transfer amount "+fromaccount+" to  "+toAccount);
	
	}

	@Override
	public void receiveMoney() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkYourAccountBalance(long account_no) {
		System.out.println("API call to check account balance for" +account_no+" account ");
		
	}
	

}
