package com.crm.AutoDesk.contactText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

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

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodisk.ObjectRepository.ContactsInfoPage;
import com.crm.autodisk.ObjectRepository.ContactsPage;
import com.crm.autodisk.ObjectRepository.CreateContactpage;
import com.crm.autodisk.ObjectRepository.HomePage;
import com.crm.autodisk.ObjectRepository.LoginPage;
/**
 * 
 * @author VINAYAKARAM J
 *
 */
public class CreateContactLnameUsingExcel {
	/**
	 * 
	 * @param args
	 * @throws Throwable
	 */

	public static void main(String[] args) throws Throwable {
	
		//create object creation libtaries
		 FileUtility fLib = new FileUtility();
		 ExcelUtility eLib = new ExcelUtility();
		 JavaUtility jLib=new JavaUtility();
		 WebDriverUtility wLib= new  WebDriverUtility();

	/*read common data*/
		
		String URL = fLib.getPropertiesKeyValue("url");
		String USERNAME = fLib.getPropertiesKeyValue("username");
		String PASSWORD = fLib.getPropertiesKeyValue("password");
		String BROWSER = fLib.getPropertiesKeyValue("browser");
		
		
		//get random  num
		int randomNum=jLib.RanDomNumber();
		
		//get data from excel
				String orgNAME = eLib.getDataFromExcel("Sheet1", 1, 2) + randomNum;	
				
		
		WebDriver driver =null ;
		if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equals("chrome")){
			driver = new ChromeDriver();
			
		}else if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver =new ChromeDriver();
		}
		
		wLib.WaitForPageToLoad(driver);
		
		//step 1 :login 
		driver.get(URL);
		driver.manage().window().maximize();
		
		LoginPage lp = new LoginPage (driver);
		lp.login(USERNAME, PASSWORD);
		
		//step 2: navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLinks();
		
		//Step 3: click on "create contacts"Button;
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickoncreateCon();
	
		//Step 4 :Enter the details & create the contacts
		
		CreateContactpage ccp= new CreateContactpage(driver);
		ccp.createContact(orgNAME);
	
        // Step 5 : verify Contacts name in header of the msg
		
		ContactsInfoPage ciofop= new ContactsInfoPage(driver);
		ciofop.getcontactInfo();
		/*
		String SHG = driver.findElement(By.className("dvHeaderText")).getText();
		if(SHG.contains(orgNAME)) {
			System.out.println("contact is successfull --'Pass'");
			
		}else {
			System.out.println("contact is not successfull --'Fail'");
		}
		*/
		
	//	logout
		
		
		hp.logout(driver);
		

		//close the browser
			driver.quit();
	}

}
