package com.companyname.projectname.modulename.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.companyname.projectname.modulename.testbase.TestBase;
import com.companyname.projectname.modulename.utilities.CommonMethods;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()=\" Signup / Login\"]")
	WebElement signupOrLogin_link;
	
	//WebElement signupOrLogin_link = driver.findElement(By.xpath("//*[text()=\" Signup / Login\"]"));
	
	@FindBy(xpath = "//*[text()=\" Cart\"]")
	WebElement cart_link;
	
	@FindBy(xpath = "//*[text()=\" Contact us\"]")
	WebElement contactUs_link;
	
	public HomePage verifyHomePageTitle(String title) {
		CommonMethods.verifyPageTitle(title);
		return this;
	}
	
	public SignUpOrLoginPage navigateToSignupOrLogin() {
		CommonMethods.clickOnWebElement(signupOrLogin_link, "Signup / Login");
		return new SignUpOrLoginPage();
	}
	
	//POM DP - Whichever method is taking control to next page, that method is responsible to 
	// return the object of the page where control is navigating 
	
	public CartPage navigateToCart() {
		CommonMethods.clickOnWebElement(cart_link, "Cart Page");
		return new CartPage();
	}
	
	public ContactUsPage navigateTocontactUsPage() {
		CommonMethods.clickOnWebElement(contactUs_link, "contactUs page");
		return new ContactUsPage();
	}
}
