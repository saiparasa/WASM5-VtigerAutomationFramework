package vtiger.Practice;

import org.testng.annotations.Test;

public class DebuggingPractice {
	
	@Test
	public void debugNow()
	{
		System.out.println("Hi");
		DebuggingPractice d = new DebuggingPractice();
		int c=d.divide(20, 0);
		System.out.println(c);
			
	}

	
	public int divide(int a, int b)
	{
		int c = a/b;
		return c;
	}
}
