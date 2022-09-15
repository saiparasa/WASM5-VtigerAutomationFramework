package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

/**
 * @author Chaitra M
 */
public class CreateContactWithOrganizationTest {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		
		//Step 1: Create Object of generic Utilities
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//Step 2: Read all the required data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		
		//Step 3: Launch the browser
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("----chrome browser launched----");
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("----fire fox browser launched---");
		}
		else
		{
			System.out.println("---invalid browser name----");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);
		
		//Step 4: Login To Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: Naviagte tO Organizations 
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 6: create Organization with mandatory fields and save
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println("----- Organization created-----");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("----- Organization NOT created-----");
		}
		
		//Step 7: Naviagte to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 8: Navigate to create contact link
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		//switch the control to child window
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		
		//Switch the control back to parent
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
			System.out.println("----- contact created-----");
		}
		else
		{
			System.out.println("FAIL");
			System.out.println("----- contact NOT created-----");
		}
		
		
		//Step 9: logout
		wUtil.mouseHoverOn(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
