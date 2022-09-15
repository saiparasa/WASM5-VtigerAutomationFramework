package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains all the generic methods to read data and 
 * write data to Excel sheet
 * @author Chaitra M
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel sheet and return the value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell cel = r.getCell(cell);
		String value = cel.getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will return the last row number in particular sheet
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		int lastRow = s.getLastRowNum();
		wb.close();
		return lastRow;
	}
	
	/**
	 * This method will write data into the excel sheet
	 * @param sheet
	 * @param row
	 * @param cel
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheet, int row, int cel, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheet);
		Row r = s.getRow(row);
		Cell cell = r.createCell(cel);
		cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(ConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
	}

	/**
	 * This method is used to execute a test script with multiple set of data.
	 * Hence it will return 2 dimensional object[][] so that it can be direct used in 
	 * dataprovider
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(ConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{ 
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
