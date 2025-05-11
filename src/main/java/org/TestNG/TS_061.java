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

public class TS_061 extends BaseClass{
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
	public void TC_298() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Product Form  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        WebElement addProductButton = driver.findElement(By.xpath("//a[text()='Add Product']"));  
	        addProductButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Fill form with valid data  
	        driver.findElement(By.id("category")).sendKeys("Electronics");  
	        driver.findElement(By.id("productname")).sendKeys("Gaming Laptop");
	        driver.findElement(By.id("quantity")).sendKeys("1");  
	        driver.findElement(By.id("price")).sendKeys("86000");  
	        driver.findElement(By.id("description")).sendKeys("High-performance gaming laptop.");  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\\\Downloads\\\\Game_Lap.jfif");  

	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement validation = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(validation.getText().contains("product added success"), "TC_298 Failed: Product not added!");  

	        System.out.println("TC_298 - Test Passed: Product added successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_298 - Test Failed: " + e.getMessage());  
	        screenShot("TC_298");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_299() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Product Form  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        WebElement addProductButton = driver.findElement(By.xpath("//a[text()='Add Product']"));  
	        addProductButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Fill form with valid data  
	        driver.findElement(By.id("category")).sendKeys("Electronics");  
	        driver.findElement(By.id("productname")).sendKeys("Gaming Laptop");
	        driver.findElement(By.id("quantity")).sendKeys("");  
	        driver.findElement(By.id("price")).sendKeys("");  
	        driver.findElement(By.id("description")).sendKeys("High-performance gaming laptop.");  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\\\Downloads\\\\Game_Lap.jfif");  

	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement validation = driver.findElement(By.xpath("//div[@role='alert']"));    
	        Assert.assertTrue(validation.isDisplayed(), "TC_299 Failed: No error message displayed!");  

	        System.out.println("TC_299 - Test Passed: Error messages displayed correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_299 - Test Failed: " + e.getMessage());  
	        screenShot("TC_299");  
	        throw e;  
	    }  
	}

	@Ignore
	@Test
	public void TC_300() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Product Form  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Product']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        WebElement addProductButton = driver.findElement(By.xpath("//a[text()='Add Product']"));  
	        addProductButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\valid-product-image.png");  

	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement uploadedImage = driver.findElement(By.className("image-preview"));  
	        Assert.assertTrue(uploadedImage.isDisplayed(), "TC_300 Failed: Image upload not successful!");  

	        System.out.println("TC_300 - Test Passed: Image upload works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_300 - Test Failed: " + e.getMessage());  
	        screenShot("TC_300");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_301() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Product Form  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        WebElement addProductButton = driver.findElement(By.xpath("//a[text()='Add Product']"));  
	        addProductButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Fill form with valid data  
	        driver.findElement(By.id("productname")).sendKeys("Gaming Laptop");
	        driver.findElement(By.id("quantity")).sendKeys("1");  
	        driver.findElement(By.id("price")).sendKeys("86000");  
	        driver.findElement(By.id("description")).sendKeys("High-performance gaming laptop.");  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\\\Downloads\\\\Game_Lap.jfif");  

	        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
	        Thread.sleep(2000);  

	        WebElement validation = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(validation.getText().contains("All fields are required"), "TC_301 Failed: System allowed duplicate entries!");  

	        System.out.println("TC_301 - Test Passed: System prevents duplicate product entries.");  
	    } catch (Exception e) {  
	        System.out.println("TC_301 - Test Failed: " + e.getMessage());  
	        screenShot("TC_301");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_302() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();  

	        // ✅ Navigate to Add Product Form  
	        WebElement productPage = driver.findElement(By.xpath("//li/a[text()='Products']"));  
	        productPage.click();  
	        Thread.sleep(2000);  

	        WebElement addProductButton = driver.findElement(By.xpath("//a[text()='Add Product']"));  
	        addProductButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Fill form with valid data  
	        driver.findElement(By.id("productname")).sendKeys("Gaming Laptop");
	        driver.findElement(By.id("quantity")).sendKeys("1");  
	        driver.findElement(By.id("price")).sendKeys("86000");  
	        driver.findElement(By.id("description")).sendKeys("High-performance gaming laptop.");  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\\\Downloads\\\\Game_Lap.jfif");
	        
	        driver.findElement(By.xpath("//a[text()='Back']")).click();

	        WebElement productTable = driver.findElement(By.xpath("//div[@class='product_table__hBkGm px-3']"));  
	        Assert.assertTrue(productTable.isDisplayed(), "TC_302 Failed: Cancel operation did not work!");  

	        System.out.println("TC_302 - Test Passed: Cancel operation works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_302 - Test Failed: " + e.getMessage());  
	        screenShot("TC_302");  
	        throw e;  
	    }  
	}

	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
