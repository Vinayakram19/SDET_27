package com.crm.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {//step 1 : create seeprate page for homepage
	
	//step2 : identify all webelement and declare them as private
	
	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderInfoText;
	
	//initialization 
	public  ContactsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactHeaderInfoText() {
		return contactHeaderInfoText;
	}
	
	//business libraries
	public String getcontactInfo() {
		return(contactHeaderInfoText.getText());
	}
	
	
  
}
