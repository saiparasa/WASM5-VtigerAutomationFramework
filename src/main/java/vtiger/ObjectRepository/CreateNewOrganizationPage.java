package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	//declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business library
	/**
	 * This method will create organization with Org name
	 * @param Orgname
	 */
	public void createNewOrg(String Orgname)
	{
		OrgNameEdt.sendKeys(Orgname);
		saveBtn.click();
	}
	
	/**
	 * This method will create orgnization with industry drop down
	 * @param OrgName
	 * @param IndustryType
	 */
	public void createNewOrg(String OrgName, String IndustryType)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryType, industryDropDown);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with type and industry drop down 
	 * @param OrgName
	 * @param industryType
	 * @param type
	 */
	public void createNewOrg(String OrgName, String industryType, String type)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(industryType, industryDropDown);
		handleDropDown(type, typeDropDown);
		saveBtn.click();
	}
}
