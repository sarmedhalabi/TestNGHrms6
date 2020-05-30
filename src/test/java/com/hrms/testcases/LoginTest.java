package com.hrms.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods {
	
	
	public static void main(String[] args) throws InterruptedException {
		/*
 		 * User should be able to login to the application with valid credentials
 		 */

 		//open browser and navigate to url
 		setUp();

 		//sending username
 		WebElement username=driver.findElement(By.cssSelector("input#email"));
 		
 		sendText(username, ConfigsReader.getProperty("username"));

 		//sending password
 		WebElement password=driver.findElement(By.xpath("//input[@type='password'][@id='pass']"));
 		sendText(password, ConfigsReader.getProperty("password"));
 		WebElement firstName= driver.findElement(By.cssSelector("input[name='firstname']"));
 		sendText(firstName,"John");
 		WebElement lastName=driver.findElement(By.cssSelector("input[name='lastname']"));
 		sendText(lastName,"Smith");
 		List<WebElement> gender= driver.findElements(By.cssSelector("input[name='sex']"));
 		ClickRadioOrCheckBox(gender,"2");
 		Thread.sleep(2000);

 		//click on login


 		//close browser
 		//tearDown();

 	}
		
		
		
		
		
	}


