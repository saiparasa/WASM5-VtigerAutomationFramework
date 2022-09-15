package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {
	
	//declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgLookUpImg;
	
	//Intialization
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getCreateOrgLookUpImg() {
		return createNewOrgLookUpImg;
	}
	
	//business library
	/**
	 * This method will click on create new organization look up image
	 */
	public void clickOnCreateNewOrgImg()
	{
		createNewOrgLookUpImg.click();
	}
	
	
	

}
