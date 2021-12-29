package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDataBase {

	public static void main(String[] args) throws Throwable {

		//register the database
        Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//establish the connection with database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/god", "root", "root");
		//issue the statement
		Statement statement = connection.createStatement();
		//execute update
		int result = statement.executeUpdate("insert into god(fname, lname, address) value ('Hara','Mahadhava','Delhi')");
		//verification
		if(result==1) {
			System.out.println("one set of data is added to database");
		}else {
			System.out.println("data is not added to database");
		}
		//close the database connection
		connection.close();
		
		
		
	}
}
