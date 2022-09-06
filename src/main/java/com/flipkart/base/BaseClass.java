package com.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.flipkart.action.ActionClass;
import com.flipkart.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public void loadConfig() throws IOException
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		try {
			prop=new Properties();
			System.out.println("Super constructor invoked");
			FileInputStream ip= new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void launchApp()
	{
		WebDriverManager.chromedriver().setup();
	    String browserName	=prop.getProperty("browser");
	    
	    if(browserName.contains("chrome")) {
	    	driver=new ChromeDriver();
	    }else if(browserName.contains("firefox")) {
	    	driver=new FirefoxDriver();
	    }else if(browserName.contains("IE")) {
	    	driver=new InternetExplorerDriver();
	}
	    
	    driver.manage().window().maximize();
	    ActionClass.implicitWait(driver, 10);
        driver.get(prop.getProperty("url"));
}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}