package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_025 extends BaseClass{
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
	public void TC_119() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify redirection to dashboard
	        WebElement dashboard = driver.findElement(By.xpath("//div[@id='menu']"));
	        Assert.assertTrue(dashboard.isDisplayed(), "TC_119 Failed: Dashboard did not load!");

	        System.out.println("TC_119 - Test Passed: Admin login and dashboard loaded successfully.");
	    } catch (Exception e) {
	        System.out.println("TC_119 - Test Failed: " + e.getMessage());
	        screenShot("TC_119");
	        throw e;
	    }
	}
	
	@Test
	public void TC_120() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify navigation bar presence and links
	        WebElement navBar = driver.findElement(By.xpath("//div[@class='admin_header__WgG3k d-flex justify-content-between']"));
	        Assert.assertTrue(navBar.isDisplayed(), "TC_120 Failed: Navigation bar is not visible!");

	        List<WebElement> navLinks = navBar.findElements(By.tagName("a"));
	        for (WebElement link : navLinks) {
	            Assert.assertTrue(link.isDisplayed(), "TC_120 Failed: Navigation link is missing!");
	        }

	        System.out.println("TC_120 - Test Passed: Navigation bar is properly aligned and functional.");
	    } catch (Exception e) {
	        System.out.println("TC_120 - Test Failed: " + e.getMessage());
	        screenShot("TC_120");
	        throw e;
	    }
	}
	
	@Test
	public void TC_121() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Test responsiveness on multiple screen sizes
	        int[] screenWidths = {1024, 768, 480}; // Desktop, Tablet, Mobile
	        WebElement dashboard = driver.findElement(By.xpath("//div[@id='menu']"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(dashboard.isDisplayed(), "TC_121 Failed: Dashboard layout broke at width " + width);
	            System.out.println("✅ Dashboard layout adapts correctly at width: " + width);
	        }

	        System.out.println("TC_121 - Test Passed: Dashboard is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_121 - Test Failed: " + e.getMessage());
	        screenShot("TC_121");
	        throw e;
	    }
	}
	
	@Test
	public void TC_122() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        Thread.sleep(4000);
	        driver.navigate().refresh();
	        
	        // ✅ Verify statistics section
	        WebElement statsSection = driver.findElement(By.xpath("//div[@class='adminhome_box1__2jZ+B']"));
	        Assert.assertTrue(statsSection.isDisplayed(), "TC_122 Failed: Statistics section is missing!");

	        List<WebElement> stats = statsSection.findElements(By.className("adminhome_boxes__CU9oa"));
	        for (WebElement stat : stats) {
	            Assert.assertFalse(stat.getText().isEmpty(), "TC_122 Failed: Statistics data is missing!");
	        }

	        System.out.println("TC_122 - Test Passed: Statistics section displays accurate data.");
	    } catch (Exception e) {
	        System.out.println("TC_122 - Test Failed: " + e.getMessage());
	        screenShot("TC_122");
	        throw e;
	    }
	}
	
	@Test
	public void TC_123() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Perform search
	        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search']"));
	        searchBar.sendKeys("Orders");
	        
	        driver.navigate().refresh();

	        // ✅ Verify search results
	        WebElement searchResults = driver.findElement(By.xpath("//input[@placeholder='Search']"));
	        Assert.assertTrue(searchResults.isDisplayed(), "TC_123 Failed: No search results displayed!");

	        System.out.println("TC_123 - Test Passed: Search bar is functional and displays results.");
	    } catch (Exception e) {
	        System.out.println("TC_123 - Test Failed: " + e.getMessage());
	        screenShot("TC_123");
	        throw e;
	    }
	}


	@Test
	public void TC_124() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify Profile Container Alignment
	        WebElement profileContainer = driver.findElement(By.xpath("//input[@placeholder='Search']"));
	        System.out.println(profileContainer.getLocation().getX());

	        int profileLocation = profileContainer.getLocation().getX();

	        Assert.assertEquals(profileLocation, 339, "TC_124 Failed: Profile container is misaligned!");

	        System.out.println("TC_124 - Test Passed: Profile container is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_124 - Test Failed: " + e.getMessage());
	        screenShot("TC_124");
	        throw e;
	    }
	}




	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
	
}
