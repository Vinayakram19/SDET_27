package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class CreateProjectCheckDatabase {
	
	public static void main(String[] args) throws Throwable {
		//create object creation libtaries
		 FileUtility fLib = new FileUtility();
		 ExcelUtility eLib = new ExcelUtility();
		 JavaUtility jLib=new JavaUtility();
		 WebDriverUtility wLib= new  WebDriverUtility();

	
		
		 WebDriver driver =new ChromeDriver();
		 
			wLib.WaitForPageToLoad(driver);
		 
		 driver.get("http://localhost:8084/");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra",Keys.TAB,"rmgy@9999",Keys.ENTER);
		 driver.findElement(By.linkText("Projects")).click();
		 driver.findElement(By.className("material-icons")).click();
		 driver.findElement(By.name("projectName")).sendKeys("testyantra1919",Keys.TAB,"Murugan");
		 WebElement selectvalue = driver.findElement(By.xpath("(//select[@class = 'form-control'])[2]"));
		 wLib.select(selectvalue, 3);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.close();
		 
		String expectedproject_name = "testyantra1919";
		         //register the database
				Driver driver1 = new Driver() ;
				//Establish the connection with database
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				//issue the statement 
				Statement statement =connection.createStatement();
				//execute queries
				ResultSet result = statement.executeQuery("select* from project");
				while(result.next()) {
					if(result.getString(4).equals(expectedproject_name)) {
					System.out.println("Passed");
				}
				}
				//close the database connection
				connection.close();
			 
			 
		 }
		 
	}
	


