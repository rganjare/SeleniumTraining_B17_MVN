package com.companyname.projectname.modulename;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleMenuSelection {

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
		
		driver.get("https://jqueryui.com/menu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		Actions act = new Actions(driver);
		
		WebElement mainMenu = driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]"));
	
		act.moveToElement(mainMenu).perform(); 
		System.out.println("Mousehover operation performed on Main Menu");
      	Thread.sleep(2000);

      	act.moveToElement(driver.findElement(By.xpath("//*[@id=\"ui-id-10\"]"))).perform();
      	System.out.println("Mousehover operation performed on Sub Menu - Rock");
      	
      	Thread.sleep(2000);
      	
      	driver.findElement(By.xpath("//*[@id=\"ui-id-12\"]")).click();
      	
  //    	driver.switchTo().defaultContent();
      	
//      	driver.switchTo().frame("FameName or ID");
//		
//      	driver.switchTo().parentFrame();
      	
		Thread.sleep(5000);
		driver.quit();
	}

}
