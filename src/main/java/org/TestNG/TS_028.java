package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_028 extends BaseClass{
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
	public void TC_135() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Locate the sidebar toggle button
	        WebElement toggleButton = driver.findElement(By.xpath("//div//button"));
	        System.out.println(toggleButton);

	        Point toggleLocation = toggleButton.getLocation();

	        Assert.assertEquals(toggleLocation.getY(), 0, "TC_135 Failed: Sidebar toggle button is misaligned!");

	        System.out.println("TC_135 - Test Passed: Sidebar toggle button is visible and correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_135 - Test Failed: " + e.getMessage());
	        screenShot("TC_135");
	        throw e;
	    }
	}

	@Test
	public void TC_136() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click the toggle button to collapse and expand the sidebar
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));
	        WebElement menuSection = driver.findElement(By.id("menu"));

	        toggleButton.click();
	        Thread.sleep(2000);
	        Assert.assertFalse(menuSection.isDisplayed(), "TC_136 Failed: Sidebar did not collapse!");

	        toggleButton.click();
	        Thread.sleep(2000);
	        Assert.assertTrue(menuSection.isDisplayed(), "TC_136 Failed: Sidebar did not expand!");

	        System.out.println("TC_136 - Test Passed: Sidebar toggle button functions correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_136 - Test Failed: " + e.getMessage());
	        screenShot("TC_136");
	        throw e;
	    }
	}
	
	@Test
	public void TC_137() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Test responsiveness on multiple screen sizes
	        int[] screenWidths = {1024, 768, 480}; // Desktop, Tablet, Mobile
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(toggleButton.isDisplayed(), "TC_137 Failed: Toggle button is not accessible at width " + width);
	            System.out.println("✅ Sidebar toggle button responsiveness confirmed at width: " + width);
	        }

	        System.out.println("TC_137 - Test Passed: Sidebar toggle button is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_137 - Test Failed: " + e.getMessage());
	        screenShot("TC_137");
	        throw e;
	    }
	}

	@Test
	public void TC_138() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify hover effect
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));
	        Actions action = new Actions(driver);
	        action.moveToElement(toggleButton).perform();

	        String hoverEffect = toggleButton.getCssValue("background-color");
	        Assert.assertTrue(hoverEffect.contains("rgba"), "TC_138 Failed: No hover effect applied!");

	        System.out.println("TC_138 - Test Passed: Hover effect is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_138 - Test Failed: " + e.getMessage());
	        screenShot("TC_138");
	        throw e;
	    }
	}
	
	@Test
	public void TC_139() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click the toggle button and check other UI elements
	        WebElement toggleButton = driver.findElement(By.xpath("//button[@class='btn ']"));
	        WebElement profileContainer = driver.findElement(By.xpath("//img"));
	        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search']"));

	        toggleButton.click();
	        Thread.sleep(2000);
	        Assert.assertTrue(profileContainer.isDisplayed() && searchBar.isDisplayed(), "TC_139 Failed: Sidebar toggle button interfered with other UI elements!");

	        System.out.println("TC_139 - Test Passed: Sidebar toggle button does not interfere with other UI elements.");
	    } catch (Exception e) {
	        System.out.println("TC_139 - Test Failed: " + e.getMessage());
	        screenShot("TC_139");
	        throw e;
	    }
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
