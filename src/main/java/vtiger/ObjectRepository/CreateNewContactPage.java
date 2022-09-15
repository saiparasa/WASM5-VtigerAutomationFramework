package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name = "lastname")
	private WebElement ContactNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchBoxEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getContactNameEdt() {
		return ContactNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return OrgLookUpImg;
	}

	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	
	/**
	 * This method will create a contact using mandatory fields and save
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		ContactNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	/**
	 * This method will create a contact with contact name and lead source down down
	 * @param lastname
	 * @param leadSourceType
	 */
	public void createNewContact(String lastname, String leadSourceType)
	{
		ContactNameEdt.sendKeys(lastname);
		handleDropDown(leadSourceType, leadSourceDropDown);
		saveBtn.click();
	}

	/**
	 * This method will create a contact with lastname and organization name
	 * @param lastname
	 * @param orgName
	 * @param driver
	 */
	public void createNewContact(String lastname, String orgName, WebDriver driver)
	{
		ContactNameEdt.sendKeys(lastname);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchBoxEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();//dynamic xpath
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	

}
