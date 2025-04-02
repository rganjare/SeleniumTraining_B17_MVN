package com.companyname.projectname.modulename;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonsAndCheckBoxTest { // CNTL+Shift+O

	// CNTL+Shift+F == To format in a proper way
	
	public static WebDriver driver; // Interface
	public static String browser = "chrome";

	public static void main(String[] args) throws InterruptedException {

		if (browser.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@value=\"Male\"]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[5]/a"))
				.click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"secondpassword\"]")).sendKeys("Password");

		Thread.sleep(5000);
		driver.quit();
	}

}
