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

public class SSDVROAll extends BaseClass
{
	public SSDVROAll()
	{
		super();
	}
	HomePage 					ssdHomepage;
	SSDWorkloadPage				ssdWorkload;
	SSDSSDTypePage 				ssdSSDType;
	SSDServerTypePage			ssdServertype;
	SSDInterfacePage			ssdInterface;
	SSDFormFactorPage			ssdFormfactorType;
	SSDBestAvailabilityPage     ssdBestAvailabilitytype;
	SSDResultPage				ssdResult;	
	
@BeforeTest(description = "To Lauch SSD Selector Tool Site And To Select Very Read Optimized (VRO) Workloads")
	
	@Test(priority = 1, description = "To Verify the Home Page To Launch The SSD Selector Tool")
	public void ToVerifyHomepage()
	{
		// For Launching the SSD Site on Chrome Browser
		Intialization();
		
		// To Verify the SSD Version in the Alert Box
		ssdHomepage = new HomePage();
		Assert.assertTrue(ssdHomepage.VerifyPopUp(), "HPE Solid-State Drive Selector v2.0.1");
		
		// In Alert Message Popup Click on "I Agree" 
		ssdHomepage.ClickAgreeButton();
		
	}
	
	@Test(priority = 2, description = "To Verify Home Page Components ")
	public void ToVerifyHomePageLabels()
	{
		// To Check the Homepage URL 
		String ActualSSDHomePageURL = Prop.getProperty("HomePage");
		String ExpectedSSDHomePageURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDHomePageURL, ExpectedSSDHomePageURL);
		
		// To Verify Home Page Components
		Assert.assertTrue(ssdHomepage.VerifyIKnowBtnLabel(), "I Know What I Need Btn Is Displayed");
		
		Assert.assertTrue(ssdHomepage.VerifyHelpChooseBtnLabel(), "Help Me Choose Btn Is Displayed");
		
		Assert.assertTrue(ssdHomepage.VerifyReleaseLinkLabel(), "Release Notes Link Is Displayed");
		
