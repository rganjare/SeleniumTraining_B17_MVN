package com.companyname.projectname.modulename;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetAllLinksFromWebPage {

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
		Thread.sleep(2000);
		
		//							driver.findElement(By.xpath(""));
		
		List<WebElement> Linkcount = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links present on wikipedia page are: "
								+Linkcount.size());
		
		for(int i =0; i<Linkcount.size(); i++) {
		System.out.println("Language Name:" + Linkcount.get(i).getText());	
		System.out.println("Language link:" + Linkcount.get(i).getDomAttribute("href"));
		System.out.println("##############################");	
		}
		
		Thread.sleep(5000);
		driver.quit();
	}

}
