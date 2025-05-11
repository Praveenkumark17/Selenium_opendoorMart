package org.TestNG;

import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TS_003 extends BaseClass {
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

	@Parameters({"email"})
	@Test
	public void TC_011(String email) throws IOException {
		try {
			// Locate Email field
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")); // Adjust ID based
																										// on actual UI

			// Test valid email input
			emailField.sendKeys(email);
			submitButton.click();
			String validResult = emailField.getAttribute("validationMessage");
			Assert.assertTrue("TC_011 Failed: Valid email not accepted!", validResult.isEmpty());

			System.out.println("TC_011 - Test Passed: Email field validation works correctly.");
		} catch (Exception e) {
			System.out.println("TC_011 - Test Failed: " + e.getMessage());
			screenShot("TC_011"); // Capture screenshot upon failure
			throw e;
		}
	}

	@Parameters({"email","invalid"})
	@Test
	public void TC_012(String email,String invalid) throws IOException {
		try {
			// Locate the Email field and Submit button
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")); // Adjust ID based
																										// on actual UI

			// Test Case 1: Valid Email Input
			emailField.sendKeys(email);
			submitButton.click();
			String validResult = emailField.getAttribute("validationMessage");
			Assert.assertTrue("TC_012 Failed: Valid email incorrectly flagged!", validResult.isEmpty());

			// Test Case 2: Invalid Email Input
			emailField.clear();
			emailField.sendKeys(invalid);
			submitButton.click();
			String invalidResult = emailField.getAttribute("validationMessage");
			Assert.assertFalse("TC_012 Failed: Invalid email was accepted!", invalidResult.isEmpty());

			System.out.println("TC_012 - Test Passed: Email field validation works correctly.");
		} catch (Exception e) {
			System.out.println("TC_012 - Test Failed: " + e.getMessage());
			screenShot("TC_012"); // Capture screenshot upon failure
			throw e;
		}
	}

	@Test
	public void TC_013() throws IOException, InterruptedException {
		try {
			// Locate the Email input field
			WebElement emailField = driver.findElement(By.name("email"));

			// Generate input exceeding 255 characters
			String longEmail = "user@" + "a".repeat(250) + ".com"; // Exceeds 255 chars

			// Enter the long email
			emailField.sendKeys(longEmail);
			String actualInput = emailField.getAttribute("value");

			// Expected result: Field should truncate input or show validation error
			Assert.assertTrue("TC_013 Failed: Email field allows more than 255 characters!",
					actualInput.length() <= 255);

			System.out.println("TC_013 - Test Passed: Email field correctly restricts input length.");
		} catch (Throwable e) { // Catch both AssertionError and Exception
			System.out.println("TC_013 - Test Failed: " + e.getMessage());
			Thread.sleep(3000); // Explicit wait before screenshot
			screenShot("TC_013"); // Capture screenshot upon failure
			throw e; // Rethrow for test reporting
		}
	}

	@Test
	public void TC_014() throws IOException {
		try {
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement submitButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")); // Adjust ID based
																										// on actual UI

			emailField.clear();
			submitButton.click();
			String blankError = emailField.getAttribute("validationMessage");
			Assert.assertTrue("TC_014 Failed: Blank email was accepted!", blankError.isEmpty());

			System.out.println("TC_014 - Test Passed: Email field validation works correctly.");
		} catch (Throwable e) {
			System.out.println("TC_014 - Test Failed: " + e.getMessage());
			screenShot("TC_014"); // Capture screenshot upon failure
			throw e;
		}
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
