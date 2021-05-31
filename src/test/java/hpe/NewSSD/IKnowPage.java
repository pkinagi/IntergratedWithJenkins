package hpe.NewSSD;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hpessdPageObjects.HomePage;
import hpessdPageObjects.SSDResultPage;
import hpessdResource.BaseClass;

public class IKnowPage extends BaseClass
{
	public IKnowPage()
	{
		super();
	}
	
	HomePage  		ssdHomepage;
	SSDResultPage	ssdResult;
	
	@BeforeTest(description = "!----------------- SSD Selector Tool Test Scenario's For I Know What I Need Page ----------------------------!")
	
	@Test(priority = 0, description = "To Check the Result Page Is Displayed")
	public void ToVerifyIKnowWhatINeedPageDisplayed()
	{
		//For Launching the Browser
		Intialization();
		
		//For Home Page, Object is created
		ssdHomepage = new HomePage();
		
		//To Verify The HPE SSD Tool Version in Pop Up
		Assert.assertTrue(ssdHomepage.VerifyPopUp(), "HPE SSD Selector Tool Version Is Displayed");
		
		//In Home Page Click on Agree Button In the Pop up Display
		ssdHomepage.ClickAgreeButton();
		
		//To Verify Home Page URL
		String ActualHomePageURL = Prop.getProperty("HomePage");
		String ExpectedHomePageURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualHomePageURL,ExpectedHomePageURL);
		
		//To Verify Home Page Labels 
		Assert.assertTrue(ssdHomepage.VerifyIKnowBtnLabel(), "I Know What I Need");
		
		Assert.assertTrue(ssdHomepage.VerifyHelpChooseBtnLabel(), "Help Me Choose");
		
		Assert.assertTrue(ssdHomepage.VerifyReleaseLinkLabel(), "Release Notes Link Is Displayed");
		
		Assert.assertTrue(ssdHomepage.VerifyManualLabel(), "UserManual Link Is Displayed");
		
		//To Click on I Know What I Need
		ssdHomepage.ClickIKnowBtn();
		
