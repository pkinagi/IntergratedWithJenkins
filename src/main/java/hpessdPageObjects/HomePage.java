package hpessdPageObjects;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.chainsaw.Main;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hpessdResource.BaseClass;

public class HomePage extends BaseClass
{
	//Home Page has 4 Links 
	// I Know What I Need , Help Me Choose, link for Release Notes and  Link for UserManual
	
	@FindBy(xpath = "//*[@id=\"iKnow_btn\"]")
	WebElement	SSDHomePageIKnow;
	
	@FindBy(xpath = "//*[@id=\"helpMeChoose_btn\"]")
	WebElement SSDHomePageHelpMe;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/section/section/div[3]/div[2]/a")
	WebElement SSDHomePageReleaseNotesLink;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/section/section/div[3]/div[3]/a")
	WebElement SSDHomePageUserManualLink;
	
	//POPup Page appears, When the HPE SSD Site is launched 
	
	@FindBy(xpath = "//*[@id=\"licenseAgree_btn\"]")
	WebElement SSDAgreeBtn;
	
	@FindBy(xpath = "//*[@id=\"ngdialog1-aria-labelledby\"]")
	public
	WebElement SSDPopUpText;
	
	//To Find the X and Y Coordinates of the Page
	
	
	//Page Factory
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyPopUp()
	{
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("arguments[0].scrollIntoView();", SSDPopUpText);
		String ActualTextPopWindow = "HPE Solid-State Drive Selector v2.0.1";
		String ExpectedTextPopWindow = SSDPopUpText.getText();
		System.out.println("---- SSD Selector Tool Version ----"+ExpectedTextPopWindow);
		if(ActualTextPopWindow.equalsIgnoreCase(ExpectedTextPopWindow))
		{
			Assert.assertEquals(ActualTextPopWindow, ExpectedTextPopWindow);
			System.out.println("--------------------!In Pop Alert SSD Driver Selector Version Displayed Correctly!------------------");
		    return true;
		}
		else
			return false;
	}
	
	public void ClickAgreeButton()
	{
		SSDAgreeBtn.click();
	}
	
	public void XCoordinatesOfHelpMeChooseNIKnowWhatINeed()
	{
		int XHelpMeCoordinates = SSDHomePageHelpMe.getLocation().getX();
		System.out.println("Help Me Choose Button X Axis:-" + XHelpMeCoordinates);
		
		int yCoordinates = SSDHomePageHelpMe.getLocation().getY();
		System.out.println("Help Me Choose Button Y Axis:-" + yCoordinates);
		
		int XIKnowWhatCoordinates = SSDHomePageIKnow.getLocation().getX();
		System.out.println("I Know What I Need Button X Axis:-" + XIKnowWhatCoordinates);
		
		int YIKnowWhatCoordinates = SSDHomePageIKnow.getLocation().getY();
		System.out.println("I Know What I Need Button Y Axis:-" + YIKnowWhatCoordinates);
		
		// To Check the X Co-ordinates of I Know What I Need and Help Me Choose
		if(XIKnowWhatCoordinates == XHelpMeCoordinates)
		{
			System.out.println("Both I Know What I Need and Help Me Choose Buttons are in Same Line");
		}
		else
		{
			System.out.println("Both I Know What I Need and Help Me Choose Buttons are not in Same Line");
		}
		
		
	}
	public void ClickIKnowBtn()
	{
		SSDHomePageIKnow.click();
	}
	
	public boolean VerifyIKnowBtnLabel()
	{
		String ActualBtnLabel = "I know what I need";
		String ExpectBtnLabel = SSDHomePageIKnow.getText();
		if (ActualBtnLabel.equalsIgnoreCase(ExpectBtnLabel))
		{
			Assert.assertEquals(ActualBtnLabel, ExpectBtnLabel);
			System.out.println("--------------------!In Home Page I Know What I Need Displayed Correctly!------------------");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ClickOnHelpMeBtn()
	{
		SSDHomePageHelpMe.click();
	}
	
	public boolean VerifyHelpChooseBtnLabel()
	{
		String ActualHelpMeLabel = "Help me choose";
		String ExpectedHelpMeLabel = SSDHomePageHelpMe.getText();
		if (ActualHelpMeLabel.equalsIgnoreCase(ExpectedHelpMeLabel))
		{
			Assert.assertEquals(ActualHelpMeLabel, ExpectedHelpMeLabel);
			System.out.println("--------------------!In Home Page Help Me Choose Displayed Correctly!------------------");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ClickReleaseNotes()
	{
		SSDHomePageReleaseNotesLink.click();
		OpenReleaseNotesPDF();
	}
	
	public boolean VerifyReleaseLinkLabel()
	{
		if(SSDHomePageReleaseNotesLink.isDisplayed())
		{
			System.out.println("--------------------!In Home Page Release Notes Link Displayed Correctly!------------------");
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void ClickUserManual()
	{
		SSDHomePageUserManualLink.click();
		OpenUserManualPDF();
	}
	
	public boolean VerifyManualLabel()
	{
		if(SSDHomePageUserManualLink.isDisplayed())
		{
			System.out.println("--------------------!In Home Page User Manual/Documentation Displayed Correctly!------------------");
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void OpenReleaseNotesPDF()
	{
		String MainWindow = driver.getWindowHandle();
		Set<String> PDFFileOpened = driver.getWindowHandles();
		Iterator<String> ReleasePDF = PDFFileOpened.iterator();
		while(ReleasePDF.hasNext())
		{
			String PDFRelease = ReleasePDF.next();
			if(!MainWindow.equalsIgnoreCase(PDFRelease))
			{	
				driver.switchTo().window(PDFRelease);
				driver.getCurrentUrl();
				String ActualString = Prop.getProperty("ReleaseNotesPDFFile");
				String ExpectedString = driver.getCurrentUrl();
				Assert.assertEquals(ActualString, ExpectedString);
				System.out.println("--------------------!In Home Page Release Notes PDF Opened Correctly!------------------");
				driver.close();
			}	
		}
		driver.switchTo().window(MainWindow);
	}
	
	public void OpenUserManualPDF()
	{
		String MainWindow = driver.getWindowHandle();
		Set<String> PDFUserManualOpened = driver.getWindowHandles();
		Iterator<String> UserManualPDF = PDFUserManualOpened.iterator();
		while(UserManualPDF.hasNext())
		{
			String PDFUserManual = UserManualPDF.next();
			if(!MainWindow.equalsIgnoreCase(PDFUserManual))
			{
				driver.switchTo().window(PDFUserManual);
				driver.getCurrentUrl();
				String ActualString = Prop.getProperty("UserManualPDFFile");
				String ExpectedString = driver.getCurrentUrl();
				Assert.assertEquals(ActualString,ExpectedString);
				System.out.println("--------------------!In Home Page User Manual/Documentation Opened Correctly!------------------");
				driver.close();
			}
		}
		driver.switchTo().window(MainWindow);
	}
	
}


