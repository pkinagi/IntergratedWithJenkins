package hpe.NewSSD;

import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

public class SSDInterfaceTypePage extends BaseClass
{

	public SSDInterfaceTypePage()
	{
		super();
	}
	
	HomePage 				ssdHomepage;
	SSDWorkloadPage   		ssdWorkload;
	SSDSSDTypePage    		ssdSSDType;
	SSDServerTypePage 		ssdServertype;
	SSDInterfacePage  		ssdInterface;
	SSDFormFactorPage 		ssdFormfactor;
	SSDBestAvailabilityPage ssdBestavailability;
	SSDResultPage     		ssdResult;
	
	@Test(priority = 0, description = "To Verify The Interface URL")
	public void ToVerifyInterfacePageURL()
	{
		WebDriverWait InterfacePageLoad = new WebDriverWait(driver, 1);
		boolean PageLoad = InterfacePageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("InterfacePage")));
		if(PageLoad == true)
		{
			String ActualSSDInterfaceURL = Prop.getProperty("InterfacePage");
			String ExpectedSSDInterfaceURL = driver.getCurrentUrl();
			Assert.assertEquals(ActualSSDInterfaceURL, ExpectedSSDInterfaceURL);
		//log.info("Successfully moved to Interface Page");
		}
	}
	
	@Test(priority = 1, description = "")
	public void ToVerifyInterfacePageComponents()
	{
		ssdInterface = new SSDInterfacePage();
		
		// To Verify Next is Enabled
		Assert.assertTrue(ssdInterface.NextBtn(), "Next Btn Is Enabled");
		
		// To Verify SATA Is Displayed
		Assert.assertTrue(ssdInterface.SSDInterfaceTypeSATA.isDisplayed(), "Serial ATA (SATA) Is Displayed In Interface Page");
		
		// To Verify SAS Is Displayed
		Assert.assertTrue(ssdInterface.SSDInterfaceTypeSAS.isDisplayed(), "Serial Attached SCSI Is Displayed In Interface Page");
		
		//To Verify NVMe Is Displayed
		Assert.assertTrue(ssdInterface.SSDInterfaceTypeNVMe.isDisplayed(), "Non-Volatile Memory Express");
	}
	
	@Test(priority = 2, description = "")
	public void ToVerifyInterfacePageMenuBar()
	{
		ssdWorkload = new SSDWorkloadPage();
		ssdSSDType = new SSDSSDTypePage();
		// To Verify In Menu Bar, Previous Pages Details are Enabled or Not
		Assert.assertTrue(ssdWorkload.SSDMenubarWorkload.isEnabled(), "Workload Is Enabled In Interface Page");
		// 
		Assert.assertTrue(ssdSSDType.SSDMenubarSSDType.isEnabled(), "SSD Type Is Enabled In Interface Page");
		//
		Assert.assertTrue(ssdInterface.SSDMenubarInterfacepageType.isEnabled(), "Interface Type Is Enabled In Interface Page");
		
	}
	
	@Test(priority = 3, description = "")
	public void ToVerifyInterfaceTypes()
	{
		// To Verify Select All Options Is Selected
		Assert.assertTrue(ssdInterface.SSDInterfaceSelectAll.isSelected(), "Select All Option Is Selected In Interface Page");
	}
	
	@Test(priority = 4, description = "To Check All options gets Disable When Double click on Select All Option")
	public void ToVerifyOptionsGetsDisable()
	{
		//All Options are in Disbale State
		Assert.assertFalse(ssdInterface.InterfacePageOptionsDisables(), "All Interface Page Options are in Disable State");
	}
	
	@Test(priority = 5, description = "Enable the Interface Options By Clicking On Select All")
	public void ToVerifySelectAllEnabled()
	{
		ssdInterface.EnableInterfaceSelectAll();
		
		//
		Assert.assertTrue(ssdInterface.SSDInterfaceSelectAll.isSelected(), "Select All Selected");
	}
	@Test(priority = 6, description = "Edit The Interface Option to Get Disable the Select All Option")
	public void ToVerifyInterfaceEditOption()
	{
		Assert.assertFalse(ssdInterface.EditInterfaceSelectAll(), "Select All Option is Not Selected");
	}
	
	@Test(priority = 7, description = "Next Button In Interface Page")
	public void ToVerifyNextButton()
	{
		ssdInterface.InterfaceNextBtn();
	}
	
	@Test(priority = 8, description = "Form Factor Page Is Launched")
	public void ToVerifyFormFactorPageIsOpened()
	{
		ssdFormfactor = new SSDFormFactorPage();
		WebDriverWait FormFactorPageLoad = new WebDriverWait(driver, 2);
		FormFactorPageLoad.until(ExpectedConditions.visibilityOf(ssdFormfactor.SSDFormFactorNextBtn));
		ssdFormfactor.FormFactorBackBtn();
	}
	
	@Test(priority = 9, description = "")
	public void ToVerifyRetainedValuesInServerTypePage()
	{
		WebDriverWait InterfacePageLoad = new WebDriverWait(driver, 1);
		boolean PageLoad = InterfacePageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("InterfacePage")));
		if(PageLoad == true)
		{
			//To Verify Edited Options are Retained In Interface Type Page, On Click Back Button In Form Factor Page
			Assert.assertFalse(ssdInterface.SSDInterfaceSelectAll.isSelected(), "Select All Option Is Not Selected");
		}
	} 
	
	@Test(priority = 10, description = "CLick On Select All Option and Click Next Button")
	public void ToClickonSelectAllOption()
	{
		// Click on Select All In Interface Page
		JavascriptExecutor ClickSelectAll = (JavascriptExecutor)driver;
		ClickSelectAll.executeScript("arguments[0].scrollIntoView()", ssdInterface.SSDInterfaceSelectAll);
		ClickSelectAll.executeScript("arguments[0].click()", ssdInterface.SSDInterfaceSelectAll);
		
		// Click Next Button
		 System.out.println("-------------------!Interface Type Test Cases are Executed Successfully!--------------------");
		ssdInterface.InterfaceNextBtn();
	} 
	
}
