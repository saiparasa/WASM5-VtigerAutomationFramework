package vtiger.Practice;

import org.apache.commons.math3.analysis.function.Add;

public class GenericMethodPractice {
	
	//caller
	public static void main(String[] args) {
		
	int sum = GenericMethodPractice.add(20, 10);
	System.out.println(sum);
		
	}
	
//	public static void add()
//	{
//		int a = 50;
//		int b=10;
//		int c = a+b;
//		System.out.println(c);
//	}

	//called 
	public static int add(int a, int b)
	{
		int c = a+b;
		return c;
	}
}
