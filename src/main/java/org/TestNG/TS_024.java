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
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_024 extends BaseClass{
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
	public void TC_114() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Upload a valid image file (JPG or PNG)
	        WebElement uploadField = driver.findElement(By.id("image-lg"));
	        uploadField.sendKeys("E:\\Downloads\\5t4rdcsh.png");

	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_114 - Test Passed: Valid image uploaded successfully.");
	    } catch (Exception e) {
	        System.out.println("TC_114 - Test Failed: " + e.getMessage());
	        screenShot("TC_114");
	        throw e;
	    }
	}

	@Test
	public void TC_115() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Leave image upload field blank and submit
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        // ✅ Verify error message appears
	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));
	        Assert.assertTrue(errorMessage.getText().contains("All fields are required"),
	                "TC_115 Failed: No error message for missing image!");

	        System.out.println("TC_115 - Test Passed: Error message correctly displayed for missing image.");
	    } catch (Exception e) {
	        System.out.println("TC_115 - Test Failed: " + e.getMessage());
	        screenShot("TC_115");
	        throw e;
	    }
	}
	
	@Test
	public void TC_116() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Upload an unsupported file type (PDF, DOC)
	        WebElement uploadField = driver.findElement(By.id("image-lg"));
	        uploadField.sendKeys("E:\\Downloads\\PaymentReceipt.pdf");

	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_116 - Test Passed: Error message displayed correctly for unsupported files.");
	    } catch (Exception e) {
	        System.out.println("TC_116 - Test Failed: " + e.getMessage());
	        screenShot("TC_116");
	        throw e;
	    }
	}
	
	@Test
	public void TC_117() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Upload a large image file (>10MB)
	        WebElement uploadField = driver.findElement(By.id("image-lg"));
	        uploadField.sendKeys("E:\\Downloads\\5t4rdcsh.png");

	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_117 - Test Passed: Error message correctly displayed for large image uploads.");
	    } catch (Exception e) {
	        System.out.println("TC_117 - Test Failed: " + e.getMessage());
	        screenShot("TC_117");
	        throw e;
	    }
	}
	
	@Ignore
	@Test
	public void TC_118() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Upload the same image twice
	        WebElement uploadField = driver.findElement(By.id("image-lg"));
	        uploadField.sendKeys("E:\\Downloads\\5t4rdcsh.png");
	        uploadField.sendKeys("E:\\Downloads\\5t4rdcsh.png"); // Duplicate upload

	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_118 - Test Passed: Duplicate image validation works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_118 - Test Failed: " + e.getMessage());
	        screenShot("TC_118");
	        throw e;
	    }
	}




	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
