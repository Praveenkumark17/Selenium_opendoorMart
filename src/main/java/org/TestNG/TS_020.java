package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_020 extends BaseClass{
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
	public void TC_095() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter valid mobile number and submit
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        mobileField.sendKeys("9876543210");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_095 - Test Passed: Valid mobile number input accepted.");
	    } catch (Exception e) {
	        System.out.println("TC_095 - Test Failed: " + e.getMessage());
	        screenShot("TC_095");
	        throw e;
	    }
	}
	
	@Test
	public void TC_096() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Leave mobile field blank and submit
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_096 - Test Passed: Error message displayed for blank input.");
	    } catch (Exception e) {
	        System.out.println("TC_096 - Test Failed: " + e.getMessage());
	        screenShot("TC_096");
	        throw e;
	    }
	}
	
	@Test
	public void TC_097() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter non-numeric input in the mobile field
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        mobileField.sendKeys("abcd@#");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_097 - Test Passed: Error message displayed for non-numeric input.");
	    } catch (Exception e) {
	        System.out.println("TC_097 - Test Failed: " + e.getMessage());
	        screenShot("TC_097");
	        throw e;
	    }
	}
	
	@Test
	public void TC_098() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter less than 10 digits and submit
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        mobileField.sendKeys("12345");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify error message appears
	        WebElement errorMessage = driver.findElement(By.className("error"));
	        Assert.assertTrue(errorMessage.getText().contains("Invalid mobile number"),
	                "TC_098 Failed: Mobile number field accepted fewer than 10 digits!");

	        System.out.println("TC_098 - Test Failed: Mobile number field accepted incorrect length.");
	    } catch (Exception e) {
	        System.out.println("TC_098 - Test Failed: " + e.getMessage());
	        screenShot("TC_098");
	        throw e;
	    }
	}

	@Test
	public void TC_099() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter mobile number with country code and submit
	        WebElement mobileField = driver.findElement(By.id("mobile-lg"));
	        mobileField.sendKeys("+91-9876543119");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify error message appears
	        WebElement errorMessage = driver.findElement(By.className("error"));
	        Assert.assertTrue(errorMessage.getText().contains("Country code not supported"),
	                "TC_099 Failed: Country code is accepted when it should be restricted!");

	        System.out.println("TC_099 - Test Failed: Country code validation failed.");
	        screenShot("TC_099");
	    } catch (Exception e) {
	        System.out.println("TC_099 - Test Failed: " + e.getMessage());
	        screenShot("TC_099");
	        throw e;
	    }
	}
	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
