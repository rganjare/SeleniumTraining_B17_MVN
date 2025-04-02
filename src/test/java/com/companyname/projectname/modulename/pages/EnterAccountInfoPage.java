package com.companyname.projectname.modulename.pages;

import java.util.Hashtable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.companyname.projectname.modulename.testbase.TestBase;
import com.companyname.projectname.modulename.utilities.CommonMethods;

public class EnterAccountInfoPage extends TestBase {
	
	public EnterAccountInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=\"Enter Account Information\"]")
	WebElement enter_Account_Info_text;
	
	@FindBy(xpath="//*[@id=\"id_gender1\"]")
	WebElement gender_male;
	
	@FindBy(xpath="//*[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"days\"]")
	WebElement days;
	
	@FindBy(xpath="//*[@id=\"months\"]")
	WebElement months;
	
	@FindBy(xpath="//*[@id=\"years\"]")
	WebElement years;
	
	@FindBy(xpath="//*[@id=\"newsletter\"]")
	WebElement newsletter;
	
	@FindBy(xpath="//*[@id=\"optin\"]")
	WebElement optin;
	
	@FindBy(xpath="//*[@id=\"first_name\"]")
	WebElement first_name;
	
	@FindBy(xpath="//*[@id=\"last_name\"]")
	WebElement last_name;
	
	@FindBy(xpath="//*[@id=\"company\"]")
	WebElement company;
	
	@FindBy(xpath="//*[@id=\"address1\"]")
	WebElement address1;
	
	@FindBy(xpath="//*[@type=\"submit\"][@data-qa='create-account']")
	WebElement submit_btn;
	
	public EnterAccountInfoPage verifyEnterAccountInfoPageText(String expectedText) {
		CommonMethods.verifyPageText(enter_Account_Info_text, expectedText);
		return this;
	}

	public EnterAccountInfoPage enterAccountInfo(Hashtable<String, String> ht) {
		CommonMethods.clickOnWebElement(gender_male, "Mr. Radio Button");
		CommonMethods.enterTextInTextBox(password, config.getProperty("Password"));
		CommonMethods.selectByVisibleText(days, ht.get("Day"));
		CommonMethods.selectByVisibleText(months, ht.get("Month"));
		CommonMethods.selectByVisibleText(years, ht.get("Year"));
		CommonMethods.clickOnWebElement(newsletter, "Sign up for our newsletter!");
		CommonMethods.clickOnWebElement(optin, "Receive special offers from our partners!");	
		return this;
	}
	
	public LoginSuccess enterAddressInfo(Hashtable<String, String> ht) {
		CommonMethods.enterTextInTextBox(first_name, ht.get("First_Name "));
		CommonMethods.enterTextInTextBox(last_name, ht.get("Last_name"));
		CommonMethods.enterTextInTextBox(company, ht.get("Company"));
		CommonMethods.enterTextInTextBox(address1, ht.get("Address"));
		
		CommonMethods.clickOnWebElement(submit_btn, "Submit button");	
		return new LoginSuccess();
	}
}
