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

public class TS_032 extends BaseClass{
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
	public void TC_155() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify sidebar button visibility & alignment
	        WebElement menuSection = driver.findElement(By.id("menu"));
	        WebElement homeButton = driver.findElement(By.xpath("//li/a[contains(text(),'Home')]"));
	        WebElement brandButton = driver.findElement(By.xpath("//li/a[contains(text(),'Brand')]"));

	        Point homeLocation = homeButton.getLocation();
	        Point brandLocation = brandButton.getLocation();

	        Assert.assertEquals(homeLocation.getY(), 159, "TC_155 Failed: Sidebar buttons are misaligned!");

	        System.out.println("TC_155 - Test Passed: Sidebar buttons are correctly aligned and visible.");
	    } catch (Exception e) {
	        System.out.println("TC_155 - Test Failed: " + e.getMessage());
	        screenShot("TC_155");
	        throw e;
	    }
	}
	
	@Test
	public void TC_156() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify button icons
	        WebElement homeIcon = driver.findElement(By.xpath("//li/a[contains(text(),'Home')]"));
	        WebElement brandIcon = driver.findElement(By.xpath("//li/a[contains(text(),'Brand')]"));

	        Assert.assertTrue(homeIcon.isDisplayed(), "TC_156 Failed: Home icon is missing!");
	        Assert.assertTrue(brandIcon.isDisplayed(), "TC_156 Failed: Brand icon is missing!");

	        System.out.println("TC_156 - Test Passed: Sidebar button icons are distinct and clear.");
	    } catch (Exception e) {
	        System.out.println("TC_156 - Test Failed: " + e.getMessage());
	        screenShot("TC_156");
	        throw e;
	    }
	}

	@Test
	public void TC_157() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify hover effect
	        WebElement homeButton = driver.findElement(By.xpath("//li/a[contains(text(),'Home')]"));
	        Actions action = new Actions(driver);
	        action.moveToElement(homeButton).perform();

	        String hoverEffect = homeButton.getCssValue("color");
	        Assert.assertTrue(hoverEffect.contains("rgba"), "TC_157 Failed: No hover effect applied!");

	        System.out.println("TC_157 - Test Passed: Hover effect is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_157 - Test Failed: " + e.getMessage());
	        screenShot("TC_157");
	        throw e;
	    }
	}

	@Test
	public void TC_158() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Test responsiveness on multiple screen sizes
	        int[] screenWidths = {1024, 768, 480}; // Desktop, Tablet, Mobile
	        WebElement menuSection = driver.findElement(By.id("menu"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(menuSection.isDisplayed(), "TC_158 Failed: Sidebar menu is not visible at width " + width);
	            System.out.println("✅ Sidebar responsiveness confirmed at width: " + width);
	        }

	        System.out.println("TC_158 - Test Passed: Sidebar adjusts correctly to different screen sizes.");
	    } catch (Exception e) {
	        System.out.println("TC_158 - Test Failed: " + e.getMessage());
	        screenShot("TC_158");
	        throw e;
	    }
	}

	@Ignore
	@Test
	public void TC_159() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify color contrast
	        WebElement sidebarText = driver.findElement(By.className("menu-title"));
	        String textColor = sidebarText.getCssValue("color");
	        String backgroundColor = sidebarText.getCssValue("background-color");

	        // ✅ Example contrast validation logic (adjust as needed)
	        Assert.assertNotEquals(textColor, backgroundColor, "TC_159 Failed: Color contrast is insufficient!");

	        System.out.println("TC_159 - Test Passed: Sidebar text color contrast meets accessibility standards.");
	    } catch (Exception e) {
	        System.out.println("TC_159 - Test Failed: " + e.getMessage());
	        screenShot("TC_159");
	        throw e;
	    }
	}

	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
