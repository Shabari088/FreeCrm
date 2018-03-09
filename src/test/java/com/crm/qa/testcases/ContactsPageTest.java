package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	public LoginPage loginpage ;
	public TestUtil testutil;
	public HomePage homepage;
	public Contacts contactpage;
	
	public String sheetName = "Contacts";

	public ContactsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void startUp() throws InterruptedException, IOException
	{
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		homepage = new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactpage = homepage.onClickcontactsPage();
	}
	
	@DataProvider
	public Object[][] getCrmTestData()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCrmTestData")
	public void fillform(String firstname,String surname,String mobile,String Emailid,String Date) throws IOException
	{
		contactpage.insertContacts(firstname, surname, mobile, Emailid,Date);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
