package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: load the file to file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//Step 2: create object of properties from java
		Properties pObj = new Properties();
		
		//Step 3: load the file to properties obj
		pObj.load(fis);
		
		//step 4: read data thru the key
		String BROWSER = pObj.getProperty("browser");
		System.out.println(BROWSER);
		
		String URL = pObj.getProperty("url");
		System.out.println(URL);
	}

}
