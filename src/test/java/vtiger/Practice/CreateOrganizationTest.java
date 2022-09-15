package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {
	
	public static void main(String[] args) {
		
		//Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//Step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: click on create organization Look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5: Enter the mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qspiders");
		
		//Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//driver.close();
		System.out.println("org created");
		
		
	}

}
