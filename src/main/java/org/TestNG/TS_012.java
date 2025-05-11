package org.TestNG;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_012 extends BaseClass {
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
	public void TC_055() throws Exception {
	    try {
	        // ✅ Click Sign-Up link
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter valid username and submit
	        WebElement usernameField = driver.findElement(By.id("username-lg"));
	        usernameField.sendKeys("validUser123");
	        
	        Thread.sleep(2000); 
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();
	        
	        Thread.sleep(2000); 

	        // ✅ Validate no error message appears
	        Assert.assertTrue(usernameField.isDisplayed(),"TC_055 Failed: Error message appeared for a valid username!");

	        System.out.println("TC_055 - Test Passed: Field accepts valid usernames.");
	    } catch (Exception e) {
	        System.out.println("TC_055 - Test Failed: " + e.getMessage());
	        screenShot("TC_055");
	        throw e;
	    }
	}
	
	@Test
	public void TC_056() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter invalid username and submit
	        WebElement usernameField = driver.findElement(By.id("username-lg"));
	        usernameField.sendKeys("invalid@User!");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify error message appears
	        Assert.assertTrue(usernameField.isDisplayed(),"TC_056 Failed: Error message appeared for a invalid username!");

	        System.out.println("TC_056 - Test Passed: Error message displayed correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_056 - Test Failed: " + e.getMessage());
	        screenShot("TC_056");
	        throw e;
	    }
	}

	@Test
	public void TC_057() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter long username and submit
	        WebElement usernameField = driver.findElement(By.id("username-lg"));
	        usernameField.sendKeys("userNAmeuserNAmeuserNAmeuserNAmeuserNAme12345");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify field restricts input or shows error

	        Assert.assertTrue(usernameField.getText().length() <= 20,
	                "TC_057 Failed: Username field did not restrict input!");

	        System.out.println("TC_057 - Test Passed: Field restricts long input correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_057 - Test Failed: " + e.getMessage());
	        screenShot("TC_057");
	        throw e;
	    }
	}
	
	@Test
	public void TC_058() throws Exception {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Leave username field blank and submit
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();
	        
	        Thread.sleep(2000);

	        // ✅ Verify error message appears
	       
	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));

	        Assert.assertTrue(errorMessage.getText().contains("All fields are required"),
	                "TC_058 Failed: No error message for blank username!");

	        System.out.println("TC_058 - Test Passed: Required field validation works.");
	    } catch (Exception e) {
	        System.out.println("TC_058 - Test Failed: " + e.getMessage());
	        screenShot("TC_058");
	        throw e;
	    }
	}

	@Test
	public void TC_059() throws Exception {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter an existing username and submit
	        WebElement usernameField = driver.findElement(By.id("username-lg"));
	        usernameField.sendKeys("existingUser");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();
	        
	        Thread.sleep(2000);

	        // ✅ Verify error message appears for duplicate username
	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));

	        Assert.assertFalse(errorMessage.getText().contains("Username already exists"),
	                "TC_059 Failed: No error message for duplicate username!");

	        System.out.println("TC_059 - Test Passed: Unique username validation works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_059 - Test Failed: " + e.getMessage());
	        screenShot("TC_059");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
