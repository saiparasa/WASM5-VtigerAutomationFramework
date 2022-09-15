package vtiger.ContactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtility.BaseClass;
import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;
import vtiger.GenericUtility.WebDriverUtility;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * @author Chaitra M
 */
public class CreateContactWithMandatoryFieldsTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createContactWithMnadatoryFields() throws IOException
	{
		
	    String LASTNAME = eUtil.readDataFromExcel("Contact", 1, 2);
	    
	    //navigate to contacts link
	    HomePage hp = new HomePage(driver);
	    hp.clickOnContactsLnk();
	    
	    //navigate to create contact img
	    ContactsPage cp = new ContactsPage(driver);
	    cp.clickOnCreateContactImg();
	    
		//create contact with mandatory fields
	    CreateNewContactPage cnp = new CreateNewContactPage(driver);
	    cnp.createNewContact(LASTNAME);
	    
		//Validate
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String contactHeader = cip.getContactHeader();
	    if(contactHeader.contains(LASTNAME))
	    {
	    	System.out.println("pass");
	    }
	    else
	    {
	    	System.out.println("fail");
	    }
	    
	}
	
	
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void demoTest1()
	{
		System.out.println("This is demo ");
	}

}
