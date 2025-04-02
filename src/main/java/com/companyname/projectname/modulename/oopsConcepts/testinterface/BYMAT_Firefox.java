package com.companyname.projectname.modulename.oopsConcepts.testinterface;

public class BYMAT_Firefox implements BYMAT_WebDriver {

	public BYMAT_Firefox() {
		System.out.println("I am in Default Constructor");
		System.out.println("Code to launch the browser");
	}
	
	@Override
	public void get(String URL) {
		System.out.println("Code to launch firefox browser");
		
	}

	@Override
	public void sendKeys(String value) {
		System.out.println("Code to sendkeys in firefox browser");
		
	}

	@Override
	public void switchTo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findelement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gettitle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getcurrentURL() {
		System.out.println("Code to getcurrentURL in firefox browser");
		
	}

	@Override
	public void takeScreenShot() {
		// TODO Auto-generated method stub
		
	}

}
