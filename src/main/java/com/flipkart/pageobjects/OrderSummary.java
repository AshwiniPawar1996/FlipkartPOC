package com.flipkart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.action.ActionClass;
import com.flipkart.base.BaseClass;

public class OrderSummary extends BaseClass{
	
	@FindBy(xpath= "//span[text()='Place Order']")
	WebElement PlaceOrder;
    
	@FindBy(xpath= "//button[@class='_32l7f0']")
	WebElement ChangeAddress;
	
	@FindBy(xpath= "//img[@class='_2oAAg8']")
	WebElement AddAddress;
	
	@FindBy(xpath= "//input[@name='name']")
	WebElement EnterName;
	
	@FindBy(xpath= "//input[@name='phone']")
	WebElement EnterMobileNumber;
	
	@FindBy(xpath= "//input[@name='pincode']")
	WebElement EnterPincode;
	
	@FindBy(xpath= "//input[@name='addressLine2']")
	WebElement EnterLocality;
	
	@FindBy(xpath= "//textarea[@name='addressLine1']")
	WebElement EnterAddress;
	
	@FindBy(xpath= "//input[@name='city']")
	WebElement EnterCity;
	
	@FindBy(xpath= "//select[@name='state']")
	WebElement SelectState;
	
	@FindBy(xpath= "//input[@name='landmark']")
	WebElement EnterLandmark;
	
	@FindBy(xpath= "//span[text()='Home (All day delivery)']")
	WebElement SelectAddresstype;
	
	@FindBy(xpath= "//button[text()='Save and Deliver Here']")
	WebElement SaveAndDeliverbutton;
	
	@FindBy(xpath= "//button[text()='CONTINUE']")
	WebElement ContinueButton;
	
	@FindBy(xpath= "//button[text()='Accept & Continue']")
	WebElement AcceptAndContinueButton;
	
	@FindBy(xpath= "//div[text()='Net Banking']")
	WebElement SelectNetBankingOption;
	
	@FindBy(xpath= "//button[@type='button']")
	WebElement SelectBank;
	
	@FindBy(xpath= "//button[contains(text(),'PAY')]")
	WebElement PayButton;
	
	
	public OrderSummary()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddToCart()
	{
		ActionClass.click(driver, PlaceOrder);
	}
    
	public void AddNewAddress(String Name, String MobileNumber, String Pincode, String Locality, String Address, String City) throws InterruptedException
	{
		
		ActionClass.click(driver, AddAddress);
		ActionClass.type(EnterName, Name);
		Thread.sleep(2000);
		ActionClass.type(EnterMobileNumber, MobileNumber);
		Thread.sleep(2000);
		ActionClass.type(EnterPincode, Pincode);
		Thread.sleep(2000);
		ActionClass.type(EnterLocality, Locality);
		Thread.sleep(2000);
		ActionClass.type(EnterAddress, Address);
		Thread.sleep(2000);
		ActionClass.type(EnterCity, City);
		Thread.sleep(2000);
		
		Select state = new Select(SelectState);
		state.selectByVisibleText("Maharashtra");
		Thread.sleep(2000);
		
		ActionClass.click(driver, SelectAddresstype);
		Thread.sleep(2000);
		
		ActionClass.click(driver, SaveAndDeliverbutton);
		Thread.sleep(2000);
		
		ActionClass.click(driver, ContinueButton);
		ActionClass.click(driver, AcceptAndContinueButton);
		
	}
	
	public void MakePayment()
	{
	    ActionClass.click(driver, SelectNetBankingOption);
	    
	    Select Selectbank= new Select(SelectBank);
	    Selectbank.selectByVisibleText("Bank of India");
	    
	}
	

	
	
	
	
	
}
