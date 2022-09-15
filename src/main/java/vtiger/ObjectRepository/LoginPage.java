package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { // rule 1: create a seperate class for evry page
	
	//rule 2: identify the elemnts using @FindBy, @findAll, @Findbys and store as private
	//Declaration
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//rule 3: create a constructor to initialise
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//rule 4: provide getters to access the elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Step 5: business library
	/**
	 * This method will login To Application with username and passowrd
	 * @author Chaitra M
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

}
