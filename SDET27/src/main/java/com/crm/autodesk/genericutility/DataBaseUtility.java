package com.crm.autodesk.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	public void createDataBaseConnection() throws Throwable {
		


	//register the database
	Driver driver = new Driver() ;
	//Establish the connection with database
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	//issue the statement 
	Statement statement =connection.createStatement();
	//execute queries
	ResultSet result = statement.executeQuery("select* from project");
	System.out.println("database is connected");
   }
	
	  
	
	
	public void closeDB(){
		
		//close the DataBase
		//connection.close();
		System.out.println("database connection is closed ");
	
	}


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
