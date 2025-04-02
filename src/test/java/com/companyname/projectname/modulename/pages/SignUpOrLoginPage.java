package com.companyname.projectname.modulename.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.companyname.projectname.modulename.testbase.TestBase;
import com.companyname.projectname.modulename.utilities.CommonMethods;

public class SignUpOrLoginPage extends TestBase {
	
	public SignUpOrLoginPage () {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=\"New User Signup!\"]")
	WebElement newUserSignUp;
	
	@FindBy(xpath="//*[@data-qa=\"signup-name\"]")
	WebElement signup_name;
	
	@FindBy(xpath="//*[@data-qa=\"signup-email\"]")
	WebElement signup_email;
	
	@FindBy(xpath="//*[@data-qa=\"signup-button\"]")
	WebElement signup_button;
	
	public SignUpOrLoginPage verifySignUpOrLoginPageTitle(String title) {
		CommonMethods.verifyPageTitle(title);
		return this;
	}
	
	public SignUpOrLoginPage verifySignUpOrLoginPageText(String expectedText) {
		CommonMethods.verifyPageText(newUserSignUp, expectedText);
		return this;
	}
	
	
	public EnterAccountInfoPage newUserSignUp(Hashtable<String, String> ht) {
		CommonMethods.enterTextInTextBox(signup_name, ht.get("UserName"));
		CommonMethods.enterTextInTextBox(signup_email, ht.get("Email"));
		CommonMethods.clickOnWebElement(signup_button, "signup-button");
		return new EnterAccountInfoPage();
	}
	
	
	public void loginToAccount() {
		
		
	}

}
