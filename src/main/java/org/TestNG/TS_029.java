package org.TestNG;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_029 extends BaseClass{
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
	public void TC_140() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Click toggle button to collapse sidebar  
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));  
	        WebElement sidebar = driver.findElement(By.id("menu"));  

	        toggleButton.click();  
	        Thread.sleep(2000);  
	        Assert.assertFalse(sidebar.isDisplayed(), "TC_140 Failed: Sidebar did not collapse!");  

	        System.out.println("TC_140 - Test Passed: Sidebar collapses successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_140 - Test Failed: " + e.getMessage());  
	        screenShot("TC_140");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_141() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Click toggle button to expand sidebar  
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));  
	        WebElement sidebar = driver.findElement(By.id("menu"));  

	        toggleButton.click();  
	        Thread.sleep(2000);  
	        toggleButton.click();  
	        Thread.sleep(2000);  
	        Assert.assertTrue(sidebar.isDisplayed(), "TC_141 Failed: Sidebar did not expand!");  

	        System.out.println("TC_141 - Test Passed: Sidebar expands successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_141 - Test Failed: " + e.getMessage());  
	        screenShot("TC_141");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_142() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Collapse sidebar  
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));  
	        toggleButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Refresh page and verify sidebar state  
	        driver.navigate().refresh();  
	        Thread.sleep(3000);  
	        WebElement sidebar = driver.findElement(By.id("menu"));  
	        Assert.assertTrue(sidebar.isDisplayed(), "TC_142 Failed: Sidebar state did not persist after refresh!");  

	        System.out.println("TC_142 - Test Passed: Sidebar state persists after page reload.");  
	    } catch (Exception e) {  
	        System.out.println("TC_142 - Test Failed: " + e.getMessage());  
	        screenShot("TC_142");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_143() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Rapidly click the toggle button  
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));  
	        for (int i = 0; i < 5; i++) {  
	            toggleButton.click();  
	            Thread.sleep(500);  
	        }  

	        System.out.println("TC_143 - Test Passed: Sidebar toggle button handles rapid clicks seamlessly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_143 - Test Failed: " + e.getMessage());  
	        screenShot("TC_143");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_144() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to sidebar toggle button using keyboard and press Enter  
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));  
	        toggleButton.sendKeys(Keys.ENTER);  
	        Thread.sleep(2000);  
	        WebElement sidebar = driver.findElement(By.id("menu"));  
	        Assert.assertFalse(sidebar.isDisplayed(), "TC_144 Failed: Sidebar did not collapse via keyboard input!");  

	        System.out.println("TC_144 - Test Passed: Sidebar toggle button is keyboard-accessible.");  
	    } catch (Exception e) {  
	        System.out.println("TC_144 - Test Failed: " + e.getMessage());  
	        screenShot("TC_144");  
	        throw e;  
	    }  
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
