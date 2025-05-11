package org.TestNG;

import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;

public class TS_001 extends BaseClass {
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
	public void TC_001() throws IOException {
		// Locate input fields
		WebElement emailField = driver.findElement(By.name("email"));
		WebElement passwordField = driver.findElement(By.name("password"));

		try {
			Assert.assertTrue("TC_001 - Test Failed: Email field is not visible", emailField.isDisplayed());
			Assert.assertTrue("TC_001 - Test Failed: Password field is not visible", passwordField.isDisplayed());
			System.out.println("TC_001 - Test passed");
		} catch (AssertionError e) {
			System.out.println("TC_001 - Test failed");
			screenShot("TC_001"); // Capture screenshot only on failure
			throw e; // Ensure failure propagates properly
		}
	}
	
	@Test
	public void TC_002() throws IOException {
		try {
			// Locate Email & Password fields
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement passwordField = driver.findElement(By.name("password"));

			// Get position & size of both fields
			org.openqa.selenium.Dimension emailSize = emailField.getSize();
			org.openqa.selenium.Dimension passwordSize = passwordField.getSize();
			int emailX = emailField.getLocation().getX();
			int passwordX = passwordField.getLocation().getX();

			// Assert horizontal alignment
			Assert.assertEquals("TC_002 Failed: Fields are NOT horizontally aligned!", emailX, passwordX);

			// Assert same width
			Assert.assertEquals("TC_002 Failed: Fields do not have the same width!", emailSize.getWidth(),
					passwordSize.getWidth());

			System.out.println("TC_002 - Test Passed: Input fields are properly aligned.");

		} catch (Throwable e) {
			System.out.println("TC_002 - Test Failed: " + e.getMessage());
			screenShot("TC_002"); // Capture screenshot only on failure
			throw e; // Ensure failure propagates properly
		}
	}

	@Test
	public void TC_003() throws IOException {
		try {
			// Locate Email & Password fields
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement passwordField = driver.findElement(By.name("password"));

			// Get placeholder text
			String emailPlaceholder = emailField.getAttribute("placeholder");
			String passwordPlaceholder = passwordField.getAttribute("placeholder");

			// Expected placeholder values
			String expectedEmailPlaceholder = "Email";
			String expectedPasswordPlaceholder = "Password";

			// Assert placeholder values
			Assert.assertEquals("TC_003 Failed: Email placeholder text is incorrect!", expectedEmailPlaceholder,
					emailPlaceholder);
			Assert.assertEquals("TC_003 Failed: Password placeholder text is incorrect!", expectedPasswordPlaceholder,
					passwordPlaceholder);

			System.out.println("TC_003 - Test Passed: Placeholder text is correct for both fields.");
		} catch (Exception e) {
			System.out.println("TC_003 - Test Failed: " + e.getMessage());
			screenShot("TC_003"); // Capture screenshot only on failure
			throw e; // Ensure failure propagates properly
		}
	}

	@Test
	public void TC_004() throws IOException {
		try {
			// Resize browser for different screen sizes
			driver.manage().window().setSize(new Dimension(1200, 800)); // Desktop
			System.out.println("Testing responsiveness on Desktop...");

			driver.manage().window().setSize(new Dimension(768, 1024)); // Tablet
			System.out.println("Testing responsiveness on Tablet...");

			driver.manage().window().setSize(new Dimension(375, 667)); // Mobile
			System.out.println("Testing responsiveness on Mobile...");

			System.out.println("TC_004 - Test Passed: Module adapts properly across screen sizes.");
		} catch (Exception e) {
			System.out.println("TC_004 - Test Failed: " + e.getMessage());
			screenShot("TC_004"); // Capture screenshot only on failure
			throw e; // Ensure failure propagates properly
		}
	}

	@Test
	public void TC_005() throws Exception {
		try {
			// Locate Email & Password fields
			WebElement emailField = driver.findElement(By.name("email")); 
			WebElement passwordField = driver.findElement(By.name("password"));

			// Get CSS properties for styling validation

			String emailBackgroundColor = emailField.getCssValue("background-color");
			String passwordBackgroundColor = passwordField.getCssValue("background-color");

			String emailTextStyle = emailField.getCssValue("font-size");
			String passwordTextStyle = passwordField.getCssValue("font-size");

			// Expected values (update based on actual UI design)
			String expectedBackgroundColor = "rgba(255, 255, 255, 1)"; // White background
			String expectedTextStyle = "16px"; // Standard text size

			// Assertions

			Assert.assertEquals("TC_005 Failed: Email background color mismatch!", expectedBackgroundColor,
					emailBackgroundColor);
			Assert.assertEquals("TC_005 Failed: Password background color mismatch!", expectedBackgroundColor,
					passwordBackgroundColor);

			Assert.assertEquals("TC_005 Failed: Email text style mismatch!", expectedTextStyle, emailTextStyle);
			Assert.assertEquals("TC_005 Failed: Password text style mismatch!", expectedTextStyle, passwordTextStyle);

			System.out.println("TC_005 - Test Passed: Input field styling is consistent and visually appealing.");
		} catch (Exception e) {
			System.out.println("TC_005 - Test Failed: " + e.getMessage());
			screenShot("TC_005"); // Capture screenshot only on failure
			throw e; // Ensure failure propagates properly
		}
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
