package com.companyname.projectname.modulename;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToInstagram {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	
	 driver = new ChromeDriver(); 
		// Driver object is responsible to launch that particular browser 
	
	driver.get("https://www.instagram.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	//Thread.sleep(2000);
	driver.findElement(By.name("username")).sendKeys("bymatAutomation@gmail.com");
	//Thread.sleep(2000);
	driver.findElement(By.name("password")).sendKeys("Password#121212");
	//Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[3]/button/div")).click();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//div[text()=\"Log in with Facebook\"]")).click();
	//Thread.sleep(5000);
	driver.quit();
	
	}

}
