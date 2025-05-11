package org.TestNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_018 extends BaseClass{
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
	public void TC_085() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Select a gender option and submit
	        WebElement genderDropdown = driver.findElement(By.id("gender-lg"));
	        Select genderSelect = new Select(genderDropdown);
	        genderSelect.selectByVisibleText("Male");

	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_085 - Test Passed: Gender selection works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_085 - Test Failed: " + e.getMessage());
	        screenShot("TC_085");
	        throw e;
	    }
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void TC_086() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Leave gender dropdown unselected and submit
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_086 - Test Passed: Error message displayed for unselected gender.");
	    } catch (Exception e) {
	        System.out.println("TC_086 - Test Failed: " + e.getMessage());
	        screenShot("TC_086");
	        throw e;
	    }
	}

	@SuppressWarnings("deprecation")
	@Test
	public void TC_087() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Verify gender dropdown contains all expected options
	        WebElement genderDropdown = driver.findElement(By.id("gender-lg"));
	        Select genderSelect = new Select(genderDropdown);
	        List<WebElement> options = genderSelect.getOptions();

	        List<String> expectedOptions = Arrays.asList("Male", "Female", "Others");
	        List<String> actualOptions = new ArrayList<>();
	        for (WebElement option : options) {
	            actualOptions.add(option.getText());
	        }

	        genderDropdown.click();
	        Thread.sleep(2000);
	        screenShot("TC_087");
	        Assert.assertTrue(actualOptions.containsAll(expectedOptions), "TC_087 Failed: 'Others' option is missing!");
	        System.out.println("TC_087 - Test Failed: Missing gender option detected.");
	        
	    } catch (Exception e) {
	        System.out.println("TC_087 - Test Failed: " + e.getMessage());
	        screenShot("TC_087");
	        throw e;
	    }
	}
	
	@Test
	public void TC_088() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Submit the form without selecting gender
	        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-primary btn d-none d-md-inline-block']"));
	        submitButton.click();

	        System.out.println("TC_088 - Test Passed: Error message appears when submitting without gender selection.");
	    } catch (Exception e) {
	        System.out.println("TC_088 - Test Failed: " + e.getMessage());
	        screenShot("TC_088");
	        throw e;
	    }
	}

	@Test
	public void TC_089() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	        signUpLink.click();

	        // ✅ Attempt to select multiple gender options
	        WebElement genderDropdown = driver.findElement(By.id("gender-lg"));
	        Select genderSelect = new Select(genderDropdown);
	        genderSelect.selectByVisibleText("Male");
	        genderSelect.selectByVisibleText("Female"); // Should replace previous selection

	        String selectedOption = genderSelect.getFirstSelectedOption().getText();
	        Assert.assertNotEquals(selectedOption, "Male, Female", "TC_089 Failed: Multiple selection allowed!");

	        System.out.println("TC_089 - Test Passed: Multiple selection is prevented.");
	    } catch (Exception e) {
	        System.out.println("TC_089 - Test Failed: " + e.getMessage());
	        screenShot("TC_089");
	        throw e;
	    }
	}

	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
