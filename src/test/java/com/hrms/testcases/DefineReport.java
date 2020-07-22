package com.hrms.testcases;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class DefineReport extends CommonMethods {

	@Test(groups = "Jira")

	public void definereport() {
		test.info("loggin in to the hrms website");
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		click(dashboard.PIM);
		sleep(3);
		test.info("creating report");
		jsClick(reportPage.report);
		sleep(2);
		click(reportPage.add);
		sleep(2);
		test.info("entering report name");
		sendText(reportPage.reportName, "Manchester United");
		selectValue(reportPage.selectCriteria, "Employee Name");
		// click(reportPage.addEmployee);
		// sendText(reportPage.employeeName, "Jeffry Smith");
		selectValue(reportPage.selectedCriteriaIncluded, 0);
		selectValue(reportPage.displayFiledGroups, "Salary");
		selectValue(reportPage.fieldDisplay, "Gender");
		click(reportPage.clickAdd);
		click(reportPage.checkBox);
		click(reportPage.save);
		sleep(2);
		test.info("report added");
		boolean flag=false;
		while(!flag) {
			List<WebElement> tablerows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			for(int i=1;i<tablerows.size();i++) {
				String actualtext= tablerows.get(i-1).getText();
				if(actualtext.contains("Manchester")) {
					flag=true;
				
					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[1]")).click();
					sleep(2);
					driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]/a")).click();
					sleep(3);
					break;
				
				}
				
			}
			
			
		}
		boolean reportDisplay=driver.findElement(By.xpath("//div[@class='head']/h1")).isDisplayed();
		assertTrue(reportDisplay);

	}

}
