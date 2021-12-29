package com.crm.autodesk.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		
	}
	
	public void onTestFailure(ITestResult result) {
		
		//Capture the method Name
		String methodName = result.getMethod().getMethodName();
		
		//Capture the Current date
		String CurrentDate = new JavaUtility().getSystemDateAndTime();
		
		//concatenate for screenshot name
		String screenShotName =methodName+"_"+CurrentDate;
		
		try {
			new WebDriverUtility().TakeScreenShot(BaseClass.sdriver, screenShotName);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void onTestSkipped(ITestResult result) {
		
		
		
		
	}

}
