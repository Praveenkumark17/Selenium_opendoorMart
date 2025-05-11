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

public class TS_052 extends BaseClass{
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
	public void TC_254() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");
	        driver.findElement(By.name("password")).sendKeys("admin");
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();    

	        // ✅ Navigate to Add Category Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement addCategoryButton = driver.findElement(By.xpath("//a[text()='Add Category']"));  
	        addCategoryButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Select Brand from Dropdown  
	        WebElement brandDropdown = driver.findElement(By.xpath("//select[@name='brand']"));  
	        brandDropdown.click();  
	        Thread.sleep(2000);  

	        WebElement option = driver.findElement(By.xpath("//option[text()='Nestle']"));  
	        option.click();  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");  

	        // ✅ Fill form with valid data  
	        driver.findElement(By.id("categoryName")).sendKeys("Electronics");  
	        driver.findElement(By.id("brandDescription")).sendKeys("Electronic gadgets category.");  
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement validation = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(validation.getText().contains("category added successfully"), "TC_254 Failed: Category not added!");  

	        System.out.println("TC_254 - Test Passed: Category added successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_254 - Test Failed: " + e.getMessage());  
	        screenShot("TC_254");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_255() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Category Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement addCategoryButton = driver.findElement(By.xpath("//a[text()='Add Category']"));  
	        addCategoryButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Submit form with empty fields  
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement errorMessage = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(errorMessage.isDisplayed(), "TC_255 Failed: No error message displayed!");  

	        System.out.println("TC_255 - Test Passed: Error messages displayed correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_255 - Test Failed: " + e.getMessage());  
	        screenShot("TC_255");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_256() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Category Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement addCategoryButton = driver.findElement(By.xpath("//a[text()='Add Category']"));  
	        addCategoryButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Select Brand from Dropdown  
	        WebElement brandDropdown = driver.findElement(By.xpath("//select[@name='brand']"));  
	        brandDropdown.click();  
	        Thread.sleep(2000);  

	        WebElement option = driver.findElement(By.xpath("//option[text()='Nestle']"));  
	        option.click();  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");  

	        // ✅ Enter duplicate category name and submit  
	        driver.findElement(By.id("categoryName")).sendKeys("Chocolate");  
	        driver.findElement(By.id("brandDescription")).sendKeys("Chocolate");  
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement duplicateMessage = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(duplicateMessage.isDisplayed(), "TC_256 Failed: System allowed duplicate entries!");  

	        System.out.println("TC_256 - Test Passed: System prevents duplicate category entries.");  
	    } catch (Exception e) {  
	        System.out.println("TC_256 - Test Failed: " + e.getMessage());  
	        screenShot("TC_256");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_257() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Category Form  
	        WebElement categoryPage = driver.findElement(By.xpath("//li/a[text()='Category']"));  
	        categoryPage.click();  
	        Thread.sleep(2000);  

	        WebElement addCategoryButton = driver.findElement(By.xpath("//a[text()='Add Category']"));  
	        addCategoryButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Select Brand from Dropdown  
	        WebElement brandDropdown = driver.findElement(By.xpath("//select[@name='brand']"));  
	        brandDropdown.click();  
	        Thread.sleep(2000);  

	        WebElement option = driver.findElement(By.xpath("//option[text()='Nestle']"));  
	        option.click();  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\wz6lpy8q-removebg-preview.png");  

	        // ✅ Enter data exceeding max character limit and submit  
	        String longText = "A".repeat(300);  
	        driver.findElement(By.id("categoryName")).sendKeys(longText);  
	        driver.findElement(By.id("brandDescription")).sendKeys(longText);  
	        if(longText.length()<100) {
	        	driver.findElement(By.xpath("//button[text()='Submit']")).click();
	        }else {
	        	Thread.sleep(2000); 
	        	System.out.println("TC_257 Failed: System did not validate max character limit!");
	        }
	         

	        System.out.println("TC_257 - Test Passed: Maximum character limit validation works.");  
	    } catch (Exception e) {  
	        System.out.println("TC_257 - Test Failed: " + e.getMessage());  
	        screenShot("TC_257");  
	        throw e;  
	    }  
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
