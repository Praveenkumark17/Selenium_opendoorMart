package org.sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPojo extends BaseClass {
	// 1. Non Parameterized Constructor
	public FbLoginPojo() {
		 PageFactory.initElements (driver, this) ;
	}
	
	@FindBy(id="email") // Located the email field in facebook login page
	private WebElement email;
	
	@FindBy(xpath="//input[@name=\"pass\"]")
	private WebElement password;
	
	@FindBy(name="pass")
	private WebElement loginBtn;

	// 3. getter for private web element
	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
