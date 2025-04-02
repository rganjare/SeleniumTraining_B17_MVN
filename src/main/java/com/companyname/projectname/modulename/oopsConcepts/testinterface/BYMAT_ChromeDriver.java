package com.companyname.projectname.modulename.oopsConcepts.testinterface;

public class BYMAT_ChromeDriver implements BYMAT_WebDriver {

	public BYMAT_ChromeDriver() {
		System.out.println("I am in Default Constructor");
		System.out.println("Code to launch the browser");
	}
	
	public BYMAT_ChromeDriver(String driver) {
		System.out.println("I am in agru Constructor");
		System.out.println(driver);
	}
	
	@Override
	public void get(String URL) {
		System.out.println("Code to launch chrome browser");
		
	}
	
	@Override
	public void sendKeys(String value) {
		System.out.println("Code to sendkeys in chrome browser");
		
	}
	
	@Override
	public void switchTo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void quit() {
		System.out.println("Code to quit the chrome browser");
		
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
		System.out.println("Code to gettitle in chrome browser");
		
	}

	@Override
	public void getcurrentURL() {
		System.out.println("Code to getcurrentURL in chrome browser");
		
	}

	@Override
	public void takeScreenShot() {
		// TODO Auto-generated method stub
		
	}


}
