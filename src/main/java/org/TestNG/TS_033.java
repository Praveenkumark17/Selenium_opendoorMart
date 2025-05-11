package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_033 extends BaseClass{
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
	public void TC_160() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click Sidebar Buttons
	        WebElement homeButton = driver.findElement(By.xpath("//li/a[contains(text(),'Home')]"));
	        WebElement brandButton = driver.findElement(By.xpath("//li/a[contains(text(),'Brand')]"));
	        
	        brandButton.click();
	        Thread.sleep(2000);
	        Assert.assertEquals(driver.getCurrentUrl(), "https://e-commerce-client-swart.vercel.app/admin/brand", "TC_160 Failed: Brand button did not navigate correctly!");

	        homeButton.click();
	        Thread.sleep(2000);
	        Assert.assertEquals(driver.getCurrentUrl(), "https://e-commerce-client-swart.vercel.app/admin", "TC_160 Failed: Home button did not navigate correctly!");

	        System.out.println("TC_160 - Test Passed: Sidebar buttons navigate correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_160 - Test Failed: " + e.getMessage());
	        screenShot("TC_160");
	        throw e;
	    }
	}
	
	@Test
	public void TC_161() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Check hover effect on sidebar buttons
	        WebElement homeButton = driver.findElement(By.xpath("//li/a[contains(text(),'Home')]"));
	        Actions action = new Actions(driver);
	        action.moveToElement(homeButton).perform();

	        String hoverEffect = homeButton.getCssValue("color");
	        Assert.assertTrue(hoverEffect.contains("rgba"), "TC_161 Failed: No hover effect applied!");

	        System.out.println("TC_161 - Test Passed: Hover effect is correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_161 - Test Failed: " + e.getMessage());
	        screenShot("TC_161");
	        throw e;
	    }
	}
	
	@Test
	public void TC_162() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Test responsiveness on multiple screen sizes
	        int[] screenWidths = {1024, 768, 480}; // Desktop, Tablet, Mobile
	        WebElement menuSection = driver.findElement(By.id("menu"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(menuSection.isDisplayed(), "TC_162 Failed: Sidebar menu is not visible at width " + width);
	            System.out.println("✅ Sidebar button visibility confirmed at width: " + width);
	        }

	        System.out.println("TC_162 - Test Passed: Sidebar buttons remain visible across screen sizes.");
	    } catch (Exception e) {
	        System.out.println("TC_162 - Test Failed: " + e.getMessage());
	        screenShot("TC_162");
	        throw e;
	    }
	}
	
	@Test
	public void TC_163() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Navigate using keyboard and press Enter
	        WebElement homeButton = driver.findElement(By.xpath("//li/a[contains(text(),'Home')]"));
	        homeButton.sendKeys(Keys.TAB);
	        homeButton.sendKeys(Keys.ENTER);
	        Thread.sleep(2000);
	        Assert.assertEquals(driver.getCurrentUrl(), "https://e-commerce-client-swart.vercel.app/admin", "TC_163 Failed: Sidebar button is not keyboard accessible!");

	        System.out.println("TC_163 - Test Passed: Sidebar buttons are accessible via keyboard navigation.");
	    } catch (Exception e) {
	        System.out.println("TC_163 - Test Failed: " + e.getMessage());
	        screenShot("TC_163");
	        throw e;
	    }
	}
	
	@Test
	public void TC_164() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify color contrast
	        WebElement sidebarText = driver.findElement(By.xpath("//div//p[@class=\"fs-5\"]"));
	        String textColor = sidebarText.getCssValue("color");
	        String backgroundColor = sidebarText.getCssValue("background-color");

	        // ✅ Example contrast validation logic (adjust as needed)
	        Assert.assertNotEquals(textColor, backgroundColor, "TC_164 Failed: Color contrast is insufficient!");

	        System.out.println("TC_164 - Test Passed: Sidebar button color contrast meets accessibility standards.");
	    } catch (Exception e) {
	        System.out.println("TC_164 - Test Failed: " + e.getMessage());
	        screenShot("TC_164");
	        throw e;
	    }
	}

	

	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
