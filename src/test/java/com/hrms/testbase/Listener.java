package com.hrms.testbase;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonMethods;

// <Listeners>
//<Listener>
//<include class-name="com.util.Listener"/>
//</Listeners>

public class Listener extends CommonMethods implements ITestListener {
	
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test started " + result.getName());
		BaseClass.test=BaseClass.report.createTest(result.getName());
		

	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed " + result.getName());
		BaseClass.test.pass("Test Case pass"+result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(TakesScreenshot("passed/"+result.getName()));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed " + result.getName());
		BaseClass.test.fail("Test Case Fail"+ result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(TakesScreenshot("failed/"+result.getName()));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
		
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped" + result.getName());
		
	}

}
