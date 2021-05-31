package hpe.NewSSD;

import hpessdResource.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import hpessdPageObjects.HomePage;
import hpessdPageObjects.SSDWorkloadPage;
import hpessdPageObjects.SSDSSDTypePage;

public class SSDWorkload extends  BaseClass
{
	HomePage ssdHomepage;
	SSDWorkloadPage ssdWorkload;
	SSDSSDTypePage	ssdSSDType;
	
	
	public SSDWorkload()
	{
		super();
	}
	@Test (priority = 0, description = "!-------------------------To Verfiy HPE-SSD Site URL is displayed----------------!")	
	public void ToVerifyURLLauch()
	{
		//To Launch Browser  
		//Intialization();
		//ssdHomepage = new HomePage();
		//ssdHomepage.ClickAgreeButton();
		//ssdHomepage.ClickOnHelpMeBtn();
	}
	
	@Test (priority = 1, description = "!-------------------------To Verfiy Workload URL is displayed----------------!")
	public void ToVerifyWorkloadPage()
	{
		ssdWorkload = new SSDWorkloadPage();
		String ActualWorkloadURL = Prop.getProperty("WorkLoadPage");
		String ExpectedWorkloadURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadURL, ExpectedWorkloadURL);
	}
	@Test (priority = 2, description = "To Verify Workload option are able to click")
	public void ToVerifyAbleToSelectWorkload()
	{
			ssdWorkload.SelectReadALL();
	}
	
	/*@Test (priority = 1, description = "")
	public void ToVerifySingleWorkload()
	{
		
	}*/
	
	@Test (priority = 3, description = "To Verify Read Intensive All Workloads are selected")
	public void ToVerifySelectAllReadIntensiveWorkload()
	{
		ssdWorkload.VerifyAllReadIntensiveSelected();
	}
	
	@Test (priority = 4, description = "To Verify Next Button is enabled When Workload options are selected")
	public void ToVerifyNextButtonEnabled()
	{
		Assert.assertTrue(ssdWorkload.NextButtonEnabled());
	}
	
	@Test (priority = 5, description = "To Verify Read Intensive Option is Autoselected in SSD Type")
	public void ToVerifyReadIntensiveAutoSelected()
	{
		ssdWorkload.ClickNextBtn();
		ssdSSDType = new SSDSSDTypePage();
		Assert.assertTrue(ssdSSDType.ReadOptionSelected(), "Read Intensive Selected");
		ssdSSDType.SSDBackBtn();
	}
	
	@Test (priority = 6, description = "To Verify Workload Options are deselected")
	public void ToVerifyDeselectReadIntensiveworkload()
	{
		ssdWorkload.DeslectReadAll();
	}
	
	@Test (priority = 7, description = "To Verfiy Next Button is disabled when Workload options are deselected")
	public void ToVerifyNextButtonDisabled()
	{
		Assert.assertFalse(ssdWorkload.UnClickNextBtn(), "Next Btn is disabled");
	}
	
	@Test (priority = 8, description = "To Verify Select All Option to Select all Workload")
	public void ToVerifyAllWorkloadSelected()
	{
		ssdWorkload.WorkloadPageSelectAll();
	}
	
	@Test (priority = 9, description = "To Verify PDF file is opened on click on Link")
	public void ToVerifyPDFFileLink()
	{
		ssdWorkload.WorkloadPDF();
	}
	
	@Test (priority = 10, description = "To Verify Selected Options Retained by clicking back Button in SSD type Page")
	public void ToVerifySelectedOptionRetained()
	{
		Assert.assertTrue(ssdWorkload.SelectAllOption(), "Selected Options are retained");
	}
	
	@Test (priority = 11, description = "To Verify Selected Workload Option is Autoselected in SSD type Page")
	public void ToVerifyAutoSelectedSSDType()
	{
		ssdWorkload.ClickNextBtn();
		Assert.assertTrue(ssdSSDType.EditSSDOptions(), "Options are Auto Selected");
	}
	
	@Test (priority = 12, description = "To Verify Selected Options are selected in SSD type")
	public void ToVerifyselectAllworkload()
	{
		Assert.assertFalse(ssdSSDType.EditSSDSelectAll(),"SelectAll/I Know Don't Know Yet Option is deselected in SSD Type");
		System.out.println("----------------!Workload Test Cases are Executed Successfully!--------------------------");
		ssdSSDType.SSDNextBtn();
		
	}
	
	@Test (priority = 13, description = "To Verify Menu Bar in the workload")
	public void ToVerifyMenuBarworkload()
	{
		Assert.assertTrue(ssdWorkload.MenubarWorkload(), "Workload is enabled and It is in highligten Mode");
	}
	
	/*@Test (priority = 12, description = "")
	public void ToVerifyMixedUse()
	{
		
	}
	
	@Test (priority = 13, description = "")
	public void ToVerifyWriteIntensive()
	{
		
	}
	
	@Test (priority = 14, description = "")
	public void ToVerifyVeryReadOptimized()
	{
		
	}*/
}
