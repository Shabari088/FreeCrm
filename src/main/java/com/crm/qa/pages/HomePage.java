package com.crm.qa.pages;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitlePage()
	{
		return driver.getTitle();
	}
	
	public Contacts onClickcontactsPage() throws IOException
	{
		
		
		contactsLink.click();
		
		return new Contacts();
	}
	
	public DealsPage onClickdealsPage()
	{
		
		
		DealsLink.click();
		
		return new DealsPage();
	}
	
	public TasksPage onClicktasksPage()
	{
		
		
		TasksLink.click();
		
		return new TasksPage();
	}
	

}
