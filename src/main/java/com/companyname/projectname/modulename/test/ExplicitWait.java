package com.companyname.projectname.modulename.test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public static WebDriver driver; 
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver(); // Default cons // Argu 
		
		driver.get("http://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String textbeforeclick = driver.findElement(By.xpath("//*[text()='Click and Wait for ']")).getText();
		System.out.println("textbeforeclick is: "+textbeforeclick);
		driver.findElement(By.xpath("//*[text()='Click Me - Fluent Wait']")).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // polling for every seconds 30 times
		
		FluentWait<WebDriver> f_wait = new FluentWait<WebDriver>(driver)
										.withTimeout(Duration.ofSeconds(30))
										.pollingEvery(Duration.ofSeconds(5)) // 5*6 = 6 time 
										.ignoring(NoSuchElementException.class);
		
		f_wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id=\"demo\"]"), textbeforeclick));
		
		//String textafterclick = driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText(); // Im W
								
		String textafterclick = f_wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"demo\"]"))).getText();
		
		System.out.println("textafterclick is: " +textafterclick);
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
