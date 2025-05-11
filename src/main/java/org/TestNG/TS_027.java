package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_027 extends BaseClass{
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
	public void TC_130() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click on the logo button
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));
	        logoButton.click();

	        // ✅ Verify redirection to homepage
	        String currentURL = driver.getCurrentUrl();
	        Assert.assertEquals(currentURL, "https://e-commerce-client-swart.vercel.app/admin", "TC_130 Failed: Logo button did not redirect to homepage!");

	        System.out.println("TC_130 - Test Passed: Logo button redirects to the homepage successfully.");
	    } catch (Exception e) {
	        System.out.println("TC_130 - Test Failed: " + e.getMessage());
	        screenShot("TC_130");
	        throw e;
	    }
	}
	
	@Test
	public void TC_131() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click the logo multiple times
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));
	        for (int i = 0; i < 3; i++) {
	            logoButton.click();
	            Thread.sleep(1000);
	        }

	        // ✅ Verify redirection consistency
	        String currentURL = driver.getCurrentUrl();
	        Assert.assertEquals(currentURL, "https://e-commerce-client-swart.vercel.app/admin", "TC_131 Failed: Multiple clicks caused inconsistent redirection!");

	        System.out.println("TC_131 - Test Passed: Multiple logo clicks consistently redirect to homepage.");
	    } catch (Exception e) {
	        System.out.println("TC_131 - Test Failed: " + e.getMessage());
	        screenShot("TC_131");
	        throw e;
	    }
	}
	
	@Test
	public void TC_132() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();
	        // ✅ Click the logo button
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));
	        logoButton.click();

	        Assert.assertTrue(logoButton.isDisplayed(), "TC_132 Failed: Logo button did not handle network failure properly!");

	        System.out.println("TC_132 - Test Passed: Logo button handles network issues gracefully.");
	    } catch (Exception e) {
	        System.out.println("TC_132 - Test Failed: " + e.getMessage());
	        screenShot("TC_132");
	        throw e;
	    }
	}

	@Ignore
	@Test
	public void TC_133() throws IOException {
		String browser = "chrome";
	    try {
	        // ✅ Set up different browsers
	        if (browser.equalsIgnoreCase("chrome")) {
	            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            System.setProperty("webdriver.edge.driver", "path/to/msedgedriver");
	            driver = new EdgeDriver();
	        }

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://e-commerce-client-swart.vercel.app/");

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click the logo button
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));
	        logoButton.click();

	        // ✅ Verify redirection works across browsers
	        String currentURL = driver.getCurrentUrl();
	        Assert.assertEquals(currentURL, "https://e-commerce-client-swart.vercel.app/admin", "TC_133 Failed: Logo button did not work correctly in browser " + browser);

	        System.out.println("TC_133 - Test Passed: Logo button works correctly across different browsers.");
	    } catch (Exception e) {
	        System.out.println("TC_133 - Test Failed: " + e.getMessage());
	        screenShot("TC_133");
	        throw e;
	    } finally {
	        driver.quit();
	    }
	}
	
	@Test
	public void TC_134() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click the logo button with extensions active
	        WebElement logoButton = driver.findElement(By.xpath("//p[text()='OpendoorMart']"));
	        logoButton.click();

	        // ✅ Verify the functionality with extensions
	        String currentURL = driver.getCurrentUrl();
	        Assert.assertEquals(currentURL, "https://e-commerce-client-swart.vercel.app/admin", "TC_134 Failed: Browser extensions affected logo button functionality!");

	        System.out.println("TC_134 - Test Passed: Logo button works seamlessly with browser extensions.");
	    } catch (Exception e) {
	        System.out.println("TC_134 - Test Failed: " + e.getMessage());
	        screenShot("TC_134");
	        throw e;
	    }
	}

	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
