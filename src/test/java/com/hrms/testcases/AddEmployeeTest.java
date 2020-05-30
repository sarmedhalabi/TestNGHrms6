package com.hrms.testcases;

import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {
	
	@BeforeMethod
	public void openBrowser() {
		setUp();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();

	}

	//@Test(dataProvider="getData",groups="smoke")
	@Test(dataProvider = "userDataFromExcel")
	public void addEmployee(String firstname,String lastname, String username,String password) {
		
	sendText(addEmp.firstName, firstname);
	sendText(addEmp.lastName, lastname);
	jsClick(addEmp.checkLogin);
	sleep(2);
	sendText(addEmp.username, username);
	sendText(addEmp.password, password);
	sendText(addEmp.confirmPassword, password);
	jsClick(addEmp.btnSave);
	sleep(2);
	String actualtext= driver.findElement(By.xpath("//div[@id='profile-pic']/h1")).getText();
	System.out.println(actualtext);
	String expectedtext= firstname+" "+lastname;
       SoftAssert soft= new SoftAssert();
	soft.assertEquals(actualtext,expectedtext,"Texts do not match");
	//TakesScreenshot(firstname+" "+lastname);
	soft.assertAll();
	}

//	@DataProvider
//	public Object[][] getData() {
//		Object[][] data = { { "David", "Beckham", "DavidBeckham", "Klevinsmigh#$341234" },
//
//				{ "Jackie", "Smithie", "JackieSmithie", "samdmd#$SDF12345" } };
//		return data;
//	}
	@DataProvider(name="userDataFromExcel")
	public Object[][] getData2(){
		return ExcelUtility.excelIntoArray(System.getProperty("user.dir") +"/testdata/Test1.xlsx","Sheet1");
		
	}
}
	