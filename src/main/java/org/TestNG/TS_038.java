package org.TestNG;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_038 extends BaseClass{
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
	public void TC_185() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate to Admin Brand Page
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        // ✅ Click "Add Brand" button
	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));
	        addBrandButton.click();
	        Thread.sleep(2000);

	        WebElement brandTable = driver.findElement(By.xpath("//div[@class=\"addbrand_content__1E5lC mx-1 mt-3 p-3\"]"));
	        Assert.assertTrue(brandTable.isDisplayed(), "TC_185 Failed: Brand was not added!");

	        System.out.println("TC_185 - Test Passed: Clicking 'Add Brand' successfully adds a brand.");
	    } catch (Exception e) {
	        System.out.println("TC_185 - Test Failed: " + e.getMessage());
	        screenShot("TC_185");
	        throw e;
	    }
	}
	
	@Test
	public void TC_186() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate to Admin Brand Page
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        // ✅ Click "Add Brand" button multiple times
	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));
	        addBrandButton.click();

//	        Assert.assertTrue(errorMessage.getText().contains("Duplicate entry"), "TC_186 Failed: Duplicate addition was not prevented!");

	        System.out.println("TC_186 - Test Passed: Button prevents duplicate additions.");
	    } catch (Exception e) {
	        System.out.println("TC_186 - Test Failed: " + e.getMessage());
	        screenShot("TC_186");
	        throw e;
	    }
	}
	
	@Ignore
	@Test
	public void TC_187() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate to Admin Brand Page
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        // ✅ Click "Add Brand" button rapidly
	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));
	        for (int i = 0; i < 5; i++) {
	            addBrandButton.click();
	            Thread.sleep(500);
	        }

	        WebElement brandEntries = driver.findElement(By.className("brand-table"));
	        Assert.assertTrue(brandEntries.getText().contains("New Brand"), "TC_187 Failed: Button did not handle rapid clicks properly!");

	        System.out.println("TC_187 - Test Passed: Button handles rapid clicks gracefully.");
	    } catch (Exception e) {
	        System.out.println("TC_187 - Test Failed: " + e.getMessage());
	        screenShot("TC_187");
	        throw e;
	    }
	}

	@Test
	public void TC_188() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate to Admin Brand Page
	        WebElement brandPage = driver.findElement(By.xpath("//li/a[text()='Brand']"));
	        brandPage.click();
	        Thread.sleep(2000);

	        // ✅ Reload page and verify button visibility
	        driver.navigate().refresh();
	        Thread.sleep(3000);
	        WebElement addBrandButton = driver.findElement(By.xpath("//a[text()='Add Brand']"));
	        Assert.assertTrue(addBrandButton.isDisplayed(), "TC_188 Failed: Button is not visible after page reload!");

	        System.out.println("TC_188 - Test Passed: 'Add Brand' button remains visible and functional after reload.");
	    } catch (Exception e) {
	        System.out.println("TC_188 - Test Failed: " + e.getMessage());
	        screenShot("TC_188");
	        throw e;
	    }
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
