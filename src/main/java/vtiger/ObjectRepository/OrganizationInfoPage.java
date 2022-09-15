package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility{
	
	//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgHeadterText;
	
	//initialise
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgHeadterText() {
		return OrgHeadterText;
	}

	//business library
	/**
	 * This method will get the header text for organization
	 * @return
	 */
	public String getOrgHeader()
	{
		String orgHeader = OrgHeadterText.getText();
		return orgHeader;
	}
	
}
