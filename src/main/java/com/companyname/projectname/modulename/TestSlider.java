package com.companyname.projectname.modulename;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSlider {

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
		
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		Actions act = new Actions(driver);
		
		WebElement src = driver.findElement(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']"));
	
		act.dragAndDropBy(src, 400, 0).perform();
		System.out.println("Drag And Drop operation is performed");
		
		Thread.sleep(3000);
		act.dragAndDropBy(src, -300, 0).perform();
		System.out.println("Drag And Drop operation is performed");
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		act.contextClick(driver.findElement(By.xpath("//*[text()='Multiple sliders']"))).perform();
		// RIGHT CLICK OPERATION
		Thread.sleep(5000);
		driver.quit();
	}

}
