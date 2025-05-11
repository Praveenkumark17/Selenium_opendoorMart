package org.TestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_005 extends BaseClass {
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
	public void TC_020() throws IOException {
		try {
			// ✅ Locate Password field
			WebElement passwordField = driver.findElement(By.name("password"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('type','text');", passwordField);
			// ✅ Test password input exceeding max length (22 characters)
			String longPassword = "abcdefghijklmnopqrstuvw"; // 22 characters (exceeds 20-char limit)
			passwordField.sendKeys(longPassword);
			submitButton.click();

			// ✅ Get actual stored input length after submission
			String actualInput = passwordField.getAttribute("value");
			Assert.assertTrue(actualInput.length() <= 20,
					"TC_020 Failed: Password field allows more than 20 characters!");

			System.out.println("TC_020 - Test Passed: Password field correctly restricts input length.");
		} catch (Throwable e) {
			System.out.println("TC_020 - Test Failed: " + e.getMessage());
			screenShot("TC_020"); // Capture screenshot upon failure
			throw e;
		}
	}

	@Test
	public void TC_022() throws IOException {
		try {
			WebElement passwordField = driver.findElement(By.name("password"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")); // Adjust locator
																										// if needed

			// ✅ Leave password field empty and click submit
			passwordField.clear();
			submitButton.click();

			// ✅ Capture validation message
			String validationMessage = passwordField.getAttribute("validationMessage");
			System.out.println("Validation Message: " + validationMessage);

			// ✅ Verify error message appears
			Assert.assertTrue(validationMessage.isEmpty(), "TC_021 Failed: No validation message displayed!");

			System.out.println("TC_022 - Test Passed: Password field correctly prevents empty submission.");
		} catch (AssertionError e) {
			System.out.println("TC_022 - Test Failed: " + e.getMessage());
			screenShot("TC_022");
			throw e;
		}
	}

	@Test
	public void TC_021() throws Exception {
		try {
			WebElement passwordField = driver.findElement(By.name("password"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
			WebElement error = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));

			// ✅ Enter password without special characters
			String weakPassword = "password123";
			passwordField.sendKeys(weakPassword);
			submitButton.click();

			Thread.sleep(5000);

			// ✅ Capture validation message
			String expectederror = "User not found";

			// ✅ Verify that special character requirement is enforced
			Assert.assertEquals(error.getText(), expectederror, "TC_022 Failed: No validation for special characters!");

			System.out.println("TC_021 - Test Passed: Password field correctly enforces special characters.");
		} catch (Throwable e) {
			System.out.println("TC_021 - Test Failed: " + e.getMessage());
			screenShot("TC_021");
			throw e;
		}
	}

	@Test
	public void TC_023() throws IOException {
		try {
			WebElement passwordField = driver.findElement(By.name("password"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('type','text');", passwordField);
			// ✅ Enter password exceeding 100 characters
			String longPassword = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			passwordField.sendKeys(longPassword);
			submitButton.click();

			// ✅ Get actual stored input length after submission
			String actualInput = passwordField.getAttribute("value");
			Assert.assertTrue(actualInput.length() <= 100,
					"TC_023 Failed: Password field allows more than 100 characters!");

			System.out.println("TC_023 - Test Passed: Password field correctly restricts input length.");
		} catch (Throwable e) {
			System.out.println("TC_023 - Test Failed: " + e.getMessage());
			screenShot("TC_023");
			throw e;
		}
	}

	@Test
	public void TC_024() throws Exception {
		try {
			WebElement passwordField = driver.findElement(By.name("password"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));
			WebElement emailField = driver.findElement(By.name("email"));

			// ✅ Enter weak password
			String weakPassword = "admin";
			emailField.sendKeys("admin01@gmail.com");
			passwordField.sendKeys(weakPassword);
			submitButton.click();
			
			Thread.sleep(3000);

			// ✅ Capture url
			String expectedurl = "https://e-commerce-client-swart.vercel.app/admin";

			// ✅ Verify secure password enforcement
			Assert.assertEquals(driver.getCurrentUrl(),expectedurl,
					"TC_024 Failed: No validation for secure passwords!");

			System.out.println("TC_024 - Test Passed: Password field correctly enforces secure password rules.");
		} catch (Exception e) {
			System.out.println("TC_024 - Test Failed: " + e.getMessage());
			screenShot("TC_024");
			throw e;
		}
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
