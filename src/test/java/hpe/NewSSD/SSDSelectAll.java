package hpe.NewSSD;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Java;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class SSDSelectAll extends BaseClass
{
	
	HomePage ssdHomepage;
	SSDWorkloadPage ssdWorkload;
	SSDSSDTypePage ssdSSDtype;
	SSDServerTypePage ssdServertype;
	SSDInterfacePage ssdInterface;
	SSDFormFactorPage ssdFormfactor;
	SSDBestAvailabilityPage ssdBestAvailability;
	SSDResultPage	ssdResult;
	
	public SSDSelectAll()
	{
		super();
	}
	
	@BeforeTest (description = "!---------Lauches the SSD Selector Application Tool--------!")
	
	@Test(priority = 0, description = " To Verify URL is Launched")
	public void ToVerifySSDURL()
	{
		Intialization();
		ssdHomepage = new HomePage();
		String ActualHomePageURL = Prop.getProperty("HomePage");
		String ExpectedHomePageURL = driver.getCurrentUrl();
		System.out.println("Home Page:-" + ExpectedHomePageURL);
		Assert.assertEquals(ActualHomePageURL, ExpectedHomePageURL);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Assert.assertTrue("Alert Message is displayed and Version is Checked", ssdHomepage.VerifyPopUp());
	}
	
	@Test(priority = 1, description = "To Verify the Labels in Home Page")
	public void ToVerifyHomePageLables()
	{
		ssdHomepage.ClickAgreeButton();
		Assert.assertTrue("I Know What I Need Btn Visible", ssdHomepage.VerifyIKnowBtnLabel());
		Assert.assertTrue("Help Me Choose Btn Visible", ssdHomepage.VerifyHelpChooseBtnLabel());
		Assert.assertTrue("Release Notes is displayed", ssdHomepage.VerifyReleaseLinkLabel());
		Assert.assertTrue("User Manual Link is Visible", ssdHomepage.VerifyManualLabel());
	}
	
	@Test(priority = 2, description = "To Verify the Release Notes and User Manual Link is opened")
	public void ToVerifyPDFFileLinkOpen()
	{
		ssdHomepage.ClickReleaseNotes();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		ssdHomepage.ClickUserManual();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		ssdHomepage.ClickOnHelpMeBtn();
	}
	@Test(priority = 3, description = " To Verify URL is launched")
	public void ToVerifySSDWorkloadPage()
	{
		//SSD Workload URL is Launched
		ssdWorkload = new SSDWorkloadPage();
		String ActualWorkloadURL = Prop.getProperty("WorkLoadPage");
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedWorkloadURL, ActualWorkloadURL);
	}
	
	@Test(priority = 4, description = "To Verify All Option are selected, on Click on Select/All option")
	public void ToVerifySelectAllOption()
	{
		ssdWorkload.AllWorkloadSelect();
	}
	
	/*@Test(priority = 2, description = "To Verify All Workloads are selected or not")
	public void ToVerifyAllWorkloadsSelected()
	{
		//To Verify the Select All Option is selected in Workload 
		
	}*/
	
	@Test(priority = 5, description = "To Verify About Workloads PDF File is opened")
	public void ToVerifyPDFFileOpened()
	{
		ssdWorkload.WorkloadPDF();
	}
	
	@Test (priority = 6, description = "To Verify the Menu bar in workload page")
	public void ToVerifyWorkloadMenuBar()
	{
		ssdWorkload.MenubarWorkload();
	}
	@Test(priority = 7, description = "To Verify Home Page displayed on click on Back Button")
	public void ToVerifyClickonBackBtn()
	{
		ssdWorkload.BackBtn();
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		// Redirects to Home Page of SSD Selector URL
		//ToVerifySSDURL();
		String ActualHomePageURL = Prop.getProperty("HomePage1");
		String ExpectedHomePageURL = driver.getCurrentUrl();
		System.out.println("Click on Back Button In Workload Page To Verify Home Page Displayed");
		System.out.println("HomePage After 2nd Time:-" + ExpectedHomePageURL);
		Assert.assertEquals(ActualHomePageURL, ExpectedHomePageURL);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		// Click on Agree Btn
		ssdHomepage.ClickAgreeButton();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//Click on Help me Choose
		ssdHomepage.ClickOnHelpMeBtn();
		System.out.println("--------------------! Home Page Components Are Displayed Successfully !------------------");
	}
	
	@Test(priority = 8, description = "Click on Select All Option and Verfiy the Next is Enabled")
	public void ToVerfyNextBtnEnabled()
	{
		// All Workload Options are selected
		ssdWorkload.AllWorkloadSelect();
		// To Verify Next Btn is enabled
		Assert.assertTrue("Next Btn is Enabled", ssdWorkload.NextButtonEnabled());
		//Click on Next Btn
		ssdWorkload.ClickNextBtn();
	}
	
	@Test(priority = 9, description = "To Verify SSD Page is enabled")
	public void ToVerifySSDPage()
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		ssdSSDtype = new SSDSSDTypePage();
		String ActualSSDTypePageURL = Prop.getProperty("SSDPage");
		String ExpectedSSDTypePageURL = driver.getCurrentUrl();
		Assert.assertEquals("SSD Type URL is Displayed", ExpectedSSDTypePageURL, ActualSSDTypePageURL);
	}
	
	@Test(priority = 10, description = "To Verify SSD Types are Autoselected")
	public void ToVerifySSDTypesAutoSelected()
	{
		//To Check all Options are selected
		Assert.assertTrue("All Options are Auto Selected in SSD-Type Page",ssdSSDtype.EditSSDOptions());
	}
	
	@Test(priority = 11, description = "To Verify Menu Bar in SSD Page")
	public void ToVerifySSDTypeMenuBar()
	{
		Assert.assertTrue("SSD type Is Enabled In SSD Type Page",ssdSSDtype.MenubarSSDType());
	}
	
	@Test(priority = 12, description = "To Verfiy in Menu Bar Workload is enabled in SSD Page")
	public void ToVerifySSDTypeWorkloadMenuBar()
	{
		Assert.assertTrue("Workload Is Enabled In Menu bar", ssdWorkload.SSDMenubarWorkload.isEnabled());
	}
	
	@Test(priority = 13, description = "To Verify Able to Edit the Autoselected Options in SSD Type")
	public void ToVerifyToEditSSDTypeAutoSelectedOptions()
	{
		Assert.assertFalse("SSD options are Editable", ssdSSDtype.EditSSDSelectAll());
		// Click on Back Btn in SSD Page
		ssdSSDtype.SSDBackBtn();
	}
	
	@Test(priority = 14, description = "To Verify Selected Workloads are displayed on Click on Back Btn in SSD Page ")
	public void ToVerifySelectedWorkloadsDisplayed()
	{
		// Verify Select All Option is selected
		Assert.assertFalse("Select All Option is selected ", ssdWorkload.SelectAllOption());
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		ssdWorkload.ClickNextBtn();
		System.out.println("--------------------! Workload Components Are Displayed Successfully !------------------");
	}
	
	@Test(priority = 15, description = "To Verify selected Options are displayed")
	public void ToCheckOptionsAreAutoSelected()
	{
		// Verify Select All Option is selected in SSD Type
		Assert.assertTrue("SSD type all Options are Selected", ssdSSDtype.EditSSDOptions());
	}
	
	@Test(priority = 16, description = "To Verify Next Btn is redirecting to Server Type Page")
	public void ToVerifyNextBtnInSSDPage()
	{
		// Verify Next Btn is Enabled in SSD type Page
		Assert.assertTrue("Next Btn Is Enabled", ssdSSDtype.NextBtn());
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		//Click on Next Btn in SSD type
		ssdSSDtype.SSDNextBtn();
	}
	
	@Test(priority = 17, description = "To Verify Menu Bar in Server Type Page")
	public void ToVerifyServerTypePageMenubar()
	{
		//Server type in Menu Bar
		ssdServertype = new SSDServerTypePage();
		//To Verify Server Type is Enabled in Menu Bar in Server type Page
		Assert.assertTrue("Server type Is Enabled In Menu Bar",ssdServertype.MenuBarServerType());
		
	}
	
	@Test(priority = 18, description = "To Verify Other Pages names Displayed in Menu bar")
	public void ToVerifyOtherPageNamesInMenuBar()
	{
		Assert.assertTrue("Workload type Is Enabled In Menu Bar", ssdWorkload.SSDMenubarWorkload.isEnabled());
		//
		Assert.assertTrue("SSD type is Enabled In Menu Bar", ssdSSDtype.MenubarSSDType());
		System.out.println("--------------------! SSD Type Page Components Are Displayed Successfully !------------------");
	}
	
	@Test(priority = 19, description = "To Verify Server Type Drop Down Label")
	public void ToVerifyServerTypeLabel()
	{
		//Select Server Type Label is displayed in Server Type
		Assert.assertTrue("Server Type Label Is Displayed In Server Type ",ssdServertype.ServerTypeLabel());
	}
	
	@Test(priority = 20, description = "To Verify Server Model Drop Down Label")
	public void ToVerifyServerModelLabel()
	{
		//Select Server Model Label is displayed in Server Type
		Assert.assertTrue("Server Model Label Is Displayed In Server Type ",ssdServertype.ServerModelLabel());
	}
	
	@Test(priority = 21, description = "To Verify Capacity Label")
	public void ToVerifyCapacityLabel()
	{
		//Select Capacity Label is displayed in Server Type Page
		Assert.assertTrue("Capacity Label Is Displayed In Server Type",ssdServertype.CapacityLabel());
	}
	
	@Test(priority = 22, description = "To Verify the Server Type and Server Model from the Drop Down")
	public void ToVerifyServerTypeServerModelList() throws InterruptedException
	{
		//Verify Server type and Server Model List
		Assert.assertTrue("Server Type and Model List Is Displayed",ssdServertype.CompareServerTypeServerModel());
	}
	
	@Test(priority = 23, description = "To Verify the Capacity Value")
	public void ToVerifyCapacityValue()
	{
		//Verify Maximum Point Capacity Value
		ssdServertype.MaximumCapacityValue();
	}
	
	@Test(priority = 24, description = "To Verify Select All Option is Selected in Server Type Page")
	public void ToVerifyServerTyeSelectAllOption()
	{
		// Click on Select All in Server Type Page
		ssdServertype.ClickSeverTypeSelectAll();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//To Verify Server Type Select All is Enabled
		System.out.println(ssdServertype.ServerTypeSelectAll());
		Assert.assertFalse("Select All Option Is Selected In Server Type Page", ssdServertype.ServerTypeSelectAll());
		//Click Back Btn In Server Type Page
		ssdServertype.ClickServerTypeBackBtn();
	}
	
	@Test(priority = 25, description = "To Verify Next Btn is Enabled")
	public void ToVerifyNextBtnEnabled()
	{
		//Redirects to SSD type page to Check the Selected Values are retained
		Assert.assertTrue("All Options Are In Selected Mode",ssdSSDtype.EditSSDOptions());
		//Click Next Btn in SSD Type Page
		ssdSSDtype.SSDNextBtn();
	}
	
	@Test(priority = 26, description = "To Click on Next Btn in Server Type Page")
	public void ToVerifyServerTypeNextBtn()
	{
		//Redirects to Server type page to Check the Selected Values are retained
		Assert.assertFalse("Select All Option Is Selected In Server Type Page", ssdServertype.ServerTypeSelectAll());
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		ssdServertype.ClickSeverTypeSelectAll();
		ssdServertype.ClickServerTypeNextBtn();
		System.out.println("--------------------! Server Type Page Components Are Displayed Successfully !------------------");
	}
	
	@Test(priority = 27, description = "To Verify Menu Bar in Interface Type Page")
	public void ToVerifyInterfaceMenuBar()
	{
		// To Verify Interface Page URL Is Displayed
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	//ssdInterface = new SSDInterfacePage();
		String ActualInterfaceURL = Prop.getProperty("InterfacePage");
		String ExpectedInterfaceURL = driver.getCurrentUrl();
		System.out.println("InterfaceURL:-" + ExpectedInterfaceURL);
		Assert.assertEquals(ActualInterfaceURL,ExpectedInterfaceURL);
	}
	
	@Test(priority = 28, description = "To Verify In Menu Bar, Other Pages Names are visible")
	public void ToVerifyInterfaceOtherPageMenuBar()
	{
		//Interface Type Is Displayed in Menu Bar
		ssdInterface = new SSDInterfacePage();
		Assert.assertTrue("Interface Types Is Enabled In Interface Type",ssdInterface.SSDMenubarInterfacepageType.isEnabled());
	}
	
	@Test(priority = 29, description = "To Verify Interface Options are autoselected")
	public void ToVerifyInterfaceOptions()
	{
		//To Check All options are Selected In Interface Page
		Assert.assertTrue("All Options Are Selected In Interface Page",ssdInterface.InterfaceSelectAll());
	}
	
	@Test(priority = 30, description = "To Verify Interface options are Editable")
	public void ToVerifyInterfaceOptionsEdit()
	{
		//To Check Edit Option is Available in Interface 
		Assert.assertFalse("Select All Option Is Unchecked In Interface Page", ssdInterface.EditInterfaceSelectAll());
	}
	
	@Test(priority = 31, description = "Click on Next btn in Interface Type page")
	public void ToVerifyInterfaceNextbtn()
	{
		// Select All is Disabled when Edit the Interface Options
		Assert.assertFalse("Interface type Select All Option Is In Disabled State", ssdInterface.InterfaceSelectAll());
		ssdInterface.InterfaceNextBtn();
		System.out.println("--------------------! Interface Types Page Components are Displayed Correctly !------------------");
	}
	
	@Test(priority = 32, description = "To Verify the Form Factor Page is displayed")
	public void ToVerifyFormFactorPageDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String ActualFormFactorURL = Prop.getProperty("FormFactorPage");
		String ExpectedFormFactorURL = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedFormFactorURL,ActualFormFactorURL);
	}
	
	@Test(priority = 32, description = "To Verify Menu Bar in Form Factor Page")
	public void ToVerifyFormFactorMenuBar()
	{
		ssdFormfactor = new SSDFormFactorPage();
		Assert.assertTrue("Form Factor Is Displayed", ssdFormfactor.SSDMenubarFormFactorpageType.isDisplayed());
	}
	
	@Test(priority = 33, description = "To Verfiy the Form Factor Options are AutoSelected")
	public void ToVerifyFormFactorAutoSelected()
	{
		Assert.assertTrue("Select All Option Is Selected In Form Factor Page ", ssdFormfactor.FormFactorSelectAll());
	}
	
	@Test(priority = 35, description = "To Verify Form Factor options are Editable")
	public void ToVerifyFormFactorOptionsEditable()
	{
		ssdFormfactor.EditFormFactorTypes();
	}
	
	@Test(priority = 34, description = "To Verify Form Factor Images are displayed")
	public void ToVerifyFormFactorImages()
	{
		Assert.assertTrue("Form Factor Images are displayed", ssdFormfactor.AllImagesDisplayed());
	}
	
	@Test(priority = 36, description = "To Verify Form Factor Next Btn")
	public void ToVerifyFormFactorNextBtn()
	{
		//Edit the Form Factor Options
		
		
		Assert.assertFalse("Select All Option Is Disabled In State", ssdFormfactor.SSDFormFactorSelectAll.isSelected());
		// Click on Next Btn in Form Factor Page
		ssdFormfactor.FormFactorNextBtn();
		System.out.println("--------------------! Form Factor Page Components are Displayed Successfully !------------------");
	}
	
	@Test(priority = 37, description = "To Verify Best Availability Page is Displayed")
	public void ToVerifyBestAvailabilityPageDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String ActualFormFactorURL = Prop.getProperty("MainstreamPage");
		String ExpectedFormFactorURL = driver.getCurrentUrl();
		System.out.println("Best Availability Page :-"+ExpectedFormFactorURL);
		Assert.assertEquals(ExpectedFormFactorURL, ActualFormFactorURL);
	}
	
	@Test(priority = 38, description = "To Verify Menu bar in Best Availability Page")
	public void ToVerifyBestAvailabilityMenubar()
	{
		ssdBestAvailability = new SSDBestAvailabilityPage();
		Assert.assertTrue("Best Availability Is Enabled", ssdBestAvailability.SSDMenubarBestAvailability.isEnabled());
	}
	
	@Test(priority = 39, description = "To Verify Best Availability Option selected")
	public void ToVerifyBestAvailabilityOptionSelected()
	{
		Assert.assertTrue("Mainstream is Selected ", ssdBestAvailability.BestAvailMainstream());
		// Next Btn is Enabled 
		Assert.assertTrue("Next Btn Is Enabled", ssdBestAvailability.BestAvailabilityNextBtn());
	}
	
	@Test(priority = 40, description = "To Verify Select All Option in Best Availability")
	public void ToVerifySelectAllBestAvailability()
	{
		Assert.assertTrue("Select All Option Is Selected In Best Availability", ssdBestAvailability.ClickOnNonMainstream());
		//Click Next Btn in Best Availability Page
		ssdBestAvailability.BestAvailNextBtn();
		System.out.println("--------------------! Best Availability Page Components are Displayed Successfully !------------------");
	}
	
	@Test(priority = 41, description = "To Verify Result Page is displayed")
	public void ToVerifyResultPageDisplayed()
	{
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//Verify the Result Page URL
		String ActualResultPage = Prop.getProperty("ResultPage");
		String ExpectedResultPage = driver.getCurrentUrl();
		Assert.assertEquals(ExpectedResultPage, ActualResultPage);
	}
	
	@Test(priority = 42, description = "To Verify Result Page label :-  Refine your Results")
	public void ToVerifyResultPageRefinelabel()
	{
		ssdResult = new SSDResultPage();
		Assert.assertTrue("Refine Your Results is Displayed", ssdResult.SSDResRefineResults.isDisplayed());
	}
	
	@Test(priority = 43, description = "To Verify Result Page label :-  SSDPortfilioAlignment")
	public void ToVerifyResultPageSSDPortfilioAlignmentlabel()
	{
		ssdResult.SSDPortImage();
		Assert.assertTrue("SSD Portfolio Alignmen Is Visible", ssdResult.SSDResPortfolioImage.isDisplayed());
	}
	
	@Test(priority = 44, description = "To Verify Result Page label :- SSD meet Your Requirements")
	public void ToVerifyResultPagSSDRequirements()
	{
		WebDriverWait AllSSDResultload =	new WebDriverWait(driver, 10);
		boolean ExpectedSSDRequirmentLabel1 = ssdResult.SSDResResultDisplayLink1;
		ExpectedSSDRequirmentLabel1 = AllSSDResultload.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("EditedInterfaceFormFactorSelectAll")));
		if(ExpectedSSDRequirmentLabel1 == true)
		{
		String ActualSelectAllSSDResults = Prop.getProperty("EditedInterfaceFormFactorSelectAll");
		String ExpectedSelectAllSSDResults = ssdResult.SSDResResultDisplayLink.getText();
		System.out.println("SSDs Results Without Interface SAS and Form Factor LFF :- " + ExpectedSelectAllSSDResults);
		Assert.assertEquals(ExpectedSelectAllSSDResults,ActualSelectAllSSDResults);
		}
		else
		{
			System.out.println("Not Meet the Expectation");
		}
	}
	
	@Test(priority = 45, description = "To Verify Result Page Refine Your Results Elements :- SSD Workload Enabled")
	public void ToVerifyResultPageSSDWorkloadPart()
	{
		Assert.assertTrue("In Result Page Selected Workloads are displayed", ssdResult.SelectAllWorkloadResultPage());
	}
	
	@Test(priority = 46, description = "To Verify Result Page Refine Your Results Elements :- InterfaceType Enabled")
	public void ToVerifyResultPageInterfaceTypePart()
	{
		Assert.assertTrue("In Result Page Selected Interface types are displayed", ssdResult.SelectAllInterfaceResultPage());
	}
	
	@Test(priority = 46, description = "To Verify Result Page Refine Your Results Elements :- FormFactor Enabled")
	public void ToVerifyResultPageFormFactorPart()
	{
		Assert.assertTrue("In Result Page Selected Form Factor types are displayed", ssdResult.SelectAllFactorFactorResultPage());
	}
	
	@Test(priority = 47, description = "To Verify Result Page Refine Your Results Elements :- BestAvailabilty Enabled")
	public void ToVerifyResultPageBestAvailabiltyPart()
	{
		Assert.assertTrue("In Result Page Selected Mainstream and Non-Mainstream types are displayed", ssdResult.BestAvailabilityResults());
	}
	
	@Test(priority = 48, description = "To Verify Result Page Refine Your Results Elements :- Search Tab")
	public void ToVerifyResultPageSearchTab()
	{
		ssdResult.SSDSearchTabText();
	}
	
	@Test(priority = 49, description = "To Verify Result Page Refine Your Results Elements :- Server Type Label")
	public void ToVerifyResultPageServerType()
	{
		ssdResult.SSDServerTypeLabel();
		Assert.assertTrue("Server type  is Enabled in Result page", ssdResult.SSDServerTypeEnable());
	}
	
	
	@Test(priority = 50, description = "To Verify Result Page Refine Your Results Elements :- Server Model Label")
	public void ToVerifyResultPageServerModel()
	{
		ssdResult.SSDServerModelLabel();
		Assert.assertTrue("Server Model Tab is Disabled in Result Page", ssdResult.SSDServerModelDisable());
	}
	
	@Test(priority = 51, description = "To Verify Result Page Refine Your Results Elements :- Capacity Slider Label")
	public void ToVerifyResultPageCapacitySlider()
	{
		ssdResult.SSDCapacityMaxSliderText();
		
	}
	
	@Test(priority = 52, description = "To Verify Result Page Refine Your Results Elements :- Endurance Slider Label")
	public void ToVerifyResultPageEnduranceSlider()
	{
		Assert.assertTrue("Capacity Label is Displayed", ssdResult.SSDEnduranceLabel());
	}
	
	@Test(priority = 53, description = "To Verify Result Page Refine Your Results Elements :- Random Read Slider Label")
	public void ToVerifyResultPageRandomReadSlider()
	{
		Assert.assertTrue("Capacity Label is Displayed", ssdResult.SSDRandReadIOPSLabel());
	}
	
	@Test(priority = 54, description = "To Verify Result Page Refine Your Results Elements :- Random Write Slider Label")
	public void ToVerifyResultPageRandomWriteSlider()
	{
		Assert.assertTrue("Capacity Label is Displayed", ssdResult.SSDRandomWriteIOPSLable());
	}
	
	@Test(priority = 55, description = "To Verify Result Page Refine Your Results Elements :- Max Random Read Slider Label")
	public void ToVerifyResultMaxRandomReadSlider()
	{
		Assert.assertTrue("Capacity Label is Displayed", ssdResult.SSDRandomMaxReadLabel());
	}
	
	@Test(priority = 56, description = "To Verify Result Page Refine Your Results Elements :- Max Random Write Slider Label")
	public void ToVerifyResultPageMaxRandomWriteSlider()
	{
		Assert.assertTrue("Capacity Label is Displayed", ssdResult.SSDRandomMaxWriteLabel());
	}
	
	@Test(priority = 57, description = "To Verify Result Page Refine Your Results Elements :- Max Power Slider Label")
	public void ToVerifyResultPageMaxPowerSlider()
	{
		Assert.assertTrue("Capacity Label is Displayed", ssdResult.SSDMaxPowerLabel());
	}
	
	@Test(priority = 58, description = "To Verify Result Page Select All/UnCheck All CheckBox")
	public void ToVerifyResultPageSelectAllOption()
	{
		// To Verify Select All Option is not Selected
		Assert.assertFalse("Select All is not Checked", ssdResult.SSDResultSelectALL());
	} 
	
	@Test(priority = 59, description = "To Verify Result Page, Select All is Checked")
	public void ToVerifyResultPageSelectAllOptionSelected()
	{
		// To Select the Select All Option in Result Page
		ssdResult.SSDResultSelectAllSelected();
	}
	
	@Test(priority = 60, description = "All SSD Results should be displayed")
	public void ToVerifyAllSSDsResultDisplayed()
	{
		WebDriverWait AllSSDResultload =	new WebDriverWait(driver, 10);
		boolean ExpectedSSDRequirmentLabel1 = ssdResult.SSDResResultDisplayLink1;
		ExpectedSSDRequirmentLabel1 = AllSSDResultload.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, "291 -  SSDs meet your requirements"));
		if(ExpectedSSDRequirmentLabel1 == true)
		{
		 String ActualAllSSDResults = Prop.getProperty("TotalSSDs");
		 String ExpectedSSDResults = ssdResult.SSDResResultDisplayLink.getText();
		 System.out.println("Select All Selected SSDs Results:-"+ ExpectedSSDResults);
		 System.out.println("SSDs Results:-"+ExpectedSSDRequirmentLabel1);
		 Assert.assertEquals(ExpectedSSDResults, ActualAllSSDResults);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		}
	}
	
 @Test(priority = 61, description = "To Verify The MainStream Results")
	public void ToVerifySSDMainStreamResults()
	{
		// To View Mainstreams on Click on Non-MainStream Check Box
		ssdResult.SSDResultNonMainstream();
		WebDriverWait ToDisplayMainstreamSSDs = new WebDriverWait(driver, 5);
		boolean MainstreamSSDs = ToDisplayMainstreamSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MainstreamSSDs")));
		if(MainstreamSSDs == true)
		{
		  String ActualMainstreamSSD = Prop.getProperty("MainstreamSSDs");
		  String ExceptedMainstreamSSD = ssdResult.SSDResResultDisplayLink.getText();
		  Assert.assertEquals(ActualMainstreamSSD,ExceptedMainstreamSSD);
		}
		else
		{
			System.out.println("Mainstream SSDs are Showing Wrong Details..");
		}
	}
	
	@Test(priority = 62, description = "To Verify Alert Message Is Displayed on Mainstream CheckBox")
	public void ToVerifyAlertMessage()
	{
		//To View NonMainstream SSDs results
		 ssdResult.SSDResultMainstream();
		//Both Mainstream and NonMainstream cann't be disabled at same time.
		ssdResult.SSDResultAlertMessageDisplayed();
	} 
	
	@Test(priority = 63, description = "To Verify NonMainstream SSDs Results")
	public void ToVerifySSDNonMainstream()
	{
		ssdResult.SSDResultNonMainstream();
		WebDriverWait SSDNonMainstream = new WebDriverWait(driver, 5);
		boolean NonMainstreamResults = ssdResult.SSDResResultDisplayLink1;
		NonMainstreamResults = SSDNonMainstream.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDs")));
		if(NonMainstreamResults == true)
		{
			JavascriptExecutor SSDResultDisplay = (JavascriptExecutor)driver;
			SSDResultDisplay.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			String ActualAllSSDs = Prop.getProperty("TotalSSDs");
			String ExpectedAllSSDs = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActualAllSSDs,ExpectedAllSSDs);
			// To View the Non-Mainstream SSDs 
			ssdResult.SSDResultMainstream();
		}
		boolean NonMainstreamSSDs = ssdResult.SSDResResultDisplayLink1;
		NonMainstreamSSDs = SSDNonMainstream.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NonMainstreamSSDs")));
		if(NonMainstreamSSDs == true)
		{
		// To View the Non-Mainstream SSDs 
		String ActualNonMainstreamSSDs = Prop.getProperty("NonMainstreamSSDs");
		String ExpectedNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		Assert.assertEquals(ActualNonMainstreamSSDs,ExpectedNonMainstreamSSDs);
		}
	}
	
	@Test(priority = 64, description = "To Verify Price URl Link")
	public void ToVerifyPriceLink()
	{
		ssdResult.SSDResultPriceLink();
	}
	
	/*@Test(priority = 65, description = " To Verify the Export Excel File Is Downloading")
	public void ToVerifyDownloadExportFile()
	{
		
	}
	
	@Test(priority = 66, description = " To Verify the Export CSV File Is Downloading")
	public void ToVerifyDownloadExportCSV()
	{
		
	}
	
	@Test(priority = 67, description = " To Verify the Export Excel File Is Downloading For Individual SSDs")
	public void ToVerifyExportExcelForIndiviualSSDs()
	{
		
	}
	
	@Test(priority = 68, description = " To Verify the Export PDF File Is Downloading For Individual SSDs")
	public void ToVerifyExportPDFForIndiviualSSDs()
	{
		
	} */
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	} 
	
}
