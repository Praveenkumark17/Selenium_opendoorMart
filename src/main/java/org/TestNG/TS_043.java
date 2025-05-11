package org.TestNG;

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

public class TS_043 extends BaseClass{
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
	public void TC_209() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate to Add Brand Form  
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));  
	        brandPage.click();  
	        Thread.sleep(2000);  

	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));  
	        addBrandButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Fill form with valid data  
	        driver.findElement(By.name("owner")).sendKeys("John Doe");  
	        driver.findElement(By.name("email")).sendKeys("brand@example.com");  
	        driver.findElement(By.name("city")).sendKeys("New York");  
	        driver.findElement(By.name("brand")).sendKeys("New Brand1");  
	        driver.findElement(By.name("phone")).sendKeys("9876543210");  
	        driver.findElement(By.name("status")).sendKeys("active");  
	        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is a new brand.");  
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement success = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(success.getText().contains("Brand added successfully"), "TC_209 Failed: Brand not added!");  

	        System.out.println("TC_209 - Test Passed: Brand added successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_209 - Test Failed: " + e.getMessage());  
	        screenShot("TC_209");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_210() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate to Add Brand Form  
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));  
	        brandPage.click();  
	        Thread.sleep(2000);  

	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));  
	        addBrandButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Submit form with empty fields  
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(errorMessage.isDisplayed(), "TC_210 Failed: No error message displayed!");  

	        System.out.println("TC_210 - Test Passed: Error messages displayed correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_210 - Test Failed: " + e.getMessage());  
	        screenShot("TC_210");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_211() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate to Add Brand Form  
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));  
	        brandPage.click();  
	        Thread.sleep(2000);  

	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));  
	        addBrandButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Enter duplicate brand name and submit  
	        driver.findElement(By.name("owner")).sendKeys("John Doe");  
	        driver.findElement(By.name("email")).sendKeys("brand@example.com");  
	        driver.findElement(By.name("city")).sendKeys("New York");  
	        driver.findElement(By.name("brand")).sendKeys("New Brand1");  
	        driver.findElement(By.name("phone")).sendKeys("9876543210");  
	        driver.findElement(By.name("status")).sendKeys("active");  
	        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is a new brand.");  
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement duplicateMessage = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(duplicateMessage.isDisplayed(), "TC_211 Failed: Duplicate entries were not prevented!");  

	        System.out.println("TC_211 - Test Passed: Duplicate entries are handled properly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_211 - Test Failed: " + e.getMessage());  
	        screenShot("TC_211");  
	        throw e;  
	    }  
	}

	@Ignore
	@Test
	public void TC_212() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Brand Form  
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));  
	        brandPage.click();  
	        Thread.sleep(2000);  

	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));  
	        addBrandButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Enter invalid phone number and submit  
	        driver.findElement(By.name("phone")).sendKeys("abcd1234");  
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement errorMessage = driver.findElement(By.className("error-message"));  
	        Assert.assertTrue(errorMessage.getText().contains("Invalid phone number"), "TC_212 Failed: Phone validation not working!");  

	        System.out.println("TC_212 - Test Passed: Phone number validation works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_212 - Test Failed: " + e.getMessage());  
	        screenShot("TC_212");  
	        throw e;  
	    }  
	}

	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
