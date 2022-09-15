package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void CreateCustomerTest()
	{
		System.out.println("this is tc 1 - customer is created");//passed
	}
	
	@Test
	public void ModifyCustomerTest()
	{
		System.out.println("this is tc 2 - customer is modified");//passed
		
	}
                                 //passed               //failed
	@Test(enabled = false)
	public void DeleteCustomerTest()
	{
		Assert.fail();//failed
		System.out.println("This is tc 3 - Customer is deleted");
	}
}
