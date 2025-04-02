package com.companyname.projectname.modulename;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAlert {

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
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@name=\"proceed\"]")).click();
		
		Alert alt = driver.switchTo().alert();
		
		System.out.println("Alert text is: " + alt.getText());
		Thread.sleep(2000);
		
		//alt.accept();
		 alt.dismiss();
		//alt.sendKeys("sdfsfsfsf");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
