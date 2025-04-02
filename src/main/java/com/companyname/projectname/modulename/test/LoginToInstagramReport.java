package com.companyname.projectname.modulename.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LoginToInstagramReport {

	public static WebDriver driver; // Interface // Global variable
	//public static String browser;
	public static Properties config;
	public static ExcelReader excel ;
	
	public static ExtentReports extents;
	public static ExtentTest test;
	
	public static DataManager dm; 
	
	@BeforeClass
	public void intialSetUp() throws IOException {
		// Definition			// Deceleration
		FileInputStream fis = new FileInputStream("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\"
				+ "Selenium_Training_B17_MVN\\src\\main\\resources\\files\\config.properties");
		/// Local 
		config = new Properties();
		config.load(fis);
		System.out.println("Config file loaded");

		//excel = new ExcelReader("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\Selenium_Training_B17_MVN\\src\\main\\resources\\files\\Test_Data.xlsx");
		dm = new DataManager("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\Selenium_Training_B17_MVN\\src\\main\\resources\\files\\Test_Data_Report.xlsx");
		System.out.println("Test data file loaded");
		
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());	
		
		ExtentSparkReporter	reporter = new ExtentSparkReporter(System.getProperty("user.dir")
					+ "\\src\\main\\resources\\executionReports\\report_"+timeStamp+".html");
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extents = new ExtentReports();
		extents.attachReporter(reporter);
		extents.setSystemInfo("Tester", "Rahul Ganjare");

		test = extents.createTest("LoginToInstagramReport");

	}

	@BeforeMethod
	public void launchBrowser() {
		if (config.getProperty("browser").equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
			System.out.println("EdgeDriver() launched");
			test.log(Status.PASS , "EdgeDriver() launched");
		} else if (config.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			System.out.println("FirefoxDriver() launched");
			test.log(Status.PASS , "FirefoxDriver() launched");
		} else {
			driver = new ChromeDriver();
			System.out.println("ChromeDriver() launched");
			test.log(Status.PASS , "ChromeDriver() launched");
		}

		//driver.get("https://www.wikipedia.org/");
		driver.get(config.getProperty("AppURL"));
		test.log(Status.PASS , "User Navigate to the App URL-" +config.getProperty("AppURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test (dataProvider = "data_Collection")
	public void loginToInstagram(Hashtable<String, String> ht) throws InterruptedException {
		
		//String username = excel.getCellData("Test_Data_SIT", "UserName", 3);
		//String password = excel.getCellData("Test_Data_SIT", "Password", 3);

		String username = ht.get("UserName");
		String password = ht.get("Password");
		// Thread.sleep(2000);
		//driver.findElement(By.name("username")).sendKeys(excel.getCellData("Test_Data_SIT", "UserName", 3));
		driver.findElement(By.name("username")).sendKeys(ht.get("UserName"));
		 System.out.println("User name entered: " +username);
		 Thread.sleep(2000);
		 test.log(Status.PASS , "User name entered: " +username);
		 
		//driver.findElement(By.name("password")).sendKeys(excel.getCellData("Test_Data_SIT", "Password", 3));
		driver.findElement(By.name("password")).sendKeys(ht.get("Password"));
		 System.out.println("password entered: " +password);
		 Thread.sleep(2000);
		 test.log(Status.PASS , "password entered: " +password);
		 
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[1]/div[3]/button/div")).click();
		System.out.println("User clicked on login button");
		test.log(Status.PASS , "User clicked on login button");
	}
	

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit(); 
		test.log(Status.PASS , "Browser Closed");
		test.pass("Browser Closed");
		
		extents.flush();
	}
	
	@DataProvider
	public Object[][] data_Collection() {		
		Hashtable<Object, Object> ht = new Hashtable<>();
		ht = dm.getTestDataInHashTable("Test_Data_SIT", this.getClass().getSimpleName());
		return new Object[][] {{ht}};
	}

}
