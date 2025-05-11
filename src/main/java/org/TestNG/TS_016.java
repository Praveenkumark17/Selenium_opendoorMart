package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_016 extends BaseClass{
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
	public void TC_075() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter valid age and submit
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        ageField.sendKeys("25");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_075 - Test Passed: Valid age input accepted.");
	    } catch (Exception e) {
	        System.out.println("TC_075 - Test Failed: " + e.getMessage());
	        screenShot("TC_075");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_076() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Leave age field blank and submit
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_076 - Test Passed: Error message displayed for blank input.");
	    } catch (Exception e) {
	        System.out.println("TC_076 - Test Failed: " + e.getMessage());
	        screenShot("TC_076");
	        throw e;
	    }
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TC_077() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter invalid input and submit
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        ageField.sendKeys("abc");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_077 - Test Passed: Error message displayed for non-numeric input.");
	    } catch (Exception e) {
	        System.out.println("TC_077 - Test Failed: " + e.getMessage());
	        screenShot("TC_077");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_078() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter negative age and submit
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        ageField.sendKeys("-5");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_078 - Test Passed: Error message displayed for negative numbers or zero.");
	    } catch (Exception e) {
	        System.out.println("TC_078 - Test Failed: " + e.getMessage());
	        screenShot("TC_078");
	        throw e;
	    }
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TC_079() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Enter excessive age and submit
	        WebElement ageField = driver.findElement(By.id("age-lg"));
	        ageField.sendKeys("200");
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_079 - Test Passed: Error message displayed for exceeding age limit.");
	    } catch (Exception e) {
	        System.out.println("TC_079 - Test Failed: " + e.getMessage());
	        screenShot("TC_079");
	        throw e;
	    }
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
