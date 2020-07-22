package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class ReportPage extends CommonMethods {
	
	@FindBy (id="menu_core_viewDefinedPredefinedReports")
	public WebElement report;
	
	@FindBy (css="input#btnAdd")
	public WebElement add;
	
	@FindBy(css="input#report_report_name")
	public WebElement reportName;
	
	@FindBy(xpath="//select[@id='report_criteria_list']")
	public WebElement selectCriteria;
	
	@FindBy (xpath="//select[@id=\"report_include_comparision\"]//following::select[1]")
	public WebElement selectedCriteriaIncluded;
	
	@FindBy (css="select#report_display_groups")
	public WebElement displayFiledGroups;
	
	@FindBy (id="report_display_field_list")
	public WebElement fieldDisplay;
	
	@FindBy (css="a#btnAddDisplayField")
	public WebElement clickAdd;
	
	@FindBy (xpath="//input[@id='display_group_1']")
	public WebElement checkBox;
	
	@FindBy(css="input#btnSave")
	public WebElement save;
	
	@FindBy(xpath="//table[@id=\"resultTable\"]/tbody/tr")
	public WebElement EmpReportName;
	
	
	
	@FindBy(css="a#btnAddConstraint")
	public WebElement addEmployee;
	
	@FindBy (css="input#employee_name_empName")
	
	public WebElement employeeName;
	
	public ReportPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
			
	
	
	
	
	

}
