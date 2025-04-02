package com.companyname.projectname.modulename.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.companyname.projectname.modulename.testbase.TestBase;

public class CommonMethods extends TestBase { // Code Optimization

	public static void verifyPageTitle(String expectedPageTitle) {
		String ActualpageTitle = driver.getTitle();
		Assert.assertEquals(ActualpageTitle, expectedPageTitle);
		test.pass(expectedPageTitle + " is visible successfully");
	}

	public static void clickOnWebElement(String xpath, String elementName) { // Team Lead, Sr. Team Member
		// driver.findElement(By.xpath(xpath)).click();
		findWebElement(xpath).click();
		test.info("User clicked on " + elementName);
	}
		// Method Overloading 
	public static void clickOnWebElement(WebElement ele, String elementName) { // POM Design pattern
		// driver.findElement(By.xpath(xpath)).click();
		ele.click();
		test.info("User clicked on " + elementName);
	}

	public static void verifyPageText(String xpath, String expectedPageText) {
		// String ActualpageText = driver.findElement(By.xpath(xpath)).getText();
		String ActualpageText = findWebElement(xpath).getText();
		Assert.assertEquals(ActualpageText, expectedPageText);
		test.pass(expectedPageText + " is visible successfully");
	}
	
	public static void verifyPageText(WebElement ele, String expectedPageText) { // POM Design pattern
		// String ActualpageText = driver.findElement(By.xpath(xpath)).getText();
		String ActualpageText = ele.getText();
		Assert.assertEquals(ActualpageText, expectedPageText);
		test.pass(expectedPageText + " is visible successfully");
	}

	public static void enterTextInTextBox(String xpath, String value) {
		// driver.findElement(By.xpath(xpath)).sendKeys(value);
		findWebElement(xpath).sendKeys(value);
		test.info("User entered value as " + value);
	}
	
	public static void enterTextInTextBox(WebElement ele, String value) { // POM Design pattern
		// driver.findElement(By.xpath(xpath)).sendKeys(value);
		ele.sendKeys(value);
		test.info("User entered value as " + value);
	}

	public static void selectByVisibleText(String xpath, String VisibleText) {
		Select sel = new Select(findWebElement(xpath));
		sel.selectByVisibleText(VisibleText);
		test.info("User selected text as " + VisibleText);
	}
	
	public static void selectByVisibleText(WebElement ele, String VisibleText) {  // POM Design pattern
		Select sel = new Select(ele);
		sel.selectByVisibleText(VisibleText);
		test.info("User selected text as " + VisibleText);
	}

	public static WebElement findWebElement(String Xpath) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)) // 5*6 = 6 time
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
		return element;
	}
	
	public static WebElement findWebElement(By ele) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)) // 5*6 = 6 time
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ele) );
		return element;
	}

}
