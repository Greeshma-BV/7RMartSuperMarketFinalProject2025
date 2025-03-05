package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();//create an extend report object,populate common info in the report
	public synchronized static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//create spark report object,used for the UI of the report
		reporter.config().setReportName("7RMart SuperMarket");
		extentReports.attachReporter(reporter);//attach spark extended report to extend report
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Greeshma"); 
		return extentReports;
	}
}
