package com.crm.AutoDesk.OrgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodisk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodisk.ObjectRepository.HomePage;
import com.crm.autodisk.ObjectRepository.LoginPage;
import com.crm.autodisk.ObjectRepository.OrganizationsPage;
/**
 * 
 * @author VINAYAKARAM J
 *
 */
public class CreateOrgWithRatingTest {
	/**
	 * 
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {
		//read common data from properties file
		//create object creation libtaries
		 FileUtility fLib = new FileUtility();
		 ExcelUtility eLib = new ExcelUtility();
		 JavaUtility jLib=new JavaUtility();
		 WebDriverUtility wLib= new  WebDriverUtility();

	
		
		String URL = fLib.getPropertiesKeyValue("url");
		String USERNAME = fLib.getPropertiesKeyValue("username");
		String PASSWORD = fLib.getPropertiesKeyValue("password");
		String BROWSER = fLib.getPropertiesKeyValue("browser");
		
		
		//get random  num
		int randomNum=jLib.RanDomNumber();
		
		//get data from excel
				String orgNAME = eLib.getDataFromExcel("Sheet1", 1, 2) + randomNum;	
				String Rating = eLib.getDataFromExcel("Sheet1", 7, 3);
	
		WebDriver driver;
		if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
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
				
		
		WebElement ratinglist = driver.findElement(By.name("rating"));
		if(ratinglist.isEnabled()) {
			System.out.println("Rating is Enabled");
		}else {
			System.out.println("Rating is not Enabled");
		}
		
		  cop.clickrating(Rating);
		//wLib.select(ratinglist, Rating);
		
		driver.findElement(By.name("description")).sendKeys("[ CAM** ] abc - Campaign Information   Updated today");
		String cap = driver.findElement(By.id("dtlview_Description")).getText();
		System.out.println(cap);

		 //logout
		hp.logout(driver);
				
	    //close the browser
		driver.quit();
		
		
	}

}
