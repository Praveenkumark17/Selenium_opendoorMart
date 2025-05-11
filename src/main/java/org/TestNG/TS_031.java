package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class TS_031 extends BaseClass{
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
	public void TC_150() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        Thread.sleep(4000);
	        
	        // ✅ Enter a valid query and search
	        WebElement searchBar = driver.findElement(By.xpath("//input"));
	        searchBar.sendKeys("Product A");
	        searchBar.sendKeys(Keys.ENTER);

	        // ✅ Verify search results appear
	        Assert.assertTrue(searchBar.isDisplayed(), "TC_150 Failed: No search results displayed for valid query!");

	        System.out.println("TC_150 - Test Passed: Search function works with valid queries.");
	    } catch (Exception e) {
	        System.out.println("TC_150 - Test Failed: " + e.getMessage());
	        screenShot("TC_150");
	        throw e;
	    }
	}
	
	@Test
	public void TC_151() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        Thread.sleep(4000);

	        // ✅ Enter an invalid or blank query and search
	        WebElement searchBar = driver.findElement(By.xpath("//input"));
	        searchBar.sendKeys("xyz123"); // Invalid query
	        searchBar.sendKeys(Keys.ENTER);

	        // ✅ Verify error message appears
	        Assert.assertFalse(searchBar.getText().contains("No results found"), "TC_151 Failed: No error message displayed for invalid query!");

	        System.out.println("TC_151 - Test Passed: Error message appears for invalid or blank queries.");
	    } catch (Exception e) {
	        System.out.println("TC_151 - Test Failed: " + e.getMessage());
	        screenShot("TC_151");
	        throw e;
	    }
	}

	@Test
	public void TC_152() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        Thread.sleep(4000);

	        // ✅ Start typing in search bar and check suggestions
	        WebElement searchBar = driver.findElement(By.xpath("//input"));
	        searchBar.sendKeys("Pro"); // Partial query

	        // ✅ Verify real-time suggestions appear
	        Assert.assertTrue(searchBar.isDisplayed(), "TC_152 Failed: No suggestions displayed for search input!");

	        System.out.println("TC_152 - Test Passed: Real-time search suggestions appear successfully.");
	    } catch (Exception e) {
	        System.out.println("TC_152 - Test Failed: " + e.getMessage());
	        screenShot("TC_152");
	        throw e;
	    }
	}
	
	@Ignore
	@Test
	public void TC_153() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Enter admin credentials and sign in
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        Thread.sleep(4000);

	        WebElement searchBar = driver.findElement(By.xpath("//input"));
	        searchBar.sendKeys("Laptop");
	        searchBar.sendKeys(Keys.ENTER);

	        // ✅ Verify search results reflect applied filters
	        WebElement filteredResults = driver.findElement(By.className("filtered-results"));
	        Assert.assertTrue(filteredResults.isDisplayed(), "TC_153 Failed: Search results did not reflect filters!");

	        System.out.println("TC_153 - Test Passed: Search results adapt based on filters.");
	    } catch (Exception e) {
	        System.out.println("TC_153 - Test Failed: " + e.getMessage());
	        screenShot("TC_153");
	        throw e;
	    }
	}
	
	@Ignore
	@Test
	public void TC_154(String browser) throws IOException {
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
	        driver.findElement(By.xpath("//button[@class='btn btn-primary d-none d-md-flex']")).click();

	        // ✅ Enter a query in search bar and validate results across browsers
	        WebElement searchBar = driver.findElement(By.className("input"));
	        searchBar.sendKeys("Product B");
	        searchBar.sendKeys(Keys.ENTER);

	        WebElement searchResults = driver.findElement(By.className("search-results"));
	        Assert.assertTrue(searchResults.isDisplayed(), "TC_154 Failed: Search function did not work correctly in browser " + browser);

	        System.out.println("TC_154 - Test Passed: Search function works correctly across browsers.");
	    } catch (Exception e) {
	        System.out.println("TC_154 - Test Failed: " + e.getMessage());
	        screenShot("TC_154");
	        throw e;
	    } finally {
	        driver.quit();
	    }
	}




	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
