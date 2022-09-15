package vtiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all the generic methods related to database
 * @author Chaitra M
 *
 */
public class DatabaseUtility {
	
	Driver driverRef;
	Connection con = null;
	
	/**
	 * This method will esatblish connection with db
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(ConstantsUtility.DBUrl, ConstantsUtility.DBUsername, ConstantsUtility.DBPassword);
	}
	
	/**
	 * This method will close the DB connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	/**
	 * This method will execute a query and check for the expected data
	 * if the expected data is found, it will return the data 
	 * else it will return the null. 
	 * data validation with respect to database
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndVerifyTheData(String query, int colIndex,String expData) throws SQLException 
	{
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actData = result.getString(colIndex);
			if(actData.equals(expData))
			{
				flag = true; // flag rising event
				break;
			}
		}
		
		if(flag)
		{
			System.out.println("data present "+expData);
			return expData;
		}
		else
		{
			System.out.println("data not present");
			return " ";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
