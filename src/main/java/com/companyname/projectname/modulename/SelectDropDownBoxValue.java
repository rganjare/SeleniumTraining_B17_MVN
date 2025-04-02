package com.companyname.projectname.modulename;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownBoxValue {
	
	public static WebDriver driver; // Interface
	public static String browser  = "chrome";
	
	public static void main(String[] args) throws InterruptedException {
		
		if(browser.equalsIgnoreCase("EDGE")) {
		 driver = new EdgeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")){ 
		driver = new FirefoxDriver();
		} else {
			 driver = new ChromeDriver();
		}
		
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Selenium Testing");
		
		WebElement dropdownbox	= driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		//Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")));
		Select sel = new Select(dropdownbox);
		
		//sel.selectByIndex(5);
		
		//sel.selectByValue("hi");
		
		sel.selectByVisibleText("Dansk");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		
		Thread.sleep(5000);
		driver.quit(); 
		
	}

}
