package hpe.NewSSD;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hpessdPageObjects.HomePage;
import hpessdPageObjects.SSDBestAvailabilityPage;
import hpessdPageObjects.SSDFormFactorPage;
import hpessdPageObjects.SSDInterfacePage;
import hpessdPageObjects.SSDResultPage;
import hpessdPageObjects.SSDSSDTypePage;
import hpessdPageObjects.SSDServerTypePage;
import hpessdPageObjects.SSDWorkloadPage;
import hpessdResource.BaseClass;

public class SSDResult extends BaseClass
{
	public SSDResult()
	{
		super();
	}
	
	HomePage         		 ssdHomepage;
	SSDWorkloadPage   		 ssdWorkload;
	SSDSSDTypePage   		 ssdSSDType;
	SSDServerTypePage 		 ssdServertype;
	SSDInterfacePage  		 ssdInterface;
	SSDFormFactorPage 		 ssdFormfactor;
	SSDBestAvailabilityPage  ssdBestavailability;
	SSDResultPage     		 ssdResult;
	
	@Test(priority = 0, description = "To Lauch Form Result Page URL Continuation From Best Availability Page ! ")
	public void ToVerifyResultPageURL()
	{
		WebDriverWait ResultPageLoad = new WebDriverWait(driver, 2);
		boolean PageLoad = ResultPageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("ResultPage")));
		if(PageLoad == true)
		{
			String ActualSSDURL = Prop.getProperty("ResultPage");
			String ExpectedSSDURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualSSDURL, ExpectedSSDURL);
			System.out.println("Verfiying The Result Page Components");
		}
	}
	
	@Test(priority = 1, description = "Result Page Label")
	public void ToVerifyResultPageRefineResults()
	{
		ssdResult = new SSDResultPage();
		
		// Click Refine Results
		Assert.assertTrue(ssdResult.SSDResRefineResults.isDisplayed(), "Refine Your Results");
	}
	
	@Test(priority = 2, description = "SSD Workloads Labels are Displayed")
	public void ToVerifyResultPageSSDWorkloadComponents()
	{
		// Checking the SSD Workload Options are Displayed
		Assert.assertTrue(ssdResult.SSDResVROlabel.isDisplayed(), "Very Read Optimized");
		
		Assert.assertTrue(ssdResult.SSDResReadIntensiveLabel.isDisplayed(), "Read Intensive");
		
		Assert.assertTrue(ssdResult.SSDResMixedUselabel.isDisplayed(), "Mixed Use");
		
		Assert.assertTrue(ssdResult.SSDResWriteIntensiveLabel.isDisplayed(), "Write Intensive");
		
	}
	
	@Test(priority = 3, description = "Selected Server Type and Server Model Is Displayed")
	public void ToVerifyResultPageServerTypeDropDown()
	{
		//To Verify Server Type Drop Down 1st Value
		ssdResult.VROMixedUseWriteServerType();
		
		// Server Model Drop Down 1st Value
		ssdResult.VROMixedUseWriteServerModel();
	}
	
	@Test(priority = 4, description = "To Verify Capacity Slider Value For VRO, Mixed Use and Write Intensive Workloads")
	public void ToVerifyCapacitySliderValue()
	{
		String ActualResultPageCapacitySlider = Prop.getProperty("VROMixedWriteIntensive6.4MaxCapacityValue");
		String ExpectedResultPageCapacitySlider = ssdResult.SSDResultPageMaxToolTip.getText();
		Assert.assertEquals(ActualResultPageCapacitySlider, ExpectedResultPageCapacitySlider);
	}
	
	@Test(priority = 5, description = "To Verify Maximum Capacity Slider Value")
	public void ToVerifyMaximumCapacitySliderValue()
	{
		ssdResult.MixedUseSSDCapacityMaxSliderText();
	}
	@Test(priority = 6, description = "To Verify Interface Type Labels ")
	public void ToVerifyResultPageSSDInterfaceTypeComponents()
	{
		// To Verify Interface types in Result Page
		Assert.assertTrue(ssdResult.SSDResInterfaceTypeSATAVROLabel.isDisplayed(), "Interface type :- SATAVRO");
		//System.out.println("SATA VRO :- " + ssdResult.SSDResInterfaceSATAVRO.getText());
		
		Assert.assertTrue(ssdResult.SSDResInterfaceTypeSATALabel.isDisplayed(), "Interface type :- SATA");
		
		Assert.assertTrue(ssdResult.SSDResInterfaceTypeValueSASLabel.isDisplayed(), "Interface type :- Value SAS");
		
		Assert.assertTrue(ssdResult.SSDResInterfaceTypeSASLabel.isDisplayed(), "Interface type :- SAS");
		
		Assert.assertTrue(ssdResult.SSDResInterfaceTypeNVMeMainstreamLabel.isDisplayed(), "Interface type :- NVMe Mainstream");
		
		Assert.assertTrue(ssdResult.SSDResInterfaceTypeNVMeHighPerformanceLabel.isDisplayed(), "Interface type :- NVMe High Performance");
	}
	
	@Test(priority = 7, description = " ")
	public void ToVerifyResultPageSSDFormFactorComponents()
	{
		// To Verify Form Factor types in Result Page
		Assert.assertTrue(ssdResult.SSDFormFactorSFFLabel.isDisplayed(), "Form Factor type :- 2.5 SFF");
		
		Assert.assertTrue(ssdResult.SSDFormFactorLFFLabel.isDisplayed(), "Form Factor type :- 3.5 LFF");
		
		Assert.assertTrue(ssdResult.SSDFormFactorAddInCardLabel.isDisplayed(), "Form Factor type :- Add-In Card");
		
		//Assert.assertTrue(ssdResult.SSDResM2.getText().equalsIgnoreCase("M.2"), "Form Factor type :- M2");
		//System.out.println("SATA VRO :- " + ssdResult.SSDResM2.getText());
		
		Assert.assertTrue(ssdResult.SSDFormFactorM2EKitlabel.isDisplayed(), "Form Factor type :- M2 E Kit");
	}
	
	@Test(priority = 8, description = "In Result Page, Select All Option Is Not Selected ")
	public void ToVerifyResultPageSSDSelectAllOption()
	{
		// Select All Is Not Selected
		Assert.assertFalse(ssdResult.SSDResSelectAll.isDisplayed(), "Select All Option Is Not Selected");
		
	}
	
	@Test(priority = 9, description = "In Result Page, Mainstream Option Is Selected")
	public void ToVerifyResultPageSSDBestAvailabilityComponents()
	{
		// Mainstream Option Is Selected
		Assert.assertTrue(ssdResult.SSDResMainstream.isSelected(), "Mainstream Option Is Selected");
		// Non Mainstream Option Is Not Selected
		Assert.assertFalse(ssdResult.SSDResNonMainstream.isSelected(), "Non Mainstream Option Is Not Selected");
	}
	
	@Test(priority = 10, description = "SSDs Results are Displayed For VRO,Mixed Use and Write Intensive Workloads with 6.4 Capacity Selected ")
	public void ToVerifyResultPageSSDResults()
	{
		// To Verify SSD Results are Displayed
		JavascriptExecutor SSDResults = (JavascriptExecutor)driver;
		SSDResults.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		
		// SSDs Results
		String ActualSSDsResults = Prop.getProperty("VROMixedWriteIntensive6.4SSDsResults");
		String ExpectedSSDsResults = ssdResult.SSDResResultDisplayLink.getText();
		Assert.assertEquals(ActualSSDsResults,ExpectedSSDsResults);
	}
	
	@Test(priority = 11, description = "In Result Page, File Download and StartOver Links")
	public void ToVerifyResultPagelabels()
	{
		// To Check Labels in the Top Bar Such as Export Excel, Export CSV, Feedback, StartOver
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		
		// To Verify Feedback Label
		Assert.assertTrue(ssdResult.SSDResultFeedbackLink.isDisplayed(), "FeedBack Label Is Displayed In SSD Result Page");
		
		// To Verify Export Excel Label
		Assert.assertTrue(ssdResult.SSDResultExportExcel.isDisplayed(),"Export Excel Label Is Displayed In SSD Result Page");
		
		// To Verify Export CSV Label
		Assert.assertTrue(ssdResult.SSDResultExportCSV.isDisplayed(), "Export CSV Label Is Displayed In SSD Result Page");
		
		// To Verify Print Label
		Assert.assertTrue(ssdResult.SSDResultPrintLink.isDisplayed(), "Print Label Is Displayed In SSD Result Page");
		
		//To Start Over Label
		Assert.assertTrue(ssdResult.SSDResultStartOverLink.isDisplayed(), "StartOVer Label Is Displayed In SSD Result Page");
	}
	
	@Test(priority = 12, description = "To Search SKU In Search Tab For Invalid SKU To Verify Message and Export Excel and CSV Is Not Displayed")
	public void ToVerifyMessageDisplayedAndExportExcelNotDisplayed()
	{
		ssdResult.InValidSKUSearch();
		// Scroll Down
		JavascriptExecutor ScrollDown = (JavascriptExecutor)driver;
		ScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		WebDriverWait LoadSSDs = new WebDriverWait(driver, 2);
		boolean Load = LoadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink,"0 -  SSDs meet your requirements"));
		if(Load == true)
		{
		//Verify Alert Message Is Displayed
		 String ActualMessageDisplayed = Prop.getProperty("NoSSDMessage");
		 String ExpectedMessageDisplayed = ssdResult.SSDResNoSSDMessageDisplay.getText();
		 System.out.println("No SSDs Available For The Invalid Search" + ExpectedMessageDisplayed);
		 Assert.assertEquals(ActualMessageDisplayed,ExpectedMessageDisplayed);
		}
		
		// Scroll Up To Check the Export Excel and CSV Visibility 
		ScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResultPrintLink);
		//Load = LoadSSDs.until(ExpectedConditions.invisibilityOf(ssdResult.SSDResultExportExcel));
		//if(Load == true)
		//Assert.assertFalse(ssdResult.SSDResultExportExcel.isDisplayed(), "Export Excel Is Not Visible");
		System.out.println(ssdResult.SSDResultExportExcel.getText() + ssdResult.SSDResultExportExcel.isDisplayed());
		
		Assert.assertFalse(ssdResult.SSDResultExportCSV.isDisplayed(), "Export CSV Is Not Visible");
		/*{
			System.out.println("Export Excel Is Not Visible");
		}
		Load = LoadSSDs.until(ExpectedConditions.invisibilityOf(ssdResult.SSDResultExportCSV));
		if(Load == true)
		{
			System.out.println("Export CSV Is Not Visible");
		} */
		
	}
	@Test(priority = 13, description = "Click on Start Over, It Directs to SSD Home Page")
	public void ToVerifyResultPageClickStartOver()
	{
		System.out.println("Result Page Test Cases are Executed Successfully");
		ssdResult.SSDResultStartOverLink.click();
	}
	
	@AfterTest(description = "Close Browser")
	public void TearDown()
	{
		driver.close();
	} 
	
}
