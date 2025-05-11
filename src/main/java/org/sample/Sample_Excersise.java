package org.sample;

public class Sample_Excersise extends BaseClass {
	public static void main(String[] args) {
		launchBrowser();
		windowMaximize();
		launchUrl("https://www.facebook.com/");
		
		FbLoginPojo f = new FbLoginPojo();
		
		passText("Praveen", f.getEmail());
		passText("Praveen12", f.getPassword());
		
		driver.navigate().refresh();
		
		passText("ranjith", f.getEmail());
		passText("ranjith12", f.getPassword());
	}
}
