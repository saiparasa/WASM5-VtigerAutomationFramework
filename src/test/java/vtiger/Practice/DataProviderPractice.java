package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger.GenericUtility.ExcelFileUtility;

public class DataProviderPractice {
	
	@Test(dataProvider = "OrgName")
	public void addProductToCartTest(String Orgname,String IndustryType)
	{
		System.out.println(Orgname+"-"+IndustryType);
	}
	
//	@DataProvider(name = "product")
//	public Object[][] data()
//	{                            //row //columns
//		Object[][] d = new Object[4][5];
//		
//		d[0][0] = "samsung";
//		d[0][1] = "A80";
//		d[0][2] = 3000;
//		d[0][3] = "Camera";
//		d[0][4] = 12;
//		
//		d[1][0] = "Vivo";
//		d[1][1] = "A8";
//		d[1][2] = 300;
//		d[1][3] = "Camera";
//		d[1][4] = 10;
//		
//		d[2][0] = "Oppo";
//		d[2][1] = "V1";
//		d[2][2] = 30000;
//		d[2][3] = "Security";
//		d[2][4] = 12;
//		
//		d[3][0] = "iphone";
//		d[3][1] = "13Pro";
//		d[3][2] = 30009;
//		d[3][3] = "Secure";
//		d[3][4] = 15;
//		
//		return d;
// 	}
	
	@DataProvider(name = "OrgName")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelFileUtility eUtil = new ExcelFileUtility();
		Object[][] data = eUtil.readMultipleDataFromExcel("MultipleOrg");
		return data;
	}
	
}
