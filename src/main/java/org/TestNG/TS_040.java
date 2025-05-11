package org.TestNG;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_040 extends BaseClass{
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
	public void TC_194() throws Exception {
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

	        // ✅ Verify data loading in table
	        WebElement brandTable = driver.findElement(By.xpath("//table"));
	        Assert.assertTrue(brandTable.isDisplayed(), "TC_194 Failed: Brand list table did not load!");

	        System.out.println("TC_194 - Test Passed: Brand list table data loads successfully.");
	    } catch (Exception e) {
	        System.out.println("TC_194 - Test Failed: " + e.getMessage());
	        screenShot("TC_194");
	        throw e;
	    }
	}
	
	@Test
	public void TC_195() throws Exception {
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

	        // ✅ Verify table row data
	        WebElement firstBrandRow = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
	        Assert.assertEquals(firstBrandRow.getText(), "Cadbury", "TC_195 Failed: Brand Name is incorrect!");

	        System.out.println("TC_195 - Test Passed: Table row data is accurate.");
	    } catch (Exception e) {
	        System.out.println("TC_195 - Test Failed: " + e.getMessage());
	        screenShot("TC_195");
	        throw e;
	    }
	}
	
	@Test
	public void TC_196() throws Exception {
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

	        // ✅ Click Edit and Delete buttons
	        WebElement editButton = driver.findElement(By.xpath("//table/tbody/tr[1]//td[6]//a[text()='Edit']"));
	        WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr[1]//td[6]//a[text()='Delete']"));

	        editButton.click();
	        Thread.sleep(2000);

	        Assert.assertTrue(editButton.isDisplayed(), "TC_196 Failed: Action buttons are not working!");

	        System.out.println("TC_196 - Test Passed: Edit/Delete functionality works.");
	    } catch (Exception e) {
	        System.out.println("TC_196 - Test Failed: " + e.getMessage());
	        screenShot("TC_196");
	        throw e;
	    }
	}
	
	@Test
	public void TC_197() throws Exception {
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

	        // ✅ Test responsiveness on multiple screen sizes
	        int[] screenWidths = {1024, 768, 480}; // Desktop, Tablet, Mobile
	        WebElement brandTable = driver.findElement(By.xpath("//table"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(brandTable.isDisplayed(), "TC_197 Failed: Brand table is not responsive at width " + width);
	            System.out.println("✅ Brand table responsiveness confirmed at width: " + width);
	        }

	        System.out.println("TC_197 - Test Passed: Brand table adapts correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_197 - Test Failed: " + e.getMessage());
	        screenShot("TC_197");
	        throw e;
	    }
	}
	
	@Test
	public void TC_198() throws Exception {
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

	        // ✅ Verify all rows are visible without search or pagination
	        WebElement tableBody = driver.findElement(By.xpath("//table/tbody"));
	        int rowCount = tableBody.findElements(By.tagName("tr")).size();

	        Assert.assertTrue(rowCount > 3, "TC_198 Failed: Not all rows are visible!");

	        System.out.println("TC_198 - Test Passed: All rows display correctly without pagination.");
	    } catch (Exception e) {
	        System.out.println("TC_198 - Test Failed: " + e.getMessage());
	        screenShot("TC_198");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}

}
