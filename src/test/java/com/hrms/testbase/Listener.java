package com.hrms.testbase;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonMethods;

// <Listeners>
//<Listener>
//<include class-name="com.util.Listener"/>
//</Listeners>

public class Listener extends CommonMethods implements ITestListener {
	
	

	public void onTestStart(ITestResult result) {
		System.out.println("Test started " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed " + result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed " + result.getName());
		
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped" + result.getName());
		
	}

}
