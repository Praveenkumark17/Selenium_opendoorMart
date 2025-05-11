package org.TestNG;

import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_004 extends BaseClass {
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
	public void TC_015() throws IOException {
		try {
			// Locate the Password input field
			WebElement passwordField = driver.findElement(By.name("password"));

			// Assert visibility without scrolling
			Assert.assertTrue("TC_015 Failed: Password field is NOT visible!", passwordField.isDisplayed());

			System.out.println("TC_015 - Test Passed: Password field is visible without scrolling.");
		} catch (Exception e) {
			System.out.println("TC_015 - Test Failed: " + e.getMessage());
			screenShot("TC_015"); // Capture screenshot upon failure
			throw e;
		}
	}

	@Test
	public void TC_016() throws IOException {
		try {
			// Locate the Password input field
			WebElement passwordField = driver.findElement(By.name("password"));

			// Get X & Y coordinates
			int passwordX = passwordField.getLocation().getX();
			int passwordY = passwordField.getLocation().getY();

			// Expected alignment values (update based on UI design)
			int expectedX = 367; // Example position, adjust as needed
			int expectedY = 343; // Example position, adjust as needed

			// Assert email field alignment
			Assert.assertEquals("TC_016 Failed: Password field X-position mismatch!", expectedX, passwordX);
			Assert.assertEquals("TC_016 Failed: Password field Y-position mismatch!", expectedY, passwordY);

			System.out.println("TC_016 - Test Passed: Password field is aligned correctly.");
		} catch (Exception e) {
			System.out.println("TC_016 - Test Failed: " + e.getMessage());
			screenShot("TC_016"); // Capture screenshot upon failure
			throw e;
		}
	}

	@Test
	public void TC_017() throws IOException {
		try {
			// Locate the Password input field
			WebElement passwordField = driver.findElement(By.name("password"));

			// Get placeholder attribute
			String placeholderText = passwordField.getAttribute("placeholder");

			// Expected placeholder text (update based on actual UI)
			String expectedPlaceholder = "Password";

			// Assert that placeholder text matches the expected value
			Assert.assertEquals("TC_017 Failed: Incorrect placeholder text!", expectedPlaceholder, placeholderText);

			System.out.println("TC_017 - Test Passed: Password field displays the correct placeholder.");
		} catch (Exception e) {
			System.out.println("TC_017 - Test Failed: " + e.getMessage());
			screenShot("TC_017"); // Capture screenshot upon failure
			throw e;
		}
	}

	@Test
	public void TC_018() throws Exception {
		try {
			WebElement passwordField = driver.findElement(By.name("password"));

			// ✅ Test Desktop View (1024px Width)
			driver.manage().window().setSize(new Dimension(1024, driver.manage().window().getSize().getHeight()));
			Thread.sleep(2000);
			System.out.println("Password field is visible: " + passwordField.isDisplayed());
			Assert.assertTrue("TC_018 Failed: Password field NOT visible at 1024px width!",
					passwordField.isDisplayed());
			System.out.println("✅ Desktop Check Passed");

			// ✅ Test Tablet View (769px Width)
			driver.manage().window().setSize(new Dimension(850, driver.manage().window().getSize().getHeight()));
			Thread.sleep(2000);
			System.out.println("Password field is visible: " + passwordField.isDisplayed());
			Assert.assertTrue("TC_018 Failed: Password field NOT visible at 769px width!", passwordField.isDisplayed());
			System.out.println("✅ Tablet Check Passed");

//			 ✅ Test Mobile View (320px Width)
			driver.manage().window().setSize(new Dimension(400, driver.manage().window().getSize().getHeight()));
			Thread.sleep(2000);
			String paddingValue = passwordField.getCssValue("padding");
			Assert.assertEquals("TC_018 Failed: Padding does not match!", "6px 12px", paddingValue);
			System.out.println("✅ Mobile Check Passed");

			System.out.println("TC_018 - Test Passed: Password field adapts properly to different screen sizes.");
		} catch (Exception e) {
			System.out.println("TC_018 - Test Failed: " + e.getMessage());
			screenShot("TC_018"); // Capture screenshot on failure
			throw e;
		}
	}
	
	@Test
	public void TC_0019() throws Exception {
		try {
			// Locate Email-fields
			WebElement emailField = driver.findElement(By.name("email")); 

			// Get CSS properties for styling validation

			String emailBackgroundColor = emailField.getCssValue("background-color");

			String emailTextStyle = emailField.getCssValue("font-size");

			// Expected values (update based on actual UI design)
			String expectedBackgroundColor = "rgba(255, 255, 255, 1)"; // White background
			String expectedTextStyle = "16px"; // Standard text size

			// Assertions

			Assert.assertEquals("TC_019 Failed: Email background color mismatch!", expectedBackgroundColor,
					emailBackgroundColor);

			Assert.assertEquals("TC_019 Failed: Email text style mismatch!", expectedTextStyle, emailTextStyle);

			System.out.println("TC_019 - Test Passed: Input field styling is consistent and visually appealing.");
		} catch (Exception e) {
			System.out.println("TC_019 - Test Failed: " + e.getMessage());
			screenShot("TC_019"); // Capture screenshot only on failure
			throw e; // Ensure failure propagates properly
		}
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}

}
