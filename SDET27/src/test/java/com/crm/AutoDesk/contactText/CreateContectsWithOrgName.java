package com.crm.AutoDesk.contactText;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodisk.ObjectRepository.ContactsInfoPage;
import com.crm.autodisk.ObjectRepository.ContactsPage;
import com.crm.autodisk.ObjectRepository.CreateContactpage;
import com.crm.autodisk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodisk.ObjectRepository.HomePage;
import com.crm.autodisk.ObjectRepository.LoginPage;
import com.crm.autodisk.ObjectRepository.OrganizationsPage;
/**
 * 
 * @author VINAYAKARAM J
 *
 */
public class CreateContectsWithOrgName {
/**
 * 
 * @param args
 * @throws Throwable
 */
	
	@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
	public class createOrgTestNG extends BaseClass{

	    @Test(groups = "SmokeSuite")
	    
	    public void createOrgTestNG() throws Throwable {
	    	
	    	
	    	int ranDomNum = jLib.RanDomNumber(); 
	    	 
	    	//get data from excel

	    	String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomNum;
	    	
			String lastn = eLib.getDataFromExcel("Sheet1", 10, 3);
			
	    	//navigate to organization module
	    	HomePage hp = new HomePage(driver);
	    	hp.clickOnOrganizationsLinks();
	    	
	    	//click on create organization button
	    	OrganizationsPage op = new OrganizationsPage(driver);
	    	op.clickoncreateOrg();
	    	
	    	//Enter all the details and create new organization
	    	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	    	cop.createorg(orgName);
	    	
	    	wLib.WaitForElementToBeCheckable(driver, driver.findElement(By.className("dvHeaderText")));
	    
	    	
	    	//navigate to con
	    	hp.clickOnContactsLinks();
	    	
	    	//click on create Contact button
	    	ContactsPage cp =  new ContactsPage(driver);
	    	cp.clickoncreateCon();
	    	
	    	//Enter all the details and create new Contact
	    	CreateContactpage ccp = new CreateContactpage(driver);
	    	ccp.CreateContectsWithOrg(driver, lastn, orgName);
	    	
	    	ContactsInfoPage cip = new ContactsInfoPage(driver);
	    	cip.getContactHeaderInfoText();
	    	
	    	
	    	
	    /*	
        wLib.SwitchToWindow(driver, "Accounts");
        driver.findElement(By.id("search_txt")).sendKeys(orgNAME);
        driver.findElement(By.xpath("//input[@name='search']")).click();
        driver.findElement(By.xpath("//a[text()='"+orgNAME+"']")).click();
        wLib.SwitchToWindow(driver, "Contacts");
        ccp.FetchOrgInCon(orgNAME);
        */
    	
        //logout 
		//hp.logout(driver);
		
		//close the browser
		//driver.quit();
        
  	}
	}	
}
