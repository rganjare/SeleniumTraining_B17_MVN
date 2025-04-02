package com.companyname.projectname.modulename.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.companyname.projectname.modulename.testbase.TestBase;
import com.companyname.projectname.modulename.utilities.CommonMethods;

public class RegisterUser extends TestBase { // Inheritance- OOPs
	
	@BeforeClass
	public void beforeTestCase() {
		testcaseName = this.getClass().getSimpleName();
		if(!run_mode.get(testcaseName).equalsIgnoreCase("Yes"))
			throw new SkipException("Skipping Test case as it's RunMode is set to No");
	}	
	
	@Test(dataProvider = "dataCollection")
	public void registerUser(Hashtable<String, String> ht) throws IOException {
		
//	String pageTitle = driver.getTitle();
//	Assert.assertEquals(pageTitle, ht.get("Page_Title"));
//	test.pass("home page is visible successfully");
		
	CommonMethods.verifyPageTitle(ht.get("Page_Title"));
	
//	String homepage = driver.findElement(By.xpath("//*[text()=\" Home\"]")).getText();
//	Assert.assertEquals(homepage, "Home");
//	test.pass("home page is visible successfully");	
	
	//driver.findElement(By.xpath("//*[text()=\" Signup / Login\"]")).click();
	
	CommonMethods.clickOnWebElement("//*[text()=\" Signup / Login\"]", "Signup / Login");
	
//	String newUsersignup = driver.findElement(By.xpath("//*[text()=\"New User Signup!\"]")).getText();
//	Assert.assertEquals(newUsersignup, "New User Signup!");
//	test.pass("New User Signup! is visible successfully");
	
	CommonMethods.verifyPageText("//*[text()=\"New User Signup!\"]", ht.get("Sign_up_Text"));
	
//	driver.findElement(By.xpath("//*[@data-qa=\"signup-name\"]")).sendKeys(ht.get("UserName"));
//	test.info("User entered Username");
	
	CommonMethods.enterTextInTextBox("//*[@data-qa=\"signup-name\"]", ht.get("UserName"));
	
//	driver.findElement(By.xpath("//*[@data-qa=\"signup-email\"]")).sendKeys(ht.get("Email"));
//	test.info("User entered Email address");
	
	CommonMethods.enterTextInTextBox("//*[@data-qa=\"signup-email\"]", ht.get("Email"));
	
//	driver.findElement(By.xpath("//*[@data-qa=\"signup-button\"]")).click();
//	test.info("User clicked on signup-button");
	
	CommonMethods.clickOnWebElement("//*[@data-qa=\"signup-button\"]", "signup-button");
	
//	String accntpageText= driver.findElement(By.xpath("//*[text()=\"Enter Account Information\"]")).getText();
//	Assert.assertEquals(accntpageText, ht.get("Page_Text"));
//	test.pass("ENTER ACCOUNT INFORMATION is visible successfully");
	
	CommonMethods.verifyPageText("//*[text()=\"Enter Account Information\"]", ht.get("Page_Text"));
	
	CommonMethods.clickOnWebElement("//*[@id=\"id_gender1\"]", "Mr. Radio Button");
	
	CommonMethods.enterTextInTextBox("//*[@id=\"password\"]", config.getProperty("Password"));
	//takeScreenShot();
	CommonMethods.selectByVisibleText("//*[@id=\"days\"]", ht.get("Day"));
	
	CommonMethods.selectByVisibleText("//*[@id=\"months\"]", ht.get("Month"));
	
	CommonMethods.selectByVisibleText("//*[@id=\"years\"]", ht.get("Year"));
	
	CommonMethods.clickOnWebElement("//*[@id=\"newsletter\"]", "Sign up for our newsletter!");
	
	CommonMethods.clickOnWebElement("//*[@id=\"optin\"]", "Receive special offers from our partners!");
	
	} // Code Optimization 

	@DataProvider
	public Object[][] dataCollection() {	
		Hashtable<Object, Object> ht = new Hashtable<>();
		ht = dm.getTestDataInHashTable("Test_Data_SIT", testcaseName);
		return new Object[][] {{ht}};
	}
	
}
