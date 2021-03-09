package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	static ExtentReports report;
	
	public static ExtentReports getReportObject() {
		
		
		String path=System.getProperty("user.dir")+ "\\reports\\index.html";
		
		ExtentSparkReporter reports=new ExtentSparkReporter(path);
		reports.config().setReportName("Web Automation Results");
		reports.config().setDocumentTitle("Test Results");
		
		 report=new ExtentReports();
		report.attachReporter(reports);
		report.setSystemInfo("Tester", "Naveen");
		return report;
	}

}
