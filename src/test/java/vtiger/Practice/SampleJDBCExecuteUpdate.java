package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driverRef = new Driver();
		Connection con = null;
		
		try {
		//Step 1: register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: get the connection
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: issue create statement
		Statement statement = con.createStatement();
		
		//Step 4: execute the query
		String query = "insert into customerinfo values('Alok',12,'mumbai');";
		int result = statement.executeUpdate(query);
		if(result==1)
		{
			System.out.println("the data is inserted");
		}
		else
		{
			System.out.println("data is not inserted");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally { 
			//Step 5: close the database
			con.close();
			System.out.println("database closed");
		}
		
	}

}
