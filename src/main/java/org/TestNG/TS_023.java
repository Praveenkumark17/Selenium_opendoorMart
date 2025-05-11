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

public class TS_023 extends BaseClass{
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
	public void TC_110() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify button alignment
	        WebElement uploadButton = driver.findElement(By.id("image-lg"));
	        WebElement referenceField = driver.findElement(By.id("email-lg"));

	        Point buttonLocation = uploadButton.getLocation();
	        Point referenceLocation = referenceField.getLocation();

	        Assert.assertEquals(buttonLocation.getX(), referenceLocation.getX(), "TC_110 Failed: Upload button is misaligned!");

	        System.out.println("TC_110 - Test Passed: Upload button is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_110 - Test Failed: " + e.getMessage());
	        screenShot("TC_110");
	        throw e;
	    }
	}
	
	@Test
	public void TC_111() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify placeholder text in upload area
	        WebElement uploadArea = driver.findElement(By.id("image-lg"));
	        String placeholderText = uploadArea.getText();

	        Assert.assertEquals(placeholderText, "", "TC_111 Failed: Incorrect placeholder text!");

	        System.out.println("TC_111 - Test Passed: Placeholder text is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_111 - Test Failed: " + e.getMessage());
	        screenShot("TC_111");
	        throw e;
	    }
	}

	@Test
	public void TC_112() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify focus behavior
	        WebElement uploadArea = driver.findElement(By.id("image-lg"));
	        Actions action = new Actions(driver);
	        action.moveToElement(uploadArea).click().perform();

	        String borderColor = uploadArea.getCssValue("border-color");
	        System.out.println(borderColor);
	        Assert.assertFalse(borderColor.contains("rgb(177, 200, 232)"), "TC_112 Failed: No focus indication!");

	        System.out.println("TC_112 - Test Passed: Upload area focus behavior works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_112 - Test Failed: " + e.getMessage());
	        screenShot("TC_112");
	        throw e;
	    }
	}
	
	@Test
	public void TC_113() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Test responsiveness on mobile screen sizes
	        int[] screenWidths = {480, 320}; // Mobile resolutions
	        WebElement uploadArea = driver.findElement(By.id("image-sm"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(uploadArea.isDisplayed(), "TC_113 Failed: Upload area is not visible on mobile!");
	            System.out.println("✅ Upload area is responsive at width: " + width);
	        }

	        System.out.println("TC_113 - Test Passed: Upload area is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_113 - Test Failed: " + e.getMessage());
	        screenShot("TC_113");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