		Assert.assertTrue(ssdHomepage.VerifyManualLabel(), "User Manual Like Is Displayed");
	}
	
	@Test(priority = 3, description = "To Verify Home Page, PDF files are opening")
	public void ToVerifyHomePagePDFFilesOpen()
	{
		// To Open Release Notes
		ssdHomepage.ClickReleaseNotes();
		
		//To Open User Manual
		ssdHomepage.ClickUserManual();
		
		// Click on Help me Choose Option in Home Page
		
		ssdHomepage.ClickOnHelpMeBtn();
		System.out.println("--------------------! Home Page Components Are Displayed Successfully !------------------");
	}
	
	@Test(priority = 4, description = "To Verify Workload Page URL SSDWorkloadPage ")
	public void ToVerifyWorkloadURL()
	{
		String ActualWorkloadURL = Prop.getProperty("WorkLoadPage");
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		System.out.println("Workload Page URL :-" + ExpectedWorkloadURL);
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	
	@Test(priority = 5, description = "To Verify Workload display based on the Performance")
	public void ToVerifyDisplayOfWorkloads()
	{
		ssdWorkload = new SSDWorkloadPage();
		ssdWorkload.CoordinatesofWorkloads();
		//Assert.assertTrue(ssdWorkload.CoordinatesofVROWorkloads(),"VRO Workload Column Is Displayed At 1st");
	}
	
	@Test(priority = 6, description = "To Verify WorkloadPage Components")
	public void ToVerifyWorkloadPageComponents()
	{
		// 
		Assert.assertTrue(ssdWorkload.WorkloadComponents(), "All Workload Components Are Displayed");
		//
		Assert.assertFalse(ssdWorkload.WorkloadSelectAll.isSelected(), "Options are not Selected");
	}
	
	@Test(priority = 7, description = "To Verify To Select VRO workloads")
	public void ToVerifyToSelectVROWorkloads()
	{
		ssdWorkload.SelectVROALL();
	}
	 
	@Test(priority = 8, description = "To Verify PDF file is opened in WorkloadPage")
	public void ToVerifyToOpenPDFFile()
	{
		ssdWorkload.WorkloadPDF();
	}
	
	@Test(priority = 9, description = "To Verify Back Btn Is redirecting to Home Page")
	public void ToVerifyWorkloadBackBtn()
	{
		WebDriverWait HomePageLoad = new WebDriverWait(driver, 1);
		ssdWorkload.BackBtn();
		
		
		boolean PageLoad = HomePageLoad.until(ExpectedConditions.textToBePresentInElement(ssdHomepage.SSDPopUpText, Prop.getProperty("SSDVersionDetails")));
		if(PageLoad == true)
		{
			// To Redirects to HomePage and Click on "I Agree" Btn
			ssdHomepage.ClickAgreeButton();
		}
		
		System.out.println("--------! In Workload Page, Clicked on Back Button, To Verify it Redirect to Home Page !---------");
		//Home Page URL 
		String ActualWorkloadURL = Prop.getProperty("HomePage1");
		String ExpectedWorkloadURl = driver.getCurrentUrl();
		System.out.println("Home Page URL :- " + ExpectedWorkloadURl);
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURl);
		
		// Click on "Help Me Choose"
		ssdHomepage.ClickOnHelpMeBtn();
	}
	
	@Test(priority = 10, description = "To Select Very Read Optimized Workloads from Workload Page")
	public void ToVerifyToSelectVeryReadOptimizedWorkloads()
	{
		// Select All Very Read Optimized Workloads
		ssdWorkload.SelectVROALL();
		
		// Click on Next Btn In Workload Page
		ssdWorkload.ClickNextBtn();
		System.out.println("--------------------! Workload Page Components Are Displayed Successfully !------------------");
	}
	
	@Test(priority = 11, description = "To Verify Next Btn of Workload Page is redirecting to SSD Page")
	public void ToVerifySSDPageDisplayed()
	{
		// SSD Page is displayed
		ssdSSDType = new SSDSSDTypePage();
		String ActualSSDURL = Prop.getProperty("SSDPage");
		String ExpectedSSDURL = driver.getCurrentUrl();
		System.out.println("SSD Page Load :- " + ExpectedSSDURL);
		Assert.assertEquals(ActualSSDURL,ExpectedSSDURL);
	}
	
	@Test(priority = 12, description = "To Verify In SSD Page, SSD Type Is Auto Selected ")
	public void ToVerifySSDTypeIsSelected()
	{
		// SSD type is Auto Selected
		Assert.assertTrue(ssdSSDType.VeryReadOptionSelected(), "Very Read Optimized Selected");
		
	}
	
	@Test(priority = 13, description = "To Verify Very Read Optimized Is Selected Click on Back Btn in SSD Page")
	public void ToVerifyVeryReadOptimizedSelected()
	{
		// Click Back Btn in SSD Page
		ssdSSDType.SSDBackBtn();
		
		// To Check Selected Very Read Optimized Workloads are Retained
		Assert.assertTrue(ssdWorkload.VerifyVeryReadOptimizedWorkloadsSelected(), "Very Read Optimized Workloads Are Selected");
		
		// Click on Next Btn in Workload page
		ssdWorkload.ClickNextBtn();
		
		// Click on Next Btn in SSD Page
		ssdSSDType.SSDNextBtn();
		
	}
	
	@Test(priority = 14, description = "To Verify Server Type Page Is Displayed")
	public void ToVerifyServerTypePageDisplayed()
	{
		ssdServertype = new SSDServerTypePage();
		// Server Type Page is Displayed
		String ActualServerTypeURL = Prop.getProperty("ServerTypePage");
		String ExpectedServerTypeURL = driver.getCurrentUrl();
		System.out.println("Server Type Page URL :- " + ExpectedServerTypeURL);
		Assert.assertEquals(ActualServerTypeURL, ExpectedServerTypeURL);
	}
	
	@Test(priority = 15, description = "To Verify Server Type Menu Bar")
	public void ToVerifyServerTypeMenuBar()
	{
		Assert.assertTrue(ssdServertype.MenuBarServerType(), "In Menu bar, Server Type Is Displayed");
	}
	
	@Test(priority= 16, description = "To Verify Server Type Page Components")
	public void ToVerifyServerPageLabels()
	{
		// Server Type Label
		Assert.assertTrue(ssdServertype.ServerTypeLabel(),"Server Type Is Displayed");
		
		//Server Model Label Is Displayed
		Assert.assertTrue(ssdServertype.ServerModelLabel(), "Server Model Is Displayed");
		
		//Capacity Label
		ssdServertype.VeryReadOptimizedMaximumCapacityValue();
		
	}
	
	@Test(priority = 17, description = "To Verify Server Type and Server Model")
	public void ToVerifyServerTypeServerModel() throws InterruptedException
	{
		//To Check the Server Type and Server Model
		ssdServertype.CompareServerTypeServerModel();
	}
	
	@Test(priority = 18, description = "Select the Server Type and Server Model")
	public void ToSelectServerTypeServerModel()
	{
		// For Selecting the Server Type 
		ssdServertype.VeryReadOptimizedSelectedServerType();
		// For Selecting the Server Model
		ssdServertype.VeryReadOptimizedSelectedServerModel();
	}
	
	@Test(priority = 19, description = "To Verify Capacity Maximum to Minimum")
	public void ToVerifyCapacityAlert()
	{
		WebDriverWait CapacityAlertLoad = new WebDriverWait(driver, 1);
		// In Capacity Part, Move the Maximum point to Min Point
		ssdServertype.SelectCapacityMoveMaxtoMin();
		// Click on next To Verify Alert Message to Display
		ssdServertype.ClickServerTypeNextBtn();
		boolean CapaAlertLoad = CapacityAlertLoad.until(ExpectedConditions.textToBePresentInElement(ssdServertype.SSDAlertMessage, Prop.getProperty("NoServerTypeAlertMessage")));
		if(CapaAlertLoad == true)
		{
			//Alert Message Display
			Assert.assertTrue(ssdServertype.VerifyAlertMessageDisplayed(), "Alert Message Is Displayed");
		}
		// Click on Alert Message
		ssdServertype.ClickAlertOk();
	}
	
	@Test(priority = 20, description = "Move the Max Point to Middle")
	public void ToMaximumPtToMiddlePt()
	{
		// Move the Slider to Middle
		ssdServertype.SelectCapacityMoveMintoMax();
		//
		ssdServertype.ClickServerTypeNextBtn();
	}
	
	 @Test(priority = 21, description = "Interface Page is displayed and Options are auto Selected")
	public void ToVerifyInterfacePage()
	{
		 ssdInterface = new SSDInterfacePage();
		 WebDriverWait InterfacePageLoad = new WebDriverWait(driver, 5);
		 InterfacePageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("InterfacePage")));
		// To Check Interface Page is displayed
		String ActualInterfaceURL = Prop.getProperty("InterfacePage");
		String ExpectedInterfaceURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualInterfaceURL, ExpectedInterfaceURL);
		JavascriptExecutor InterfaceScrollDown = (JavascriptExecutor)driver;
		// 
		InterfaceScrollDown.executeScript("arguments[0].scrollIntoView();", ssdInterface.SSDInterfaceBackBtn);
		InterfaceScrollDown.executeScript("arguments[0].click()", ssdInterface.SSDInterfaceBackBtn);
	}
	
	 @Test(priority = 22, description = "To Verify Selected Values retained in SSD Page on Click on Back Btn in Server Type Page")
		public void ToVerifySSDValues()
		{
			//To Check Selected Server Type and Server Model retained
			ssdServertype.VeryReadOptimizedSelectedRetainedCheck();
			//Click Next Btn In Server type Page
			ssdServertype.ClickServerTypeNextBtn();
		System.out.println("--------------------! Server Type Page Components Are Displayed Successfully !------------------");
		}
	@Test (priority = 23, description = "Options are auto Selected")
	public void ToVerifyInterfaceLabels()
	{
		// Check Interface Options
		Assert.assertTrue(ssdInterface.VeryReadOptimizedInterfaceOption(), "Interface Options Are AutoSelected With SATA VRO");
	}
	
	@Test (priority = 24, description = "To Edit the Interface options")
	public void ToEditInterfaceOptions()
	{
		// 
		Assert.assertFalse(ssdInterface.EditVROInterfaceOption(),"Select All Option Is Not There");
		
		// Again Click on SATAVRO in Interface Page
		ssdInterface.RetainVROInterfaceOption();
		
		// Click  Next Btn in Interface Page
		ssdInterface.InterfaceNextBtn();
		
	}
	
	@Test(priority = 25, description = "To Check Values are retained  ")
	public void ToVerifyEditedOptionsRetained()
	{
		ssdFormfactorType = new SSDFormFactorPage();
		//Let Page Load Completely
		 WebDriverWait FormFactorPageLoad = new WebDriverWait(driver, 5);
		 FormFactorPageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("FormFactorPage")));
		 
		//To Check the Values are retained 
		ssdFormfactorType.FormFactorBackBtn();
		
		System.out.println("--------------------! Interface Types Page Components are Retained on Click Back Button In Form Factor Page !------------------");
		//To Check the Interface options are retained
		Assert.assertTrue(ssdInterface.VeryReadOptimizedInterfaceOption(), "SATAVRO Is Selected");
		
		
		// Click Next Btn in Interface Page
		ssdInterface.InterfaceNextBtn();
		System.out.println("--------------------! Interface Types Page Components Are Displayed Successfully !------------------");
		
	}
	
	@Test(priority = 26, description = "Form Factor Page Display")
	public void ToVerifyFormFactorPage()
	{
		String ActualFormFactorURL = Prop.getProperty("FormFactorPage");
		String ExpectedFormFactorURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualFormFactorURL, ExpectedFormFactorURL);
	}
	
	@Test(priority = 27, description = " FormFactors are autoSelected ")
	public void ToVerifyFormFactorOptions()
	{
		WebDriverWait FormFactorPageLoad = new WebDriverWait(driver, 2);
		boolean FFPageLoad = FormFactorPageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("FormFactorPage")));
		if(FFPageLoad == true)
		{
			// FormFactor Page types
			Assert.assertTrue(ssdFormfactorType.VeryReadOptimizedSelectFormFactorType(),"Select All Option Is Selected In FormFactor Page");
		}
	}
	
	@Test(priority = 28, description = "Form Factor Options Can be edited ")
	public void ToEditFormFactionOptions()
	{
		// Form Factor Options can edit 
		Assert.assertFalse(ssdFormfactorType.VeryReadOptimizedEditFormFactorOption(), "Select All Option is not Selected");
		
		 
		// Click Next Btn in Form Factor
		ssdFormfactorType.FormFactorNextBtn();
	}
	
	@Test(priority = 29, description = "Form Factor Options Edited ")
	public void ToVerifyEditedOptionRetained()
	{
		ssdBestAvailabilitytype = new SSDBestAvailabilityPage();
		//Let Page Load Completely
		 WebDriverWait BestAvailabilityPageLoad = new WebDriverWait(driver, 5);
		 BestAvailabilityPageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("MainstreamPage")));
		
		// To Check Selected Values are retained on Click Back Btn in FormFactor
		ssdBestAvailabilitytype.BestAvailBackBtn();
		
		System.out.println("--------------------! Form Factor Types Page Components are Retained on Click Back Button In Best Availability Page !------------------");
		//To Check retained values in Form Factor Page
		Assert.assertFalse(ssdFormfactorType.SSDFormFactorSelectAll.isSelected(), "Select All Option is not Selected");
		
		//Select All Option is Selected
		Assert.assertTrue(ssdFormfactorType.VeryReadOptimizedFormFactorAsItIs(), "Select All Option is Selected");
		
		// Click Next Btn in Form Factor Page
		ssdFormfactorType.FormFactorNextBtn();
		
		System.out.println("--------------------! Form Factor Types Page Components Are Displayed Successfully !------------------");
	}
	
	@Test(priority = 30, description = " Mainstream Page is displayed ")
	public void ToVerifyBestAvailabilityPageDisplayed()
	{
		String ActualMainstreamURL = Prop.getProperty("MainstreamPage");
		String ExpectedMainstreamURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualMainstreamURL, ExpectedMainstreamURL);
		
		// By Default Main Stream option is selected
		Assert.assertTrue(ssdBestAvailabilitytype.BestAvailMainstream(), "MainStream Option is Selected");
	}
	
	@Test(priority = 31, description = "Edit Mainstream options in Best Availability Page")
	public void ToVerifyToEditSelectedOption()
	{
		//
		Assert.assertFalse(ssdBestAvailabilitytype.EditMainStreamOption(), "Select All Option is Not Selected and Next Btn is Not Enabled in Best Availability Page");
		
		//Click on Mainstream and NonMainstream options to enable the Select All Option in MainStream Page
		Assert.assertTrue(ssdBestAvailabilitytype.ReadEditMainstream(), "Select All option is Selected");
		
		//Click Next Btn In Mainstream Page
		ssdBestAvailabilitytype.BestAvailNextBtn();
		
		System.out.println("--------------------! Best Availability Page Components Are Displayed Successfully !------------------");
		
	}
	
	@Test(priority = 32, description = "Result Page is Displayed")
	public void ToVerifyResultPageDisplayed()
	{
		ssdResult = new SSDResultPage();
		String ActualResultPageURL = Prop.getProperty("ResultPage");
		String ExpectedResultPageURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualResultPageURL,ExpectedResultPageURL);
	}
	
	@Test(priority = 33, description = "SSD Workload Only Read Intensive should be selected")
	public void ToVerifyWorkloadSelectedOptionDisplayed()
	{
		// Very Read Optimized Workload Is Selected
		Assert.assertTrue(ssdResult.SSDResVRO.isSelected(), "Very Read Optimized Is Selected");
	}
	
	@Test(priority = 34, description = "SSD Intenface Options Selected")
	public void ToVerifySelectedInterfaceOptionsDisplayed()
	{
		Assert.assertTrue(ssdResult.SSDResInterfaceSATAVRO.isSelected(), "Interface Options are Selected");
	}
	
	@Test(priority = 35, description = "SSD Form Factor Options Selected")
	public void ToVerifySelectedFormFactorDisplayed()
	{
		Assert.assertTrue(ssdResult.VeryReadOptimizedSSDFormFactorTypeSelected(), "Form Factor Options are Selected");
	}
	
	@Test(priority = 36, description = "Mainstream and Non-Mainstream is Selected")
	public void ToVerifySelectedCatergoryDisplayed()
	{
		Assert.assertTrue(ssdResult.BestCatergorySelected(), "Mainstream and NonMainstream Is Selected");
	}
	
	@Test(priority = 37, description = "To Verify The Selected Server type and Server Model Is Displayed ")
	public void ToVerifySelectedServerTypeDisplayed()
	{
		// To Check the Server Type in Result Page
		ssdResult.VeryReadOptimizedSelectedResultPageServerType();
		// To Check the Server Model in Result Page
		ssdResult.VeryReadOptimizedSelectedResultPageServerModel();
		// To Check the Max Capacity Slider
		ssdResult.ResultPageVeryReadOptimizedSSDCapacityMaxSliderText();
	}
	
	@Test(priority = 38, description = " All Slider Labels Are displayed")
	public void ToVerifySliderLables()
	{
		// Endurance Labels  :- 
		Assert.assertTrue(ssdResult.SSDEnduranceLabel(),"Endurance Label Is Displayed");
		// 4K MAX Random Read IOPS :- 
		Assert.assertTrue(ssdResult.SSDRandomMaxReadLabel(), "4K MAX Random Read IOPS");
		// 4K MAX Random Write IOPS :- 
		Assert.assertTrue(ssdResult.SSDRandomMaxWriteLabel(), "4K MAX Random Write IOPS");
		// 4K Q16 Random Read IOPS :- 
		Assert.assertTrue(ssdResult.SSDRandReadIOPSLabel(), "4K Q16 Random Read IOPS");
		// 4K Q16 Random Write IOPS :- 
		Assert.assertTrue(ssdResult.SSDRandomWriteIOPSLable(), "4K Q16 Random Write IOPS");
		
	}
	
	@Test(priority = 39, description = "SSDs Results Displayed Based on the Selected Server Type and Server Model ")
	public void ToVerifySSDResultsDisplayedBasedOnServerType()
	{
		JavascriptExecutor VROSSDResults = (JavascriptExecutor)driver;
		VROSSDResults.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		WebDriverWait VROSSDs = new WebDriverWait(driver,5);
		boolean VROResultDisplay = ssdResult.SSDResResultDisplayLink1;
		VROResultDisplay = VROSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VeryReadOptimizedSSDsResultBasedOnServerType")));
		if(VROResultDisplay == true)
		{
			String ActualWriteIntensiveSSDs = Prop.getProperty("VeryReadOptimizedSSDsResultBasedOnServerType");
			String ExpectedWriteIntensiveSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Very Read Optimized SSDs Results Based on Selected Server Type and Server Model :- " + ExpectedWriteIntensiveSSDs);
			Assert.assertEquals(ActualWriteIntensiveSSDs, ExpectedWriteIntensiveSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		}
		
	}
	
	@Test(priority = 40, description = " To Verify to Export CSV File")
	public void ToVerifyDownloadExportCSVFile() throws InterruptedException
	{
		if(ssdResult.DownloadCSVFile() == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("File Not Found");
		}
	}
	
	@Test(priority = 41, description = " To Verify to Export Excel File")
	public void ToVerifyDownloadExportExcelFile() throws InterruptedException
	{
		if(ssdResult.DownloadExcelFile() == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("File Not Found");
		}
	}
	
	@Test(priority = 42, description = " Change The Server Type To -- Please Select Server type --")
	public void ToVerifySSDsUponSelectingServerTypeToPleaseSelectServerType()
	{
		//To Change the Server Type to -- Please Select Server type -- and To Know Check the All Read SSDs
		ssdResult.ToChangeServerTypeToPleaseSeverType();
	}
	
	@Test(priority = 43, description = "To Check All Very Read Optimized SSDs Are Displayed ")
	public void ToVerifyAllVeryreadOptimizedSSDsDisplayedOnSelectServerType()
	{
		//To move the Cursor Scroll Down to SSD Results
		JavascriptExecutor SSDResultsScrollDown = (JavascriptExecutor)driver;
		SSDResultsScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		
		WebDriverWait WriteIntensiveSSDs = new WebDriverWait(driver,10);
		boolean WriteResultDisplay = ssdResult.SSDResResultDisplayLink1;
		WriteResultDisplay = WriteIntensiveSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VROSSDs")));
		if(WriteResultDisplay == true)
		{
			String ActualWriteSSDs = Prop.getProperty("VROSSDs");
			String ExpectedWriteSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Very Read Optimized SSDs With Mainstream and NonMainstream :- " + ExpectedWriteSSDs);
			Assert.assertEquals(ActualWriteSSDs, ExpectedWriteSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		}
	}
	 
	// To Check Only Read SSDs should be displayed
	@Test(priority = 44, description = " To Verify Only Very Read Optimized SSDs Are Displayed ")
	public void ToVerifyOnlyVeryReadOptimizedSSDsDisplayed()
	{
		Assert.assertTrue(ssdResult.SSDOnlyVROResults.isDisplayed(), "Only Very Read Optimized");
	}
	
	// Click on ShowMore Link
	@Test(priority = 45, description = " To Verify Click on Show More Link")
	public void ToVerifyShoweMoreLink()
	{
		ssdResult.SSDResultShowmoreLink();
	}
	
	// To Check the PDF file Download for Individual SSDs
	@Test(priority = 46, description = "To Verify To Download PDF File For Individual SSDs")
	public void ToVerifyDownloadPDFFileIndividualSSDs() throws InterruptedException
	{
		if(ssdResult.DownloadPDFFile() == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("File Not Found For Individual Excel File ");
		}
	}
	
	@Test(priority = 47, description = "To Verify To Download Excel File For Individual SSDs")
	public void ToVerifyDownloadIndividualExportExcelFile() throws InterruptedException
	{
		if(ssdResult.DownloadIndividualExcelFile() == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("File Not Found For Individual Excel File ");
		}
	}

/*// Click on Price Link
	@Test(priority = 48, description = "To Verify Price Link Is Opened")
	public void ToVerifyPriceLink()
	{
		ssdResult.SSDResultPriceLink();
	} */
		
// Click on Browser Back Button 
	@Test(priority = 49, description = "To Verify Best Availability Page Displayed")
	public void ToVerifyBrowserBackButton()
	{
		// Browser Back Button
		driver.navigate().back();
		
		WebDriverWait MainstreamPageLoad = new WebDriverWait(driver, 1);
		boolean MainPageLoad = MainstreamPageLoad.until(ExpectedConditions.urlToBe("MainstreamPage"));
		if(MainPageLoad == true)
		{
			// To Confirm the Best Availability Page
			String ActualMainstreamURL = Prop.getProperty("MainstreamPage");
			String ExpectedMainstreamURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualMainstreamURL, ExpectedMainstreamURL);
		}
			
		// To Check Select All is Selected in the Best Availability Page
		Assert.assertTrue(ssdBestAvailabilitytype.SSDBestAvailSelectAll.isSelected(), "Select All Option is Selected");
			
		// UnCheck the Non Mainstream Option
			
		ssdBestAvailabilitytype.EditNonMainstream();
	}
	
// CLick on Browser Forward Button
	@Test(priority = 50, description = "To Verify Home Page Is Displayed")
	public void ToVerifyItRedirectsToHomePage()
	{
		// Click on Browser Forward Button
		driver.navigate().forward();
		
		WebDriverWait HomePageLoad = new WebDriverWait(driver, 1);
		boolean HPageLoad = HomePageLoad.until(ExpectedConditions.urlToBe("HomePage1"));
		if(HPageLoad == true)
		{
			// 
			String ActualMainstreamURL = Prop.getProperty("HomePage1");
			String ExpectedMainstreamURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualMainstreamURL, ExpectedMainstreamURL);	
		}
	}

	@AfterTest(description = "Once All TestCases are Executed, then Close the Opened Browser")
	public void SSDBrowserClose()
	{
		driver.close();
	}  
	 
}
