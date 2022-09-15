package vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class acts like a implementation class to override all the methods 
 * present in Itestlistner interface
 * @author Chaitra M
 *
 */
public class ListenerImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName); // test is created which will initialize the individual test execution
		
		//Reporter.log(methodName+" => test script execution started",true);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" ---> passed");
		
		//Reporter.log(methodName+" => is Passed",true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		//this will capture the exception occured
		//String msg = result.getThrowable().toString();
		
		//this will capture the current test method name 
		String methodName = result.getMethod().getMethodName();
		
		//This will append method name with date for screenshot
		String screenShotName = methodName+"-"+jLib.getSystemDateInFormat();
		
		//This will log in report and console
		test.log(Status.FAIL, methodName+ "---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		
		//Reporter.log(methodName+" => is failed because => "+msg,true);
		
		//This will capture the screen shot and provide the screen shot name and save it in folder
		try {
			String path = wLib.takeScreenShot(BaseClass.sdriver, screenShotName);
			
			test.addScreenCaptureFromPath(path); //Navigate to screenshot path and attach it to the report
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		//String msg = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName +" ---> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		
		//Reporter.log(methodName+" => is skipped because => "+msg,true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Start of suite execution
		/*Configure the extent reports*/                           // inside ExtentReports - Report-06 sep 2022 10-38-41.html
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("WASM-5-Vtiger Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Vtiger Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-platform", "Windows");
		report.setSystemInfo("Base-URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Chaitra");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//End of Suite execution
		
		report.flush(); // consolidate all the test script execution and dump the status into report
		
	}
	
	

}
