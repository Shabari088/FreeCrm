package com.crm.qa.pages;

import java.io.IOException;

//import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// page factory ---- OR(object Repository)
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//div[a[img[contains(@class,'img-responsive')]]]/button/following-sibling::a/img")
	WebElement logo;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signIn;

	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public  String crmTitleTest()
	{
		return driver.getTitle();
	}
	
	public  boolean crmLogoTest()
	{
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException, IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		loginBtn.click();
		
		return new HomePage();
	}

}
