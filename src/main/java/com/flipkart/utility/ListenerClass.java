package com.flipkart.utility;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.flipkart.base.BaseClass;
import com.flipkart.action.ActionClass;


public class ListenerClass extends ExtentManager implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
	if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, "Passed Test Case is : " +result.getName());
}
	
	}

	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +"- Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() +"- Test Case Failed", ExtentColor.RED));
		    String pathString=ActionClass.screenShot(BaseClass.driver, result.getName());
		    test.fail("Screenshot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(pathString).build());
		}
			}
		public void onTestSkipped(ITestResult result)
		{
		if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test Case is : " +result.getName());
		}

		}
}
