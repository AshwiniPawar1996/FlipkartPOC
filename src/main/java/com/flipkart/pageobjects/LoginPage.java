package com.flipkart.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.action.ActionClass;
import com.flipkart.base.BaseClass;



public class LoginPage extends BaseClass{
	
	@FindBy(xpath= "/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input[@type='text']")
	WebElement EnterEmail;
	
	@FindBy(xpath= "//input[@type='password']")
	WebElement EnterPassword;
	
	@FindBy(xpath= "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement LoginButton;

	@FindBy(xpath= "/html/body/div[2]/div/div/button")
	WebElement CloseButton;
	
	@FindBy(xpath="//a[@class='_1_3w1N']")
	WebElement Login;
	
	@FindBy(xpath= "//div[@class='exehdJ']")
	WebElement MyAccount;
	

public LoginPage()
{
PageFactory.initElements(driver, this);
}

public void ClickOnCloseButton()
{
	ActionClass.click(driver,CloseButton);
}

public LoginPage ClickOnLogin()
{
	ActionClass.click(driver,Login);
	return new LoginPage();
}

public HomePage Login(String Email, String Pass) throws InterruptedException
{
	
    ActionClass.type(EnterEmail, Email);
    Thread.sleep(5000);
    
    ActionClass.type(EnterPassword, Pass);
	Thread.sleep(5000);
    
	ActionClass.click(driver, LoginButton);
	return new HomePage();
	
}

}