		// To Verify The Result Page URL
		String ActualResultPageURL = Prop.getProperty("ResultPage");
		String ExpectedResultPageURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualResultPageURL, ExpectedResultPageURL);
	}
	
	@Test(priority = 1, description = "To Check All SSD Workloads are Selected")
	public void ToVerifySSDWorkloadSelected()
	{
		ssdResult = new SSDResultPage();
		
		//
		assertTrue(ssdResult.ResultPageSSDWorkloads(), "All Workloads Are Selected");
	}
	
	@Test(priority = 2, description = "To Check All Interface Options are Selected")
	public void ToVerifySSDInterfaceOptionSelected()
	{
		//
		assertTrue(ssdResult.ResultPageSSDInterfaceOptions(), "All Interface Options are Selected");
	}
	
	@Test(priority = 3, description = "To Check All FormFactor Options are Selected")
	public void ToVerifySSDFormFactorOptionSelected()
	{
		//
		assertTrue(ssdResult.ResultPageSSDFormFactorOptions(), "All Form Factor Options are Selected");
	}
	
	@Test(priority = 4, description = "To Check Best Availablilty Options are Selected")
	public void ToVerifySSDBestAvailabilityOptionSelected()
	{
		//
		assertTrue(ssdResult.ResultPageSSDBestAvailability(), "MainStream and Non Mainstream Options are Selected");
	}
	
	@Test(priority = 5, description = "To Check Certification Options are not Selected")
	public void ToVerifySSDCertificationOpionNotSelected()
	{
		//
		assertFalse(ssdResult.ResultPageSSDCertifications(), "All Certifications are not Selected");
	}
	
	@Test(priority = 6, description = "To Check Select All/UnCheck All Option is Selected")
	public void ToVerifySSDSelectAllOptionIsSelected()
	{
		//
		assertTrue(ssdResult.ResulPageSSDSelectAll(), "Select All/UnCheck All option Is Selected");
	}
	
	@Test(priority = 7, description = "To Verify SSD Results Are Displayed")
	public void ToVerifySSDResults()
	{
		JavascriptExecutor ScrollDown = (JavascriptExecutor)driver;
		ScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		String ActualSelectAllSSDResults = Prop.getProperty("TotalSSDSs");
		String ExpectedSelectAllSSDResults = ssdResult.SSDResResultDisplayLink.getText();
		Assert.assertEquals(ActualSelectAllSSDResults,ExpectedSelectAllSSDResults);
	}
	
	@Test(priority = 8, description = "To Verify Server Type DropDow")
	public void ToVerifySSDServerType()
	{
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ssdResult.SSDServerTypeLabel();
	}
	
	@Test(priority = 9, description = "To Verify Mouse Tip In Capacity Slider")
	public void ToVerifySSDMouseTipDisplayed()
	{
		// Capacity Slider Max Mouse Tool Tip
		Assert.assertTrue(ssdResult.SSDResultPageMaxToolTip.isDisplayed(),"Capacity Slider Max Tool Tip Is Displayed");
		ssdResult.CapacitySliderMaxValueToolTip();
		
		// Capacity Slider Min Mouse Tool Tip
		Assert.assertTrue(ssdResult.SSDResultPageMinToolTip.isDisplayed(), "Capacity Slider Min Tool Tip Is Displayed");
		ssdResult.CapacitySliderMinValueToolTip();
	}
	
	@Test(priority = 10, description = "To Verify SSD Results After UnCheck Of SSD Workloads")
	public void ToUnCheckSSDWorkloads()
	{
		ssdResult.UnCheckSSDWorkloads();
	}
	
	@Test(priority = 11, description = "To Verify SSD Results By Deselecting the Best Availability Options")
	public void ToVerifySSDResultsByDeSelectingBestAvailabilityOptions()
	{
		ssdResult.UnCheckBestAvailability();
	}
	@Test(priority = 12, description = "To Verify SSD Results After Selecting The VRO SSD Workloads")
	public void ToVerifySSDResultBySelectingVROWorkload()
	{
		WebDriverWait PageLoad = new WebDriverWait(driver, 2);
		JavascriptExecutor ClickVRO = (JavascriptExecutor)driver;
		System.out.println("In SSD Workload, VRO Is Selected, To Verify VRO SSDs, Mainstream and NonMainstream");
		ClickVRO.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ClickVRO.executeScript("arguments[0].click();",ssdResult.SSDResVRO);
		//Scroll Down to Verify VRO Results are displayed
		boolean VROPageLoad = PageLoad.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForVRONonMainstream")));
		if(VROPageLoad == true) 
		{
			ClickVRO.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			//To Verify VRO Non-Mainstream SSD are Displayed
			String ActualVRONonMainstreamSSDs = Prop.getProperty("ForVRONonMainstream");
			String ExpectedVRONonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			//To NonMainstream SSDs 
			System.out.println("NonMainstream SSDs Results :- " + ExpectedVRONonMainstreamSSDs);
			Assert.assertEquals(ActualVRONonMainstreamSSDs,ExpectedVRONonMainstreamSSDs);
			Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(),"NonMainStream Is Displayed");
			// To Click on Mainstream Option 
			ClickVRO.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
			VROPageLoad = PageLoad.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VROSSDsResults")));
			if(VROPageLoad == true)
			{
				System.out.println("Mainstream SSDs Results :- " + ssdResult.SSDResResultDisplayLink.getText());
				//To Click on NonMainstream to Verify Mainstream SSDs
				ClickVRO.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResNonMainstream);
				ClickVRO.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
				VROPageLoad = PageLoad.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForVROMainstream")));
				if(VROPageLoad == true)
				{
					//To Verify VRO Mainstream SSDS
					String ActualVROMainstreamSSDs = Prop.getProperty("ForVROMainstream");
					String ExpectedVROMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
					System.out.println("Mainstream SSDs Results :- " + ExpectedVROMainstreamSSDs);
					Assert.assertEquals(ActualVROMainstreamSSDs, ExpectedVROMainstreamSSDs);
					ClickVRO.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					VROPageLoad = PageLoad.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VROSSDsResults")));
					if(VROPageLoad == true)
					{
						// To Verify VRO SSDs
						String ActualVROSSDs = Prop.getProperty("VROSSDsResults");
						String ExpectedVROSSDs = ssdResult.SSDResResultDisplayLink.getText();
						System.out.println("VRO SSDs Results :- " + ExpectedVROSSDs);
						Assert.assertEquals(ActualVROSSDs, ExpectedVROSSDs);
					}
				}
			}
		}
	}
	
	@Test(priority = 13, description = "To Verify Only VRO SSDs are displayed")
	public void ToVerifyOnlyVROResults()
	{
		// Only VRO Text Is Displayed
		Assert.assertTrue(ssdResult.SSDOnlyVROResults.isDisplayed(), "Only Very Read Optimized");
		
		// 
		//Assert.assertFalse(ssdResult.VerifyVROResults(),"Mixed Use, Read Intensive and Write Intensive SSDs are not Displayed");
	}
	@Test(priority = 14, description = "To Verify SSD Results After Selecting The Read Intensive Workload")
	public void ToVerifySSDResultBySelectingReadIntensiveWorkload()
	{
		WebDriverWait LoadReadSSDs = new WebDriverWait(driver,3);
		JavascriptExecutor ClickReadIntensive = (JavascriptExecutor)driver;
		//To Scroll Up
		ClickReadIntensive.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		//Click on VRO To Uncheck VRO
		ClickReadIntensive.executeScript("arguments[0].click()", ssdResult.SSDResVRO);
		ClickReadIntensive.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		boolean LoadRead = LoadReadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
		if(LoadRead == true)
		{
		  //Scroll Up
		  ClickReadIntensive.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		  System.out.println("In SSD Workload, Read Intensive Is Selected, To Verify Read Intensive SSDs, with respect to Mainstream and NonMainstream");
		  //Click on Read Intensive Workload
		  ClickReadIntensive.executeScript("arguments[0].click()", ssdResult.SSDResReadIntensive);
		  ClickReadIntensive.executeScript("arguments[0].scrollIntoView();",ssdResult.SSDResResultDisplayLink);
		  LoadRead = LoadReadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ReadIntensiveResults")));
		  	if(LoadRead == true)
		  	{
		  		//To Verify Read Intensive SSDs
		  		String ActualReadIntensiveSSDs = Prop.getProperty("ReadIntensiveResults");
		  		String ExpectedReadIntesiveSSDs = ssdResult.SSDResResultDisplayLink.getText();
		  		Assert.assertEquals(ActualReadIntensiveSSDs, ExpectedReadIntesiveSSDs);
			
		  		// To Verify Only Read Intensive SSDs are Displayed
		  		Assert.assertTrue(ssdResult.VerifyReadIntensive(), "Read Intensive Is Displayed");
			
		  		ClickReadIntensive.executeScript("arguments[0].scrollIntoView()", ssdResult.SSDResMainstream);
		  		ClickReadIntensive.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
		  		LoadRead = LoadReadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForReadIntensiveMainstream")));
		  		if(LoadRead == true)
		  		{
		  			// Mainstream Read Intensive SSDs
		  			System.out.println("Read Intensive - Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
		  			//ToVerify Mainstream SSDS
		  			String ActualReadIntensiveMainstreamSSDs = Prop.getProperty("ForReadIntensiveMainstream");
		  			String ExpectedReadIntensiveMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		  			Assert.assertEquals(ActualReadIntensiveMainstreamSSDs, ExpectedReadIntensiveMainstreamSSDs);
		  			//To Verify Mainstream Label
		  			Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Label Is Displayed");
				
		  			//Click on NonMainstream Check Box, 
		  			ClickReadIntensive.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
		  			LoadRead = LoadReadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForReadIntensiveMainstream")));
				if(LoadRead == true)
				{
					ClickReadIntensive.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
					ClickReadIntensive.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
					LoadRead = LoadReadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForReadIntensiveNonMainstream")));
					if(LoadRead == true)
					{
						//To Verify NonMainstream SSDs
						System.out.println("Read Intensive - NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						String ActualReadIntensiveNonMainstreamSSDs = Prop.getProperty("ForReadIntensiveNonMainstream");
						String ExpectedReadIntensiveNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualReadIntensiveNonMainstreamSSDs,ExpectedReadIntensiveNonMainstreamSSDs);
						//To Verify NonMainstream Label
						Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
					}
				}
			}
		}	
	 }
  }
	
	@Test(priority = 15, description = "To Verify SSD Results After Selecting The Mixed Use Workload")
	public void ToVerifySSDResultBySelectingMixedUseWorkload()
	{
		WebDriverWait LoadMixedSSDs = new WebDriverWait(driver,2);
		JavascriptExecutor ClickMixedUse = (JavascriptExecutor)driver;
		// Click on Mainstream Option 
		ClickMixedUse.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadMixed = LoadMixedSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ReadIntensiveResults")));
		if(LoadMixed == true)
		{
			//ScrollUp
			ClickMixedUse.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Click on Read Intensive
			ClickMixedUse.executeScript("arguments[0].click()", ssdResult.SSDResReadIntensive);
			LoadMixed = LoadMixedSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadMixed == true)
			{
				 System.out.println("In SSD Workload, Mixed Use Is Selected, To Verify Mixed Use SSDs, with respect to Mainstream and NonMainstream");
				//Click on Mixed Use 
				ClickMixedUse.executeScript("arguments[0].click()", ssdResult.SSDResMixedUse);
				//Scroll Down
				ClickMixedUse.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadMixed = LoadMixedSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedUseResults")));
				if(LoadMixed == true)
				{
					//To Verify Mixed Use SSDs Results
					String ActualMixedUseSSDs = Prop.getProperty("MixedUseResults");
					String ExpectedMixedUseSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualMixedUseSSDs, ExpectedMixedUseSSDs);
					
					// To Verify Only Mixed Use SSDs are displayed
					Assert.assertTrue(ssdResult.VerifyMixedUse(), "Only Mixed Use SSDs Are Displayed");
					
					//To Verify Click on NonMainstream Option to Check Mixed Mainstream SSDs
					ClickMixedUse.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadMixed = LoadMixedSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForMixedUseMainstream")));
					if(LoadMixed == true)
					{
						System.out.println("Mixed Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						String ActualMixedUseMainstreamSSDs = Prop.getProperty("ForMixedUseMainstream");
						String ExpectedMixedUseMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualMixedUseMainstreamSSDs, ExpectedMixedUseMainstreamSSDs);
						
						// Mixed Use Mainstream Label
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						ClickMixedUse.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadMixed = LoadMixedSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedUseResults")));
						if(LoadMixed == true)
						{
							//To Verify NonMainstream SSDs click Mainstream Option
							ClickMixedUse.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadMixed = LoadMixedSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForMixedUseNonMainstream")));
							if(LoadMixed == true)
							{
								System.out.println("Mixed Non-Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								String ActualMixedUseNonMainstreamSSDs = Prop.getProperty("ForMixedUseNonMainstream");
								String ExpectedMixedUseNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualMixedUseNonMainstreamSSDs,ExpectedMixedUseNonMainstreamSSDs);
								
								// To Verify Non-Mainstream Label
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "Non-Mainstream Is Displayed");
							}
						}
					}
				}	
			}
		}
	}
	
	@Test(priority = 16, description = "To Verify SSD Results After Selecting The Write Intensive Workload")
	public void ToVerifySSDResultBySelectingWriteIntensive()
	{
		WebDriverWait LoadWriteSSDs = new WebDriverWait(driver,2);
		JavascriptExecutor ClickWrite = (JavascriptExecutor)driver;
		//ScrollUp to Click on Write Intensive
		ClickWrite.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		 System.out.println("In SSD Workload, Write Intensive Is Selected, To Verify Write Intensive SSDs, with respect to Mainstream and NonMainstream");
		//Click on Write Intensive Workload
		ClickWrite.executeScript("arguments[0].click()", ssdResult.SSDResWriteIntensive);
		//Scroll Down to Check SSD Results Mixed Use and Write Intensive For Non-Mainstream
		ClickWrite.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		boolean LoadWrite = LoadWriteSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedUseWriteIntensiveNonMainstreamSSDs")));
		if(LoadWrite == true)
		{
			System.out.println("Mixed Use and Write Intensive For Non-Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
			// To Verify SSD Results Mixed Use and Write Intensive For Non-Mainstream
			String ActualMixedUseWriteIntensiveNonMainstream = Prop.getProperty("MixedUseWriteIntensiveNonMainstreamSSDs");
			String ExpectedMixedUseWriteIntensiveNonMainstream = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActualMixedUseWriteIntensiveNonMainstream, ExpectedMixedUseWriteIntensiveNonMainstream);
			//Scroll Up 
			ClickWrite.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			// To Uncheck Mixed Use
			ClickWrite.executeScript("arguments[0].click()", ssdResult.SSDResMixedUse);
			//Scroll Down
			ClickWrite.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadWrite = LoadWriteSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForWriteIntensiveNonMainstreamSSDs")));
			if(LoadWrite == true)
			{
				System.out.println("Write Intensive For Non-Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				// To Verify Write Intensive Non-Mainstream SSDs
				String ActualWriteIntensiveNonMainstreamSSDs = Prop.getProperty("ForWriteIntensiveNonMainstreamSSDs");
				String ExpectedWriteIntensiveNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
				Assert.assertEquals(ActualWriteIntensiveNonMainstreamSSDs,ExpectedWriteIntensiveNonMainstreamSSDs);
				
				// To Check NonMainstream Label Is Displayed
				Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "Non-Mainstream Label Is Displayed");
				
				//Click on Mainstream 
				ClickWrite.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
				LoadWrite = LoadWriteSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("WriteIntensiveSSDsResults")));
				if(LoadWrite == true)
				{
					// To Verify Write Intensive SSDs
					System.out.println("Write Intensive SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					String ActualWriteIntensiveSSDs = Prop.getProperty("WriteIntensiveSSDsResults");
					String ExpectedWriteIntensiveSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualWriteIntensiveSSDs,ExpectedWriteIntensiveSSDs);
					
					// To Verify Only Write Intensive SSD Are Displayed
					Assert.assertTrue(ssdResult.VerifyWriteIntensive(), "Write Intensive SSDs Are Displayed");
					
					// Click on NonMainstream Option to Verify Write Intensive Mainstream SSDs
					ClickWrite.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadWrite = LoadWriteSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("ForWriteIntensiveMainstreamSSDs")));
					if(LoadWrite == true)
					{
						// To Verify Write Intensive Mainstream SSDs
						System.out.println("Write Intensive Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						String ActualWriteIntensiveMainstreamSSDs = Prop.getProperty("ForWriteIntensiveMainstreamSSDs");
						String ExpectedWriteIntensiveMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualWriteIntensiveMainstreamSSDs,ExpectedWriteIntensiveMainstreamSSDs);
						
						// To Check Mainstream Label Is Displayed
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Label Is Displayed");
					}
				}
			}
		}
	}
	
	@Test(priority = 17, description = "To UnCheck the Write Intensive Workload and Check the Mainstream Option")
	public void ToDisAbleSSDWorkload()
	{
		WebDriverWait DisableWorkload = new WebDriverWait(driver, 2);
		JavascriptExecutor ClickWorkload = (JavascriptExecutor)driver;
		// Click on NonMainstream Option 
		ClickWorkload.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
		boolean Workload = DisableWorkload.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("WriteIntensiveSSDsResults")));
		if(Workload == true)
		{
			System.out.println("Write Intensive SSD :- " + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickWorkload.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			// Click on Write Intensive
			ClickWorkload.executeScript("arguments[0].click()", ssdResult.SSDResWriteIntensive);
			Workload = DisableWorkload.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(Workload == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				String ActualTotalSSDs = Prop.getProperty("TotalSSDSs");
				String ExpectedTotalSSDs = ssdResult.SSDResResultDisplayLink.getText();
				Assert.assertEquals(ActualTotalSSDs,ExpectedTotalSSDs);
			}
		}
	}
	@Test(priority = 18, description = "To Verify SSD Results After Deselecting The Interface Options")
	public void ToVerifySSDResultBySelectingInterfaceOptions()
	{
		ssdResult.UnCheckSSDInterface();
	}

	@Test(priority = 19, description = "To Verify SSD Results By Selecting SATAVRO Interface Option")
	public void ToVerifySSDResultsBySelectingSATAVROOption()
	{
		WebDriverWait LoadSataVROSSDs = new WebDriverWait(driver, 2);
		JavascriptExecutor ClickSATAVRO = (JavascriptExecutor)driver;
		//ScrollUp 
		ClickSATAVRO.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		 System.out.println("In Interface Type, SATAVRO Is Selected, To Verify SATAVRO SSDs, with respect to Mainstream and NonMainstream");
		//Click on SATAVRO 
		ClickSATAVRO.executeScript("arguments[0].click();", ssdResult.SSDResInterfaceSATAVRO);
		boolean LoadSataVRO = LoadSataVROSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAVROInterfaceSSDs")));
		if(LoadSataVRO == true)
		{
			ClickSATAVRO.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			System.out.println("Interface: - SATAVRO Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// To Verify SATAVRO SSDs 
			String ActualSATAVROSSDs = Prop.getProperty("SATAVROInterfaceSSDs");
			String ExpectedSATAVROSSDs = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActualSATAVROSSDs,ExpectedSATAVROSSDs);
			
			// To Verify Only SATAVRO is Displayed
			Assert.assertTrue(ssdResult.VerifyInterfaceSATAVRO(), "SATA VRO Is Displayed");
			
			// Click on NonMainstream to Check Mainstream SSDS in SATAVRO
			ClickSATAVRO.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
			LoadSataVRO = LoadSataVROSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAVROInterfaceMainstreamSSDs")));
			if(LoadSataVRO == true)
			{
				System.out.println("Interface: - SATAVRO Mainstream -" + ssdResult.SSDResResultDisplayLink.getText());
				// To Verify SATAVRO NonMainstream
				String ActualSATAVRONonMainstream = Prop.getProperty("SATAVROInterfaceMainstreamSSDs");
				String ExpectedSATAVRONonMainstream = ssdResult.SSDResResultDisplayLink.getText();
				Assert.assertEquals(ActualSATAVRONonMainstream,ExpectedSATAVRONonMainstream);
				
				// To Verify NonMainstream Label
				Assert.assertTrue(ssdResult.SSDMainstreamLabel(),"MainStream Is Displayed");
				
				// To Click on NonMainstream, 
				ClickSATAVRO.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
				LoadSataVRO = LoadSataVROSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAVROInterfaceSSDs")));
				if(LoadSataVRO == true)
				{
					System.out.println("Interface: - SATAVRO Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
					
					// To Click on MainStream Option , To Check the NonMainstream SSDs
					ClickSATAVRO.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
					LoadSataVRO = LoadSataVROSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAVROInterfaceNonMainstreamSSDs")));
					if(LoadSataVRO == true)
					{
						System.out.println("Interface: - SATAVRO NonMainstream -" + ssdResult.SSDResResultDisplayLink.getText());
						// To Verify SATAVRO NonMainstream
						String ActualSATAVROMainstream = Prop.getProperty("SATAVROInterfaceNonMainstreamSSDs");
						String ExpectedSATAVROMainstream = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualSATAVROMainstream,ExpectedSATAVROMainstream);
						
						// To Verify SATAVRO NonMainstream label
						Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(),"MainStream Is Displayed");
					}
				}
			}
		}
	}
	
	@Test(priority = 20,description = "To Verify SSD Results By Selecting SATA Interface Option")
	public void ToVerifySSDResultSBySelectingSATAOption()
	{
		//Click On Mainstream Option
		JavascriptExecutor ClickSATAInterface = (JavascriptExecutor)driver;
		WebDriverWait LoadSATASSDs = new WebDriverWait(driver, 2);
		ClickSATAInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadSATA = LoadSATASSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAVROInterfaceSSDs")));
		if(LoadSATA == true)
		{
			System.out.println("Interface: - SATAVRO Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickSATAInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the SATAVRO Interface Option
			ClickSATAInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceSATAVRO);
			ClickSATAInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadSATA = LoadSATASSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadSATA == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Interface Type, SATA Is Selected, To Verify SATA SSDs, with respect to Mainstream and NonMainstream");
				// Click on SATA Interface Option
				ClickSATAInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceSATA);
				ClickSATAInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadSATA = LoadSATASSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAInterfaceSSDs")));
				if(LoadSATA == true)
				{
					System.out.println("SATA Interface SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify SATA Interface SSDs
					String ActualSATAInterfaceSSDs = Prop.getProperty("SATAInterfaceSSDs");
					String ExpectedSATAInterfaceSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualSATAInterfaceSSDs,ExpectedSATAInterfaceSSDs);
					
					// To Verify Only SATA are displayed
					Assert.assertTrue(ssdResult.VerifyInterfaceSATA(), "SATA Is Displayed");
					
					//Click on NonMainstream Option to verify SATA Interface Mainstream SSDs
					ClickSATAInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadSATA = LoadSATASSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAInterfaceMainstreamSSDs")));
					if(LoadSATA == true)
					{
						System.out.println("SATA Interface Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify SATA Interface Mainstream SSDs
						String ActualSATAInterfaceMainstreamSSDs = Prop.getProperty("SATAInterfaceMainstreamSSDs");
						String ExpectedSATAInterfaceMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualSATAInterfaceMainstreamSSDs, ExpectedSATAInterfaceMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickSATAInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadSATA = LoadSATASSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAInterfaceSSDs")));
						if(LoadSATA == true)
						{
							System.out.println("SATA Interface Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the SATA Interface NonMainstream SSDs
							ClickSATAInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadSATA = LoadSATASSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAInterfaceNonMainstreamSSDs")));
							if(LoadSATA == true)
							{
								System.out.println("SATA Interface NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify SATA Interface NonMainstream SSDs
								String ActualSATAInterfaceNonMainstreamSSDs = Prop.getProperty("SATAInterfaceNonMainstreamSSDs");
								String ExpectedSATAInterfaceNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualSATAInterfaceNonMainstreamSSDs, ExpectedSATAInterfaceNonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 21, description = "To Verify SSD Results By Selecting VALUESAS Interface Option")
	public void ToVerifySSDResultsBySelectingVALUESAS()
	{
		JavascriptExecutor ClickVALUESASInterface = (JavascriptExecutor)driver;
		WebDriverWait LoadVALUESASSSDs = new WebDriverWait(driver, 2);
		ClickVALUESASInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadVALUESAS = LoadVALUESASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SATAInterfaceSSDs")));
		if(LoadVALUESAS == true)
		{
			System.out.println("Interface: - SATAVRO Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickVALUESASInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the SATA Interface Option
			ClickVALUESASInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceSATA);
			ClickVALUESASInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadVALUESAS = LoadVALUESASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadVALUESAS == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Interface Type, VALUESAS Is Selected, To Verify VALUESAS SSDs, with respect to Mainstream and NonMainstream");
				// Click on VALUESAS Interface Option
				ClickVALUESASInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceValueSAS);
				ClickVALUESASInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadVALUESAS = LoadVALUESASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VALUESASInterfaceSSDs")));
				if(LoadVALUESAS == true)
				{
					System.out.println("VALUESAS Interface SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify SATA Interface SSDs
					String ActualVALUESASInterfaceSSDs = Prop.getProperty("VALUESASInterfaceSSDs");
					String ExpectedVALUESASInterfaceSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualVALUESASInterfaceSSDs,ExpectedVALUESASInterfaceSSDs);
					
					// To Verify Only ValueSAS are displayed
					
					//Click on NonMainstream Option to verify SATA Interface Mainstream SSDs
					ClickVALUESASInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadVALUESAS = LoadVALUESASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VALUESASInterfaceMainstreamSSDs")));
					if(LoadVALUESAS == true)
					{
						System.out.println("VALUESAS Interface Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify SATA Interface Mainstream SSDs
						String ActualVALUESASInterfaceMainstreamSSDs = Prop.getProperty("VALUESASInterfaceMainstreamSSDs");
						String ExpectedVALUESASInterfaceMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualVALUESASInterfaceMainstreamSSDs, ExpectedVALUESASInterfaceMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickVALUESASInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadVALUESAS = LoadVALUESASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VALUESASInterfaceSSDs")));
						if(LoadVALUESAS == true)
						{
							System.out.println("VALUESAS Interface Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the VALUESAS Interface NonMainstream SSDs
							ClickVALUESASInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadVALUESAS = LoadVALUESASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VALUESASInterfaceNonMainstreamSSDs")));
							if(LoadVALUESAS == true)
							{
								System.out.println("VALUESAS Interface NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify VALUESAS Interface NonMainstream SSDs
								String ActualVALUESASInterfaceNonMainstreamSSDs = Prop.getProperty("VALUESASInterfaceNonMainstreamSSDs");
								String ExpectedVALUESASInterfaceNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualVALUESASInterfaceNonMainstreamSSDs, ExpectedVALUESASInterfaceNonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 22, description = "To Verify SSD Results By Selecting SAS Interface Option")
	public void ToVerifySSDResultsBySelectingSAS()
	{
		JavascriptExecutor ClickSASInterface = (JavascriptExecutor)driver;
		WebDriverWait LoadSASSSDs = new WebDriverWait(driver, 2);
		ClickSASInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadSAS = LoadSASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("VALUESASInterfaceSSDs")));
		if(LoadSAS == true)
		{
			System.out.println("Interface: - SATAVRO Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickSASInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the VALUESAS Interface Option
			ClickSASInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceValueSAS);
			ClickSASInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadSAS = LoadSASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadSAS == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Interface Type, SAS Is Selected, To Verify SAS SSDs, with respect to Mainstream and NonMainstream");
				// Click on SAS Interface Option
				ClickSASInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceSAS);
				ClickSASInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadSAS = LoadSASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SASInterfaceSSDs")));
				if(LoadSAS == true)
				{
					System.out.println("SAS Interface SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify SATA Interface SSDs
					String ActualSASInterfaceSSDs = Prop.getProperty("SASInterfaceSSDs");
					String ExpectedSASInterfaceSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualSASInterfaceSSDs,ExpectedSASInterfaceSSDs);
					
					// To Verify Only SAS are displayed
					
					//Click on NonMainstream Option to verify SAS Interface Mainstream SSDs
					ClickSASInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadSAS = LoadSASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SASInterfaceMainstreamSSDs")));
					if(LoadSAS == true)
					{
						System.out.println("VALUESAS Interface Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify SATA Interface Mainstream SSDs
						String ActualSASInterfaceMainstreamSSDs = Prop.getProperty("SASInterfaceMainstreamSSDs");
						String ExpectedSASInterfaceMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualSASInterfaceMainstreamSSDs, ExpectedSASInterfaceMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickSASInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadSAS = LoadSASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SASInterfaceSSDs")));
						if(LoadSAS == true)
						{
							System.out.println("VALUESAS Interface Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the VALUESAS Interface NonMainstream SSDs
							ClickSASInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadSAS = LoadSASSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SASInterfaceNonMainstreamSSDs")));
							if(LoadSAS == true)
							{
								System.out.println("VALUESAS Interface NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify VALUESAS Interface NonMainstream SSDs
								String ActualSASInterfaceNonMainstreamSSDs = Prop.getProperty("SASInterfaceNonMainstreamSSDs");
								String ExpectedSASInterfaceNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualSASInterfaceNonMainstreamSSDs, ExpectedSASInterfaceNonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 23, description = "To Verify SSD Results By Selecting NVMe Mainstream Interface Option")
	public void ToVerifySSDResultsBySelectingNVMeMainStream()
	{
		JavascriptExecutor ClickNVMeMainstreamInterface = (JavascriptExecutor)driver;
		WebDriverWait LoadNVMeMainSSDs = new WebDriverWait(driver, 2);
		ClickNVMeMainstreamInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadNVMe = LoadNVMeMainSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("SASInterfaceSSDs")));
		if(LoadNVMe == true)
		{
			System.out.println("Interface: - SATAVRO Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickNVMeMainstreamInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the SAS Interface Option
			ClickNVMeMainstreamInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceSAS);
			ClickNVMeMainstreamInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadNVMe = LoadNVMeMainSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadNVMe == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Interface Type, NVMeMainstream Is Selected, To Verify NVMeMainstream SSDs, with respect to Mainstream and NonMainstream");
				// Click on NVMe Mainstream Interface Option
				ClickNVMeMainstreamInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceNVMeMainstream);
				ClickNVMeMainstreamInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadNVMe = LoadNVMeMainSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeMainstreamInterfaceSSDs")));
				if(LoadNVMe == true)
				{
					System.out.println("NVMe Mainstream Interface SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify SATA Interface SSDs
					String ActualNVMeMainstreamInterfaceSSDs = Prop.getProperty("NVMeMainstreamInterfaceSSDs");
					String ExpectedNVMeMainstreamInterfaceSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualNVMeMainstreamInterfaceSSDs,ExpectedNVMeMainstreamInterfaceSSDs);
					
					// To Verify Only NVMe Mainstream are displayed
					
					//Click on NonMainstream Option to verify NVMe Mainstream Interface Mainstream SSDs
					ClickNVMeMainstreamInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadNVMe = LoadNVMeMainSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeMainstreamInterfaceMainstreamSSDs")));
					if(LoadNVMe == true)
					{
						System.out.println("NVMe Mainstream Interface Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify NVMe Mainstream Interface Mainstream SSDs
						String ActualNVMeMainstreamInterfaceMainstreamSSDs = Prop.getProperty("NVMeMainstreamInterfaceMainstreamSSDs");
						String ExpectedNVMeMainstreamInterfaceMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualNVMeMainstreamInterfaceMainstreamSSDs, ExpectedNVMeMainstreamInterfaceMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickNVMeMainstreamInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadNVMe = LoadNVMeMainSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeMainstreamInterfaceSSDs")));
						if(LoadNVMe == true)
						{
							System.out.println("VALUESAS Interface Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the VALUESAS Interface NonMainstream SSDs
							ClickNVMeMainstreamInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadNVMe = LoadNVMeMainSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeMainstreamInterfaceNonMainstreamSSDs")));
							if(LoadNVMe == true)
							{
								System.out.println("VALUESAS Interface NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify NVMe Mainstream Interface NonMainstream SSDs
								String ActualNVMeMainstreamInterfaceNonMainstreamSSDs = Prop.getProperty("NVMeMainstreamInterfaceNonMainstreamSSDs");
								String ExpectedNVMeMainstreamInterfaceNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualNVMeMainstreamInterfaceNonMainstreamSSDs, ExpectedNVMeMainstreamInterfaceNonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 24, description = "To Verify SSD Results By Selecting NVMe High Performance Interface Option")
	public void ToVerifySSDResultBySelectingNVMeHighPerformance()
	{
		JavascriptExecutor ClickNVMeHighPerformInterface = (JavascriptExecutor)driver;
		WebDriverWait LoadNVMeHighSSDs = new WebDriverWait(driver, 2);
		ClickNVMeHighPerformInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadNVMeHigh = LoadNVMeHighSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeMainstreamInterfaceSSDs")));
		if(LoadNVMeHigh == true)
		{
			System.out.println("Interface: - NVMe Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickNVMeHighPerformInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the NVMe Mainstream Interface Option
			ClickNVMeHighPerformInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceNVMeMainstream);
			ClickNVMeHighPerformInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadNVMeHigh = LoadNVMeHighSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadNVMeHigh == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Interface Type, NVmeHighPerformance Is Selected, To Verify NVMeHighPerformance, with respect to Mainstream and NonMainstream");
				// Click on NVMe High Performance Interface Option
				ClickNVMeHighPerformInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceNVMeHigh);
				ClickNVMeHighPerformInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadNVMeHigh = LoadNVMeHighSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeHighPerformanceInterfaceSSDs")));
				if(LoadNVMeHigh == true)
				{
					System.out.println("NVMe HighPerformance Interface SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify SATA Interface SSDs
					String ActualNVMeHighPerformanceInterfaceSSDs = Prop.getProperty("NVMeMainstreamInterfaceSSDs");
					String ExpectedNVMeHighPerformanceInterfaceSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualNVMeHighPerformanceInterfaceSSDs,ExpectedNVMeHighPerformanceInterfaceSSDs);
					
					// To Verify Only NVMe HighPerformance are displayed
					
					//Click on NonMainstream Option to verify NVMe Mainstream Interface Mainstream SSDs
					ClickNVMeHighPerformInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadNVMeHigh = LoadNVMeHighSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeHighPerformanceIntefaceMainstreamSSDs")));
					if(LoadNVMeHigh == true)
					{
						System.out.println("NVMe HighPerformance Interface Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify NVMe Mainstream Interface Mainstream SSDs
						String ActualNVMeHighPerformanceInterfaceMainstreamSSDs = Prop.getProperty("NVMeHighPerformanceIntefaceMainstreamSSDs");
						String ExpectedNVMeHighPerformanceInterfaceMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualNVMeHighPerformanceInterfaceMainstreamSSDs, ExpectedNVMeHighPerformanceInterfaceMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickNVMeHighPerformInterface.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadNVMeHigh = LoadNVMeHighSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeHighPerformanceInterfaceSSDs")));
						if(LoadNVMeHigh == true)
						{
							System.out.println("NVMe HighPerformance Interface Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the NVMe HighPerformance Interface NonMainstream SSDs
							ClickNVMeHighPerformInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadNVMeHigh = LoadNVMeHighSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeHighPerformanceInterfaceNonMainstreamSSDs")));
							if(LoadNVMeHigh == true)
							{
								System.out.println("NVMe High Performance Interface NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify NVMe Mainstream Interface NonMainstream SSDs
								String ActualNVMeHighPerformanceInterfaceNonMainstreamSSDs = Prop.getProperty("NVMeHighPerformanceInterfaceNonMainstreamSSDs");
								String ExpectedNVMeHighPerformanceInterfaceNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualNVMeHighPerformanceInterfaceNonMainstreamSSDs, ExpectedNVMeHighPerformanceInterfaceNonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 25, description = "To UnCheck the NVMe High Performance Interface and Check the Mainstream SSDs")
	public void ToDisAbleSSDInterfaceOption()
	{
		WebDriverWait DisableInterface = new WebDriverWait(driver, 2);
		JavascriptExecutor ClickInterface = (JavascriptExecutor)driver;
		// Click on NonMainstream Option 
		ClickInterface.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean Interface = DisableInterface.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NVMeHighPerformanceInterfaceSSDs")));
		if(Interface == true)
		{
			System.out.println("NVme HighPerformance SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickInterface.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			// Click on NVMe HighPerformance to UnCheck
			ClickInterface.executeScript("arguments[0].click()", ssdResult.SSDResInterfaceNVMeHigh);
			Interface = DisableInterface.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(Interface == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				String ActualTotalSSDs = Prop.getProperty("TotalSSDSs");
				String ExpectedTotalSSDs = ssdResult.SSDResResultDisplayLink.getText();
				Assert.assertEquals(ActualTotalSSDs,ExpectedTotalSSDs);
			}
		}
	}
	@Test(priority = 26, description = "To Verify SSD Results By DeSelecting Form Factor Options")
	public void ToVerifySSDResultByDeselectingFormFactorOptions()
	{
		ssdResult.UnCheckFormFactor();
	}
	
	@Test(priority = 27, description = "To Verify SSD Results By Selecting 2.5 SFF Form Factor Option")
	public void ToVerifySSDResultsBySelectingSFFOption()
	{
		JavascriptExecutor ClickSFF = (JavascriptExecutor)driver;
		WebDriverWait	LoadSFFSSDs = new WebDriverWait(driver, 2);
		//ScrollUp 
		ClickSFF.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		System.out.println("In Form Factor Type, 2.5SFF Is Selected, To Verify 2.5SFF SSDs, with respect to Mainstream and NonMainstream");
		//Click on 2.5SFF
		ClickSFF.executeScript("arguments[0].click();", ssdResult.SSDResFFSFF);
		boolean LoadSFF = LoadSFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("2.5SFFFormFactorSSDs")));
		if(LoadSFF == true)
		{
			ClickSFF.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			System.out.println("Form Factor: - 2.5SFF Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// To Verify 2.5SFF SSDs 
			String Actual25SFFSSDs = Prop.getProperty("2.5SFFFormFactorSSDs");
			String Expected25SFFSSDs = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(Actual25SFFSSDs,Expected25SFFSSDs);
					
			// To Verify Only 2.5 SFF is Displayed
			Assert.assertTrue(ssdResult.VerifyFormFactor25SFF(), "SATA VRO Is Displayed");
					
			// Click on NonMainstream to Check Mainstream SSDS in 2.5SFF
			ClickSFF.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
			LoadSFF = LoadSFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("2.5SFFFormFactorMainstreamSSDs")));
			if(LoadSFF == true)
			{
				System.out.println("Form Factor: - 2.5SFF Mainstream -" + ssdResult.SSDResResultDisplayLink.getText());
				// To Verify 2.5 SFF NonMainstream
				String Actual25SFFNonMainstream = Prop.getProperty("2.5SFFFormFactorMainstreamSSDs");
				String Expected25SFFNonMainstream = ssdResult.SSDResResultDisplayLink.getText();
				Assert.assertEquals(Actual25SFFNonMainstream,Expected25SFFNonMainstream);
						
				// To Verify NonMainstream Label
				Assert.assertTrue(ssdResult.SSDMainstreamLabel(),"MainStream Is Displayed");
						
				// To Click on NonMainstream, 
				ClickSFF.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
				LoadSFF = LoadSFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("2.5SFFFormFactorSSDs")));
				if(LoadSFF == true)
				{
					System.out.println("Form Factor: - 2.5SFF Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
							
					// To Click on MainStream Option , To Check the NonMainstream SSDs
					ClickSFF.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
					LoadSFF = LoadSFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("2.5SFFFormFactorNonMainstreamSSDs")));
					if(LoadSFF == true)
					{
						System.out.println("Form Factor: - 2.5SFF NonMainstream -" + ssdResult.SSDResResultDisplayLink.getText());
						// To Verify 2.5 SFF NonMainstream
						String ActualSATAVROMainstream = Prop.getProperty("2.5SFFFormFactorNonMainstreamSSDs");
						String ExpectedSATAVROMainstream = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualSATAVROMainstream,ExpectedSATAVROMainstream);
								
						// To Verify 2.5 SFF NonMainstream label
						Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(),"MainStream Is Displayed");
					}	
				}
			}
		}	
	}
	
	@Test(priority = 28, description = "To Verify SSD Results By Selecting 3.5 LFF Form Factor Option")
	public void ToVerifySSDResultsBySelectingLFFOption()
	{
		JavascriptExecutor ClickLFF = (JavascriptExecutor)driver;
		WebDriverWait LoadLFFSSDs = new WebDriverWait(driver, 2);
		ClickLFF.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadLFF = LoadLFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("2.5SFFFormFactorSSDs")));
		if(LoadLFF == true)
		{
			System.out.println("FormFactor: - 2.5 SFF Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickLFF.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the 2.5 SFF Form Factor Option
			ClickLFF.executeScript("arguments[0].click()", ssdResult.SSDResFFSFF);
			ClickLFF.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadLFF = LoadLFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadLFF == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Form Factor Type, 3.5SFF Is Selected, To Verify 3.5SFF SSDs, with respect to Mainstream and NonMainstream");
				// Click on 3.5 LFF Form Factor Option
				ClickLFF.executeScript("arguments[0].click()", ssdResult.SSDResFFLFF);
				ClickLFF.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadLFF = LoadLFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("3.5SFFFormFactorSSDs")));
				if(LoadLFF == true)
				{
					System.out.println("3.5 LFF Form Factor SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify 3.5 LFF Form Factor SSDs
					String Actual35LFFSSDs = Prop.getProperty("3.5SFFFormFactorSSDs");
					String Expected35LFFSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(Actual35LFFSSDs,Expected35LFFSSDs);
					
					// To Verify Only 3.5 LFF Form Factor are displayed
					Assert.assertTrue(ssdResult.VerifyFormFactor35LFF(), "3.5 LFF SSDs are Displayed");
					
					//Click on NonMainstream Option to verify NVMe Mainstream Interface Mainstream SSDs
					ClickLFF.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadLFF = LoadLFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("3.5SFFFormFactorMainstreamSSDs")));
					if(LoadLFF == true)
					{
						System.out.println("3.5 LFF Form Factor Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify NVMe Mainstream Interface Mainstream SSDs
						String Actual35LFFMainstreamSSDs = Prop.getProperty("3.5SFFFormFactorMainstreamSSDs");
						String Expected35LFFMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(Actual35LFFMainstreamSSDs, Expected35LFFMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickLFF.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadLFF = LoadLFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("3.5SFFFormFactorSSDs")));
						if(LoadLFF == true)
						{
							System.out.println("3.5 LFF Form Factor Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the NVMe HighPerformance Interface NonMainstream SSDs
							ClickLFF.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadLFF = LoadLFFSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("3.5SFFFormFactorNonMainstreamSSDs")));
							if(LoadLFF == true)
							{
								System.out.println("3.5 LFF Form Factor NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify NVMe Mainstream Interface NonMainstream SSDs
								String Actual35LFFNonMainstreamSSDs = Prop.getProperty("3.5SFFFormFactorNonMainstreamSSDs");
								String Expected35LFFNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(Actual35LFFNonMainstreamSSDs, Expected35LFFNonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 29, description = "To Verify SSD Results By Selecting Add-In Card Form Factor Option")
	public void ToVerifySSDResultsBySelectingAddInCardOption()
	{
		JavascriptExecutor ClickAddInCard = (JavascriptExecutor)driver;
		WebDriverWait LoadAICSSDs = new WebDriverWait(driver, 2);
		ClickAddInCard.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadAIC = LoadAICSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("3.5SFFFormFactorSSDs")));
		if(LoadAIC == true)
		{
			System.out.println("FormFactor: - 3.5 SFF Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickAddInCard.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the 3.5 SFF Form Factor Option
			ClickAddInCard.executeScript("arguments[0].click()", ssdResult.SSDResFFLFF);
			ClickAddInCard.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadAIC = LoadAICSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadAIC == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Form Factor Type, Add-In Card Is Selected, To Verify Add-In Card  SSDs, with respect to Mainstream and NonMainstream");
				// Click on Add-In-Card Form Factor Option
				ClickAddInCard.executeScript("arguments[0].click()", ssdResult.SSDResFFAIC);
				ClickAddInCard.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadAIC = LoadAICSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("Add-In-CardFormFactorSSDs")));
				if(LoadAIC == true)
				{
					System.out.println("Add-In-Card Form Factor SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify Add-In Card Form Factor SSDs
					String ActualAICSSDs = Prop.getProperty("Add-In-CardFormFactorSSDs");
					String ExpectedAICSSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualAICSSDs,ExpectedAICSSDs);
					
					// To Verify Only Add-In-Card Form Factor are displayed
					Assert.assertTrue(ssdResult.VerifyFormFactorAddInCard(), "AIC SSDs are Displayed");
					
					//Click on NonMainstream Option to verify AIC Form Factor Mainstream SSDs
					ClickAddInCard.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadAIC = LoadAICSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("Add-In-CardFormFactorMainstreamSSDs")));
					if(LoadAIC == true)
					{
						System.out.println("AIC Form Factor Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify AIC Form Factor Mainstream SSDs
						String ActualAICMainstreamSSDs = Prop.getProperty("Add-In-CardFormFactorMainstreamSSDs");
						String ExpectedAICMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualAICMainstreamSSDs, ExpectedAICMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickAddInCard.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadAIC = LoadAICSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("Add-In-CardFormFactorSSDs")));
						if(LoadAIC == true)
						{
							System.out.println("AIC Form Factor Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the AIC Form Factor NonMainstream SSDs
							ClickAddInCard.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadAIC = LoadAICSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("Add-In-CardFormFactorNonMainstreamSSDs")));
							if(LoadAIC == true)
							{
								System.out.println("AIC Form Factor NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify AIC Form Factor NonMainstream SSDs
								String ActualAICNonMainstreamSSDs = Prop.getProperty("Add-In-CardFormFactorNonMainstreamSSDs");
								String ExpectedAICNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualAICNonMainstreamSSDs, ExpectedAICNonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								//Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 30, description = "To Verify SSD Results By Selecting M.2 Form Factor Option")
	public void ToVerifySSDResultsBySelectingM2Option() 
	{
		JavascriptExecutor ClickM2 = (JavascriptExecutor)driver;
		WebDriverWait LoadM2SSDs = new WebDriverWait(driver, 2);
		ClickM2.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadM2 = LoadM2SSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("Add-In-CardFormFactorSSDs")));
		if(LoadM2 == true)
		{
			System.out.println("FormFactor: -Add-In Card Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickM2.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			//Uncheck the Add-In-Card Form Factor Option
			ClickM2.executeScript("arguments[0].click()", ssdResult.SSDResFFAIC);
			ClickM2.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadM2 = LoadM2SSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadM2 == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				System.out.println("In Form Factor Type, M.2 Is Selected, To Verify M.2 SSDs, with respect to Mainstream and NonMainstream");
				// Click on M2 Form Factor Option
				ClickM2.executeScript("arguments[0].click()", ssdResult.SSDResM2);
				ClickM2.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				LoadM2 = LoadM2SSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M.2FormFactorSSDs")));
				if(LoadM2 == true)
				{
					System.out.println("M.2 Form Factor SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify M2 Form Factor SSDs
					String ActualM2SSDs = Prop.getProperty("M.2FormFactorSSDs");
					String ExpectedM2SSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualM2SSDs,ExpectedM2SSDs);
					
					// To Verify Only M.2 Form Factor are displayed
					Assert.assertTrue(ssdResult.VerifyM2(), "AIC SSDs are Displayed");
					
					// To Verify Download Export Excel File 
					//Assert.assertTrue(ssdResult.DownloadExcelFile(), "Download Export Excel File, File should contains 11 SSDS");
					
					//Click on NonMainstream Option to verify AIC Form Factor Mainstream SSDs
					ClickM2.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadM2 = LoadM2SSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M.2FormFactorMainstreamSSDs")));
					if(LoadM2 == true)
					{
						System.out.println("M.2 Form Factor Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify M.2 Form Factor Mainstream SSDs
						String ActualM2MainstreamSSDs = Prop.getProperty("M.2FormFactorMainstreamSSDs");
						String ExpectedM2MainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualM2MainstreamSSDs, ExpectedM2MainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickM2.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadM2 = LoadM2SSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M.2FormFactorSSDs")));
						if(LoadM2 == true)
						{
							System.out.println("M.2 Form Factor Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the AIC Form Factor NonMainstream SSDs
							ClickM2.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadM2 = LoadM2SSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M.2FormFactorNonMainstreamSSDs")));
							if(LoadM2 == true)
							{
								System.out.println("M.2 Form Factor NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify M.2 Form Factor NonMainstream SSDs
								String ActualM2NonMainstreamSSDs = Prop.getProperty("M.2FormFactorNonMainstreamSSDs");
								String ExpectedM2NonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualM2NonMainstreamSSDs, ExpectedM2NonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 31, description = "To Verify SSD Results By Selecting M.2 E Kit Form Factor Option")
	public void ToVerifySSDResultsBySelectingM2EKitOption()
	{
		JavascriptExecutor ClickM2EKit = (JavascriptExecutor)driver;
		WebDriverWait LoadM2ESSDs = new WebDriverWait(driver, 3);
		ClickM2EKit.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadM2E = LoadM2ESSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M.2FormFactorSSDs")));
		if(LoadM2E == true)
		{
			System.out.println("FormFactor: M.2 Mainstream N NonMainstream Selected -" + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickM2EKit.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResFormFactor);
			//Uncheck the M.2 Form Factor Option
			ClickM2EKit.executeScript("arguments[0].click()", ssdResult.SSDResM2);
			ClickM2EKit.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
			LoadM2E = LoadM2ESSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(LoadM2E == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				// Scroll Up  Form Factor Option
				ClickM2EKit.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResFormFactor);
				System.out.println("In Form Factor Type, M.2 E Kit Is Selected, To Verify M.2 E Kit SSDs, with respect to Mainstream and NonMainstream");
				// Click on M2E Kit  Form Factor Option
				ClickM2EKit.executeScript("arguments[0].click()", ssdResult.SSDResM2E);
				ClickM2EKit.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
				System.out.println("1st M.2 E Form Factor SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				LoadM2E = LoadM2ESSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M2EFormFactorSSDs")));
				if(LoadM2E == true)
				{
					System.out.println("2nd M.2 E Form Factor SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
					// To Verify M2 E Kit Form Factor SSDs
					String ActualM2ESSDs = Prop.getProperty("M2EFormFactorSSDs");
					String ExpectedM2ESSDs = ssdResult.SSDResResultDisplayLink.getText();
					Assert.assertEquals(ActualM2ESSDs,ExpectedM2ESSDs);
					
					// To Verify Only M.2 E Kit Form Factor are displayed
					Assert.assertTrue(ssdResult.VerifyM2E(), "AIC SSDs are Displayed");
					
					//Click on NonMainstream Option to verify M.2 E Kit Form Factor Mainstream SSDs
					ClickM2EKit.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
					LoadM2E = LoadM2ESSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M2EFormFactorMainstreamSSDs")));
					if(LoadM2E == true)
					{
						System.out.println("M.2 E Kit Form Factor Mainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
						//To Verify M.2 Form Factor Mainstream SSDs
						String ActualM2EMainstreamSSDs = Prop.getProperty("M2EFormFactorMainstreamSSDs");
						String ExpectedM2EMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
						Assert.assertEquals(ActualM2EMainstreamSSDs, ExpectedM2EMainstreamSSDs);
						
						// To Verify Mainstream Label 
						Assert.assertTrue(ssdResult.SSDMainstreamLabel(), "Mainstream Is Displayed");
						
						// CLick on NonMainstream Option 
						ClickM2EKit.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
						LoadM2E = LoadM2ESSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M2EFormFactorSSDs")));
						if(LoadM2E == true)
						{
							System.out.println("M.2 E Kit  Form Factor Mainstream and NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
							
							// Click on Mainstream option to Check the M.2 E Form Factor NonMainstream SSDs
							ClickM2EKit.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
							LoadM2E = LoadM2ESSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M2EFormFactorNonMainstreamSSDs")));
							if(LoadM2E == true)
							{
								System.out.println("M.2 E Kit Form Factor NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
								//To Verify M.2 E Kit Form Factor NonMainstream SSDs
								String ActualM2ENonMainstreamSSDs = Prop.getProperty("M2EFormFactorNonMainstreamSSDs");
								String ExpectedM2ENonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
								Assert.assertEquals(ActualM2ENonMainstreamSSDs, ExpectedM2ENonMainstreamSSDs);
								
								//To Verify NonMainstream the Display of NonMainstream
								//Assert.assertTrue(ssdResult.SSDNonMainstreamLabel(), "NonMainstream Is Displayed");
							}
						}
					}
				}
			}
		}
	}
	
	@Test(priority = 32, description = " To Enable the Mainstream and Uncheck the M.2 E Kit")
	public void ToDisableFormFactorOptions()
	{
		JavascriptExecutor ClickFormFactor = (JavascriptExecutor)driver;
		WebDriverWait DisableFormFactor = new WebDriverWait(driver, 3);
		// Click on NonMainstream Option 
		ClickFormFactor.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean FormFactor = DisableFormFactor.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("M2EFormFactorSSDs")));
		if(FormFactor == true)
		{
			System.out.println("M.2 E Kit SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
			// Scroll Up 
			ClickFormFactor.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
			// Click on M.2 E Kit to UnCheck
			ClickFormFactor.executeScript("arguments[0].click()", ssdResult.SSDResM2E);
			FormFactor = DisableFormFactor.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
			if(FormFactor == true)
			{
				System.out.println("Total SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
				String ActualTotalSSDs = Prop.getProperty("TotalSSDSs");
				String ExpectedTotalSSDs = ssdResult.SSDResResultDisplayLink.getText();
				Assert.assertEquals(ActualTotalSSDs,ExpectedTotalSSDs);
			}
		}
	}
	
	@Test(priority = 33, description = "To Verify Download Excel File")
	public void ToVerifyDownloadExcelFile() throws InterruptedException
	{
		Assert.assertTrue(ssdResult.DownloadExcelFile(),"Export Excel File Downloaded and File Should Contain 291 SSDs");
	} 
	
	@Test(priority = 34, description = "To Verify SSD Results By Deselecting the Best Availability Options")
	public void ToVerifySSDResultsByChangingSliders()
	{
		//ssdResult.UnCheckBestAvailability();
		ssdResult.SliderMoveFromMaxtoMiddle();
		WebDriverWait SliderValue = new WebDriverWait(driver, 2);
		JavascriptExecutor SliderClickResults = (JavascriptExecutor)driver;
		SliderClickResults.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		boolean Slide = SliderValue.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("CapacitySlidedValue")));
		if(Slide == true)
		{
			String ActualCapacitySliderSSDs = Prop.getProperty("CapacitySlidedValue");
			String ExpectedCapacitySliderSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("In Result Page Capacity Slider Moved to 7.7 TB SSDs Results Are :- " + ExpectedCapacitySliderSSDs);
			Assert.assertEquals(ActualCapacitySliderSSDs,ExpectedCapacitySliderSSDs);
		}
	}
	
	@Test(priority = 35, description = "To Verify Capacity Slider Tool Tip Value")
	public void ToVerifyCapacitySliderToolTipValue()
	{
		JavascriptExecutor CapacityValue = (JavascriptExecutor)driver;
		CapacityValue.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		String ActualCapacitySlidedValue = "7.7";
		String ExpectedCapacitySlidedValue = ssdResult.SSDResultPageMaxToolTip.getText();
		Assert.assertEquals(ActualCapacitySlidedValue, ExpectedCapacitySlidedValue);
	}
	
	@Test(priority = 36, description = "To Verify Download Excel File")
	public void ToVerifyDownloadExcelFileAfterSlidling() throws InterruptedException
	{
		WebDriverWait ExportExcel	= new WebDriverWait(driver, 2);
		ExportExcel.until(ExpectedConditions.visibilityOf(ssdResult.SSDResultExportExcel));
		Assert.assertTrue(ssdResult.DownloadExcelFile(),"Export Excel File Downloaded and File Should Contain 291 SSDs");
	}
	@Test(priority = 37, description = "To Verify SSD Results By Selecting MainStream Option")
	public void ToVerifySSDResultsBySelectingMainStreamOption()
	{
		JavascriptExecutor ClickMainstream = (JavascriptExecutor)driver;
		WebDriverWait LoadNonMainstreamSSDs = new WebDriverWait(driver, 2);
		ClickMainstream.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResBestAvailability);
		//CLick on Mainstream Option
		ClickMainstream.executeScript("arguments[0].click()", ssdResult.SSDResMainstream);
		boolean LoadNonMainstream = LoadNonMainstreamSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NonMainstreamSlidedValue")));
		if(LoadNonMainstream == true)
		{
			System.out.println("NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
			// To Verify Non Mainstream SSDs with Capacity of 7.7 TB
			String ActualNonMainstreamSSDs = Prop.getProperty("NonMainstreamSlidedValue");
			String ExpectedNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActualNonMainstreamSSDs,ExpectedNonMainstreamSSDs);
		}
	}
	
	@Test(priority = 38, description = "To Verify SSD Results By Selecting NonMainStream, Alert Message Is Displayed")
	public void ToVerifyAlertMessageDisplayed()
	{
		JavascriptExecutor ClickMainstream = (JavascriptExecutor)driver;
		ClickMainstream.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResBestAvailability);
		System.out.println("To Verify Alert Message, Trying to deselect the Best Availability Options");
		//CLick on Mainstream Option
		ClickMainstream.executeScript("arguments[0].click()", ssdResult.SSDResNonMainstream);
		ssdResult.SSDResultAlertMessageDisplayed();
	}
	
	@Test(priority = 39, description = "Select NO to Reset All Options in Alert Message In Result Page")
	public void ToVerifySSDsResultsOnClickNOInResetAlertMessage()
	{
		JavascriptExecutor ClickSelectAll = (JavascriptExecutor)driver;
		WebDriverWait LoadNonMainstreamSSDs = new WebDriverWait(driver, 3);
		ClickSelectAll.executeScript("arguments[0].click()",ssdResult.SSDResSelectAll);
		ssdResult.SSDResultClickNoOnResetMessage();
		System.out.println("In Alert Message, No Option is Selected, So Reset Is Not Applied");
		// To Verify SSDs Results are retained on Click on No Option
		System.out.println("NonMainstream SSDs :- " + ssdResult.SSDResResultDisplayLink.getText());
		//
		boolean LoadNonMainstream = LoadNonMainstreamSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("NonMainstreamSlidedValue")));
		if(LoadNonMainstream == true)
		{
		// To Verify Non Mainstream SSDs with Capacity of 7.7 TB
		 String ActualNonMainstreamSSDs = Prop.getProperty("NonMainstreamSlidedValue");
		 String ExpectedNonMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		 Assert.assertEquals(ActualNonMainstreamSSDs,ExpectedNonMainstreamSSDs);
		// To Verify the Slider Values are retained on Click on No Option
		 ToVerifyCapacitySliderToolTipValue();
		}
	}
	
	@Test(priority = 40, description = "Select YES to Reset All Options in Alert Message In Result Page")
	public void ToVerifySSDsResultsOnClickYESInResetAlertMessage()
	{
		JavascriptExecutor ClickSelectAll = (JavascriptExecutor)driver;
		WebDriverWait LoadResetSSDs = new WebDriverWait(driver, 2);
		ClickSelectAll.executeScript("arguments[0].click()",ssdResult.SSDResSelectAll);
		ssdResult.SSDResultResetMessage();
		System.out.println("In Alert Message, Yes Option is Selected, So Reset Is Applied");
		//To Verify The SSDs After Reset 
		boolean LoadReset = LoadResetSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("Mainstream")));
		if(LoadReset == true)
		{
			System.out.println("After Reset By Default Mainstream SSDs Are Displayed :- " + ssdResult.SSDResResultDisplayLink.getText());
			String ActualResetMainstreamSSDs = Prop.getProperty("Mainstream");
			String ExpectedResetMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActualResetMainstreamSSDs, ExpectedResetMainstreamSSDs);
		}
	}
	
	@Test(priority = 41, description = "To Verify Capacity Value After Reset")
	public void ToVerifyCapacityValueAfterReset()
	{
		ToVerifySSDMouseTipDisplayed();
	}
	
	@Test(priority = 42, description = "To Check SSD Selector Tool Representational Image Is Displayed")
	public void ToVerifySSDImageDisplayed()
	{
		JavascriptExecutor ClickSSDImage = (JavascriptExecutor)driver;
		ClickSSDImage.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResPortfolioImage);
		//Click on SSD Portfolio Alignment
		//ssdResult.SSDPortfolioImage();
		ClickSSDImage.executeScript("arguments[0].click()", ssdResult.SSDResPortfolioImage);
		//To Verify SSD Portfolio Image Is Displayed
		Assert.assertTrue(ssdResult.SSDPortfolioImage.isDisplayed(), "SSD Portfolio Image Is Displayed");
		System.out.println("In SSD Portfolio Alignment, Graphical Representational of Workload Image Is Displayed");
	}
	
	@Test(priority = 43, description = "To Check SKU Number In Search Tab")
	public void ToVerifyValidSearchSKUNumber()
	{
		JavascriptExecutor SearchSKU = (JavascriptExecutor)driver;
		WebDriverWait LoadSKU = new WebDriverWait(driver, 1);
		SearchSKU.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ssdResult.ValidSearch();
		// Verify Search SSD Is displayed
		SearchSKU.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		boolean WaitSKUDisplay = LoadSKU.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, "1 -  SSDs meet your requirements"));
		if(WaitSKUDisplay == true)
		{
		 String ActualSearchedSKU = "SKU:P04560-B21";
		 String ExpectedSearchedSKU = ssdResult.SearchedSKUResult.getText();
		 Assert.assertEquals(ActualSearchedSKU, ExpectedSearchedSKU);
		 System.out.println("Valid SKU Number Is Searched In Search Tab");
		}
	}
	
	@Test(priority = 44, description = " To Check SSDs Results are Retained After Clearing the Search Tab")
	public void ToVerifySSDsResultsAfterClearingSearchTab()
	{
		JavascriptExecutor SearchSKU = (JavascriptExecutor)driver;
		SearchSKU.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ssdResult.ClearSearchTab();
		WebDriverWait LoadSSDs = new WebDriverWait(driver, 2);
		boolean Load = LoadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink, Prop.getProperty("Mainstream")));
		if(Load == true)
		{
			System.out.println("After Reset Mainstream SSDs Are :- " + ssdResult.SSDResResultDisplayLink.getText());
			String ActualMainstreamSSDs = Prop.getProperty("Mainstream");
			String ExpectedMainstreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActualMainstreamSSDs, ExpectedMainstreamSSDs);
		}
		
	}
	
	@Test(priority = 45, description = "To Check Invalid SKU Number and Message Is displayed")
	public void ToVerifyAlertMessageDisplayedInValidSearch()
	{
		JavascriptExecutor SearchSKU = (JavascriptExecutor)driver;
		SearchSKU.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ssdResult.InValidSKUSearch();
		WebDriverWait LoadSSDs = new WebDriverWait(driver, 2);
		boolean Load = LoadSSDs.until(ExpectedConditions.textToBePresentInElement(ssdResult.SSDResResultDisplayLink,"0 -  SSDs meet your requirements"));
		if(Load == true)
		{
		//Verify Alert Message Is Displayed
		 String ActualMessageDisplayed = Prop.getProperty("NoSSDMessage");
		 String ExpectedMessageDisplayed = ssdResult.SSDResNoSSDMessageDisplay.getText();
		 System.out.println("No SSDs Message :- "+ ExpectedMessageDisplayed);
		 Assert.assertEquals(ActualMessageDisplayed,ExpectedMessageDisplayed);
		}
	} 
	
	@Test(priority = 46, description = "Message Is Displayed In Red Color")
	public void ToVerifyMessageDisplayedInRedColor()
	{
		String NoSSDMessageDisplayed = ssdResult.SSDResNoSSDMessageDisplay.getText();
		//System.out.println("No SSD Message Displayed :- " + NoSSDMessageDisplayed);
		//To Get the Color of the Message
		String MessageColor = ssdResult.SSDResNoSSDMessageDisplay.getCssValue("color");
		//Convert the color from String type to hexa form
		String ColorAsHex = Color.fromString(MessageColor).asHex();
		//System.out.println("Hexdecimal Format :- " + ColorAsHex);
		if(ColorAsHex.equals("#ff0000"))
		{
			System.out.println("Message Is Displayed In Red Color");
		}
		else
		{
			System.out.println("Message Is Not Displayed In Red Color");
		}
	}
	
	// Add Download Export Excel, PDF and Individual Test cases 
	
	@AfterTest(description = "Close the Browser")
	public void TearDown()
	{
		driver.close();
	}
}
