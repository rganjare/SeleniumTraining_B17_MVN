package com.companyname.projectname.modulename.oopsConcepts.testinterface;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestInterface { // Class level AM
	
	public static BYMAT_WebDriver driver; // member Level AM
	
	public static void main(String[] args) { // member Level AM
		
		driver = new BYMAT_ChromeDriver();
		
		driver = new BYMAT_ChromeDriver("BYMAT");
		
		//Select sel = new Select((WebElement) driver);
		
		//Actions act = new Actions(driver);
		
//		driver.get("");
//		driver.findelement();
//		driver.getcurrentURL();
//		driver.gettitle();
//		driver.sendKeys(null);
//		
//		driver.takeScreenShot();
//		
//		driver = new BYMAT_Firefox();
	}

}
