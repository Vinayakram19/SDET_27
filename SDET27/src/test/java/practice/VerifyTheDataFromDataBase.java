package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		String expectedgodID ="3";
		//register the database
				Driver driver = new Driver() ;
				//Establish the connection with database
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/god", "root", "root");
				//issue the statement 
				Statement statement =connection.createStatement();
				//execute querries
				ResultSet result = statement.executeQuery("select* from god");
				while(result.next()) {
					if(result.getString(1).equals(expectedgodID)) {
					System.out.println("Passed");
				}
				}
				//close the database connection
				connection.close();
	}
}
