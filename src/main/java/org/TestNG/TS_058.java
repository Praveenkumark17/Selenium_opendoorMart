package org.TestNG;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_058 extends BaseClass{
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
	public void TC_283() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Product List Table Section  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Verify Data Loading in Table  
	        WebElement productTable = driver.findElement(By.xpath("//div[@class='product_table__hBkGm px-3']"));  
	        Assert.assertTrue(productTable.isDisplayed(), "TC_283 Failed: Product data did not load correctly!");  

	        System.out.println("TC_283 - Test Passed: Product data loads successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_283 - Test Failed: " + e.getMessage());  
	        screenShot("TC_283");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_284() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Product List Section  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Click Edit Button & Update Product  
	        WebElement editButton = driver.findElement(By.xpath("//table/tbody/tr[1]//td[6]//a"));  
	        editButton.click();  
	        Thread.sleep(2000);  

	        driver.findElement(By.name("quantity")).clear();  
	        driver.findElement(By.name("quantity")).sendKeys("3");  
	        driver.findElement(By.name("price")).clear();  
	        driver.findElement(By.name("price")).sendKeys("450");  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("C:\\Users\\Praveenkumar\\OneDrive\\Pictures\\Animated Profiles\\products\\download.jpg");
	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

	        WebElement productTable = driver.findElement(By.xpath("//div[@class='product_table__hBkGm px-3']"));  
	        Assert.assertTrue(productTable.isDisplayed(), "TC_284 Failed: Product details not updated!");  

	        System.out.println("TC_284 - Test Passed: Product details updated successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_284 - Test Failed: " + e.getMessage());  
	        screenShot("TC_284");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_285() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Product List Section  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Product']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Click Delete Button and Confirm  
	        WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr[1]//td[6]//button"));  
	        deleteButton.click();  
	        Thread.sleep(2000);  

	        WebElement productTable = driver.findElement(By.xpath("//div[@class='product_table__hBkGm px-3']"));  
	        Assert.assertFalse(productTable.isDisplayed(), "TC_285 Failed: Product not removed!");  

	        System.out.println("TC_285 - Test Passed: Product deleted successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_285 - Test Failed: " + e.getMessage());  
	        screenShot("TC_285");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_286() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Product List Section  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Search for a Specific Product  
	        WebElement searchBar = driver.findElement(By.name("search"));  
	        searchBar.sendKeys("Laptop");  
	        Thread.sleep(2000);  

	        WebElement productTable = driver.findElement(By.className("product-table"));  
	        Assert.assertTrue(productTable.getText().contains("Laptop"), "TC_286 Failed: Search function does not work!");  

	        System.out.println("TC_286 - Test Passed: Search function works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_286 - Test Failed: " + e.getMessage());  
	        screenShot("TC_286");  
	        throw e;  
	    }  
	}


	@Test
	public void TC_287() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Product List Section  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Use Pagination Controls  
	        WebElement nextPage = driver.findElement(By.xpath("//button[text()='Next']"));  
	        nextPage.click();  
	        Thread.sleep(2000);  

	        WebElement productTable = driver.findElement(By.className("product-table"));  
	        Assert.assertTrue(productTable.isDisplayed(), "TC_287 Failed: Pagination does not work correctly!");  

	        System.out.println("TC_287 - Test Passed: Pagination works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_287 - Test Failed: " + e.getMessage());  
	        screenShot("TC_287");  
	        throw e;  
	    }  
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
