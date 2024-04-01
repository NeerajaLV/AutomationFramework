package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"--- Test execution STARTED ---");
		
		//create a test for @Test in extent reports
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"--- Test SUCCESS ---");
		
		//log the pass status in extent reports
		test.log(Status.PASS, methodName+"--- Test SUCCESS ---");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"--- Test FAILURE ---");
		
		//log the fail status in extent reports
		test.log(Status.FAIL, methodName+"--- Test FAILURE ---");
		
		SeleniumUtility sUtil=new SeleniumUtility();
		JavaUtility jUtil=new JavaUtility();
		String screenshotName=methodName+"-"+jUtil.getDate();
		
		try {
			String path=sUtil.capturScreenshot(BaseClass.sdriver, screenshotName);
			
			//attach the screenshot for extent reports
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"--- Test SKIP ---");
		
		//log the fail status in extent reports
		test.log(Status.SKIP, methodName+"--- Test SKIP ---");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("--- Suit execution started ---");
		
		//configure the extent reports
		ExtentSparkReporter rep=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getDate()+".html");
		rep.config().setDocumentTitle("Execution Report");
		rep.config().setTheme(Theme.DARK);
		rep.config().setReportName("Vtiger Execution Report");
		
		report=new ExtentReports();
		report.attachReporter(rep);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Testing");
		report.setSystemInfo("Base OS", "Wndows 11");
		report.setSystemInfo("Base URL", "http://localhost:8888/");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("--- Suit execution finished ---");
		
		//generate extent report
		report.flush();
	}
	
}
