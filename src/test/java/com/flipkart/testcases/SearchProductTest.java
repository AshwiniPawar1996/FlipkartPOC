package com.flipkart.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.pageobjects.HomePage;
import com.flipkart.pageobjects.LoginPage;
import com.flipkart.pageobjects.SerachProductPage;
import com.flipkart.utility.Logs;

public class SearchProductTest extends BaseClass{

	LoginPage loginPage;
	HomePage homePage;
	SerachProductPage searchProductPage;
	
	@BeforeMethod
	public void setup()
	{
		launchApp();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	
	}
	@Test
	public void searchProductTestCase() throws InterruptedException
	{
		Logs.startTestCase("Search Product");
		searchProductPage= new SerachProductPage();
		Logs.info("User will close the login Popup");
		searchProductPage.ClickOnCloseButton();
		Thread.sleep(2000);
		Logs.info("User will Enter Product Name");
		searchProductPage.SearchProduct("REDMI 10");
		Logs.info("Product is successfully added in Cart");
		Logs.endTestCase("Search Product");
		
		
		
		
		
	    
	}
}
