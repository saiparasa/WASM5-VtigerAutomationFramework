package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods to read data from property file
 * @author Chaitra M
 *
 */
public class PropertyFileUtility {
	
	/**
	 * This method will read the specific key value from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.PropertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
	
	

}
