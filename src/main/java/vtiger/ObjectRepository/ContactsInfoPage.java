package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//Business library
	/**
	 * this method will return the header text 
	 * @return
	 */
	public String getContactHeader() {
		
		return contactHeaderText.getText();
	}
	
	
	

}
