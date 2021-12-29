package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertAndVerifyTheDatabase {

	public static void main(String[] args) throws Throwable {
		
		Connection connection=null;
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate("insert into project(project_id,created_by,project_name,status,team_size)values('TY_PROJ_0033','zogo','bullcat','completed',3)");

		if(result==1)
		{
			System.out.println("added");
		}
		else {
		
		System.out.println("not added");
		}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally {
		connection.close();
		}
	}

		
	}

