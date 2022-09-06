package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.pageobjects.HomePage;
import com.flipkart.pageobjects.LoginPage;
import com.flipkart.utility.Logs;

public class HomePageTest extends BaseClass{


		
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
		public void MyAccountTest() throws InterruptedException
		{
			Logs.startTestCase("My Home Page");
			loginPage=new LoginPage();
			loginPage.ClickOnCloseButton();
			Logs.info("User will close the login Page Popup");
			Thread.sleep(2000);
			loginPage.ClickOnLogin();
			homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
			Thread.sleep(2000);
			Logs.info("User Successfully Logged in into Flipkart");
			boolean result=homePage.ValidateMyAccount();
			Assert.assertTrue(result);
			Logs.info("My Account tab is displayed");
			
			boolean result1=homePage.ValidateFirstName();
			Assert.assertTrue(result);
			Logs.info("First Name is verified");
			
			boolean result2=homePage.ValidateLastName();
			Assert.assertTrue(result);
			Logs.info("Last Name is verified");
			
			boolean result3=homePage.ValidateEamilId();
			Assert.assertTrue(result);
			Logs.info("Eamil id is verified" );
			
			
			Logs.endTestCase("My Home Page");
		}
	
}
