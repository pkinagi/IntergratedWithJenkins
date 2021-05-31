package hpe.NewSSD;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Java;
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

public class SSDFormFactorTypePage extends BaseClass
{
	public SSDFormFactorTypePage()
	{
		super();
	}
	
	HomePage          			ssdHomepage;
	SSDWorkloadPage   			ssdWorkload;
	SSDSSDTypePage    			ssdSSDType;
	SSDServerTypePage 			ssdServertype;
	SSDInterfacePage  			ssdInterface;
	SSDFormFactorPage 			ssdFormfactor;
	SSDBestAvailabilityPage		ssdBestAvailability;
	
	/*@Test(priority = 0, description = "To Verify Form Factor Page Is Opened")
	public void ToVerifyFormFactorPageURL()
	{
		Intialization();
		ssdHomepage = new HomePage();
		ssdHomepage.ClickAgreeButton();
		ssdHomepage.ClickOnHelpMeBtn();
		ssdWorkload = new SSDWorkloadPage();
		ssdWorkload.AllWorkloadSelect();
		ssdWorkload.ClickNextBtn();
		ssdSSDType = new SSDSSDTypePage();
		ssdSSDType.SSDNextBtn();
		ssdServertype = new SSDServerTypePage();
		ssdServertype.ServerTypeNextButtonClick();
		ssdInterface = new SSDInterfacePage();
		ssdInterface.InterfaceNextBtn();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	} */
	
	@Test(priority = 1, description = "URL Verification ")
	public void ToVerifyFFURL()
	{
			String ActualSSDFormFactorURL = Prop.getProperty("FormFactorPage");
			String ExpectedSSDFormFactorURL = driver.getCurrentUrl();
			//System.out.println(ExpectedSSDFormFactorURL);
			Assert.assertEquals(ActualSSDFormFactorURL, ExpectedSSDFormFactorURL);
	}
	
	@Test(priority = 2, description = "Form Factor Images Are Displayed")
	public void ToVerifFormFactorPageComponents()
	{
		ssdFormfactor = new SSDFormFactorPage();
		// All Form Factor Images Are Displayed 
		Assert.assertTrue(ssdFormfactor.AllImagesDisplayed(), "All Form Factor Images Are Displayed ");
	}
	
	
	@Test(priority = 3, description = "To Verify Menu Bar In Form Factor Page")
	public void ToVerifyFormFactorPageMenuBar()
	{
		// In Menu Bar Previous Page 
		ssdWorkload = new SSDWorkloadPage();
		Assert.assertTrue(ssdWorkload.SSDMenubarWorkload.isDisplayed(), "Workload Is Displayed In Menu Bar");
		
		ssdSSDType = new SSDSSDTypePage();
		Assert.assertTrue(ssdSSDType.SSDMenubarSSDType.isDisplayed(), "SSD type Is Displayed In Menu Bar");
		
		ssdServertype = new SSDServerTypePage();
		Assert.assertTrue(ssdServertype.SSDMenubarServerType.isDisplayed(), "Server type Is Displayed In Menu Bar");
		
		ssdInterface = new SSDInterfacePage();
		Assert.assertTrue(ssdInterface.SSDMenubarInterfacepageType.isDisplayed(), "Interface type Is Displayed In Menu Bar");
		
		Assert.assertTrue(ssdFormfactor.SSDMenubarFormFactorpageType.isDisplayed(), "Form Factor Is Displayed In Menu Bar");
		
	}
	
	@Test(priority = 4, description = "To Verify Select All Option Is Selected")
	public void ToVerifyFormFactorChecKBoxesTypes()
	{
		// All Options of Form Factor Checkboxes are Selected
		Assert.assertTrue(ssdFormfactor.FormFactorCheckBoxes(), "In Form Factor All Checkboxes are Selected");
		//JavascriptExecutor ClickFF = (JavascriptExecutor)driver;
		//ClickFF.executeScript("arguments[0].click()", ssdFormfactor.SSDFormFactorSFF);
		
		
		// To Verify Form Factor Select All Option Is Selected
		Assert.assertTrue(ssdFormfactor.SSDFormFactorSelectAll.isSelected(), "Select All Option Is Selected In Form Factor Page");
	}
	
