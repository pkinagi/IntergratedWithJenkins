package hpe.NewSSD;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hpessdPageObjects.HomePage;
import hpessdPageObjects.SSDBestAvailabilityPage;
import hpessdPageObjects.SSDFormFactorPage;
import hpessdPageObjects.SSDInterfacePage;
import hpessdPageObjects.SSDSSDTypePage;
import hpessdPageObjects.SSDServerTypePage;
import hpessdPageObjects.SSDWorkloadPage;
import hpessdResource.BaseClass;

public class SSDBestAvailabilityTypePage extends BaseClass
{
	
	public SSDBestAvailabilityTypePage()
	{
		super();
	}
	
	HomePage         	 		ssdHomepage;
	SSDWorkloadPage  		 	ssdWorkload;
	SSDSSDTypePage   	 		ssdSSDType;
	SSDServerTypePage 			ssdServertype;
	SSDInterfacePage  			ssdInterface;
	SSDFormFactorPage 			ssdFormfactor;
	SSDBestAvailabilityPage 	ssdBestAvailability;

	
	@Test(priority = 0, description = "To Lauch Form Best Availability Page URL Continuation From Form Factor Type Page")
	public void ToVerifyBestAvailabilityPageURL()
	{
		ssdBestAvailability  = new SSDBestAvailabilityPage();
		String ActualSSDBestAvailURL = Prop.getProperty("MainstreamPage");
		String ExpectedSSDBestAvailURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDBestAvailURL, ExpectedSSDBestAvailURL);
	}
	
	@Test(priority = 1, description = "To Verify The Best Availability Page Components")
	public void ToVerifyBestAvailabilityPageComponents()
	{
		
		
		// By Default Mainstream Option Is Selected
		Assert.assertTrue(ssdBestAvailability.SSDBestAvailMainstream.isSelected(), "Mainstream Option Is Selected");
		
		// By Default Non-Mainstream Option Is Not Selected
		Assert.assertFalse(ssdBestAvailability.SSDBestAvailNonMainstream.isSelected(), "Non-Mainstream Option Is Not Selected");
		
		// Select All Option Is Not Selected
		Assert.assertFalse(ssdBestAvailability.SSDBestAvailSelectAll.isSelected(),"Select All Option Is Not Selected");
		
		//To Check Next Button
		Assert.assertTrue(ssdBestAvailability.SSDBestAvailNextBtn.isEnabled(), "Next Button Is Enabled");
	}
	
	@Test(priority = 2, description = "To Verify the Best Availability Menu Bar")
	public void ToVerifyBestAvailabilityPageMenuBar()
	{
		//Menu Bar 
		
		ssdWorkload = new SSDWorkloadPage();
		//Workload Displayed in Menu Bar
		Assert.assertTrue(ssdWorkload.SSDMenubarWorkload.isDisplayed(), "Workload Is Displayed");
		
		ssdSSDType = new SSDSSDTypePage();
		//SSD type Displayed in Menu Bar
		Assert.assertTrue(ssdSSDType.SSDMenubarSSDType.isDisplayed(), "SSD type Is Displayed");
		
		ssdServertype = new SSDServerTypePage();
		//Server type Displayed in Menu Bar
		Assert.assertTrue(ssdServertype.SSDMenubarServerType.isDisplayed(), "Server type Is Displayed");
		
		ssdInterface = new SSDInterfacePage();
		//Interface type Displayed in Menu Bar
		Assert.assertTrue(ssdInterface.SSDMenubarInterfacepageType.isDisplayed(), "Interface type Is Displayed");
		
		ssdFormfactor = new SSDFormFactorPage();
		// Form Factor type Displayed in Menu Bar
		Assert.assertTrue(ssdFormfactor.SSDMenubarFormFactorpageType.isDisplayed(), "Form Factor Is Displayed");
		
		ssdBestAvailability = new SSDBestAvailabilityPage();
		//Best Availability Displayed in Menu Bar
		Assert.assertTrue(ssdBestAvailability.SSDMenubarBestAvailability.isDisplayed(), "Best Availability Is Displayed");
	}
	
	@Test(priority = 3, description = "To Verify Select All Option Is Selected")
	public void ToVerifyBestAvailabilityTypes()
	{
		//Click on NonMainstream Option
		Assert.assertTrue(ssdBestAvailability.ClickOnNonMainstream(), "Click on NonMainstream,Then Select All Option Gets Selected");
	}
	
	@Test(priority = 4, description = "To Verify Best Availability Page gets Disabled On Click on Select All")
	public void ToVerifyBestAvailabilityPageGetsDisabled()
	{
		Assert.assertFalse(ssdBestAvailability.BestAvailabilityOptionDisabled(), "All Options are not Selected");
	}
	
	@Test(priority = 5, description = "To Check Form Factor Values are Retained On Click on Back Button In Best Availability")
	public void ToVerifyValuesRetainedInFormFactorPage()
	{
		ssdBestAvailability.BestAvailBackBtn();
		
		ssdFormfactor = new SSDFormFactorPage();
		// To Verify Form Factor Values are reatined
		WebDriverWait FormFactorLoad = new WebDriverWait(driver, 1);
		FormFactorLoad.until(ExpectedConditions.visibilityOf(ssdFormfactor.SSDFormFactorM2eImage));
		
		// All Options In Form Factor Page Is Selected
		/*Assert.assertFalse(ssdFormfactor.SSDFormFactorSelectAll.isSelected(), "Select All Option Is Selected");
		
		//For Enabling Form Factor Select All Option
		JavascriptExecutor FFSelectAll = (JavascriptExecutor)driver;
		FFSelectAll.executeScript("arguments[0].click()", ssdFormfactor.SSDFormFactorSelectAll); */
		
		// Click Next Button In Form Factor Page
		ssdFormfactor.FormFactorNextBtn();
	}
	
	@Test(priority = 6, description = "By Default One Option Is Selected In Best Availability Page")
	public void ToVerifyMainstreamOptionSelected()
	{
		WebDriverWait BestAvailLoad = new WebDriverWait(driver, 1);
		BestAvailLoad.until(ExpectedConditions.visibilityOf(ssdBestAvailability.SSDBestAvailNextBtn));
		
		// By Default Mainstream Option Is Selected
		Assert.assertTrue(ssdBestAvailability.SSDBestAvailMainstream.isSelected(), "Mainstream Option Is Selected");
	}
	
	@Test(priority = 7, description = "Click Next Button In Best Availability Page")
	public void ToVerifyNextButtonClickInBestAvailability()
	{
		System.out.println("------------------------!Best Availability Test Cases are Executed Successfully!-----------------------");
		ssdBestAvailability.BestAvailNextBtn();
	}
	
	@Test(priority = 8, description = "Directing To Result Page")
	public void ToVerifyResultPageURL()
	{
		String ActualSSDResultPageURL = Prop.getProperty("ResultPage");
		String ExpectedSSDResultPageURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDResultPageURL, ExpectedSSDResultPageURL);
	}
	
}
