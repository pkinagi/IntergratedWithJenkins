package hpe.NewSSD;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import hpessdResource.BaseClass;
import hpessdResource.SSDTestReport;

public class Listeners extends BaseClass implements ITestListener
{
	ExtentReports ResultsReport = SSDTestReport.getResultObject();
	ExtentTest AllTest;
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	//public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	//public static Logger log = (Logger) LogManager.getLogger(BaseClass.class.getName());
	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
		AllTest = ResultsReport.createTest(result.getMethod().getMethodName());
		extentTest.set(AllTest);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSuccess(result);
		//AllTest.log(Status.PASS, "Working As Per Expected Results");
		extentTest.get().log(Status.PASS,"Working As Per Expected Results");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		//AllTest.fail(result.getThrowable());
		
		
		//extentTest.get().log("*** Test Execution " + result.getMethod().getMethodName() + " Failed ****");
		//log.info((result.getMethod().getMethodName() + "Failed"));
		
		String targetlocation = null;
		String testmethodname = result.getMethod().getMethodName();
		String ScreenShotName = testmethodname + ".png";
		String FileSeparator = System.getProperty("file.separator");
		String ReportPath = System.getProperty("user.dir") + FileSeparator + "TestReports" + FileSeparator + "ScreenShots";
		//log.info("Screen Shot Report Path - " + ReportPath);
		try
		{
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e)
		{
			
		}
		try 
		{
			TakeScreenshot(testmethodname,driver);
		} 
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Define the Target Location 
		targetlocation = ReportPath + FileSeparator + testmethodname + FileSeparator + ScreenShotName;
		//Attach a failed test case screen to Extent Report
		try
		{
			//extentTest.get().fail("ScreenCapture", MediaEntityBuilder.createScreenCaptureFromPath(targetlocation).build());
			extentTest.get().addScreenCaptureFromPath(TakeScreenShot(testmethodname, driver), result.getMethod().getMethodName());
		}
		catch (Exception e2)
		{
			System.out.println("An Exception Occured While Taking Screen Shot " + e2.getCause());
		}
		
		extentTest.get().fail(result.getThrowable());
	}

	private void TakeScreenshot(String testmethodname, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
		ResultsReport.flush();
	
	}
	
	
}
