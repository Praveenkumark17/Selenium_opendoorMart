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

public class TS_011 extends BaseClass {
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
	public void TC_050() throws Exception {
	    try {
	        // ✅ Locate and Click Sign-Up link
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();
	        
	        Thread.sleep(2000);

	        // ✅ Verify Username field visibility
	        WebElement usernameField = driver.findElement(By.id("username-lg"));
	        Assert.assertTrue(usernameField.isDisplayed(), "TC_050 Failed: Username field is not visible!");

	        System.out.println("TC_050 - Test Passed: Username field is visible.");
	    } catch (Exception e) {
	        System.out.println("TC_050 - Test Failed: " + e.getMessage());
	        screenShot("TC_050");
	        throw e;
	    }
	}
	
	@Test
	public void TC_051() throws IOException {
	    try {
	        // ✅ Locate and Click Sign-Up link
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify alignment of Username field
	        WebElement usernameField = driver.findElement(By.name("username"));
	        WebElement emailField = driver.findElement(By.name("email"));

	        Point usernameLocation = usernameField.getLocation();
	        Point emailLocation = emailField.getLocation();

	        Assert.assertEquals(usernameLocation.getX(), emailLocation.getX(), "TC_051 Failed: Username field is not properly aligned!");

	        System.out.println("TC_051 - Test Passed: Username field is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_051 - Test Failed: " + e.getMessage());
	        screenShot("TC_051");
	        throw e;
	    }
	}

	@Test
	public void TC_052() throws IOException {
	    try {
	        // ✅ Locate and Click Sign-Up link
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify placeholder text in Username field
	        WebElement usernameField = driver.findElement(By.name("username"));
	        String placeholderText = usernameField.getAttribute("placeholder");

	        Assert.assertEquals(placeholderText, "Enter username", "TC_052 Failed: Incorrect placeholder text for Username field!");

	        System.out.println("TC_052 - Test Passed: Placeholder text is correct.");
	    } catch (Exception e) {
	        System.out.println("TC_052 - Test Failed: " + e.getMessage());
	        screenShot("TC_052");
	        throw e;
	    }
	}
	
	@Test
	public void TC_053() throws Exception {
	    try {
	        // ✅ Locate and Click Sign-Up link
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify responsiveness of Username field
	        WebElement usernameField = driver.findElement(By.id("username-lg"));

	        int[] screenWidths = {1024, 800}; // Desktop, Tablet
	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(usernameField.isDisplayed(), "TC_053 Failed: Username field is missing at width " + width);
	            System.out.println("✅ Username field is responsive at width: " + width);
	        }

	        System.out.println("TC_053 - Test Passed: Username field is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_053 - Test Failed: " + e.getMessage());
	        screenShot("TC_053");
	        throw e;
	    }
	}

	@Test
	public void TC_054() throws Exception {
	    try {
	        // ✅ Locate and Click Sign-Up link
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();
	        
	        Thread.sleep(2000);

	        // ✅ Verify styling consistency
	        WebElement usernameField = driver.findElement(By.id("username-lg"));

	        String fontSize = usernameField.getCssValue("font-size");
	        String borderColor = usernameField.getCssValue("border-color");


	        Assert.assertEquals(fontSize, "16px", "TC_054 Failed: Incorrect font size for Username field!");
	        Assert.assertEquals(borderColor, "rgb(206, 212, 218)", "TC_054 Failed: Incorrect border color!");

	        System.out.println("TC_054 - Test Passed: Username field styling is consistent.");
	    } catch (Exception e) {
	        System.out.println("TC_054 - Test Failed: " + e.getMessage());
	        screenShot("TC_054");
	        throw e;
	    }
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
