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

public class TS_021 extends BaseClass{
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
	public void TC_100() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify alignment of password field
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        WebElement referenceField = driver.findElement(By.id("username-lg"));

	        Point passwordLocation = passwordField.getLocation();
	        Point referenceLocation = referenceField.getLocation();

	        Assert.assertEquals(passwordLocation.getX(), referenceLocation.getX(), "TC_100 Failed: Password field is misaligned!");

	        System.out.println("TC_100 - Test Passed: Password field is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_100 - Test Failed: " + e.getMessage());
	        screenShot("TC_100");
	        throw e;
	    }
	}
	
	@Test
	public void TC_101() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify placeholder text
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        String placeholderText = passwordField.getAttribute("placeholder");

	        Assert.assertEquals(placeholderText, "Enter password", "TC_101 Failed: Incorrect placeholder text!");

	        System.out.println("TC_101 - Test Passed: Placeholder text is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_101 - Test Failed: " + e.getMessage());
	        screenShot("TC_101");
	        throw e;
	    }
	}
	
	@Test
	public void TC_102() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify focus behavior
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        Actions action = new Actions(driver);
	        action.moveToElement(passwordField).click().perform();

	        String borderColor = passwordField.getCssValue("border-color");
	        System.out.println(borderColor);
	        Assert.assertEquals(borderColor,"rgb(198, 209, 222)", "TC_102 Failed: No focus indication!");

	        System.out.println("TC_102 - Test Passed: Password field focus behavior works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_102 - Test Failed: " + e.getMessage());
	        screenShot("TC_102");
	        throw e;
	    }
	}

	@Test
	public void TC_103() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter password and verify masking
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        passwordField.sendKeys("password123");

	        String passwordType = passwordField.getAttribute("type");
	        Assert.assertEquals(passwordType, "password", "TC_103 Failed: Password masking is not applied!");

	        System.out.println("TC_103 - Test Passed: Password masking functionality works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_103 - Test Failed: " + e.getMessage());
	        screenShot("TC_103");
	        throw e;
	    }
	}

	@Test
	public void TC_104() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Test responsiveness on mobile screen sizes
	        int[] screenWidths = {480, 320}; // Mobile resolutions
	        WebElement passwordField = driver.findElement(By.id("password-sm"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(passwordField.isDisplayed(), "TC_104 Failed: Password field not visible on mobile!");
	            System.out.println("✅ Password field is responsive at width: " + width);
	        }

	        System.out.println("TC_104 - Test Passed: Password field is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_104 - Test Failed: " + e.getMessage());
	        screenShot("TC_104");
	        throw e;
	    }
	}
	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
