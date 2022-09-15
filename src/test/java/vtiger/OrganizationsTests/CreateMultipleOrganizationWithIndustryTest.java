package vtiger.OrganizationsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

/**
 * @author Chaitra M
 */
public class CreateMultipleOrganizationWithIndustryTest {
	
	//Create Object of all the required utilities
	JavaUtility jUtil = new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	
	WebDriver driver;
	
	@Test(dataProvider = "OrgData")
	public void createMultipleOrgTest(String OrgName, String industryType) throws IOException
	{
		//read all the necessary data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String Org = OrgName+jUtil.getRandomNumber();
		
		//launch the browser
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
		
		//login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		//Navigate to create org look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		
		//create new org with industry type
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createNewOrg(Org, industryType);
		
		//Validate
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getOrgHeader();
		System.out.println(orgHeader);
		if(orgHeader.contains(Org))
        {
	      System.out.println("PASS");
        }
		else
		{
			System.out.println("FAIL");
		}
		
	}
	
	@DataProvider(name = "OrgData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("MultipleOrg");
	}
	

}
