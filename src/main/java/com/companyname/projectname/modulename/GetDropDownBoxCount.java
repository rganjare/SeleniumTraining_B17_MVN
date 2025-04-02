package com.companyname.projectname.modulename;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GetDropDownBoxCount {
	
	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Selenium Testing");
		
		WebElement dropdownbox	= driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		//Select sel = new Select(driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")));
		Select sel = new Select(dropdownbox);
		
		List<WebElement> listvalues = sel.getOptions();
		System.out.println("Total number of languages available in the dropdown box are:" 
							+listvalues.size());
		
		for(int i=0; i<listvalues.size();i++) {
		System.out.println("Language Name:-" +listvalues.get(i).getText());	
		//System.out.println("value is:-" +listvalues.get(i).getAttribute("value") );	
		//System.out.println("lang is:-" +listvalues.get(i).getAttribute("lang") );
		
		System.out.println("value_getDomAttribute is:-" +listvalues.get(i).getDomAttribute("value"));
		System.out.println("lang_getDomProperty is:-" +listvalues.get(i).getDomProperty("lang"));
		System.out.println("###############################################");	
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 5 sec // Never recommended // Hard coded wait
		driver.quit();
		
	}
	
	// 1. installed Java and configured
	// 2. Set up Eclipse
	// 3. Java Project -- Workspace -- Folder structure
	// 4. Package, Classes and method
	// 5. Webelements, Jar  
}
