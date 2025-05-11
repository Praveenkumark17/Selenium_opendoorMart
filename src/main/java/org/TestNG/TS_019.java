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

public class TS_019 extends BaseClass{
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
	public void TC_090() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify alignment of Mobile Number field
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        WebElement referenceField = driver.findElement(By.id("email-lg"));

	        Point mobileLocation = mobileField.getLocation();
	        Point referenceLocation = referenceField.getLocation();

	        Assert.assertEquals(mobileLocation.getX(), referenceLocation.getX(), "TC_090 Failed: Mobile number field is misaligned!");

	        System.out.println("TC_090 - Test Passed: Mobile number field is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_090 - Test Failed: " + e.getMessage());
	        screenShot("TC_090");
	        throw e;
	    }
	}
	
	@Test
	public void TC_091() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify placeholder text
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        String placeholderText = mobileField.getAttribute("placeholder");

	        Assert.assertEquals(placeholderText, "Enter mobile number", "TC_091 Failed: Incorrect placeholder text!");

	        System.out.println("TC_091 - Test Passed: Placeholder text is displayed correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_091 - Test Failed: " + e.getMessage());
	        screenShot("TC_091");
	        throw e;
	    }
	}

	@Test
	public void TC_092() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify focus behavior
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        Actions action = new Actions(driver);
	        action.moveToElement(mobileField).click().perform();

	        String borderColor = mobileField.getCssValue("border-color");
	        System.out.println(borderColor);
	        Assert.assertFalse(borderColor.contains("rgb(204, 211, 219)"), "TC_092 Failed: No focus indication!");

	        System.out.println("TC_092 - Test Passed: Mobile number field focus behavior works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_092 - Test Failed: " + e.getMessage());
	        screenShot("TC_092");
	        throw e;
	    }
	}
	
	@Test
	public void TC_093() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Test responsiveness on mobile screen sizes
	        int[] screenWidths = {480, 320}; // Mobile resolutions
	        WebElement mobileField = driver.findElement(By.id("mobile-sm"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(mobileField.isDisplayed(), "TC_093 Failed: Mobile number field not visible on mobile!");
	            System.out.println("✅ Mobile number field is responsive at width: " + width);
	        }

	        System.out.println("TC_093 - Test Passed: Mobile number field is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_093 - Test Failed: " + e.getMessage());
	        screenShot("TC_093");
	        throw e;
	    }
	}

	@Test
	public void TC_094() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter excessive mobile number
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        mobileField.sendKeys("12345678901234567890"); // Exceeding limit
	        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
	        submitButton.click();

	        String enteredValue = mobileField.getAttribute("value");
	        Assert.assertTrue(enteredValue.length() <= 10, "TC_094 Failed: Field allows more than 10 digits!");

	        System.out.println("TC_094 - Test Passed: Mobile number field restricts input length.");
	    } catch (Exception e) {
	        System.out.println("TC_094 - Test Failed: " + e.getMessage());
	        screenShot("TC_094");
	        throw e;
	    }
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
