package com.companyname.projectname.modulename.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.companyname.projectname.modulename.pages.HomePage;
import com.companyname.projectname.modulename.utilities.DataManager;
import com.companyname.projectname.modulename.utilities.ExcelReader;

public class TestBase { // Heart of Framework or Engine of the Framework 
	
	// Definitions & Declarations of all common variables and methods should go

	public static WebDriver driver; // Interface // Global variable
	//public static String browser;
	public static Properties config;
	public static ExcelReader excel ;
	public static ExtentReports extent ;
	public static ExtentTest test;
	public static String testcaseName;
	public static DataManager dm;
	public static HomePage hp;
	public static Hashtable<String, String> run_mode; 
	
	@BeforeSuite  // 2 to any number 
	public void intialSetUp() throws IOException { // 500 0r 1000
		// Definition			// Deceleration
		//FileInputStream fis = new FileInputStream("D:\\BYMAT_Automation\\WorkSpace\\Selenium_Training_B16\\"
		//		+ "Selenium_Training_B17_MVN\\src\\test\\resources\\files\\config.properties");
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\propertiesfiles\\config.properties");
		/// Local 
		config = new Properties();
		config.load(fis);
		System.out.println("Config file loaded");

		excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Test_Data.xlsx");
		System.out.println("Test data file loaded");
				
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\src\\test\\resources\\executionReports\\"
				+ "\\report_"+timeStamp+".html");
		spark.config().setDocumentTitle("Execution Report");
		spark.config().setReportName("Regression Execution Report");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		dm = new DataManager(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Test_Data.xlsx");
		//test = extent.createTest("RegisterUser");
		run_mode = new Hashtable<>();
		run_mode = dm.getRunMode("Test_Cases", "Test_Case_Name", "Run_Mode");
	}
	
	@BeforeMethod
	public void launchBrowser() {
		test = extent.createTest(testcaseName);
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

		driver.get(config.getProperty("AppURL"));
		test.info("User Navigated to App URL: " +config.getProperty("AppURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp = new HomePage();
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
		
		File dest = new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\screenShots\\screenshot_"+timeStamp+".png");
		
		FileUtils.copyFile(scrFile, dest);
		
		//test.addScreenCaptureFromPath(dest.toString());
		
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest.toString()).build());
	}
	
}
