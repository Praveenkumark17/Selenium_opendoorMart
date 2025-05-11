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

public class TS_008 extends BaseClass {
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
	public void TC_035() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Verify visibility
	        Assert.assertTrue(signUpLink.isDisplayed(), "TC_035 Failed: 'Sign-Up' link is not visible!");

	        System.out.println("TC_035 - Test Passed: 'Sign-Up' link is clearly visible.");
	    } catch (Exception e) {
	        System.out.println("TC_035 - Test Failed: " + e.getMessage());
	        screenShot("TC_035");
	        throw e;
	    }
	}
	
	@Test
	public void TC_036() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Get coordinates for both elements
	        Point signUpLocation = signUpLink.getLocation();
	        int expectedX = 687;

	        // ✅ Validate horizontal alignment
	        Assert.assertEquals(signUpLocation.getX(), expectedX, "TC_036 Failed: 'Sign-Up' link is not horizontally aligned!");

	        System.out.println("TC_036 - Test Passed: 'Sign-Up' link is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_036 - Test Failed: " + e.getMessage());
	        screenShot("TC_036");
	        throw e;
	    }
	}
	
	@Test
	public void TC_037() throws Exception {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Get default font color
	        String defaultColor = signUpLink.getCssValue("color");

	        // ✅ Hover over the link
	        Actions action = new Actions(driver);
	        action.moveToElement(signUpLink).perform();
	        Thread.sleep(2000); // Wait for hover effect

	        // ✅ Get hover font color
	        String hoverColor = signUpLink.getCssValue("color");

	        // ✅ Validate color change on hover
	        Assert.assertNotEquals(defaultColor, hoverColor, "TC_037 Failed: No hover effect on 'Sign-Up' link!");

	        System.out.println("TC_037 - Test Passed: Hover effect applied correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_037 - Test Failed: " + e.getMessage());
	        screenShot("TC_037");
	        throw e;
	    }
	}

	@Test
	public void TC_038() throws Exception {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Test responsiveness across multiple screen widths
	        int[] screenWidths = {1024, 800}; // Desktop, Tablet

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000); // Allow UI to adjust
	            Assert.assertTrue(signUpLink.isDisplayed(), "TC_038 Failed: 'Sign-Up' link is missing at width " + width);
	            System.out.println("✅ 'Sign-Up' link is responsive at width: " + width);
	        }

	        System.out.println("TC_038 - Test Passed: 'Sign-Up' link is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_038 - Test Failed: " + e.getMessage());
	        screenShot("TC_038");
	        throw e;
	    }
	}
	
	@Test
	public void TC_039() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Get font properties
	        String fontSize = signUpLink.getCssValue("font-size");
	        String fontFamily = signUpLink.getCssValue("font-family");

	        // ✅ Validate expected font size and family
	        Assert.assertEquals(fontSize, "16px", "TC_039 Failed: Incorrect font size!");
	        Assert.assertTrue(fontFamily.contains("Arial") || fontFamily.contains("sans-serif"), "TC_039 Failed: Incorrect font family!");

	        System.out.println("TC_039 - Test Passed: Font style and size are correct.");
	    } catch (Exception e) {
	        System.out.println("TC_039 - Test Failed: " + e.getMessage());
	        screenShot("TC_039");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
