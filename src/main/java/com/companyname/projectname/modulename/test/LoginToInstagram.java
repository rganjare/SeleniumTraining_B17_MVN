package com.companyname.projectname.modulename.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginToInstagram {

	public static WebDriver driver; // Interface // Global variable
	//public static String browser;
	public static Properties config;
	public static ExcelReader excel ;
	
	public static ExtentReports extent ;
	public static ExtentTest test;

	@BeforeClass
	public void intialSetUp() throws IOException { // 500 0r 1000
		// Definition			// Deceleration
		FileInputStream fis = new FileInputStream("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\"
				+ "Selenium_Training_B17_MVN\\src\\main\\resources\\files\\config.properties");
		/// Local 
		config = new Properties();
		config.load(fis);
		System.out.println("Config file loaded");

		excel = new ExcelReader("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\Selenium_Training_B17_MVN\\src\\main\\resources\\files\\Test_Data_Report.xlsx");
		System.out.println("Test data file loaded");
				
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		ExtentSparkReporter spark = new ExtentSparkReporter("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\Selenium_Training_B17_MVN\\src\\main\\resources\\"
				+ "executionReport\\report_"+timeStamp+".html");
		spark.config().setDocumentTitle("Execution Report");
		spark.config().setReportName("Regression Execution Report");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		test = extent.createTest("LoginToInstagram");

	}

	@BeforeMethod
	public void launchBrowser() {
		if (config.getProperty("browser").equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
			System.out.println("EdgeDriver() launched");
			test.info("Edge browser launched");
		} else if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("FirefoxDriver() launched");
			test.info("Firefox browser launched");
		} else {
			driver = new ChromeDriver();
			System.out.println("ChromeDriver() launched");
			test.info("Chrome browser launched");
		}

		//driver.get("https://www.wikipedia.org/");
		driver.get(config.getProperty("AppURL"));
		test.pass("User Navigated to App URL: " +config.getProperty("AppURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void loginToInstagram() throws InterruptedException, IOException {
		
		String username = excel.getCellData("Test_Data_SIT", "UserName", 3);
		String password = excel.getCellData("Test_Data_SIT", "Password", 3);

		// Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys(excel.getCellData("Test_Data_SIT", "UserName", 3));
		 System.out.println("User name entered: " +username);
		 test.pass("User name entered: " +username);
		 takeScreenShot();
		 Thread.sleep(2000);
		 
		driver.findElement(By.name("password")).sendKeys(excel.getCellData("Test_Data_SIT", "Password", 3));
		 System.out.println("password entered: " +password);
		 test.pass("password entered: " +password);
		 takeScreenShot();
		 Thread.sleep(2000);
		 
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[3]/button/div")).click();
		System.out.println("User clicked on login button");
		test.fail("User clicked on login button"); // Take screen shot 
		takeScreenShot();
		
	}
	

	@AfterMethod
	public void closeBrowser() throws InterruptedException  {
		Thread.sleep(5000);
		driver.quit(); 
		test.info("Broweser closed");
		extent.flush(); // Very Important 
	}
	
	
	public void takeScreenShot() throws IOException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		File dest = new File("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\Selenium_Training_B17_MVN\\"
				+ "src\\main\\resources\\screenShots\\screenshot_"+timeStamp+".png");
		
		FileUtils.copyFile(scrFile, dest);
	}

}
