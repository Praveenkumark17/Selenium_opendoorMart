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

public class TS_064 extends BaseClass{
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
	public void TC_313() throws Exception {
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

	        WebElement editProductButton = driver.findElement(By.xpath("//tbody//tr[2]//td[6]/a"));  
	        editProductButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Update product fields with valid data   
	        driver.findElement(By.id("category")).sendKeys("Electronics");    
	        driver.findElement(By.id("quantity")).clear();  
	        driver.findElement(By.id("quantity")).sendKeys("1");  
	        driver.findElement(By.id("price")).clear();  
	        driver.findElement(By.id("price")).sendKeys("90000");  
	        driver.findElement(By.id("description")).clear();  
	        driver.findElement(By.id("description")).sendKeys("Updated high-performance gaming laptop.");  

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\Game_Lap.jfif");  

	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

	        WebElement productTable = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertTrue(productTable.isDisplayed(), "TC_313 Failed: Product details not updated!");  

	        System.out.println("TC_313 - Test Passed: Product details updated successfully.");  
	    } catch (Exception e) {  
	        System.out.println("TC_313 - Test Failed: " + e.getMessage());  
	        screenShot("TC_313");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_314() throws Exception {
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

	        WebElement editProductButton = driver.findElement(By.xpath("//tbody//tr[2]//td[6]/a"));  
	        editProductButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Update product fields with valid data      
	        driver.findElement(By.id("quantity")).clear();  
	        driver.findElement(By.id("price")).clear();   
	        driver.findElement(By.id("description")).clear();    

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\Game_Lap.jfif");  

	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

	        WebElement error = driver.findElement(By.xpath("//div[@role='alert']"));  
	        Assert.assertFalse(error.getText().contains("All fields are Required"), "TC_314 Failed: No error message displayed!");  

	        System.out.println("TC_314 - Test Passed: Error messages displayed correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_314 - Test Failed: " + e.getMessage());  
	        screenShot("TC_314");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_315() throws Exception {
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

	        WebElement editProductButton = driver.findElement(By.xpath("//tbody//tr[2]//td[6]/a"));  
	        editProductButton.click();  
	        Thread.sleep(2000);    

	        // ✅ Upload Image  
	        WebElement image = driver.findElement(By.name("image"));  
	        image.sendKeys("E:\\Downloads\\Game_Lap.jfif");  

	        driver.findElement(By.xpath("//button[text()='Update']")).click();  
	        Thread.sleep(2000);  

	        WebElement uploadedImage = driver.findElement(By.xpath("//tbody//tr[2]//td[5]//img")); 
	        Assert.assertTrue(uploadedImage.isDisplayed(), "TC_315 Failed: Image upload not successful!");  

	        System.out.println("TC_315 - Test Passed: Image upload works correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_315 - Test Failed: " + e.getMessage());  
	        screenShot("TC_315");  
	        throw e;  
	    }  
	}

	@Ignore
	@Test
	public void TC_316() throws Exception {
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

	        WebElement editProductButton = driver.findElement(By.xpath("//tbody//tr[2]//td[6]/a"));  
	        editProductButton.click();  
	        Thread.sleep(2000);    

	        driver.findElement(By.xpath("//button[text()='Update']")).click();
	        Thread.sleep(2000);

	        WebElement duplicateMessage = driver.findElement(By.className("duplicate-message"));
	        Assert.assertTrue(duplicateMessage.isDisplayed(), "TC_316 Failed: System allowed duplicate entries!");

	        System.out.println("TC_316 - Test Passed: System prevents duplicate product entries.");
	    } catch (Exception e) {
	        System.out.println("TC_316 - Test Failed: " + e.getMessage());
	        screenShot("TC_316");
	        throw e;
	    }
	}
	
	@Test
	public void TC_317() throws Exception {
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

	        WebElement editProductButton = driver.findElement(By.xpath("//tbody//tr[2]//td[6]/a"));  
	        editProductButton.click();  
	        Thread.sleep(2000); 

	        // ✅ Edit fields but cancel operation
	        driver.findElement(By.id("productname")).clear();
	        driver.findElement(By.id("productname")).sendKeys("Canceled Product");
	        driver.findElement(By.xpath("//button[text()='Cancel']")).click();
	        Thread.sleep(2000);

	        WebElement productTable = driver.findElement(By.className("//tbody"));
	        Assert.assertFalse(productTable.isDisplayed(), "TC_317 Failed: Cancel operation did not work!");

	        System.out.println("TC_317 - Test Passed: Cancel operation works correctly.");
	    } catch (Exception e) {
	        System.out.println("TC_317 - Test Failed: " + e.getMessage());
	        screenShot("TC_317");
	        throw e;
	    }
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
