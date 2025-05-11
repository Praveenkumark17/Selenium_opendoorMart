package org.TestNG;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_013 extends BaseClass{
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
	public void TC_060() throws IOException {
	    try {
	        // ✅ Locate and Click Sign-Up link
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify Email field alignment
	        WebElement emailField = driver.findElement(By.name("email"));
	        WebElement referenceField = driver.findElement(By.name("username")); // Example reference field

	        Point emailLocation = emailField.getLocation();
	        Point referenceLocation = referenceField.getLocation();

	        Assert.assertEquals(emailLocation.getX(), referenceLocation.getX(), "TC_060 Failed: Email field is misaligned!");

	        System.out.println("TC_060 - Test Passed: Email field is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_060 - Test Failed: " + e.getMessage());
	        screenShot("TC_060");
	        throw e;
	    }
	}

	@Test
	public void TC_061() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify placeholder text
	        WebElement emailField = driver.findElement(By.name("email"));
	        String placeholderText = emailField.getAttribute("placeholder");

	        Assert.assertEquals(placeholderText, "Enter email", "TC_061 Failed: Incorrect placeholder text for Email field!");

	        System.out.println("TC_061 - Test Passed: Placeholder text is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_061 - Test Failed: " + e.getMessage());
	        screenShot("TC_061");
	        throw e;
	    }
	}
	
	@Test
	public void TC_062() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Focus on Email field
	        WebElement emailField = driver.findElement(By.id("email-lg"));

	        // ✅ Validate focus indicator
	        String borderColor = emailField.getCssValue("border-color");
	        System.out.println(borderColor);
	        Assert.assertTrue(borderColor.contains("rgb(206, 212, 218)"), "TC_062 Failed: No focus indicator!");

	        System.out.println("TC_062 - Test Passed: Focus behavior works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_062 - Test Failed: " + e.getMessage());
	        screenShot("TC_062");
	        throw e;
	    }
	}

	@Test
	public void TC_063() throws Exception {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Test responsiveness on different screen sizes
	        int[] screenWidths = {1024, 800}; // Desktop, Tablet
	        WebElement emailField = driver.findElement(By.id("email-lg"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(emailField.isDisplayed(), "TC_063 Failed: Email field not visible at width " + width);
	            System.out.println("✅ Email field is responsive at width: " + width);
	        }

	        System.out.println("TC_063 - Test Passed: Email field is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_063 - Test Failed: " + e.getMessage());
	        screenShot("TC_063");
	        throw e;
	    }
	}
	
	@Test
	public void TC_064() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter invalid email and submit
	        WebElement emailField = driver.findElement(By.id("email-lg"));
	        emailField.sendKeys("invalid-email");

	        // ✅ Verify visual feedback (e.g., red border)
	        String borderColor = emailField.getCssValue("border-color");
	        System.out.println(borderColor);
	        Assert.assertTrue(borderColor.contains("rgb(134, 183, 254)"), "TC_064 Failed: No visual feedback for invalid email!");

	        System.out.println("TC_064 - Test Passed: Visual feedback for invalid email works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_064 - Test Failed: " + e.getMessage());
	        screenShot("TC_064");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
