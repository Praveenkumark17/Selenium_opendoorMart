package org.TestNG;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_049 extends BaseClass{
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
	public void TC_239() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();     

	        // ✅ Navigate to Category List Table Section  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Verify Data Loading  
	        WebElement categoryTable = driver.findElement(By.xpath("//div[@class='category_table__syMJP px-3']"));  
	        Assert.assertTrue(categoryTable.isDisplayed(), "TC_239 Failed: Category data did not load correctly!");  

	        System.out.println("TC_239 - Test Passed: Category data loads successfully in the table.");  
	    } catch (Exception e) {  
	        System.out.println("TC_239 - Test Failed: " + e.getMessage());  
	        screenShot("TC_239");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_240() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Category List Table Section  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Click Edit Button and Update Category  
	        WebElement editButton = driver.findElement(By.xpath("//table/tbody/tr[1]//td[5]//a[text()='Edit']"));  
	        editButton.click();  
	        Thread.sleep(2000);  

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement brandDropdown = driver.findElement(By.xpath("//select[@name='brand']"));
	        brandDropdown.click();
	        
	        Thread.sleep(2000);  

	        // Select an option (modify the XPath based on your dropdown structure)
	        WebElement option = driver.findElement(By.xpath("//option[text()='Nestle']")); 
	        option.click();
	        
	        WebElement image = driver.findElement(By.name("image"));
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");

	        // Click the Update button
	        driver.findElement(By.xpath("//button[text()='Update']")).click();
	        Thread.sleep(2000);
  

	        WebElement categoryTable = driver.findElement(By.xpath("//tbody//tr//td"));  
	        Assert.assertTrue(categoryTable.getText().contains("Nestle"), "TC_240 Failed: Category details not updated!");  

	        System.out.println("TC_240 - Test Passed: Category details updated successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_240 - Test Failed: " + e.getMessage());  
	        screenShot("TC_240");  
	        throw e;  
	    }  
	}
	
	
	@Ignore
	@Test
	public void TC_241() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Category List Table Section  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Click Delete Button and Confirm  
	        WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr[1]//a[@text()='Delete']"));  
	        deleteButton.click();  
	        Thread.sleep(2000);  

	        WebElement categoryTable = driver.findElement(By.className("category-table"));  
	        Assert.assertFalse(categoryTable.getText().contains("Deleted Category"), "TC_241 Failed: Category not removed!");  

	        System.out.println("TC_241 - Test Passed: Category deleted successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_241 - Test Failed: " + e.getMessage());  
	        screenShot("TC_241");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_242() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Category List Table Section  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000); 
	        
	        WebElement addcategoryPage = driver.findElement(By.xpath("//a[text()='Add Category']"));  
	        addcategoryPage.click();  
	        Thread.sleep(2000);
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        WebElement brandDropdown = driver.findElement(By.xpath("//select[@name='brand']"));
	        brandDropdown.click();
	        
	        Thread.sleep(2000);  

	        // Select an option (modify the XPath based on your dropdown structure)
	        WebElement option = driver.findElement(By.xpath("//option[text()='Nestle']")); 
	        option.click();
	        
	        WebElement image = driver.findElement(By.name("image"));
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");

	        // ✅ Attempt to Add Duplicate Category  
	        driver.findElement(By.id("categoryName")).sendKeys("Chocolate");  
	        driver.findElement(By.id("brandDescription")).sendKeys("Chocolate"); 
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement duplicateMessage = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(duplicateMessage.isDisplayed(), "TC_242 Failed: System allowed duplicate entries!");  

	        System.out.println("TC_242 - Test Passed: System prevents duplicate category entries.");  
	    } catch (Exception e) {  
	        System.out.println("TC_242 - Test Failed: " + e.getMessage());  
	        screenShot("TC_242");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_243() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Category List Table Section  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        // ✅ Use Search Bar to Find Category  
	        WebElement searchBar = driver.findElement(By.name("search"));  
	        searchBar.sendKeys("Electronics");  
	        Thread.sleep(2000);  

	        WebElement categoryTable = driver.findElement(By.className("category-table"));  
	        Assert.assertTrue(categoryTable.getText().contains("Electronics"), "TC_243 Failed: Search function does not work!");  

	        System.out.println("TC_243 - Test Passed: Search function works correctly for categories.");  
	    } catch (Exception e) {  
	        System.out.println("TC_243 - Test Failed: " + e.getMessage());  
	        screenShot("TC_243");  
	        throw e;  
	    }  
	}



	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
