package org.TestNG;

import java.io.IOException;
import java.util.Date;

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

public class TS_006 extends BaseClass {
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
	public void TC_025() throws IOException {
		try {
			// Locate the Password input field
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			Assert.assertTrue(signInButton.isDisplayed(), "TC_015 Failed: Password field is NOT visible!");

			System.out.println("TC_025 - Test Passed: Sign-In button is visible without scrolling.");
		} catch (Exception e) {
			System.out.println("TC_025 - Test Failed: " + e.getMessage());
			screenShot("TC_025");
			throw e;
		}
	}

	@Test
	public void TC_026() throws IOException {
		try {
			// Locate the Password input field
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			// ✅ Get coordinates for both elements
			Point buttonLocation = signInButton.getLocation();

			int expectedX = 343;
			int expectedY = 396;

			// ✅ Validate horizontal alignment (Same X-axis)
			Assert.assertEquals(buttonLocation.getX(), expectedX,
					"TC_026 Failed: Sign-In button is not horizontally aligned!");

			// ✅ Validate vertical alignment (Button appears slightly below password field)
			Assert.assertEquals(buttonLocation.getY(), expectedY,
					"TC_026 Failed: Sign-In button is misplaced vertically!");

			System.out.println("TC_026 - Test Passed: Sign-In button is correctly aligned.");
		} catch (Exception e) {
			System.out.println("TC_026 - Test Failed: " + e.getMessage());
			screenShot("TC_026");
			throw e;
		}
	}

	@Test
	public void TC_027() throws Exception {
		try {
			// Locate the Password input field
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			// ✅ Get default background color
			String defaultColor = signInButton.getCssValue("background-color");

			// ✅ Hover over the Sign-In button
			Actions action = new Actions(driver);
			action.moveToElement(signInButton).perform();
			Thread.sleep(2000); // Wait for hover effect

			// ✅ Get hover background color
			String hoverColor = signInButton.getCssValue("background-color");

			// ✅ Validate that color changes on hover
			Assert.assertNotEquals(defaultColor, hoverColor, "TC_027 Failed: No hover effect on Sign-In button!");

			System.out.println("TC_027 - Test Passed: Hover effect applied correctly.");
		} catch (Exception e) {
			System.out.println("TC_027 - Test Failed: " + e.getMessage());
			screenShot("TC_027");
			throw e;
		}
	}

	@Test
	public void TC_028() throws Exception {
		try {
			// Locate the Password input field
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			// ✅ Test responsiveness across multiple screen widths
			int[] screenWidths = { 1024, 850 }; // Desktop, Tablet

			for (int width : screenWidths) {
				driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
				Thread.sleep(2000); // Allow UI to adjust
				Assert.assertTrue(signInButton.isDisplayed(),
						"TC_028 Failed: Sign-In button is missing at width " + width);
				System.out.println("✅ Sign-In button is responsive at width: " + width);
			}

			System.out.println("TC_028 - Test Passed: Sign-In button is fully responsive.");
		} catch (Exception e) {
			System.out.println("TC_028 - Test Failed: " + e.getMessage());
			screenShot("TC_028");
			throw e;
		}
	}

	@Test
	public void TC_029() throws IOException {
		try {
			// Locate the Password input field
			WebElement signInButton = driver
					.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]"));

			// ✅ Get font properties
			String fontSize = signInButton.getCssValue("font-size");
			String fontFamily = signInButton.getCssValue("font-family");

			// ✅ Validate expected font size and family
			Assert.assertEquals(fontSize, "16px", "TC_029 Failed: Incorrect font size!");
			Assert.assertTrue(fontFamily.contains("Arial") || fontFamily.contains("sans-serif"),
					"TC_029 Failed: Incorrect font family!");

			System.out.println("TC_029 - Test Passed: Font style and size are correct.");
		} catch (Exception e) {
			System.out.println("TC_029 - Test Failed: " + e.getMessage());
			screenShot("TC_029");
			throw e;
		}
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
