package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {

	public WebEventListener() throws IOException {
		super();

	}

	public void beforeNavigateTo(String url, WebDriver driver) {

		System.out.println("Before navigating to: '" + url + "'");

	}

	public void afterNavigateTo(String url, WebDriver driver) {

		System.out.println("After navigating to: '" + url + "'");

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {

		System.out.println("Value of the:" + element.toString() + "before any changes made");

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {

		System.out.println("Value of the:" + element.toString() + "before any changes made");

	}

	public void beforeClickOn(WebElement element, WebDriver driver) {

		System.out.println("Trying to click on:" + element.toString());

	}

	public void afterClickOn(WebElement element, WebDriver driver) {

		System.out.println("Clicked on: " + element.toString());

	}
	
	public void beforeNavigateBack(WebDriver driver) {
		
		System.out.println("Navigating back to previous page");

	}
	
	public void afterNavigateBack(WebDriver driver) {
		
		System.out.println("Navigated back to previous page");

	}
	
	public void beforeNavigateForward(WebDriver driver) {
		
		System.out.println("Navigating forward to next page");

	}
	
	public void afterNavigateForward(WebDriver driver) {
		
		System.out.println("Navigated forward to next page");

	}
	
	public void onException(Throwable error, WebDriver driver) {
		
		System.out.println("Exception occured:"+error);
		
		try {
			
			TestUtil.takeScreenShot();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("Trying to find element by: "+by.toString());

	}
	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println("Element found by: "+by.toString());

	}

	public void afterAlertAccept(WebDriver arg0) {

	}

	public void afterAlertDismiss(WebDriver arg0) {

	}

	public void afterNavigateRefresh(WebDriver arg0) {

	}

	public void afterScript(String arg0, WebDriver arg1) {

	}

	public void beforeAlertAccept(WebDriver arg0) {

	}

	public void beforeAlertDismiss(WebDriver arg0) {

	}

	public void beforeNavigateRefresh(WebDriver arg0) {

	}

	public void beforeScript(String arg0, WebDriver arg1) {

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
		
	}

}
