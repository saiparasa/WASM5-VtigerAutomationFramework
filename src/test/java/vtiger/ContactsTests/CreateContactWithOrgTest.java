package vtiger.ContactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtility.ListenerImplementation.class)
public class CreateContactWithOrgTest extends BaseClass {
	
	@Test(groups = "SmokeSuite", retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException
	{

		//Read all the required data
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+jUtil.getRandomNumber();
	    String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
	    
	    //Navigate to Organizations link
	    HomePage hp = new HomePage(driver);
	    hp.clickOnOrgLink();
	    Reporter.log("Organization link clicked", true);
	    
	    //Navigate to create Org img
	    OrganizationsPage op = new OrganizationsPage(driver);
	    op.clickOnCreateNewOrgImg();
	    Reporter.log("create org Look Up image clicked", true);
	    
	    // Create Organization with mandatory fields
	    CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
	    cop.createNewOrg(ORGNAME);
	    Reporter.log("New Organization created", true);
	    
	    //Validate
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
	    String OrgHeader = oip.getOrgHeader();
	    System.out.println(OrgHeader);
	    Assert.assertTrue(OrgHeader.contains(ORGNAME));
	    //Assert.fail();
	    
	    //Navigate to Contacts link
	    hp.clickOnContactsLnk();
	    Reporter.log("Contacts link clicked", true);
	    
	    //Navigate to create contcts img
	    ContactsPage cp = new ContactsPage(driver);
	    cp.clickOnCreateContactImg();
	    Reporter.log("create Contact Look Up image clicked", true);
	    
	    //Create contact with org details
	    CreateNewContactPage cnp = new CreateNewContactPage(driver);
	    cnp.createNewContact(LASTNAME, ORGNAME, driver);
	    Reporter.log("new contact with organization created", true);
	    
	    //Validate
	    ContactsInfoPage cip = new ContactsInfoPage(driver);
	    String contactHeader = cip.getContactHeader();
	    System.out.println(contactHeader);
	    Assert.assertEquals(contactHeader.contains(LASTNAME), true);
	                         
	    
	}

	
	@Test
	public void demoRegregression()
	{
		System.out.println("This is demo");
	}
}
