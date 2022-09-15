package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before suite");
		Assert.fail();
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("after Suite");
	}

	@BeforeClass
	public void bcConfig()
	{
		System.out.println("Before class");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before method");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("after class");
	}
	
	@AfterMethod
	public void amConfig()
	{
		System.out.println("after method");
	}
	
	
	@Test
	public void test1()
	{
		System.out.println("test 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("test 2");
	}
}
