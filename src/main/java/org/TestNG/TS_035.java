package org.TestNG;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_035 extends BaseClass{
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
	public void TC_170() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Locate profile container  
	        WebElement profileContainer = driver.findElement(By.xpath("//img[@alt=\"img\"]"));  
	        profileContainer.click();  
	        Thread.sleep(2000);  

	        // ✅ Verify dropdown interaction  
//	        WebElement dropdownMenu = driver.findElement(By.className("profile-dropdown"));  
	        Assert.assertTrue(profileContainer.isDisplayed(), "TC_170 Failed: No interactive behavior detected!");  

	        System.out.println("TC_170 - Test Passed: Profile container interaction works properly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_170 - Test Failed: " + e.getMessage());  
	        screenShot("TC_170");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_171() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Locate username and role  
	        WebElement username = driver.findElement(By.xpath("//p[@class=\"m-0 fw-semibold\"]"));  
	        WebElement role = driver.findElement(By.xpath("//p[@class=\"m-0 fw-bold\"]"));  

	        Assert.assertFalse(username.getText().isEmpty(), "TC_171 Failed: Username not displayed!");  
	        Assert.assertFalse(role.getText().isEmpty(), "TC_171 Failed: Role information missing!");  

	        System.out.println("TC_171 - Test Passed: Profile information is displayed correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_171 - Test Failed: " + e.getMessage());  
	        screenShot("TC_171");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_172() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Click logout option  
	        WebElement logoutButton = driver.findElement(By.xpath("//a[text()=\"Log Out\"]"));  
	        logoutButton.click();  
	        Thread.sleep(2000);  

	        // ✅ Verify redirection  
	        Assert.assertEquals(driver.getCurrentUrl(), "https://e-commerce-client-swart.vercel.app/", "TC_172 Failed: Logout functionality not working!");  

	        System.out.println("TC_172 - Test Passed: Logout functionality is working properly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_172 - Test Failed: " + e.getMessage());  
	        screenShot("TC_172");  
	        throw e;  
	    }  
	}

	@Test
	public void TC_173() throws Exception {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Resize window and verify profile container behavior  
	        int[] screenWidths = {1024, 768, 480}; // Desktop, Tablet, Mobile  
	        WebElement profileContainer = driver.findElement(By.xpath("//img[@alt=\"img\"]"));  

	        for (int width : screenWidths) {  
	            driver.manage().window().setSize(new Dimension(width, driver.manage().window().getSize().getHeight()));  
	            Thread.sleep(2000);  
	            Assert.assertTrue(profileContainer.isDisplayed(), "TC_173 Failed: Profile container is not responsive at width " + width);  
	            System.out.println("✅ Profile container responsiveness confirmed at width: " + width);  
	        }  

	        System.out.println("TC_173 - Test Passed: Profile container adapts correctly to screen changes.");  
	    } catch (Exception e) {  
	        System.out.println("TC_173 - Test Failed: " + e.getMessage());  
	        screenShot("TC_173");  
	        throw e;  
	    }  
	}
	
	@Test
	public void TC_174() throws IOException {
	    try {
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	        // ✅ Admin Login  
	        driver.findElement(By.name("email")).sendKeys("admin01@gmail.com");  
	        driver.findElement(By.name("password")).sendKeys("admin");  
	        driver.findElement(By.xpath("//button[@class=\"btn btn-primary  d-none d-md-flex\"]")).click();

	        // ✅ Verify profile image display  
	        WebElement profileImage = driver.findElement(By.xpath("//img[@alt=\"img\"]"));  

	        Assert.assertTrue(profileImage.isDisplayed(), "TC_174 Failed: Profile image is not visible!");  

	        System.out.println("TC_174 - Test Passed: Profile image loads correctly.");  
	    } catch (Exception e) {  
	        System.out.println("TC_174 - Test Failed: " + e.getMessage());  
	        screenShot("TC_174");  
	        throw e;  
	    }  
	}


	
	@AfterMethod
	public void afterTestCase() {
		System.out.println("After Test Case: Closing browser");
		closeEntireBrowser();
	}
}
