package com.companyname.projectname.modulename;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MousehoverActionOnElectronics {

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
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		Actions act = new Actions(driver);
		
		WebElement loginBtn = driver.findElement(By.xpath("//*[text()='Electronics']"));
		//Thread.sleep(2000);
		act.moveToElement(loginBtn).perform(); 
      	Thread.sleep(2000);
      	
      	act.moveToElement(driver.findElement(By.xpath("//*[text()='Computer Peripherals']"))).perform();
      	Thread.sleep(2000);
      	
      	driver.findElement(By.xpath("//*[text()='Projectors']")).click();
      	
		Thread.sleep(5000);
		driver.quit();
	}

}
