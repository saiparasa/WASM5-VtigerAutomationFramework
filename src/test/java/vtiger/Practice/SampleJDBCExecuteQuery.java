package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();//--- this is mysql driver
		
		//Step 1: Register the Driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection with database - use database name 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: issue create statement
		Statement state = con.createStatement();
		
		//Step 4: execute the query - use table name
		ResultSet result = state.executeQuery("select * from customerinfo;");
	
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		
		//Step 5: close the database
		con.close();
		
	}

}
