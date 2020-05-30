package com.hrms.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTask extends CommonMethods {
	
	public static void main(String[] args) {
		setUp();
	System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
	WebElement username= driver.findElement(By.cssSelector("input#txtUsername"));
	WebElement password=driver.findElement(By.cssSelector("input#txtPassword"));
	sendText(username,ConfigsReader.getProperty("username"));
	sendText(password,ConfigsReader.getProperty("password"));
	WebElement login= driver.findElement(By.cssSelector("input[name='Submit']"));
	click(login);
	WebElement pim= driver.findElement(By.cssSelector("a#menu_pim_viewPimModule"));
	pim.click();
	WebElement addEmployee= driver.findElement(By.xpath("//a[text()='Add Employee']"));
			addEmployee.click();
			WebElement firstName= driver.findElement(By.cssSelector("input#firstName"));
			WebElement lastName=driver.findElement(By.cssSelector("input#lastName"));
			sendText(firstName,"sarmed");
			sendText(lastName,"Halabi");
			driver.findElement(By.cssSelector("input#btnSave")).click();
	
		
		
		
		
		
		
		
		
	}

}
