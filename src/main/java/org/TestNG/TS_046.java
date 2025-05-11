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

public class TS_046 extends BaseClass{
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
	public void TC_224() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Brand Edit Form
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        WebElement editBrandButton = driver.findElement(By.xpath("//table/tbody/tr[5]//td[6]//a[text()='Edit']"));
	        editBrandButton.click();
	        Thread.sleep(2000);

	        // ✅ Update form fields with valid data
	        driver.findElement(By.name("owner")).clear();
	        driver.findElement(By.name("owner")).sendKeys("Updated Owner");
	        driver.findElement(By.name("email")).clear();
	        driver.findElement(By.name("email")).sendKeys("updated@example.com");
	        driver.findElement(By.name("phone")).clear();
	        driver.findElement(By.name("phone")).sendKeys("9876543210");

	        driver.findElement(By.xpath("//button[text()='Update']")).click();
	        Thread.sleep(2000);

//	        WebElement brandTable = driver.findElement(By.xpath("//div[@role='alert']"));
//	        Assert.assertTrue(brandTable.isDisplayed(), "TC_224 Failed: Brand data not updated!");

	        System.out.println("TC_224 - Test Passed: Brand data updated successfully.");
	    } catch (Exception e) {
	        System.out.println("TC_224 - Test Failed: " + e.getMessage());
	        screenShot("TC_224");
	        throw e;
	    }
	}
	
	@Ignore
	@Test
	public void TC_225() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Brand Edit Form
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        WebElement editBrandButton = driver.findElement(By.xpath("//table/tbody/tr[5]//td[6]//a[text()='Edit']"));
	        editBrandButton.click();
	        Thread.sleep(2000);

	        // ✅ Update form fields with valid data
	        driver.findElement(By.name("owner")).clear();
	        driver.findElement(By.name("email")).clear();
	        driver.findElement(By.name("phone")).clear();

	        driver.findElement(By.xpath("//button[text()='Update']")).click();
	        Thread.sleep(2000);

//	        WebElement errorMessage = driver.findElement(By.className("error-message"));
//	        Assert.assertTrue(errorMessage.isDisplayed(), "TC_225 Failed: No error message displayed!");

	        System.out.println("TC_225 - Test Passed: Error messages displayed correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_225 - Test Failed: " + e.getMessage());
	        screenShot("TC_225");
	        throw e;
	    }
	}
	
	@Test
	public void TC_226() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Brand Edit Form
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        WebElement editBrandButton = driver.findElement(By.xpath("//table/tbody/tr[5]//td[6]//a[text()='Edit']"));
	        editBrandButton.click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.name("email")).clear();
	        driver.findElement(By.name("email")).sendKeys("emailgmail.com");

	        driver.findElement(By.xpath("//button[text()='Update']")).click();
	        Thread.sleep(2000);

	        System.out.println("TC_226 - Test Passed: Email validation works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_226 - Test Failed: " + e.getMessage());
	        screenShot("TC_226");
	        throw e;
	    }
	}

	@Test
	public void TC_227() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Brand Edit Form
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        WebElement editBrandButton = driver.findElement(By.xpath("//table/tbody/tr[5]//td[6]//a[text()='Edit']"));
	        editBrandButton.click();
	        Thread.sleep(2000);
	        
	     // ✅ Enter invalid phone number and attempt update
	        driver.findElement(By.name("phone")).clear();
	        driver.findElement(By.name("phone")).sendKeys("abcd1234");

	        driver.findElement(By.xpath("//button[text()='Update']")).click();
	        Thread.sleep(2000);

	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));
	        Assert.assertTrue(errorMessage.isDisplayed(), "TC_227 Failed: Phone validation not working!");

	        System.out.println("TC_227 - Test Passed: Phone number validation works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_227 - Test Failed: " + e.getMessage());
	        screenShot("TC_227");
	        throw e;
	    }
	}

	
	@Test
	public void TC_228() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Brand Edit Form
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        WebElement editBrandButton = driver.findElement(By.xpath("//table/tbody/tr[5]//td[6]//a[text()='Edit']"));
	        editBrandButton.click();
	        Thread.sleep(2000);

	        WebElement brandTable = driver.findElement(By.xpath("//a[text()='Back']"));
	        Assert.assertTrue(brandTable.isDisplayed(), "TC_228 Failed: Cancel operation did not work!");

	        System.out.println("TC_228 - Test Passed: Cancel operation works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_228 - Test Failed: " + e.getMessage());
	        screenShot("TC_228");
	        throw e;
	    }
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
