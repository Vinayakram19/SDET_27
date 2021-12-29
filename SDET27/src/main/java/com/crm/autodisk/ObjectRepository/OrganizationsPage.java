package com.crm.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {//step 1 : create seeprate page for homepage
	
	//step2 : identify all webelement and declare them as private
	
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	//step 3 : initialization 
	public  OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//step 4 Utilization

	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//business library
	
	public void clickoncreateOrg() {
		createOrgLookUpImg.click();
	}
	
	


}
