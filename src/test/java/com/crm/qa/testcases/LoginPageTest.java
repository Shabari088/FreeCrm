package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	public static LoginPage login;
	
	public HomePage homepage;
	
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login = new LoginPage(); 
		log.info("*********Chrome is starting*************");
	}
	
	@Test(priority=1)
	public  void loginPageTitleTest()
	{
		String title = login.crmTitleTest();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void logoTest()
	{
		boolean flag = login.crmLogoTest();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void Login() throws InterruptedException, IOException
	{
		homepage = login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
