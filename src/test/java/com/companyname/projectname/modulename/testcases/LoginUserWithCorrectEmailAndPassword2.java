package com.companyname.projectname.modulename.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.companyname.projectname.modulename.testbase.TestBase;
import com.companyname.projectname.modulename.utilities.CommonMethods;

public class LoginUserWithCorrectEmailAndPassword2 extends TestBase {
	
	@BeforeClass
	public void beforeTestCase() {
		testcaseName = this.getClass().getSimpleName();
		if(!run_mode.get(testcaseName).equalsIgnoreCase("Yes"))
			throw new SkipException("Skipping Test case as it's RunMode is set to No");
	}
	
	@Test(dataProvider = "dataCollection")
	public void loginUserWithCorrectEmailAndPassword2(Hashtable<String, String> ht) throws IOException {
		
//	String pageTitle = driver.getTitle();
//	Assert.assertEquals(pageTitle, ht.get("Page_Title"));
//	test.pass("home page is visible successfully");
	// 500*3 = 1500
		
	CommonMethods.verifyPageTitle(ht.get("Page_Title"));
	
	//driver.findElement(By.xpath("//*[text()=\" Signup / Login\"]")).click();
	
	CommonMethods.clickOnWebElement("//*[text()=\" Signup / Login\"]", "Signup / Login link");
	
//	String newUsersignup = driver.findElement(By.xpath("//*[text()=\"Login to your account\"]")).getText();
//	Assert.assertEquals(newUsersignup, ht.get("Sign_up_Text"));
//	test.pass("Login to your account is visible successfully");
	
	CommonMethods.verifyPageText("//*[text()=\"Login to your account\"]", ht.get("Sign_up_Text"));
	
//	driver.findElement(By.xpath("//*[@data-qa=\"login-email\"]")).sendKeys(ht.get("Email"));
//	test.info("User entered email address");
	
	CommonMethods.enterTextInTextBox("//*[@data-qa=\"login-email\"]", ht.get("Email"));
//	
//	driver.findElement(By.xpath("//*[@data-qa=\"login-password\"]")).sendKeys(ht.get("Password"));
//	test.info("User entered password");
	
	CommonMethods.enterTextInTextBox("//*[@data-qa=\"login-password\"]", ht.get("Password"));
	
//	driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();
//	test.info("User clicked on login-button");
	
	CommonMethods.clickOnWebElement("//*[@data-qa=\"login-button\"]", "login-button");
	
//	String accntpageText= driver.findElement(By.xpath(" //*[text()=\" Logged in as \"]")).getText();
//	System.out.println(accntpageText);
//	Assert.assertEquals(accntpageText, ht.get("Accnt_Page_Text"));
//	test.pass("User "+accntpageText+" is visible");
	
	CommonMethods.verifyPageText("//*[text()=\" Logged in as \"]", ht.get("Accnt_Page_Text"));
	}
	
	@DataProvider
	public Object[][] dataCollection() {	
		Hashtable<Object, Object> ht = new Hashtable<>();
		ht = dm.getTestDataInHashTable("Test_Data_SIT", testcaseName);
		return new Object[][] {{ht}};
	}

}
