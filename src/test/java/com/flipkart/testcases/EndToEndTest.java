package com.flipkart.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.BaseClass;
import com.flipkart.pageobjects.HomePage;
import com.flipkart.pageobjects.LoginPage;
import com.flipkart.pageobjects.OrderSummary;
import com.flipkart.pageobjects.SerachProductPage;
import com.flipkart.utility.Logs;

public class EndToEndTest extends BaseClass {
	
	LoginPage loginPage;
	HomePage homePage;
	SerachProductPage searchProductPage;
	OrderSummary orderSummary;
	
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
	public void EndToEndTestCase() throws InterruptedException
	{
		Logs.startTestCase("End To End Test Case");
		loginPage = new LoginPage();
		loginPage.ClickOnCloseButton();
		Thread.sleep(5000);
		Logs.info("User is going login in Flipkart");
		loginPage.ClickOnLogin();
		Logs.info("User Will Enter UserName and Password");
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		Logs.info("User Successfully Logged in into Flipkart");
		searchProductPage= new SerachProductPage();
		Thread.sleep(2000);
		Logs.info("User will Enter Product Name");
		searchProductPage.SearchProduct("REDMI 10");
		Logs.info("Product is successfully added in Cart");
		
		orderSummary= new OrderSummary();
		
		orderSummary.AddToCart();
		Logs.info("Order Placed Successfully");
		
		Logs.info("Enter New Address");
		Thread.sleep(10000);
		orderSummary.AddNewAddress("Ashwini Pawar", "8286830936", "411028", "Hadapsar", "BhekraiNagar", "Pune");
		
		Logs.info("Address Added successfully");
		
		Logs.info("Select Payment Method");
		
		orderSummary.MakePayment();
		
		Logs.info("Payment Done...");
		Logs.info("Order Placed Successfully...");
		Logs.endTestCase("End To End Test Case");
		
		
	}
}

	
