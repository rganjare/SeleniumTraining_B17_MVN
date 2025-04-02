package com.companyname.projectname.modulename.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationExerciseSignup {

    WebDriver driver;
    WebDriverWait wait; // Explicit wait

    @BeforeMethod
    public void setUp() {
        // 1. Launch browser
      //  System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Replace with your ChromeDriver path
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Optional: Maximize browser window
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize explicit wait
    }

    @Test
    public void userSignupTest() {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://automationexercise.com/"); //Verify URL
        WebElement homePageLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='logo pull-left']//a//img"))); // Verify logo presence
        Assert.assertTrue(homePageLogo.isDisplayed(), "Home page is not visible successfully");
        System.out.println("Home page is visible successfully.");

        // 4. Click on 'Signup / Login' button
        WebElement signupLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),' Signup / Login')]")));
        signupLoginButton.click();

        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSignupText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'New User Signup!')]")));
        Assert.assertTrue(newUserSignupText.isDisplayed(), "'New User Signup!' is not visible");
        System.out.println("'New User Signup!' is visible.");

        // 6. Enter name and email address
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-name']")));
        nameField.sendKeys("Test User");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-email']")));
        emailField.sendKeys("testuser"+System.currentTimeMillis()+"@example.com"); // Using timestamp to make email unique for each run

        // 7. Click 'Signup' button
        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='signup-button']")));
        signupButton.click();

        // You can add further assertions here to check if signup is successful,
        // for example, verify if you are redirected to the account creation page or logged in.
        String accountInfoPageTitle = driver.getTitle();
        Assert.assertEquals(accountInfoPageTitle, "Automation Exercise - Signup"); // Verify navigated to account info page
        System.out.println("Navigated to 'Enter Account Information' page successfully.");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close browser after test
        }
    }
}
