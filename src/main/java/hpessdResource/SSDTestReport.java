package hpessdResource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SSDTestReport 
{
	static ExtentReports ResultsReport;
	
	public static ExtentReports getResultObject()
	{
		String ResultReportPath = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter TestResults = new ExtentSparkReporter(ResultReportPath);
		TestResults.config().setReportName("SSD Selector Tool Automation Testing Report");
		
		/*ExtentSparkReporter testresults = new ExtentSparkReporter(ResultReportPath);
		testresults.config().setReportName("SSD Tool");
		
		/*testresults.config().setTimeStampFormat("EEEE,MMMM,dd,yyyy,hh:mm a '('zzz')'");
		testresults.config().setReportName("SSD Selector Tool Automation");
		testresults.config().setDocumentTitle("SSD Test Results");
		//testresults.config().setTheme(Theme.STANDARD); */
		ResultsReport = new ExtentReports();
		ResultsReport.attachReporter(TestResults);
		ResultsReport.setSystemInfo("Tester", "Prashant Kinagi");
		return ResultsReport;
	}
}
