package com.crm.autodisk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility { //step 1 : create seeprate page for homepage 
	
	//step2 : Declaration
	@FindBy(linkText= "Organizations")
	private WebElement organizationsLnk;
	@FindBy(linkText="Contacts")
	private WebElement contectsLnk;
	@FindBy(linkText= "Opportunities")
	private WebElement OpportunitiesLnk;
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	@FindBy(linkText= "Documents")
	private WebElement DocumentsLnk;
	@FindBy(linkText="Trouble Tickets")
	private WebElement TroubleTicketsLnk;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//step 3 : initialization 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//step 4  Utilization
	

	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContectsLnk() {
		return contectsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getDocumentsLnk() {
		return DocumentsLnk;
	}

	public WebElement getTroubleTicketsLnk() {
		return TroubleTicketsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business Library to click on Organizations
	public void clickOnOrganizationsLinks() {
		organizationsLnk.click();
	}
	
	//Business Library to click on contacts
		public void clickOnContactsLinks() {
			contectsLnk.click();
		}
		//Business Library for logout
		public void logout(WebDriver driver) {
			MouseOverOnElement(driver, administratorImg);
			SignOutLnk.click();
		}
	

}
