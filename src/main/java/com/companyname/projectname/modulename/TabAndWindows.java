package com.companyname.projectname.modulename;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TabAndWindows {

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
		
		driver.get("https://omni.axisbank.co.in/axisretailbanking/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		System.out.println("Home Page Title is: " + driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"custid\"]")).sendKeys("username");
		System.out.println("User entered Username");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password");
		System.out.println("User entered password");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"axis-group\"]")).click();
		System.out.println("User clicked on axis-group");
		System.out.println("axis-group page title " +driver.getTitle());
	
		Set<String> windows = driver.getWindowHandles();
		
		for(String wid: windows) {
			System.out.println(wid);
		}
		
		Iterator<String> itr = windows.iterator();
		String parent_window = itr.next();
		String child_window = itr.next();
		
		System.out.println("parent_window Id is "+ parent_window);
		System.out.println("child_window Id is "+ child_window);
		
		driver.switchTo().window(child_window);
		System.out.println("axis-group child_window title " +driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"search-chatInput\"]")).sendKeys("Personal Loan");
		System.out.println("user entered Personal Loan in input box" );
		new Actions(driver).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		Thread.sleep(5000);
		driver.close(); // child_window // Close the current active window
		
		
		driver.switchTo().window(parent_window);
		System.out.println("Driver switched back to the parent window");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"about-us\"]")).click();
		System.out.println("User clicked on about-us button");
		
		windows = driver.getWindowHandles();
		for(String wid: windows) {
			System.out.println(wid);
		}
		itr = windows.iterator();
		parent_window = itr.next();
		child_window = itr.next();
		
		System.out.println("parent_window Id is "+ parent_window);
		System.out.println("child_window Id is "+ child_window);
		
		driver.switchTo().window(child_window);
		System.out.println("about-us child_window title " +driver.getTitle());
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[text()=\"Make Payments\"]"))).perform();
		Thread.sleep(5000);
		driver.close();
		
		Thread.sleep(10000);
		driver.quit(); // Kill the entire session
	}

}
