package testComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static  ExtentReports getExtentReports(){
		
		String reportPath = "E:\\software testing notes\\manual testing notes\\Eclipsce Worksspace\\Gmail_Project\\ExtentReports\\Index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath); 
		
		reporter.config().setReportName("Gmail Test Report");
		
		reporter.config().setDocumentTitle("Test Repor");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Anshul Badgaiyan");
		return extent;
	}
	
	
}
