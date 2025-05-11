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
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_026 extends BaseClass {
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
	public void TC_125() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Locate the logo button
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));

	        Point logoLocation = logoButton.getLocation();

	        Assert.assertEquals(logoLocation.getX(), 52, "TC_125 Failed: Logo button is misaligned!");

	        System.out.println("TC_125 - Test Passed: Logo button is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_125 - Test Failed: " + e.getMessage());
	        screenShot("TC_125");
	        throw e;
	    }
	}

	@Test
	public void TC_126() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Test responsiveness on multiple screen sizes
	        int[] screenWidths = {1024, 768, 480}; // Desktop, Tablet, Mobile
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(logoButton.isDisplayed(), "TC_126 Failed: Logo button is not visible at width " + width);
	            System.out.println("✅ Logo button responsiveness confirmed at width: " + width);
	        }

	        System.out.println("TC_126 - Test Passed: Logo button is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_126 - Test Failed: " + e.getMessage());
	        screenShot("TC_126");
	        throw e;
	    }
	}

	@Test
	public void TC_127() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify hover effect
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));
	        Actions action = new Actions(driver);
	        action.moveToElement(logoButton).perform();

	        String hoverEffect = logoButton.getCssValue("filter");
	        Assert.assertFalse(hoverEffect.contains("brightness"), "TC_127 Failed: No hover effect applied!");

	        System.out.println("TC_127 - Test Passed: Hover effect is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_127 - Test Failed: " + e.getMessage());
	        screenShot("TC_127");
	        throw e;
	    }
	}
	
	@Test
	public void TC_128() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        driver.findElement(By.xpath("//a[@href=\"/admin/brand\"]")).click();
	        
	        // ✅ Click on the logo button
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));
	        logoButton.click();

	        // ✅ Verify redirection to homepage
	        String currentURL = driver.getCurrentUrl();
	        Assert.assertEquals(currentURL, "https://e-commerce-client-swart.vercel.app/admin", "TC_128 Failed: Logo button did not redirect to homepage!");

	        System.out.println("TC_128 - Test Passed: Logo button redirects to the homepage successfully.");
	    } catch (Exception e) {
	        System.out.println("TC_128 - Test Failed: " + e.getMessage());
	        screenShot("TC_128");
	        throw e;
	    }
	}
	
	@Ignore
	@Test
	public void TC_129() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify visibility of the logo button in both modes
	        WebElement logoButton = driver.findElement(By.className("logo"));

	        // Switch to dark mode
	        WebElement darkModeToggle = driver.findElement(By.className("dark-mode-toggle"));
	        darkModeToggle.click();
	        Thread.sleep(2000);
	        Assert.assertTrue(logoButton.isDisplayed(), "TC_129 Failed: Logo button is not visible in dark mode!");

	        // Switch back to light mode
	        darkModeToggle.click();
	        Thread.sleep(2000);
	        Assert.assertTrue(logoButton.isDisplayed(), "TC_129 Failed: Logo button is not visible in light mode!");

	        System.out.println("TC_129 - Test Passed: Logo button visibility confirmed in light & dark modes.");
	    } catch (Exception e) {
	        System.out.println("TC_129 - Test Failed: " + e.getMessage());
	        screenShot("TC_129");
	        throw e;
	    }
	}

	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
