package com.companyname.projectname.modulename.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.companyname.projectname.modulename.testbase.TestBase;
import com.companyname.projectname.modulename.utilities.CommonMethods;

public class RegisterUserWithPOMDP2_GitDemo extends TestBase { // Inheritance- OOPs
	
	@BeforeClass
	public void beforeTestCase() {
		testcaseName = this.getClass().getSimpleName();
		if(!run_mode.get(testcaseName).equalsIgnoreCase("Yes"))
			throw new SkipException("Skipping Test case as it's RunMode is set to No");
	}	
	
	@Test(dataProvider = "dataCollection")
	public void registerUserWithPOM(Hashtable<String, String> ht) throws IOException {

	//CommonMethods.verifyPageTitle(ht.get("Page_Title"));
	
//	HomePage hp = new HomePage();
//	hp.verifyHomePageTitle(ht.get("Page_Title"));
//	
//	//CommonMethods.clickOnWebElement("//*[text()=\" Signup / Login\"]", "Signup / Login");
//	
//	hp.navigateToSignupOrLogin();
//
//	//CommonMethods.verifyPageText("//*[text()=\"New User Signup!\"]", ht.get("Sign_up_Text"));
//	
//	SignUpOrLoginPage sulp = new SignUpOrLoginPage();
//	sulp.verifySignUpOrLoginPageText(ht.get("Sign_up_Text"));
//	
//	//CommonMethods.enterTextInTextBox("//*[@data-qa=\"signup-name\"]", ht.get("UserName"));
//	//CommonMethods.enterTextInTextBox("//*[@data-qa=\"signup-email\"]", ht.get("Email"));
//	//CommonMethods.clickOnWebElement("//*[@data-qa=\"signup-button\"]", "signup-button");
//	
//	sulp.newUserSignUp(ht);
	
	hp.verifyHomePageTitle(ht.get("Page_Title"))
	.navigateToSignupOrLogin()
	.verifySignUpOrLoginPageText(ht.get("Sign_up_Text"))
	.newUserSignUp(ht)
	.verifyEnterAccountInfoPageText(ht.get("Page_Text"))
	.enterAccountInfo(ht)
	.enterAddressInfo(ht);
	
	//CommonMethods.verifyPageText("//*[text()=\"Enter Account Information\"]", ht.get("Page_Text"));
	
//	CommonMethods.clickOnWebElement("//*[@id=\"id_gender1\"]", "Mr. Radio Button");
//	
//	CommonMethods.enterTextInTextBox("//*[@id=\"password\"]", config.getProperty("Password"));
//	//takeScreenShot();
//	CommonMethods.selectByVisibleText("//*[@id=\"days\"]", ht.get("Day"));
//	
//	CommonMethods.selectByVisibleText("//*[@id=\"months\"]", ht.get("Month"));
//	
//	CommonMethods.selectByVisibleText("//*[@id=\"years\"]", ht.get("Year"));
//	
//	CommonMethods.clickOnWebElement("//*[@id=\"newsletter\"]", "Sign up for our newsletter!");
//	
//	CommonMethods.clickOnWebElement("//*[@id=\"optin\"]", "Receive special offers from our partners!");
	
	} // Code Optimization 

	@DataProvider
	public Object[][] dataCollection() {	
		Hashtable<Object, Object> ht = new Hashtable<>();
		ht = dm.getTestDataInHashTable("Test_Data_SIT", testcaseName);
		return new Object[][] {{ht}};
	}
	
}
