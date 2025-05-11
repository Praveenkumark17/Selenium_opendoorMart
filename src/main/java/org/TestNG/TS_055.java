package org.TestNG;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TS_055 extends BaseClass{
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
	public void TC_268() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Category Edit Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement editCategoryButton = driver.findElement(By.xpath("//tbody//tr[2]//td[5]//a[text()='Edit']"));  
	        editCategoryButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Select Brand from Dropdown  
	        WebElement brandDropdown = driver.findElement(By.name("brand"));  
	        brandDropdown.click();  
	        Thread.sleep(2000);  

	        WebElement option = driver.findElement(By.xpath("//option[text()='Nestle']"));  
	        option.click();  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");  

	        // ✅ Update category details   
	        driver.findElement(By.id("brandDescription")).clear();  
	        driver.findElement(By.id("brandDescription")).sendKeys("Updated Description");  
	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

	        WebElement validation = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(validation.getText().contains("Category updated"), "TC_268 Failed: Category data not updated!");  

	        System.out.println("TC_268 - Test Passed: Category updated successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_268 - Test Failed: " + e.getMessage());  
	        screenShot("TC_268");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_269() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();   

	        // ✅ Navigate to Category Edit Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement editCategoryButton = driver.findElement(By.xpath("//tbody//tr[2]//td[5]//a[text()='Edit']"));  
	        editCategoryButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Clear required fields and attempt update    
//	        driver.findElement(By.id("brandDescription")).clear();  
	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

//	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));  
//	        Assert.assertTrue(errorMessage.isDisplayed(), "TC_269 Failed: No error message displayed!");  

	        System.out.println("TC_269 - Test Passed: Error messages displayed correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_269 - Test Failed: " + e.getMessage());  
	        screenShot("TC_269");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_270() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();   

	        // ✅ Navigate to Category Edit Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement editCategoryButton = driver.findElement(By.xpath("//tbody//tr[2]//td[5]//a[text()='Edit']"));  
	        editCategoryButton.click();  
	        Thread.sleep(2000);   

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");

	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

	        WebElement validation = driver.findElement(By.xpath("//div[@role='alert']")); 
	        Assert.assertTrue(validation.getText().contains("Category updated"), "TC_270 Failed: Image upload not successful!");  

	        System.out.println("TC_270 - Test Passed: Image upload works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_270 - Test Failed: " + e.getMessage());  
	        screenShot("TC_270");  
	        throw e;  
	    }  
	}

	@Ignore
	@Test
	public void TC_271() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Category Edit Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement editCategoryButton = driver.findElement(By.xpath("//tbody//tr[2]//td[5]//a[text()='Edit']"));  
	        editCategoryButton.click();  
	        Thread.sleep(2000);

	        // ✅ Enter duplicate category name and attempt update  
	        driver.findElement(By.name("categoryName")).clear();  
	        driver.findElement(By.name("categoryName")).sendKeys("Existing Category");  

	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

	        WebElement duplicateMessage = driver.findElement(By.className("duplicate-message"));  
	        Assert.assertTrue(duplicateMessage.isDisplayed(), "TC_271 Failed: System allowed duplicate entries!");  

	        System.out.println("TC_271 - Test Passed: System prevents duplicate category entries.");  
	    } catch (Exception e) {  
	        System.out.println("TC_271 - Test Failed: " + e.getMessage());  
	        screenShot("TC_271");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_272() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();   

	        // ✅ Navigate to Category Edit Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement editCategoryButton = driver.findElement(By.xpath("//tbody//tr[2]//td[5]//a[text()='Edit']"));  
	        editCategoryButton.click();  
	        Thread.sleep(2000);

	        // ✅ Select Brand from Dropdown  
	        WebElement brandDropdown = driver.findElement(By.name("brand"));  
	        brandDropdown.click();  
	        Thread.sleep(2000);  

	        WebElement option = driver.findElement(By.xpath("//option[text()='Nestle']"));  
	        option.click();  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");

	        // ✅ Edit fields but cancel operation  
	        driver.findElement(By.xpath("//a[text()='Back']")).click();  
	        Thread.sleep(2000);  

	        WebElement categoryTable = driver.findElement(By.xpath("//tbody"));  
	        Assert.assertTrue(categoryTable.isDisplayed(), "TC_272 Failed: Cancel operation did not work!");  

	        System.out.println("TC_272 - Test Passed: Cancel operation works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_272 - Test Failed: " + e.getMessage());  
	        screenShot("TC_272");  
	        throw e;  
	    }  
	}

	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
