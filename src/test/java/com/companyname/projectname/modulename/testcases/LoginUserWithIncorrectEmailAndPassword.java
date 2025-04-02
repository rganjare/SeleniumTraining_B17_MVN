package com.companyname.projectname.modulename.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.companyname.projectname.modulename.testbase.TestBase;

public class LoginUserWithIncorrectEmailAndPassword extends TestBase {
	
	@BeforeClass
	public void beforeTestCase() {
		testcaseName = this.getClass().getSimpleName();
		if(!run_mode.get(testcaseName).equalsIgnoreCase("Yes"))
			throw new SkipException("Skipping Test case as it's RunMode is set to No");
	}
	
	@Test
	public void loginUserWithIncorrectEmailAndPassword() throws IOException {
		
		String pageTitle = driver.getTitle();
		
		Assert.assertEquals(pageTitle, "Automation Exercise");
		
		test.pass("home page is visible successfully");
		
		driver.findElement(By.xpath("//*[text()=\" Signup / Login\"]")).click();
		
		String newUsersignup = driver.findElement(By.xpath("//*[text()=\"Login to your account\"]")).getText();
		Assert.assertEquals(newUsersignup, "Login to your account");
		test.pass("Login to your account is visible successfully");
		
		driver.findElement(By.xpath("//*[@data-qa=\"login-email\"]")).sendKeys("bymatAutomation@gmail.com");
		test.info("User entered email address");
		
		driver.findElement(By.xpath("//*[@data-qa=\"login-password\"]")).sendKeys("passwor45564646d@2024");
		test.info("User entered password");
		
		driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();
		test.info("User clicked on login-button");
		
		String accntpageText= driver.findElement(By.xpath(" //*[text()=\" Logged in as \"]")).getText();
		System.out.println(accntpageText);
		Assert.assertEquals(accntpageText, "Logged in as BYMAT_Automation");
		test.pass("User Logged in as username' is visible");
		
	}
}
