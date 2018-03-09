package com.crm.qa.testcases;

import java.io.IOException;
//import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;
//import com.crm.qa.pages.UpgradeAccountPage;

public class HomePageTest extends TestBase{
	
	public LoginPage loginpage;
	public HomePage homepage;
	public Contacts contactsPage;
	public TasksPage taskspage;
	public DealsPage dealspage;
	public TestUtil testutil;

	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void startUp() throws IOException, InterruptedException
	{
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
	}
	
	
	@Test(priority=1)
	public void verifyTitleTest()
	{
		String title = homepage.verifyTitlePage();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void contactsLinkTest() throws IOException
	{
		homepage.onClickcontactsPage();
		boolean b = driver.findElement(By.xpath("//td[contains(text(),'Contacts')]")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void dealsLinkTest()
	{
		homepage.onClickdealsPage();
		boolean b = driver.findElement(By.xpath("//td[contains(text(),'State: Open ')]")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Test(priority=4)
	public void tasksLinkTest()
	{
		homepage.onClicktasksPage();
		boolean b = driver.findElement(By.xpath("//em[contains(text(),'Showing all tasks')]")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
