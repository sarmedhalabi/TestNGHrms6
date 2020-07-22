package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;


import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods {
	
	@Test(groups="smoke")
	
 	public void validAdminLogin() {
 		// LoginPageElements login = new LoginPageElements();
		test.info("Entering valid admin credentials");
 		sendText(login.username, ConfigsReader.getProperty("username"));
 		sendText(login.password, ConfigsReader.getProperty("password"));
 		click(login.loginBtn);

 		// DashboardPageElements dashboard = new DashboardPageElements();
 		test.info("Verifying valid username shows with welcome text");
 		String expectedUser = "Welcome Admin";
 		String actualUser = dashboard.welcome.getText();
 		Assert.assertEquals(actualUser, expectedUser, "Admin is NOT Logged in");
 		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
 	}

 	@Test(groups="regression")
 	public void invalidPasswordLogin() {
 		test.info("Entering invalid Credentials");
 		// LoginPageElements login = new LoginPageElements();
 		sendText(login.username, ConfigsReader.getProperty("username"));
 		sendText(login.password, "uiuguig");
 		click(login.loginBtn);

 		String expected = "Invalid credentials";
 		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
 	}

 	@Test(groups="regression")
 	public void emptyUsernameLogin() {
 		test.info("Checking empty login");
 		// LoginPageElements login = new LoginPageElements();
 		sendText(login.password, ConfigsReader.getProperty("password"));
 		click(login.loginBtn);

 		String expected = "Username cannot be empty";

 		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
 	}
 	
 	//@Test
 	public void timeStamp() {
 		
 		Date d=new Date();
 		System.out.println(d.getTime());
 		SimpleDateFormat sdf= new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
 		System.out.println(sdf.format(d.getTime()));
 		
 	}


}
