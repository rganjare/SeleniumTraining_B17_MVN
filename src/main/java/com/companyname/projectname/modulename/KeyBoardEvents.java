package com.companyname.projectname.modulename;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardEvents {

	public static WebDriver driver; // Interface
	public static String browser  = "chrome";
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		if(browser.equalsIgnoreCase("EDGE")) {
		 driver = new EdgeDriver();
		} else if(browser.equalsIgnoreCase("Firefox")){ 
		driver = new FirefoxDriver();
		} else {
			 driver = new ChromeDriver();
		}
		
		driver.get("https://jqueryui.com/spinner/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
//		Robot rb = new Robot();
//		rb.keyPress(Keys.CONTROL)
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).sendKeys("A").sendKeys("C").perform();
		act.keyUp(Keys.CONTROL).perform();
		System.out.println("user copies all text from the web page");
		
		//act.keyDown(Keys.CONTROL).keyDown(Keys.ALT).keyDown(Keys.DELETE).perform();
		//act.keyUp(Keys.CONTROL). keyUp(Keys.ALT).keyUp(Keys.DELETE).perform();
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		System.out.println("Driver switched to the iframe");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"spinner\"]")).click();
		System.out.println("User clicked on spinner input box");
		
		Thread.sleep(2000);
		act.keyDown(Keys.CONTROL).sendKeys("V").perform();
		act.keyUp(Keys.CONTROL).perform();
		System.out.println("CONTROL key is released");
		
		Thread.sleep(10000);
		driver.quit();
	}

}
