package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetTheDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		
		//register the database
		Driver driver = new Driver() ;
		//Establish the connection with database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/god", "root", "root");
		//issue the statement 
		Statement statement =connection.createStatement();
		//execute querries
		ResultSet result = statement.executeQuery("select* from god");
		while(result.next()) {
			System.out.println(result.getInt(1) + "\t" +result.getString(2)+ "\t" + result.getString(3));
		}
		//close the database connection
		connection.close();
	}
}