	@Test(priority = 5, description = "To Check Form Factor Options gets disabled On Click On Select All")
	public void ToVerifyFormFactorOptionsGetDisabled()
	{
		// 
		Assert.assertFalse(ssdFormfactor.FormFactorAllOptionsDisabled(), "All Options Gets Disabled");
	}
	
	@Test(priority = 6, description = "Edit The Form Factor Options")
	public void ToVerifyRetainedValuesInInterfaceTypePage()
	{
		// Enable the Form Factor options
		JavascriptExecutor ClickSelectAll = (JavascriptExecutor)driver;
		ClickSelectAll.executeScript("arguments[0].click()", ssdFormfactor.SSDFormFactorSelectAll);
		
		//To Edit The Form Factor Options
		ssdFormfactor.EditFormFactorTypes();
	}
	
	@Test(priority = 7, description = "All FormFactor Types Are Enabled Then Select All Option Is Selected")
	public void ToVerifySelectAllOptionSelected()
	{
		Assert.assertFalse(ssdFormfactor.SSDFormFactorSelectAll.isSelected(), "Select All Option is Not Selected");
	}
	
	@Test (priority = 8, description = "To Check Next Button In Form Factor Page")
	public void ToVerifyFFNextButton()
	{
		ssdFormfactor.FormFactorNextBtn();
	}
	
	@Test(priority = 9, description = "To Check Best Availability Page Is Opened")
	public void ToVerifyBestAvailabilityPage()
	{
		ssdBestAvailability = new SSDBestAvailabilityPage();
		WebDriverWait LoadBestAvailability = new WebDriverWait(driver, 1);
		String ActualBestAvailabilityURL =  Prop.getProperty("MainstreamPage");
		String ExpectedBestAvailabilityURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualBestAvailabilityURL,ExpectedBestAvailabilityURL);
		
		// Wait Till Page gets completely Load
		LoadBestAvailability.until(ExpectedConditions.visibilityOf(ssdBestAvailability.SSDBestAvailNextBtn));
		
		// Click Back Button
		ssdBestAvailability.BestAvailBackBtn();
	}
	
	@Test(priority = 10, description = "To Check Form Factor Values Are Retained")
	public void ToVerifyRetainedValuesInFormFactor()
	{
		WebDriverWait LoadInterfacePage = new WebDriverWait(driver, 2);
		LoadInterfacePage.until(ExpectedConditions.visibilityOf(ssdFormfactor.SSDFormFactorM2eImage));
		
		// To Verify Select All Is not Selected
		Assert.assertFalse(ssdFormfactor.SSDFormFactorSelectAll.isSelected(), "Select All Option Is Not Selected");
	}
	
	@Test(priority = 11, description = "Click on Select All In Form Factor Page")
	public void ToVerifyAllCheckBoxesSelectedInFormFactor()
	{
		JavascriptExecutor ClickInterfaceSelectAll = (JavascriptExecutor)driver;
		ClickInterfaceSelectAll.executeScript("arguments[0].click()", ssdFormfactor.SSDFormFactorSelectAll);
		
		//To Verify All Check Boxes Are Selected
		Assert.assertTrue(ssdFormfactor.FormFactorCheckBoxes(), "All Options are Selected");
	}
	
	@Test(priority = 12, description = "Click Next Button")
	public void ToClickNextButtonInFormFactorPage()
	{
		//Click on Next Button In Form Factor Page
		System.out.println("-------------------!Form Factor Test Cases are Executed Successfully!-------------------------");
		ssdFormfactor.FormFactorNextBtn();
	} 
}
