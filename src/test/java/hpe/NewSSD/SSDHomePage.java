package hpe.NewSSD;

import hpessdPageObjects.SSDWorkloadPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import hpessdPageObjects.HomePage;
import hpessdResource.BaseClass;

public class SSDHomePage extends BaseClass
{
	
	SSDWorkloadPage ssdWorkload;
	HomePage ssdHomepage;
	
	public SSDHomePage()
	{
		super();
	}
	
	@Test (priority = 0, description = "To Verify the URL link is Opened")
	public void ToVerifyLanchedURL()
	{
		// URL is Launch
		Intialization();
		ssdHomepage = new HomePage();
		ssdWorkload = new SSDWorkloadPage();
		String ActualSSDURL = Prop.getProperty("URL");
		String ExpectedSSDURL =  driver.getCurrentUrl();
		Assert.assertEquals(ActualSSDURL, ExpectedSSDURL, "SSD URL is Launch");
	}
	
	@Test (priority = 1, description = "To Verify the Pop up Dialogue Message")
	public void ToVerifyPopMessage()
	{
		//ssdHomepage.VerifyPopUp();
		Assert.assertTrue(ssdHomepage.VerifyPopUp(), "In PopUp Alert Message is Correct");
	}
	
	@Test (priority = 2, description = "To Verify and Click on Agree Button")
	public void ToVerifyAgreeButton()
	{
		ssdHomepage.ClickAgreeButton();
	}
	
	@Test (priority = 3, description = "To Verify the Help Me Choose and I Know What I Need Buttons are Visible and Aligned in the Page")
	public void ToVerifyHelpMeBtnLabel()
	{
		//ssdHomepage.VerifyHelpChooseBtnLabel();
		ssdHomepage.XCoordinatesOfHelpMeChooseNIKnowWhatINeed();
	}
	
	@Test (priority = 4, description = "To Verify the I Know What I Need Visible in the Page")
	public void ToVerifyIKnowBtnLabel()
	{
		ssdHomepage.VerifyIKnowBtnLabel();
	}
	
	@Test (priority = 5, description = "To Verify the Release Notes Link Visible in the Page")
	public void ToVerifyReleaseLinkLabel()
	{
		ssdHomepage.VerifyReleaseLinkLabel();
	}
	
	@Test (priority = 6, description = "To Verify the User Manual Link Visible in the Page")
	public void ToVerifyUserManualLinkLabel()
	{
		ssdHomepage.VerifyManualLabel();
	}
	
	@Test (priority = 7, description = "To Verify it is redirecting to Result Page")
	public void ToVerifyIKnowWhatINeed()
	{
		ssdHomepage.ClickIKnowBtn();
		String ActualResultPageURL = Prop.getProperty("ResultPage");
		String ExpectedResultPageURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualResultPageURL, ExpectedResultPageURL);
	}
	
	@Test (priority = 8, description = "To Verify it is redirecting to HomePage on Click on Start Over")
	public void ToVerifyToGetBackHomePage()
	{
		driver.navigate().refresh();
		ToVerifyAgreeButton();
	}
	
	@Test (priority = 9, description = "To Verify PDF File is Opened in Next Tab")
	public void ToVerifyReleaseNotesLink()
	{
		ssdHomepage.ClickReleaseNotes();
	}
	
	@Test (priority = 10, description = "To Verify PDF is Opened is Next  Tab")
	public void ToVerifyUserManualLink()
	{
		ssdHomepage.ClickUserManual();
	}
	
	@Test (priority = 11, description = "To Verify it it redirecting to Workload Page")
	public void ToVerifyHelpMeChoose()
	{
		ssdHomepage.ClickOnHelpMeBtn();
		System.out.println("--------------!HomePage Test Cases Are Executed Successfully!----------------");
		String ActualWorkloadPage = Prop.getProperty("WorkLoadPage");
		String ExpectedWorkloadPage = driver.getCurrentUrl();
		Assert.assertEquals(ActualWorkloadPage, ExpectedWorkloadPage);
	}
	
	
}











































































