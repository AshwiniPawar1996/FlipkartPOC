package com.flipkart.utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentSparkReporter sparkReporter;
	public static  ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() throws IOException
	{
	   
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
		
		 sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("ProjectName", "Flipkart Automation");
		extent.setSystemInfo("Tester", "Ashwini Pawar");
		
     }
	public static void endReport()
	{
		extent.flush();
	}
	
}
