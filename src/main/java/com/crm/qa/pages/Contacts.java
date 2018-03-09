package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.ContactsPageTest;

public class Contacts extends TestBase{
	
	@FindBy(xpath = "//input[@value='New Contact']")
	WebElement newcontactbutton;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="f_trigger_c_birthday")
	WebElement birthday;
	
	@FindBy(xpath = "//input[@value='Save and Create Another (same company)']")
	WebElement savebutton;
	
	public Contacts() throws IOException {

		PageFactory.initElements(driver, this);
	}
	
	public void dateOfBirth(WebElement element,WebDriver driver,String dateval)
	{
		js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateval+"')", element);
	}
	public ContactsPageTest insertContacts(String fn,String sn,String mob,String emailid,String date) throws IOException
	{
		newcontactbutton.click();
		
		firstname.sendKeys(fn);
		surname.sendKeys(sn);
		mobile.sendKeys(mob);
		email.sendKeys(emailid);
		WebElement birthday = driver.findElement(By.id("fieldId_birthday"));
		dateOfBirth(birthday, driver,date);
		savebutton.click();
		
		return new ContactsPageTest();
	}
	

}
