package com.crm.AutoDesk.OrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodisk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodisk.ObjectRepository.HomePage;
import com.crm.autodisk.ObjectRepository.LoginPage;
import com.crm.autodisk.ObjectRepository.OrganizationinfoPage;
import com.crm.autodisk.ObjectRepository.OrganizationsPage;
/**
 * 
 * @author VINAYAKARAM J
 *
 */
public class CreateOrgWithIndustriesAndType {
	/**
	 * 
	 * @param args
	 * @throws Throwable
	 */
	
 public static void main(String[] args) throws Throwable {
		//create object creation libtaries
	 FileUtility fLib = new FileUtility();
	 JavaUtility jLib = new JavaUtility();
	 ExcelUtility eLib = new ExcelUtility();
	 WebDriverUtility wLib= new  WebDriverUtility();
	 
	 //read the data from properties file
		String URL = fLib.getPropertiesKeyValue("url");
		String USERNAME = fLib.getPropertiesKeyValue("username");
		String PASSWORD = fLib.getPropertiesKeyValue("password");
		String BROWSER = fLib.getPropertiesKeyValue("browser");
		
		//get random  num
		int randomNum=jLib.RanDomNumber();
			
	    //get data from excel
		String orgNAME = eLib.getDataFromExcel("Sheet1", 1, 2) + randomNum;	
		String industry = eLib.getDataFromExcel("Sheet1", 4, 3);	
		String type = eLib.getDataFromExcel("Sheet1", 4, 4);
	
		
		WebDriver driver;
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
		
		//step 1 : login
		
				driver.get(URL);
				driver.manage().window().maximize();
				LoginPage lp = new LoginPage(driver);
				lp.login(USERNAME, PASSWORD);
						
				//step 2: navigate to organization module
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganizationsLinks();
				
				//step 3: click on create organization button
				OrganizationsPage op= new OrganizationsPage(driver);
				op.clickoncreateOrg();
				
				//step 4: create new  organization 
				CreateOrganizationPage cop= new CreateOrganizationPage(driver);
				cop.createorg(orgNAME);
				cop.createorgwithIndustry(orgNAME, industry, type);
				
	
	
		 String s11=driver.findElement(By.id("dtlview_Industry")).getText();
		    String s12=driver.findElement(By.id("mouseArea_Type")).getText();
		    
		    if((industry.equals(s11))&&(type.equals(s12)))
		    {
		    	System.out.println("Industry Type added Successfully");
		    }else {
		    	System.out.println("Failed to added Industry and Type");
		    }
		    
            //logout
    		hp.logout(driver);
    				
    	    //close the browser
    		driver.quit();
    		
     	}
     
}	
	
	

