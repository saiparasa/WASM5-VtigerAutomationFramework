package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class POMPractice {
	
	public static void main(String[] args) {
		
		//launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//login to app
		LoginPage lp = new LoginPage(driver);
//		WebElement username = lp.getUserNameEdt();
//		username.sendKeys("admin");
//		
//		lp.getPasswordEdt().sendKeys("manager");
//		lp.getLoginBtn().click();
		
		lp.loginToApp("admin", "manager");
	}

}
