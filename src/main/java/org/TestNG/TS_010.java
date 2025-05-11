package org.TestNG;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_010 extends BaseClass {
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
	public void TC_045() throws IOException {
		try {
			WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

			signUpLink.click();

			WebElement signUpModule = driver.findElement(By.xpath("//p[contains(text(),'Sign Up')]"));

			// ✅ Verify visibility
			Assert.assertTrue(signUpModule.isDisplayed(), "TC_045 Failed: Sign-Up module is not visible!");

			System.out.println("TC_045 - Test Passed: Sign-Up module is clearly visible.");
		} catch (Exception e) {
			System.out.println("TC_045 - Test Failed: " + e.getMessage());
			screenShot("TC_045");
			throw e;
		}
	}

	@Test
	public void TC_046() throws IOException {
		try {
			WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

			signUpLink.click();

			WebElement emailField = driver.findElement(By.name("email"));
			WebElement passwordField = driver.findElement(By.name("password"));

			// ✅ Get coordinates for both fields
			Point emailLocation = emailField.getLocation();
			Point passwordLocation = passwordField.getLocation();

			// ✅ Validate horizontal alignment
			Assert.assertEquals(emailLocation.getX(), passwordLocation.getX(),
					"TC_046 Failed: Input fields are not properly aligned!");

			System.out.println("TC_046 - Test Passed: Form fields are correctly aligned.");
		} catch (Exception e) {
			System.out.println("TC_046 - Test Failed: " + e.getMessage());
			screenShot("TC_046");
			throw e;
		}
	}

	@Test
	public void TC_047() throws IOException {
		try {
			WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

			signUpLink.click();
			WebElement emailField = driver.findElement(By.name("email"));
			WebElement passwordField = driver.findElement(By.name("password"));

			// ✅ Check placeholders
			String emailPlaceholder = emailField.getAttribute("placeholder");
			String passwordPlaceholder = passwordField.getAttribute("placeholder");

			// ✅ Validate expected placeholder text
			Assert.assertEquals(emailPlaceholder, "Enter email",
					"TC_047 Failed: Incorrect placeholder for email field!");
			Assert.assertEquals(passwordPlaceholder, "Enter password",
					"TC_047 Failed: Incorrect placeholder for password field!");

			System.out.println("TC_047 - Test Passed: Placeholder texts are correct.");
		} catch (Exception e) {
			System.out.println("TC_047 - Test Failed: " + e.getMessage());
			screenShot("TC_047");
			throw e;
		}
	}

	@Test
	public void TC_048() throws Exception {
		try {
			WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

			signUpLink.click();
			
			WebElement signUpModule = driver.findElement(By.xpath("//p[contains(text(),'Sign Up')]"));

			// ✅ Test responsiveness across multiple screen widths
			int[] screenWidths = { 1024, 800 }; // Desktop, Tablet

			for (int width : screenWidths) {
				driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
				Thread.sleep(2000); // Allow UI to adjust
				Assert.assertTrue(signUpModule.isDisplayed(),
						"TC_048 Failed: Sign-Up module is missing at width " + width);
				System.out.println("✅ Sign-Up module is responsive at width: " + width);
			}

			System.out.println("TC_048 - Test Passed: Sign-Up module is fully responsive.");
		} catch (Exception e) {
			System.out.println("TC_048 - Test Failed: " + e.getMessage());
			screenShot("TC_048");
			throw e;
		}
	}
	
	@Test
	public void TC_049() throws IOException {
	    try {
	    	WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	    	
	    	signUpLink.click();
	    	
	        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));

	        // ✅ Get button properties
	        String fontSize = signUpButton.getCssValue("font-size");
	        String backgroundColor = signUpButton.getCssValue("background-color");

	        // ✅ Validate expected styling
	        Assert.assertEquals(fontSize, "14px", "TC_049 Failed: Incorrect font size for Sign-Up button!");
	        Assert.assertEquals(backgroundColor, "rgba(13, 110, 253, 1)", "TC_049 Failed: Incorrect button color!");

	        System.out.println("TC_049 - Test Passed: Sign-Up button styling is consistent.");
	    } catch (Exception e) {
	        System.out.println("TC_049 - Test Failed: " + e.getMessage());
	        screenShot("TC_049");
	        throw e;
	    }
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
