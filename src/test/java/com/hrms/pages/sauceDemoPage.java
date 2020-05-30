package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utils.CommonMethods;

public class sauceDemoPage extends CommonMethods {
	
	@FindBy(id="user-name")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy (css="input[class=btn_action]")
	public WebElement btnLogin;
	
	@FindBy (xpath="//div[text()='Products']")
	public WebElement productDisplayed;
	
	public sauceDemoPage() {
		PageFactory.initElements(driver, this);
		
	}
	
}
	


