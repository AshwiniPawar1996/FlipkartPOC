package com.flipkart.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.pageobjects.HomePage;
import com.flipkart.pageobjects.LoginPage;
import com.flipkart.utility.Logs;

public class LoginTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup()
	{
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.close();
	
	}
	
	@Test
	public void LoginPageTest() throws InterruptedException
	{
		Logs.startTestCase("Login");
		loginPage = new LoginPage();
		loginPage.ClickOnCloseButton();
		Thread.sleep(5000);
		Logs.info("User is going login in Flipkart");
		loginPage.ClickOnLogin();
		Logs.info("User Will Enter UserName and Password");
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Logs.info("User Successfully Logged in into Flipkart");
		Logs.endTestCase("Login");
		
	}
	
}
