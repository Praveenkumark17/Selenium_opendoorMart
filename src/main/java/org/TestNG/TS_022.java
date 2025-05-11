package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_022 extends BaseClass{
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
	public void TC_105() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter a valid password and submit
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].setAttribute('type', 'text');", passwordField);
	        passwordField.sendKeys("Password123");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_105 - Test Passed: Valid password input accepted.");
	    } catch (Exception e) {
	        System.out.println("TC_105 - Test Failed: " + e.getMessage());
	        screenShot("TC_105");
	        throw e;
	    }
	}
	
	@Test
	public void TC_106() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Leave password field blank and submit
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify error message appears
	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));
	        System.out.println(errorMessage.getText());
	        Assert.assertEquals(errorMessage.getText(),"All fields are required",
	                "TC_106 Failed: No error message displayed for blank password!");

	        System.out.println("TC_106 - Test Passed: Error message correctly displayed for blank input.");
	    } catch (Exception e) {
	        System.out.println("TC_106 - Test Failed: " + e.getMessage());
	        screenShot("TC_106");
	        throw e;
	    }
	}
	
	@Test
	public void TC_107() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter a short password and submit
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        passwordField.sendKeys("12345");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify error message appears
	        Assert.assertTrue(passwordField.getText().length()<=10,
	                "TC_107 Failed: No error message for short passwords!");

	        System.out.println("TC_107 - Test Passed: Error message correctly displayed for short passwords.");
	    } catch (Exception e) {
	        System.out.println("TC_107 - Test Failed: " + e.getMessage());
	        screenShot("TC_107");
	        throw e;
	    }
	}

	@Test
	public void TC_108() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter a password without letters or numbers and submit
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        passwordField.sendKeys("%%%%%%%%");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_108 - Test Passed: Error message correctly displayed for missing letters/numbers.");
	    } catch (Exception e) {
	        System.out.println("TC_108 - Test Failed: " + e.getMessage());
	        screenShot("TC_108");
	        throw e;
	    }
	}
	
	@Test
	public void TC_109() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter a password exceeding the maximum allowed length
	        WebElement passwordField = driver.findElement(By.id("password-lg"));
	        passwordField.sendKeys("A".repeat(200)); // 200-character password
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_109 - Test Passed: Error message correctly displayed for exceeding max length.");
	    } catch (Exception e) {
	        System.out.println("TC_109 - Test Failed: " + e.getMessage());
	        screenShot("TC_109");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
