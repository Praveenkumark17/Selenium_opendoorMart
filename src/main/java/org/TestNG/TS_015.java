package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

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

public class TS_015 extends BaseClass{
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
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_070() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify Age field alignment
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        WebElement referenceField = driver.findElement(By.id("email-lg"));

	        Point ageLocation = ageField.getLocation();
	        Point referenceLocation = referenceField.getLocation();

	        Assert.assertEquals(ageLocation.getX(), referenceLocation.getX(), "TC_070 Failed: Age field is misaligned!");

	        System.out.println("TC_070 - Test Passed: Age field is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_070 - Test Failed: " + e.getMessage());
	        screenShot("TC_070");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_071() throws IOException {
	    try {
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify placeholder text
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        String placeholderText = ageField.getAttribute("placeholder");

	        Assert.assertEquals(placeholderText, "Enter age", "TC_071 Failed: Incorrect placeholder text for Age field!");

	        System.out.println("TC_071 - Test Passed: Placeholder text is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_071 - Test Failed: " + e.getMessage());
	        screenShot("TC_071");
	        throw e;
	    }
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TC_072() throws IOException {
	    try {
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Focus on Age field
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        Actions action = new Actions(driver);
	        action.moveToElement(ageField).click().perform();

	        // ✅ Validate focus indicator
	        String borderColor = ageField.getCssValue("border-color");
	        Assert.assertFalse(borderColor.contains("rgba(0, 0, 0, 1)"), "TC_072 Failed: No focus indicator!");

	        System.out.println("TC_072 - Test Passed: Focus behavior works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_072 - Test Failed: " + e.getMessage());
	        screenShot("TC_072");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_073() throws IOException {
	    try {
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Test responsiveness on mobile
	        driver.manage().window().setSize(new Dimension(480, 800)); // Mobile dimensions
	        WebElement ageField = driver.findElement(By.id("age-sm"));

	        Assert.assertFalse(ageField.isDisplayed(), "TC_073 Failed: Age field not visible or misaligned on mobile!");

	        System.out.println("TC_073 - Test Failed: Alignment is incorrect; responsiveness is not implemented.");
	        screenShot("TC_073");
	    } catch (Exception e) {
	        System.out.println("TC_073 - Test Failed: " + e.getMessage());
	        screenShot("TC_073");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_074() throws IOException {
	    try {
	    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter invalid age and submit
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        ageField.sendKeys("-10"); // Invalid age
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify visual feedback
	        String borderColor = ageField.getCssValue("border-color");
	        Assert.assertFalse(borderColor.contains("rgba(255, 0, 0, 1)"), "TC_074 Failed: No visual feedback for invalid input!");

	        System.out.println("TC_074 - Test Passed: Visual feedback for invalid input works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_074 - Test Failed: " + e.getMessage());
	        screenShot("TC_074");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
