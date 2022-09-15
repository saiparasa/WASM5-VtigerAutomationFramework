package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;

/**
 * This contains test script to create contact
 * @author Chaitra M
 *
 */
public class CreateContactTest {
	
	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		
		/*Step 1: create Object of all utilities*/
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		/*Step 2: read all the necessary data */
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);
		
		/*Step 3: launch the browser */
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched");
			
		}
		else
		{
			System.out.println("browser name invalid, henced launched chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome browser launched");
		}
		
		wUtil.maximiseWindow(driver);
		wUtil.waitForElementsToLoadInDOM(driver);
		driver.get(URL);
		
		/*Step 4: login to app */
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*Step 5: navigate to contacts */
		driver.findElement(By.linkText("Contacts")).click();
		
		/*Step 6: click on create contact */
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		/*Step 7: create contact with With mandatory info */
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME+jUtil.getRandomNumber());
		
		/*Step 8: save */
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 9: logout*/
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverOn(driver, element);
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
