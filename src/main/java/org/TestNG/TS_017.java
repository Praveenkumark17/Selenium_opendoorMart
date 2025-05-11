package org.TestNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_017 extends BaseClass{
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
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_080() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify dropdown alignment
	        WebElement genderDropdown = driver.findElement(By.id("gender-lg"));
	        WebElement referenceField = driver.findElement(By.id("age-lg"));

	        Point dropdownLocation = genderDropdown.getLocation();
	        Point referenceLocation = referenceField.getLocation();

	        Assert.assertEquals(dropdownLocation.getX(), referenceLocation.getX(), "TC_080 Failed: Gender dropdown is misaligned!");

	        System.out.println("TC_080 - Test Passed: Gender dropdown is correctly aligned.");
	    } catch (Exception e) {
	        System.out.println("TC_080 - Test Failed: " + e.getMessage());
	        screenShot("TC_080");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_081() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify placeholder/default option
	        WebElement genderDropdown = driver.findElement(By.id("gender-lg"));
	        Select genderSelect = new Select(genderDropdown);
	        String defaultOption = genderSelect.getFirstSelectedOption().getText();

	        Assert.assertEquals(defaultOption, "Select gender", "TC_081 Failed: Default option is incorrect!");

	        System.out.println("TC_081 - Test Passed: Default gender option is displayed correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_081 - Test Failed: " + e.getMessage());
	        screenShot("TC_081");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_082() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify dropdown options
	        WebElement genderDropdown = driver.findElement(By.id("gender-lg"));
	        Select genderSelect = new Select(genderDropdown);
	        List<WebElement> options = genderSelect.getOptions();

	        List<String> expectedOptions = Arrays.asList("Male", "Female","Others");
	        List<String> actualOptions = new ArrayList<>();
	        for (WebElement option : options) {
	            actualOptions.add(option.getText());
	        }

	        Assert.assertTrue(actualOptions.containsAll(expectedOptions), "TC_082 Failed: Not all expected options are present!");

	        System.out.println("TC_082 - Test Passed: All gender options are correctly displayed.");
	    } catch (Exception e) {
	        System.out.println("TC_082 - Test Failed: " + e.getMessage());
	        screenShot("TC_082");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_083() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Select gender and verify
	        WebElement genderDropdown = driver.findElement(By.id("gender-lg"));
	        Select genderSelect = new Select(genderDropdown);
	        genderSelect.selectByVisibleText("Male");

	        String selectedOption = genderSelect.getFirstSelectedOption().getText();
	        Assert.assertEquals(selectedOption, "Male", "TC_083 Failed: Gender selection is incorrect!");

	        System.out.println("TC_083 - Test Passed: Gender selection works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_083 - Test Failed: " + e.getMessage());
	        screenShot("TC_083");
	        throw e;
	    }
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TC_084() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Test responsiveness across mobile screen sizes
	        int[] screenWidths = {480, 320}; // Mobile resolutions
	        WebElement genderDropdown = driver.findElement(By.id("gender-sm"));

	        for (int width : screenWidths) {
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));
	            Thread.sleep(2000);
	            Assert.assertTrue(genderDropdown.isDisplayed(), "TC_084 Failed: Gender dropdown not visible on mobile!");
	            System.out.println("✅ Gender dropdown is responsive at width: " + width);
	        }

	        System.out.println("TC_084 - Test Passed: Gender dropdown is fully responsive.");
	    } catch (Exception e) {
	        System.out.println("TC_084 - Test Failed: " + e.getMessage());
	        screenShot("TC_084");
	        throw e;
	    }
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
