package com.flipkart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.action.ActionClass;
import com.flipkart.base.BaseClass;

public class SerachProductPage extends BaseClass{
	
	
	@FindBy(xpath= "//input[@class='_3704LK']")
	WebElement SearchProductBox;
	
	@FindBy(xpath= "//button[@class='L0Z3Pu']")
	WebElement SearchButton;
	
	@FindBy(xpath= "/html/body/div[2]/div/div/button")
	WebElement CloseButton;
	
	@FindBy(xpath= "//div[contains(text(),'REDMI 10')]")
	WebElement Product;
	
	@FindBy(xpath= "//button[text()='ADD TO CART']")
	WebElement AddToCart;
	
	@FindBy(xpath= "//span[text()='Place Order']")
	WebElement PlaceOrder;
	
	
	public SerachProductPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	public void ClickOnCloseButton()
	{
		ActionClass.click(driver,CloseButton);
	}
	
	public void SearchProduct(String ProductName) throws InterruptedException
	{
		ActionClass.type(SearchProductBox, ProductName);
	    Thread.sleep(2000);
	    ActionClass.click(driver, SearchButton);
	    Thread.sleep(2000);
	    ActionClass.click(driver, Product);
	    Thread.sleep(2000);
	    String winHandleBefore = driver.getWindowHandle();
	    for(String winHandle : driver.getWindowHandles()){
	       driver.switchTo().window(winHandle);
	    }
	    ActionClass.click(driver, AddToCart);
	    Thread.sleep(2000);
	    
	    
	}
	

	}
