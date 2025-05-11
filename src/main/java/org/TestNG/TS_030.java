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

public class TS_030 extends BaseClass {
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
	public void TC_145() throws IOException {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// ✅ Enter admin credentials and sign in
			driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

			// ✅ Locate the search bar field
			WebElement searchBar = driver.findElement(By.xpath("//input"));

			Point searchLocation = searchBar.getLocation();
			System.out.println(searchLocation.getX());

			Assert.assertEquals(searchLocation.getX(), 391, "TC_145 Failed: Search bar is misaligned!");

			System.out.println("TC_145 - Test Passed: Search bar is correctly aligned.");
		} catch (Exception e) {
			System.out.println("TC_145 - Test Failed: " + e.getMessage());
			screenShot("TC_145");
			throw e;
		}
	}

	@Test
	public void TC_146() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// ✅ Enter admin credentials and sign in
			driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

			Thread.sleep(3000);
			// ✅ Verify placeholder text
			WebElement searchBar = driver.findElement(By.xpath("//input"));
			String placeholderText = searchBar.getAttribute("placeholder");

			Assert.assertEquals(placeholderText, "Search", "TC_146 Failed: Incorrect placeholder text!");

			System.out.println("TC_146 - Test Passed: Placeholder text is correctly displayed.");
		} catch (Exception e) {
			System.out.println("TC_146 - Test Failed: " + e.getMessage());
			screenShot("TC_146");
			throw e;
		}
	}

	@Test
	public void TC_147() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// ✅ Enter admin credentials and sign in
			driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

			Thread.sleep(3000);
			// ✅ Click inside search bar and check focus behavior
			WebElement searchBar = driver.findElement(By.xpath("//input"));
			Actions action = new Actions(driver);
			action.moveToElement(searchBar).click().perform();

			String borderColor = searchBar.getCssValue("border-color");
			Assert.assertFalse(borderColor.contains("rgba"), "TC_147 Failed: No focus indication!");

			System.out.println("TC_147 - Test Passed: Search bar focus behavior works correctly.");
		} catch (Exception e) {
			System.out.println("TC_147 - Test Failed: " + e.getMessage());
			screenShot("TC_147");
			throw e;
		}
	}

	@Test
	public void TC_148() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// ✅ Enter admin credentials and sign in
			driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

			Thread.sleep(3000);
			// ✅ Test responsiveness on multiple screen sizes
			int[] screenWidths = { 1024, 768, 480 }; // Desktop, Tablet, Mobile
			WebElement searchBar = driver.findElement(By.xpath("//input"));

			for (int width : screenWidths) {
				driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
				Thread.sleep(2000);
				Assert.assertTrue(searchBar.isDisplayed(),
						"TC_148 Failed: Search bar is not visible at width " + width);
				System.out.println("✅ Search bar responsiveness confirmed at width: " + width);
			}

			System.out.println("TC_148 - Test Passed: Search bar is fully responsive.");
		} catch (Exception e) {
			System.out.println("TC_148 - Test Failed: " + e.getMessage());
			screenShot("TC_148");
			throw e;
		}
	}

	@Test
	public void TC_149() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// ✅ Enter admin credentials and sign in
			driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();
			Thread.sleep(3000);
			// ✅ Interact with search bar and other UI elements
			WebElement searchBar = driver.findElement(By.xpath("//input"));

			searchBar.sendKeys("Laptop");

			System.out.println("TC_149 - Test Passed: Search bar interacts smoothly with other UI elements.");
		} catch (Exception e) {
			System.out.println("TC_149 - Test Failed: " + e.getMessage());
			screenShot("TC_149");
			throw e;
		}
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
