package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: load the file into file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: navigate to sheet
		Sheet sh = wb.getSheet("Organization");
		
		//Step 4: Navigate to row
		Row row = sh.getRow(1);
		
		//Step 5: navigate to cell
		Cell cell = row.getCell(2);
		
		//Step 6: read the response cell value
		String value = cell.getStringCellValue();
		System.out.println(value);
	}

}
