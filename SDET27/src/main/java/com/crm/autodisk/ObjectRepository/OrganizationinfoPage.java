package com.crm.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationinfoPage {//step 1 : create seeprate page for homepage
	
	
	//step2 : identify all webelement and declare them as private
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement assignchk;
	

	//step 3 : initialization 
	public OrganizationinfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	//step 4 Utilization

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	public WebElement getAssignchk() {
		return assignchk;
	}

	//business library

	public String getOrgInfo(){
		return(orgHeaderText.getText());
			
	}
	
	//business Library
	
	public  String AssignGrp() {
		return(assignchk.getText());
	}

}
