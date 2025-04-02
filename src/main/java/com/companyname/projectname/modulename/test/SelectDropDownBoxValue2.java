package com.companyname.projectname.modulename.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropDownBoxValue2 { //1 - 1 Mapping - 1 class - 1 Test Case
									  // 1 - multiple 
	public static WebDriver driver; // Interface // Global variable 
	//public static String browser;
	public static Properties config;

	@BeforeClass
	public void intialSetUp() throws IOException {
	// Definition			// Deceleration
	FileInputStream fis = new FileInputStream("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\"
			+ "Selenium_Training_B17_MVN\\src\\main\\resources\\files\\config.properties");	
	/// Local 
	config = new Properties(); 
	
	config.load(fis);
	
	System.out.println("I am inside intialSetUp() method/function");
	System.out.println(config.getProperty("browser"));
	System.out.println(config.getProperty("AppURL_Test"));
	System.out.println(config.getProperty("MasterCreditCardNumber"));
	
	System.out.println("################################");
		
	}
	
	@BeforeMethod
	public void launchBrowser() {
		if(config.getProperty("browser").equalsIgnoreCase("EDGE")) {
			 driver = new EdgeDriver();
			 System.out.println("EdgeDriver() launched");
			} else if(config.getProperty("browser").equalsIgnoreCase("Firefox")){ 
			driver = new FirefoxDriver();
			System.out.println("FirefoxDriver() launched");
			} else {
				 driver = new ChromeDriver();
				 System.out.println("ChromeDriver() launched");
			}
			
			//driver.get("https://www.wikipedia.org/");
			driver.get(config.getProperty("AppURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	
	@Test // Test case 1
	public void getAllLinksFromThePage1() {
		System.out.println("I am inside getAllLinksFromThePage1 method");
		System.out.println(driver.getTitle());
	}
	
	//@Test // Test case 2
	public void getAllLinksFromThePage2() {
		System.out.println("I am inside getAllLinksFromThePage2 method");
		System.out.println(driver.getTitle());
	}
	//@Test // Test case 3
	public void getAllLinksFromThePage3() {
		System.out.println("I am inside getAllLinksFromThePage3 method");
		System.out.println(driver.getTitle());
	}
	//@Test // Test case 4
	public void getAllLinksFromThePage4() {
		System.out.println("I am inside getAllLinksFromThePage4 method");
		System.out.println(driver.getTitle());
	}
	
	//@Test //Test Case 5
	public void selectDropDownBoxValue5() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Selenium Testing");
		
		WebElement dropdownbox	= driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		//Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")));
		Select sel = new Select(dropdownbox);
		
		//sel.selectByIndex(5);
		
		//sel.selectByValue("hi");
		
		sel.selectByVisibleText("Dansk");
		System.out.println("Dansk value is selected");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		System.out.println("User clicked on submit button");
		
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit(); 
	}
	
}
