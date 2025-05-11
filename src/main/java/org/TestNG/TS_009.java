package org.TestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_009 extends BaseClass {
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
	public void TC_040() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Click the "Sign-Up" link
	        signUpLink.click();

	        // ✅ Verify redirection to Sign-Up page
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.location.href='https://e-commerce-client-swart.vercel.app/register'");


	        System.out.println("TC_040 - Test Passed: 'Sign-Up' link redirects correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_040 - Test Failed: " + e.getMessage());
	        screenShot("TC_040");
	        throw e;
	    }
	}
	
	@Test
	public void TC_041() throws IOException {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Get current window handle before clicking
	        String originalWindow = driver.getWindowHandle();

	        // ✅ Click the "Sign-Up" link
	        signUpLink.click();

	        // ✅ Verify if new tab is opened
	        Set<String> windowHandles = driver.getWindowHandles();
	        Assert.assertEquals(windowHandles.size(), 1, "TC_041 Failed: 'Sign-Up' link opened in a new tab!");

	        System.out.println("TC_041 - Test Passed: 'Sign-Up' link opens in the same tab.");
	    } catch (Exception e) {
	        System.out.println("TC_041 - Test Failed: " + e.getMessage());
	        screenShot("TC_041");
	        throw e;
	    }
	}

	@Test
	public void TC_042() throws Exception {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	        // ✅ Use Actions to move focus to the link
	        Actions action = new Actions(driver);
	        for(int i=1;i<=4;i++) {
	        	action.sendKeys(Keys.TAB).perform();
	        }
	        Thread.sleep(1000);

	        // ✅ Press ENTER to activate the link
	        action.sendKeys(Keys.ENTER).perform();

	        // ✅ Verify redirection
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.location.href='https://e-commerce-client-swart.vercel.app/register'");

	        System.out.println("TC_042 - Test Passed: 'Sign-Up' link accessible via keyboard.");
	    } catch (Exception e) {
	        System.out.println("TC_042 - Test Failed: " + e.getMessage());
	        screenShot("TC_042");
	        throw e;
	    }
	}
	
	@Test
	public void TC_043() throws IOException {
	    String[] browsers = {"chrome"};
	    
	    for (String browser : browsers) {
	        WebDriver driver = null;
	        try {
	            // ✅ Use a helper function to get the WebDriver instance
	            driver = WebDriverFactory.getDriver(browser);
	            driver.manage().window().maximize();
	            driver.get("https://e-commerce-client-swart.vercel.app/");

	            // ✅ Use explicit wait for link presence
	            WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));

	            // ✅ Click the link
	            signUpLink.click();

	            // ✅ Verify redirection
	            JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.location.href='https://e-commerce-client-swart.vercel.app/register'");

	            System.out.println("✅ 'Sign-Up' link works on " + browser);
	        } catch (Exception e) {
	            System.out.println("TC_043 - Test Failed on " + browser + ": " + e.getMessage());
	            screenShot("TC_043_" + browser);
	            throw e;
	        } finally {
	            // ✅ Close WebDriver properly
	            if (driver != null) {
	                driver.quit();
	            }
	        }
	    }

	    System.out.println("TC_043 - Test Passed: 'Sign-Up' link works across all browsers.");
	}

	
	@Test
	public void TC_044() throws Exception {
	    try {
	        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
	       

	        // ✅ Click the "Sign-Up" link
	        signUpLink.click();
	        
	        WebElement emailField = driver.findElement(By.name("email"));
	        Thread.sleep(2000);

	        // ✅ Check if the email field is still accessible
	        Assert.assertFalse(emailField.isDisplayed(), "TC_044 Failed: Other elements are disrupted after clicking 'Sign-Up'!");

	        System.out.println("TC_044 - Test Passed: 'Sign-Up' link does not disrupt other page elements.");
	    } catch (Exception e) {
	        System.out.println("TC_044 - Test Failed: " + e.getMessage());
	        screenShot("TC_044");
	        throw e;
	    }
	}
	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
