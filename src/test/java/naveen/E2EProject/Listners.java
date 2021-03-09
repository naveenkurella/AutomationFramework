package naveen.E2EProject;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportNG;
import resources.base;

public class Listners extends base implements ITestListener {
	ExtentReports report=ExtentReportNG.getReportObject();
	
	ExtentTest test;

	ThreadLocal<ExtentTest> extentThread=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		test=report.createTest(result.getMethod().getMethodName());
		extentThread.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	//ITestListener.super.onTestSuccess(result);
		
		extentThread.get().log(Status.PASS, "TEST IS PASSED");
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		extentThread.get().fail(result.getThrowable());
		
		WebDriver driver=null;
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		extentThread.get().addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
			
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		report.flush();
	}

}
