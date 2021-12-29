package com.crm.autodesk.genericutility;

import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodisk.ObjectRepository.HomePage;
import com.crm.autodisk.ObjectRepository.LoginPage;

public class BaseClass {


	
		/*Object Creation for Lib*/
		public JavaUtility jLib = new JavaUtility();
		public WebDriverUtility wLib = new WebDriverUtility();
		public FileUtility fLib = new FileUtility();
		public ExcelUtility eLib = new ExcelUtility();
		public DataBaseUtility dLib = new DataBaseUtility();
		public WebDriver driver;
		public static WebDriver sdriver;
	
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void dbConnection() throws Throwable {
		dLib.createDataBaseConnection();
		System.out.println("=============connect to DB==============");
                 
	}
		
	@BeforeClass(groups = "RegressionSuite")
	public void launchBrowser() throws Throwable {
		String URL = fLib.getPropertiesKeyValue("url");
		String BROWSER = fLib.getPropertiesKeyValue("browser");
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("invalid Browser");
		}
		System.out.println("=============Launch the Browser=======");
		wLib.WaitForPageToLoad(driver);
		wLib.maximiseWindow(driver);

		/* Navigate to app*/
		   driver.get(URL);
		   System.out.println("========Application Launched========");
	}
	
	@BeforeMethod(groups = "RegressionSuite")
	public void loginToApp() throws Throwable { 
		/*common Data*/
		String USERNAME = fLib.getPropertiesKeyValue("username");
		String PASSWORD = fLib.getPropertiesKeyValue("password");
	    /* step : login */
		   LoginPage lp = new LoginPage(driver);
		   lp.login(USERNAME, PASSWORD);
		   System.out.println("=========login successful========");
	}

	@AfterMethod(groups = "RegressionSuite")
	public void logoutofApp() {
	      
		HomePage hp = new HomePage(driver);
       hp.logout(driver);
       
	
	//wLib.TakeScreenShot(driver,screenshot);
       System.out.println("========logout successful=========");
	}
	
	@AfterClass(groups = "RegressionSuite")
	public void closeBrowser() {
		
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite(groups = "RegressionSuite")
	public void closedbConnection() {
		
		dLib.closeDB();
		
		System.out.println("========================close DB========================");
	}
}



