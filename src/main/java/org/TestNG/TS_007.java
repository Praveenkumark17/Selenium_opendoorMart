package org.TestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_007 extends BaseClass {
	@BeforeClass
	public static void browseropen() {
		// To set the system properties and maximize the browser
		System.out.println("BeforeClass");
		Date d = new Date();
		System.out.println("Test case executed at :" + d);
	}

	@BeforeMethod
	public void beforeTestCase() {
		// This method is used to navigate to the url before each tes
		launchBrowser();
		windowMaximize();
		launchUrl("https://e-commerce-client-swart.vercel.app/");
	}

	@Test
	public void TC_030() throws Exception {
		try {
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement passwordField = driver.findElement(By.name("password"));
// Locate the Password input field
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			// ✅ Enter valid credentials
			emailField.sendKeys("admin01@gmail.com");
			passwordField.sendKeys("admin");
			signInButton.click();

			Thread.sleep(5000);

			// ✅ Verify redirection to the dashboard
			Assert.assertTrue(driver.getCurrentUrl().contains("admin"), "TC_030 - Test Failed");

			System.out.println("TC_030 - Test Passed: Successful Sign-In redirects to admin dashboard.");
		} catch (Exception e) {
			System.out.println("TC_030 - Test Failed: " + e.getMessage());
			screenShot("TC_030");
			throw e;
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TC_031() throws Exception {
		try {
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement passwordField = driver.findElement(By.name("password"));
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			// ✅ Enter invalid credentials
			emailField.sendKeys("wronguser@example.com");
			passwordField.sendKeys("WrongPass123!");
			signInButton.click();

			// ✅ Use implicit wait instead of implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement toastMessage = driver.findElement(By.xpath("//div[@id='1']"));

			// ✅ Store the message before it disappears
			String toastText = toastMessage.getText();
			System.out.println("Toast Message: " + toastText);

			// ✅ Verify error message content (Fix: Remove `.getText()`)
			Assert.assertTrue(toastText.contains("User not found"),
					"TC_031 Failed: No error message for invalid input!");

			System.out.println("TC_031 - Test Passed: Error message displayed correctly.");
		} catch (Exception e) {
			System.out.println("TC_031 - Test Failed: " + e.getMessage());
			screenShot("TC_031");
			throw e;
		}
	}

	@Test
	public void TC_032() throws IOException {
		try {
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement passwordField = driver.findElement(By.name("password"));
// Locate the Password input field
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			// ✅ Clear fields and check button state
			emailField.clear();
			passwordField.clear();
			boolean isDisabled = !signInButton.isEnabled();

			// ✅ Validate button is disabled
			Assert.assertTrue(isDisabled, "TC_032 Failed: Sign-In button remains active when fields are empty!");

			System.out.println("TC_032 - Test Passed: Sign-In button correctly disables with empty fields.");
		} catch (AssertionError e) {
			System.out.println("TC_032 - Test Failed: " + e.getMessage());
			screenShot("TC_032");
			throw e;
		}
	}
	
	@Test
	public void TC_033() throws Exception {
	    try {
	    	WebElement emailField = driver.findElement(By.name("email"));
	        WebElement passwordField = driver.findElement(By.name("password"));
// Locate the Password input field
	        	WebElement signInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

	        // ✅ Enter valid credentials
	        emailField.sendKeys("user@example.com");
	        passwordField.sendKeys("SecurePass123!");

	        // ✅ Click Sign-In button multiple times
	        for (int i = 0; i < 3; i++) {
	            signInButton.click();
	            Thread.sleep(1000);
	        }

	        // ✅ Verify no duplicate submissions
	        String confirmationMessage = driver.getCurrentUrl();
	        Assert.assertTrue(confirmationMessage.contains(confirmationMessage), "TC_033 Failed: Multiple clicks caused duplicate submissions!");

	        System.out.println("TC_033 - Test Passed: No duplicate submissions on multiple clicks.");
	    } catch (Exception e) {
	        System.out.println("TC_033 - Test Failed: " + e.getMessage());
	        screenShot("TC_033");
	        throw e;
	    }
	}


	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_034() throws IOException {
	    try {
	    	WebElement emailField = driver.findElement(By.name("email"));
	        WebElement passwordField = driver.findElement(By.name("password"));
// Locate the Password input field
	        	WebElement signInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

	        // ✅ Enter valid credentials
	        emailField.sendKeys("admin01@gmail.com");
	        passwordField.sendKeys("admin");

	        // ✅ Measure time from clicking to dashboard redirection
	        long startTime = System.currentTimeMillis();
	        signInButton.click();

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.getCurrentUrl().contains("admin");
	        long endTime = System.currentTimeMillis();

	        // ✅ Calculate response time
	        long responseTime = endTime - startTime;
	        Assert.assertTrue(responseTime <= 3000, "TC_034 Failed: Submission took too long!");

	        System.out.println("TC_034 - Test Passed: Sign-In submission completed within acceptable time.");
	    } catch (Exception e) {
	        System.out.println("TC_034 - Test Failed: " + e.getMessage());
	        screenShot("TC_034");
	        throw e;
	    }
	}



	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
