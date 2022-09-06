package com.flipkart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.action.ActionClass;
import com.flipkart.base.BaseClass;

public class HomePage extends BaseClass{

	
		
		@FindBy(xpath= "//div[@class='exehdJ']")
		WebElement MyAccountName;
				
		@FindBy(xpath= "//input[@name='firstName']")
		WebElement FirstName;
		
		@FindBy(xpath= "//input[@name='firstName']")
		WebElement LastName;
		
		@FindBy(xpath= "//input[@name='email']")
		WebElement EmailId;
		
		@FindBy(xpath= "//div[text()='My Profile']")
		WebElement MyProfile;
		
		
		public HomePage()
		{
		PageFactory.initElements(driver, this);
		}
		
		public boolean ValidateMyAccount()
		{
			return ActionClass.isDisplayed(driver, MyAccountName);
			
		}
		
		public boolean ValidateFirstName() throws InterruptedException
		{
			ActionClass.click(driver, MyAccountName);
			Thread.sleep(2000);
			ActionClass.click(driver, MyProfile);
			return ActionClass.isDisplayed(driver, FirstName);
		}
		
		public boolean ValidateLastName()
		{
			return ActionClass.isDisplayed(driver, LastName);
		}
		
		public boolean ValidateEamilId()
		{
			return ActionClass.isDisplayed(driver, EmailId);
		}
		
	}
