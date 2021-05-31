package hpe.NewSSD;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.graphbuilder.curve.Point;

import hpessdPageObjects.HomePage;
import hpessdPageObjects.SSDBestAvailabilityPage;
import hpessdPageObjects.SSDFormFactorPage;
import hpessdPageObjects.SSDInterfacePage;
import hpessdPageObjects.SSDResultPage;
import hpessdPageObjects.SSDSSDTypePage;
import hpessdPageObjects.SSDServerTypePage;
import hpessdPageObjects.SSDWorkloadPage;
import hpessdResource.BaseClass;

public class SSDModuleTest extends BaseClass
{
	public SSDModuleTest()
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
	
	@BeforeTest(description = "!-------------------!--To Test SSD Scenarios for SSD Selector Tool---!----------------------!")
	
	@Test(priority = 0, description ="To Verify the SSD Selector Home Page URL")
	public void ToVerifySSDURLLaunch()
	{
		// To Launch the SSD URL In Browser
		Intialization();
		
		// Declaration of Home Page Object
		ssdHomepage = new HomePage();
		
		// Click on I Agree Button
		ssdHomepage.ClickAgreeButton();
		
		// To Verify URL 
		String ActualHomePageURL = Prop.getProperty("HomePage");
		String ExpectedHomePageURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualHomePageURL,ExpectedHomePageURL);
	}
	
	@Test(priority = 1, description = "In Home Page, All Label is visible")
	public void ToVerifyLabelInHomePage()
	{
		// To Verify Home Page Components
		AssertJUnit.assertTrue("I Know What I Need Btn Is Displayed",ssdHomepage.VerifyIKnowBtnLabel());
				
		AssertJUnit.assertTrue("Help Me Choose Btn Is Displayed",ssdHomepage.VerifyHelpChooseBtnLabel());
				
		AssertJUnit.assertTrue("Release Notes Link Is Displayed",ssdHomepage.VerifyReleaseLinkLabel());
				
		AssertJUnit.assertTrue("User Manual Like Is Displayed", ssdHomepage.VerifyManualLabel());
	}
	
	@Test(priority = 2, description = "TO Click on Help Me Choose Option In The Home Page")
	public void ToVerifyHelpMeChooseBtn()
	{
		// Click on "Help Me Choose" Button In The Home Page
		ssdHomepage.ClickOnHelpMeBtn();
		
		//To Verify Workload Page is Displayed
		String ActualWorkloadPageURL = Prop.getProperty("WorkLoadPage");
		String ExpectedWorkloadPageURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualWorkloadPageURL,ExpectedWorkloadPageURL);
	}
	
	@Test(priority = 3, description = "To Verify Workload Are Displayed Based On Performance Wise")
	public void ToVerifyWorkloadDisplay()
	{
		
		
	}
	
	@Test(priority = 4, description = "To Select the Workload")
	public void ToSelectTheWorkload()
	{
		ssdWorkload = new SSDWorkloadPage();
		
		// For Selecting the Workload In Workload Page
		
		ssdWorkload.SelectMixedALL();
		
		System.out.println("---------! Workload Page :- Mixed Use Workload Selected !------------");
		
		// TO Dimensions of Mixed Column
		//ssdWorkload.CoordinatesofWorkloads();
		//Assert.assertTrue(ssdWorkload.CoordinatesofMixedUseWorkloads());
		//AssertJUnit.assertTrue("User Manual Like Is Displayed", ssdWorkload.CoordinatesofMixedUseWorkloads());
		
		// Click on Next Btn
		
		ssdWorkload.ClickNextBtn();
		
	}
	
	@Test(priority = 5, description = "To Click Next Btn In SSD Type")
	public void ToVerifySSDTypePage()
	{
		ssdSSDType = new SSDSSDTypePage();
		
		// To Verify Auto SSD type Is Selected based on the Workload
		
		AssertJUnit.assertTrue("Mixed Use Is Selected In The SSD type Page", ssdSSDType.MixedUseSelected());
		
		// To Click on Next Btn in SSD page
		
		ssdSSDType.SSDNextBtn();
		System.out.println("---------! SSD Type Page :- Mixed Use Workload Selected !------------");
	}
	
	@Test(priority = 6, description = "To Select Server Type ")
	public void ToVerifyToSelectSeverType()
	{
		ssdServertype = new SSDServerTypePage();
		
		//Select the Server type 
		
		Select ServerType = new Select(ssdServertype.SSDServerType);
		ServerType.selectByVisibleText(Prop.getProperty("ServerApollo"));
		WebElement SelectedServerType = ServerType.getFirstSelectedOption();
		String ServerTypePageSelectedServerType = SelectedServerType.getText();
		
		System.out.println("---------! Server Type Page :- Server Type Selected :- " + ServerTypePageSelectedServerType + "!------------");
		
		// Click Next Btn
		ssdServertype.ClickServerTypeNextBtn();
	}
	
	@Test(priority = 7, description = "To Click Next In Interface Page")
	public void ToVerifyInterfacePage()
	{
		ssdInterface = new SSDInterfacePage();
		
		// To Verify Interface Options Are AutoSelected
		
		 WebDriverWait InterfacePageLoad = new WebDriverWait(driver, 5);
		 InterfacePageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("InterfacePage")));
		// To Check Interface Page is displayed
		String ActualInterfaceURL = Prop.getProperty("InterfacePage");
		String ExpectedInterfaceURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualInterfaceURL, ExpectedInterfaceURL);
		
		JavascriptExecutor InterfacePageScrollDown = (JavascriptExecutor)driver;
		InterfacePageScrollDown.executeScript("arguments[0].scrollIntoView();",ssdInterface.SSDInterfaceSelectAll);
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		AssertJUnit.assertTrue("Select All Option Is Selected", ssdInterface.SSDInterfaceSelectAll.isSelected());
		
		// Click Next Btn In Interface Page
		
		ssdInterface.InterfaceNextBtn();
		System.out.println("--------------------! Interface Types Page Components are Displayed Correctly !------------------");
	}
	
	@Test(priority = 8, description = "To Click Next In Form Factor Page")
	public void ToVerifyFormFactorPage()
	{
		ssdFormfactorType = new SSDFormFactorPage();
		
		// To Verify Form Factor Options Are AutoSelected
		WebDriverWait FormFactorPageLoad = new WebDriverWait(driver, 5);
		 FormFactorPageLoad.until(ExpectedConditions.urlToBe(Prop.getProperty("FormFactorPage")));
		
		JavascriptExecutor FormFactorPageScrollDown = (JavascriptExecutor)driver;
		FormFactorPageScrollDown.executeScript("arguments[0].scrollIntoView();",ssdFormfactorType.SSDFormFactorSelectAll);
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//Assert.assertTrue("Select All Option Is Selected", ssdFormfactorType.SSDFormFactorSelectAll.isSelected());
		
		// Click Next Btn In FormFactor Page
		
		ssdFormfactorType.FormFactorNextBtn();
		System.out.println("--------------------! Form Factor Page Components are Displayed Successfully !------------------");
	}
	
	@Test(priority = 9, description = "To Click Next In Best Availability")
	public void ToVerifyMainstreamPage()
	{
		ssdBestAvailabilitytype = new SSDBestAvailabilityPage();
		
		// By default Mainstream Option is Selected
		
		AssertJUnit.assertTrue("Mainstream Option is Selected", ssdBestAvailabilitytype.BestAvailMainstream());
		
		// Click Next Btn In Best Availability Page
		
		ssdBestAvailabilitytype.BestAvailNextBtn();
		System.out.println("--------------------! Best Availability Page Components are Displayed Successfully !------------------");
	}
	
	@Test(priority = 10, description = "To Verify Result Page Is Displayed")
	public void ToVerifySSDResultPage()
	{
		ssdResult = new SSDResultPage();
		
		// 
		String ActualResultPageURL = Prop.getProperty("ResultPage");
		String ExpectedResultPageURL = driver.getCurrentUrl();
		AssertJUnit.assertEquals(ActualResultPageURL,ExpectedResultPageURL);
	}
	
	@Test(priority = 11, description = "To Verify SSD Results with Mainstream Options")
	public void ToVerifySSDResults()
	{
		WebDriverWait SSDLoad = new WebDriverWait(driver, 8);
		
		JavascriptExecutor SSDResultsScrollDown = (JavascriptExecutor)driver;
		SSDResultsScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		
		boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		
		/*ReadResultDisplay = SSDLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedApolloMainstreamSSDs")));
		if(ReadResultDisplay == true)
		{
			String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloMainstreamSSDs");
			String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Mixed Intensive SSDs :- " + ExpectedMixedMaistreamSSDs);
			AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		}*/
		SSDLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloMainstreamSSDs");
		String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		System.out.println("Mixed Intensive SSDs :- " + ExpectedMixedMaistreamSSDs);
		AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
	}
	
	@Test(priority = 12, description = "To Check the Server Type and Server Model Drop down")
	public void ToVerifyResultPageSelectedServerTypeDisplayed()
	{
		// Scroll the Browser Window 
		JavascriptExecutor SSDResultsScrollUp= (JavascriptExecutor)driver;
		SSDResultsScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		
		// Server Type 
		
		Select ResultPageServerType = new Select(ssdResult.SSDResSelectServerType);
		WebElement SelectedServerType = ResultPageServerType.getFirstSelectedOption();
		String ActualResultPageSelectedServerType = Prop.getProperty("ServerApollo");
		String ExpectedResultPageSelectedServerType = SelectedServerType.getText();
		AssertJUnit.assertEquals(ActualResultPageSelectedServerType, ExpectedResultPageSelectedServerType);
		
		// Server Model
		
		Select ResultPageServerModel = new Select(ssdResult.SSDResSelectServerModel);
		WebElement SelectedServerModel = ResultPageServerModel.getFirstSelectedOption();
		String ActualResulPageSelectedServerModel = "-- Server Model --";
		String ExpectedResultPageSelectedServerModel = SelectedServerModel.getText();
		AssertJUnit.assertEquals(ActualResulPageSelectedServerModel,ExpectedResultPageSelectedServerModel);
		
	}
	
	@Test(priority = 13, description = "To Select Server Model")
	public void ToVerifyToSelectServerModel()
	{
		Select ReseultPageSelectServerModel = new Select(ssdResult.SSDResSelectServerModel);
		ReseultPageSelectServerModel.selectByVisibleText("Apollo 4200 Gen10");
		
	}
	

	@Test(priority = 14, description = "To Verify SSDs After Changing Server Model")
	public void ToVerifySSDsResults() throws InterruptedException
	{
		JavascriptExecutor SSDResultsScrollDown = (JavascriptExecutor)driver;
		SSDResultsScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		
		//SSDResultsScrollDown.executeScript("arguments[0].scrollIntoView();",ssdResult.SSDResRefineResults);
		WebElement SSDResultsDisplayed = ssdResult.SSDResResultDisplayLink;
		
		WebDriverWait SSDResultsLoad = new WebDriverWait(driver, 1);
		
		SSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		
		
		//boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		
		/* FluentWait wait = new FluentWait(driver);
		wait.withMessage(Prop.getProperty("MixedApolloServerModelMainstreamSSDs"));
		String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloServerModelMainstreamSSDs");
		String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		System.out.println("Mixed Intensive SSDs :- " + ExpectedMixedMaistreamSSDs);
		AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs); */
		
		boolean ReadResultDisplay = SSDResultsLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedApolloServerModelMainstreamSSDs")));
		//SSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		if(ReadResultDisplay == true)
		{
			String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloServerModelMainstreamSSDs");
			String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Mixed Intensive SSDs :- " + ExpectedMixedMaistreamSSDs);
			AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		} 
	}
	
	@Test(priority = 15, description = "Change the Server Type To ----Please Select Server Type----")
	public void ToVerifySSDsResultOnChangeServertype()
	{
		JavascriptExecutor SSDResultsScrollUp= (JavascriptExecutor)driver;
		SSDResultsScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		
		// Server Type 
		Select ResultPageServerType = new Select(ssdResult.SSDResSelectServerType);
		ResultPageServerType.selectByVisibleText("-- Please select server type --");
	}
	
	@Test(priority = 16, description = "To Mainstream SSDs Results are Displayed")
	public void ToVerifySSDsMixedMainStreamResults()
	{
		JavascriptExecutor SSDResultsScrollDown = (JavascriptExecutor)driver;
		SSDResultsScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
	
		
		WebDriverWait MixedMainstreamSSDResultsLoad = new WebDriverWait(driver, 1);
		MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
	
		
		// boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		
		boolean ReadResultDisplay = MixedMainstreamSSDResultsLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedMainstreamSSDsResults")));
		if(ReadResultDisplay == true)
		{
			String ActualMixedMaistreamSSDs = Prop.getProperty("MixedMainstreamSSDsResults");
			String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Mixed Use MainStream SSDs :- " + ExpectedMixedMaistreamSSDs);
			AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		}
		
		//MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		 /* FluentWait wait = new FluentWait(driver);
		wait.withMessage(Prop.getProperty("MixedMainstreamSSDsResults"));
		String ActualMixedMaistreamSSDs = Prop.getProperty("MixedMainstreamSSDsResults");
		String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		System.out.println("Mixed Use MainStream SSDs :- " + ExpectedMixedMaistreamSSDs);
		AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs); */
	}
	
	@Test(priority = 17, description = "To Select The Server Type")
	public void ToVerifyToSelectServerType()
	{
		JavascriptExecutor SSDResultsScrollUp= (JavascriptExecutor)driver;
		SSDResultsScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		
		Select ServerType = new Select(ssdResult.SSDResSelectServerType);
		ServerType.selectByVisibleText(Prop.getProperty("ServerApollo"));
		
	}
	
	@Test(priority = 18, description = "To Verify SSDs Results are displayed Based on the Selected Server Type")
	public void ToVerifySelectedServerSSDs()
	{
		WebDriverWait MixedMainstreamSSDResultsLoad = new WebDriverWait(driver, 2);
		// boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		
		MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		
		boolean ReadResultDisplay = MixedMainstreamSSDResultsLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedApolloMainstreamSSDs")));
		if(ReadResultDisplay == true)
		{
			String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloMainstreamSSDs");
			String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Mixed Use MainStream SSDs :- " + ExpectedMixedMaistreamSSDs);
			AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		} 
		
		/* FluentWait wait = new FluentWait(driver);
		wait.withMessage(Prop.getProperty("MixedApolloMainstreamSSDs"));
		//MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloMainstreamSSDs");
		String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		System.out.println("Mixed Use MainStream SSDs :- " + ExpectedMixedMaistreamSSDs);
		AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs); */
	}
	
	@Test(priority = 19, description = "To Verify Alert Message Is Displayed On Click on Mainstream")
	public void ToVerifyAlertMessageUnableUnCheckBestAvailabilityOptions()
	{
		if(ssdResult.SSDResNonMainstream.isSelected() == false)
		{
			// Click on MainStream Option
			ssdResult.SSDResultMainstream();
			// To Verify the Alert Message
			ssdResult.SSDResultAlertMessageDisplayed();
		}
	}
	
	@Test(priority = 20, description = "SSDs Results are Not Changes on Clicked")
	public void ToVerifySSDResultsNotChanged()
	{
		WebDriverWait MixedMainstreamSSDResultsLoad = new WebDriverWait(driver, 1);
		
		MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		
		//boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		boolean ReadResultDisplay = MixedMainstreamSSDResultsLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedApolloMainstreamSSDs")));
		if(ReadResultDisplay == true)
		{
			String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloMainstreamSSDs");
			String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Mixed Use MainStream SSDs :- " + ExpectedMixedMaistreamSSDs);
			AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		} 
		//MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		 /* FluentWait wait = new FluentWait(driver);
		wait.withMessage(Prop.getProperty("MixedApolloMainstreamSSDs"));
		String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloMainstreamSSDs");
		String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		System.out.println("Mixed Use MainStream SSDs :- " + ExpectedMixedMaistreamSSDs);
		AssertJUnit.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs); */
	}
	
	/*@Test(priority = 21, description = "SSDs Results are Not Changes on Clicked")
	public void ToVerifySSDResultsNotChanged()
	{
		WebDriverWait MixedMainstreamSSDResultsLoad = new WebDriverWait(driver, 2);
		boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		
		ReadResultDisplay = MixedMainstreamSSDResultsLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedApolloMainstreamSSDs")));
		if(ReadResultDisplay == true)
		{
			String ActualMixedMaistreamSSDs = Prop.getProperty("MixedApolloMainstreamSSDs");
			String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("Mixed Use MainStream SSDs :- " + ExpectedMixedMaistreamSSDs);
			Assert.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		}
	} */
	
	@Test(priority = 22, description = "To Check Search Tab With SKU Number")
	public void ToVerifySKUNumberInSearchTab()
	{
		JavascriptExecutor ScrollUpSearch = (JavascriptExecutor)driver;
		ScrollUpSearch.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ssdResult.ValidSearch();
	}
	
	@Test(priority = 23, description = "To Verify SSD Result Displayed Based On Search Tab")
	public void ToVerifySSDResultBasedOnSearch()
	{
		JavascriptExecutor ScrollDownSSDResults = (JavascriptExecutor)driver;
		ScrollDownSSDResults.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		String ActualSKUNUmber = "P04560-B21";
		String ExpectedSKUNumber = ssdResult.SearchedSKUResult.getText();
		if(ActualSKUNUmber.equalsIgnoreCase(ExpectedSKUNumber))
		{
			Assert.assertTrue(true,"Searched SKU Number Is Displayed");
		}
	}
	
	@Test(priority = 24, description = "After Clearing The Search Tab, Previous SSDs Numbers are displayed")
	public void ToVerifySSDResultClearedSearchTab()
	{
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ssdResult.ClearSearchTab();;
	}
	
	@Test(priority = 25, description = "To Verify the Capacity Slider Max and Min Point Value")
	public void ToVerifyCapacitySliderValue()
	{
		//To Check the Max Point Value
		String ActualCapacityMaxPointValue = "12.8";
		String ExpectedCapacityMaxPointValue = ssdResult.SSDResultPageMaxCapSlider.getText();
		Assert.assertEquals(ActualCapacityMaxPointValue,ExpectedCapacityMaxPointValue);
	}
	
	@Test(priority = 26, description = "To Verify Alert Message Is Displayed For Invalid SKU Number Search In Search Tab")
	public void ToVerifyMessageDisplayedForInvalidSKU()
	{
		// For Invalid SKU Number Search
		ssdResult.InValidSKUSearch();
	}
	
	@Test(priority = 27, description = "To Verify Alert Message Is Displayed")
	public void ToVerifyNoSSDMessageDisplayed()
	{
		JavascriptExecutor ScrollDown = (JavascriptExecutor)driver;
		ScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		Assert.assertTrue(ssdResult.NoSSDResultMessageDisplay(),"No SSD Available Message Is Displayed");
	}
	
	@Test(priority = 28, description = "Message Displayed In Red Colour")
	public void ToVerifyMessageDisplayedInRedColour()
	{
		String NoSSDMessageDisplayed = ssdResult.SSDResNoSSDMessageDisplay.getText();
		System.out.println("No SSD Message Displayed" + NoSSDMessageDisplayed);
		//To Get the Color of the Message
		String MessageColor = ssdResult.SSDResNoSSDMessageDisplay.getCssValue("color");
		//Convert the color from String type to hexa form
		String ColorAsHex = Color.fromString(MessageColor).asHex();
		System.out.println("Hexdecimal Format :- " + ColorAsHex);
		if(ColorAsHex.equals("#ff0000"))
		{
			System.out.println("Message Is Displayed In Red Color");
		}
		else
		{
			System.out.println("Message Is Not Displayed In Red Color");
		}
	}
	
	@Test(priority = 29, description = "To Verify SSDs Are Displayed After Clearing The Search Tab")
	public void ToVerifySSDDisplayed()
	{
		JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		ssdResult.ClearSearchTab();
		
		ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
	
		WebDriverWait MixedMainstreamSSDResultsLoad = new WebDriverWait(driver, 1);
		MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));
		
		// boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		boolean ReadResultDisplay = MixedMainstreamSSDResultsLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("MixedMainstreamSSDsResults")));
		if(ReadResultDisplay == true)
		{
			//To Check the SSD Results After clearing the Search Tab
			String ActualSSDAfterClearing = Prop.getProperty("MixedMainstreamSSDsResults");
			String ExpectedSSDAfterClearing = ssdResult.SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActualSSDAfterClearing,ExpectedSSDAfterClearing);
		}
		/* FluentWait wait = new FluentWait(driver);
		wait.withMessage(Prop.getProperty("MixedMainstreamSSDsResults"));
		String ActualSSDAfterClearing = Prop.getProperty("MixedMainstreamSSDsResults");
		String ExpectedSSDAfterClearing = ssdResult.SSDResResultDisplayLink.getText();
		Assert.assertEquals(ActualSSDAfterClearing,ExpectedSSDAfterClearing); */
	}
	
	@Test(priority = 30, description = "To Verify To Check Reset Button")
	public void ToVerifyResetButton()
	{
		// To Verify Alert Message displayed For Confirmation of Reset Option
		JavascriptExecutor ScrollDown = (JavascriptExecutor)driver;
		ScrollDown.executeScript("arguments[0].click()",ssdResult.SSDResSelectAll);
		ssdResult.SSDResultResetMessage();
		
		//To Display all SSDs 
		WebDriverWait MixedMainstreamSSDResultsLoad = new WebDriverWait(driver, 1);
		
		
		MixedMainstreamSSDResultsLoad.until(ExpectedConditions.visibilityOf(ssdResult.SSDResResultDisplayLink));

		//boolean ReadResultDisplay = ssdResult.SSDResResultDisplayLink1;
		boolean ReadResultDisplay = MixedMainstreamSSDResultsLoad.until(ExpectedConditions.textToBePresentInElementValue(ssdResult.SSDResResultDisplayLink, Prop.getProperty("TotalSSDs")));
		if(ReadResultDisplay == true)
		{
			String ActualMixedMaistreamSSDs = Prop.getProperty("TotalSSDs");
			String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
			System.out.println("All SSD Displayed :- " + ExpectedMixedMaistreamSSDs);
			Assert.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);
		
		}
		else
		{
			System.out.println("SSDs are Not Meet to Expectations");
		} 
		
		/*FluentWait wait = new FluentWait(driver);
		wait.withMessage(Prop.getProperty("MixedMainstreamSSDsResults"));
		String ActualMixedMaistreamSSDs = Prop.getProperty("TotalSSDs");
		String ExpectedMixedMaistreamSSDs = ssdResult.SSDResResultDisplayLink.getText();
		System.out.println("All SSD Displayed :- " + ExpectedMixedMaistreamSSDs);
		Assert.assertEquals(ActualMixedMaistreamSSDs, ExpectedMixedMaistreamSSDs);*/
		
	}

	 @Test(priority = 31, description = "To Verify Max Capacity Value After Reset Option Selected")
	 public void ToVerifyMaxCapacityValue()
	 {
		 JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		 ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		 String ActualMaxCapacityValue = Prop.getProperty("ReadMaxCapacityValue");
		 String ExpectedMaxCapacitValue = ssdResult.SSDResultPageMaxCapSlider.getText();
		Assert.assertEquals(ExpectedMaxCapacitValue, ActualMaxCapacityValue);
	 }
	 
	 @Test(priority = 32, description = "To Check Icon are displayed In Show Section")
	 public void ToVerifySpecialFeatureIcons()
	 {
		 JavascriptExecutor	ScrollDown = (JavascriptExecutor)driver;
		 WebDriverWait LoadShowMore = new WebDriverWait(driver, 3);
		 ScrollDown.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResResultDisplayLink);
		 //To Click on ShowmoreLink
		 ssdResult.SSDResultShowmoreLink();
		 //In Show More Display To Verify Special Feature Icons are Displayed, Sanitize Block Erase
		 Assert.assertTrue(ssdResult.SSDShowMoreSBEIcon.isDisplayed(), "Sanitize Block Erase Icon Is Displayed");
					 
		 //Sanitize Crypto Erase Icon
		 Assert.assertTrue(ssdResult.SSDShowMoreSCEIcon.isDisplayed(), "Sanitize Crypto Erase Icon Is Displayed");
					 
		 //Sanitize  Erase Icon 
		 Assert.assertTrue(ssdResult.SSDShowMoreSEIcon.isDisplayed(), "Sanitize  Erase Icon Is Displayed");
					 
		 //Trim Icon
		 Assert.assertTrue(ssdResult.SSDShowMoreTIcon.isDisplayed(), "Trim Icon Is Displayed");
					 
		 //Self Encrypting
		 Assert.assertTrue(ssdResult.SSDShowMoreSEDIcon.isDisplayed(), "Self Encrypting Icon Is Displayed");
					 
		 //Digitally Signed Firmware
		 Assert.assertTrue(ssdResult.SSDShowMoreDSFIcon.isDisplayed(), "Digitally Signed Firmware Icon Is Displayed");
					 
		 //Power Throttling 
		 Assert.assertTrue(ssdResult.SSDShowMorePTIcon.isDisplayed(), "Power Throttling Icon Is Displayed");
					 
		 //Trade Agreements Act
		 Assert.assertTrue(ssdResult.SSDShowMoreTAAIcon.isDisplayed(), "Trade Agreements Act Icon Is Displayed");
					 
		 //Federal Information Processing Standards - FIPS
		 Assert.assertTrue(ssdResult.SSDShowMoreFIPSIcon.isDisplayed(), "Federal Information Processing Standards Icon Is Displayed");
					 
		 //Non Descruptive Update
		 Assert.assertTrue(ssdResult.SSDShowMoreNDUIcon.isDisplayed(), "Non Descruptive Update Icon Is Displayed");
				 
				 /*Actions MouseOver = new Actions(driver);
				 MouseOver.moveToElement(ssdResult.SSDShowMoreSBEIcon).perform();
				 //To Verify Tool Tip text For Sanitize Block Erase
				 String ExpectedSanitizeBlockErase = "The Sanitize Block Erase operation can be used to physically eliminate data and return the SSD to its FOB performance state.";
				 String ActualSantitizeBlockErase = ssdResult.SSDShowMoreSBEIcon.getAttribute("title");
				 System.out.println("Sanitize Block Erase Tool Tip :- " + ActualSantitizeBlockErase);
				 Assert.assertEquals(ActualSantitizeBlockErase, ExpectedSanitizeBlockErase);
				 
				 //
				 String ActualTAA = ssdResult.SSDShowMoreTAAIcon.getAttribute("title");
				 System.out.println("Sanitize Block Erase Tool Tip :- " + ActualTAA); */
	 }
	 
	 @Test(priority = 33, description = " To Verify The Mouse Over Text For Sanitize Block Erase Tool Tip")
	 public void MouseTextForSanitizeBlockEraseToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreSBEIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedSanitizeBlockErase = "The Sanitize Block Erase operation can be used to physically eliminate data and return the SSD to its FOB performance state.";
		 String ActualSantitizeBlockErase = ssdResult.SSDShowMoreSBEIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreSBEIcon));
		 System.out.println("Sanitize Block Erase Tool Tip :- " + ActualSantitizeBlockErase);
		 Assert.assertEquals(ActualSantitizeBlockErase, ExpectedSanitizeBlockErase);
	 }
	
	 @Test(priority = 34, description = " To Verify The Mouse Over Text For Sanitize Crypto Erase Tool Tip")
	 public void MouseTextForSanitizeCryptoEraseToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreSCEIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 //String ExpectedSanitizeCryptoErase = "Sanitize cryptographic Erase changes the internal encryption keys that are used for user data, making the data irretrievable.";
		 String ExpectedSanitizeCryptoErase = Prop.getProperty("SanitizeCryptoErase");
		 String ActualSantitizeCryptoErase = ssdResult.SSDShowMoreSCEIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreSCEIcon));
		 System.out.println("Sanitize Crypto Erase Tool Tip :- " + ActualSantitizeCryptoErase);
		 Assert.assertEquals(ActualSantitizeCryptoErase, ExpectedSanitizeCryptoErase);
	 }
	 
	 @Test(priority = 35, description = " To Verify The Mouse Over Text For Secure Erase Tool Tip")
	 public void MouseTextForSecureEraseToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreSEIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedSecureErase = "Secure Erase is designed to protect data on drives by instantly resetting the drive back to factory settings and changing the encryption key so that any data remaining on the drive is cryptographically. ";
		 String ActualSecureErase = ssdResult.SSDShowMoreSEIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreSEIcon));
		 System.out.println("Secure Erase Tool Tip :- " + ActualSecureErase);
		 Assert.assertEquals(ActualSecureErase, ExpectedSecureErase);
	 }
	 
	 @Test(priority = 36, description = " To Verify The Mouse Over Text For Trim Tool Tip")
	 public void MouseTextForTrimToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreTIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedT = "Advanced Technology Attachment (ATA) command that enables an operating system to inform a NAND flash solid-state drive (SSD) which data blocks it can erase because they are no longer in use.";
		 String ActualT = ssdResult.SSDShowMoreTIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreTIcon));
		 System.out.println("Trim Tool Tip :- " + ActualT);
		 Assert.assertEquals(ActualT, ExpectedT);
	 }
	 
	 @Test(priority = 37, description = " To Verify The Mouse Over Text For Self Encrypting Drive-SED Tool Tip")
	 public void MouseTextForSelfEncrypDriverToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreSEDIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedSelfEncD = "Self-Encrypting Drives protect data-at-rest and reduce IT drive retirement costs, it keep data safe even if drives are lost, stolen, or misplaced.";
		 String ActualSelfEncD = ssdResult.SSDShowMoreSEDIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreSEDIcon));
		 System.out.println("Self Encryting Drive SED- Tool Tip :- " + ActualSelfEncD);
		 Assert.assertEquals(ActualSelfEncD, ExpectedSelfEncD);
	 }
	 
	 @Test(priority = 38, description = " To Verify The Mouse Over Text For Digitally Signed Firmware Tool Tip")
	 public void MouseTextForDigitallySignedToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreDSFIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedDigitallySigned = "Digitally Signed Firmware validate authentic firmware for the drive, Ensures firmware has been unaltered, Prevents malicious modifications to the firmware.";
		 String ActualDigitallySigned = ssdResult.SSDShowMoreDSFIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreDSFIcon));
		 System.out.println("Digitally Signed Firmware Tool Tip :- " + ActualDigitallySigned);
		 Assert.assertEquals(ActualDigitallySigned, ExpectedDigitallySigned);
	 }
	 
	 @Test(priority = 39, description = " To Verify The Mouse Over Text For Power Throttling Tool Tip")
	 public void MouseTextForPowerThrottlingToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMorePTIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedPowerThrottling = "The solid state drive includes a monitoring system to monitor temperature and power. The throttling may include adjusting the rate of concurrent non-volatile memory operations between a minimum value and a maximum value.";
		 String ActualPowerThrottling = ssdResult.SSDShowMorePTIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMorePTIcon));
		 System.out.println("Power Throttling Tool Tip :- " + ActualPowerThrottling);
		 Assert.assertEquals(ActualPowerThrottling, ExpectedPowerThrottling);
	 }
	 
	 @Test(priority = 40, description = " To Verify The Mouse Over Text For Trade Agreement Acts Tool Tip")
	 public void MouseTextForTradeArgementActToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreTAAIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedTradeAgrementAct = "TAA (Trade Agreements Act) fosters fair and open international trade between nations, requiring that products are produced or undergo “substantial transformation” within the United States or designated country.";
		 String ActualTradeAgrementAct = ssdResult.SSDShowMoreTAAIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreTAAIcon));
		 System.out.println("Trade Agreements Act Tool Tip :- " + ActualTradeAgrementAct);
		 Assert.assertEquals(ActualTradeAgrementAct, ExpectedTradeAgrementAct);
	 }
	 
	 @Test(priority = 41, description = " To Verify The Mouse Over Text For Federal Information Processing Std Tool Tip")
	 public void MouseTextForFederalInformationToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreFIPSIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedFederalInformation = "Federal Information Processing Standard (140-2) specifies the security requirements that will be satisfied by a cryptographic module in information technology products.";
		 String ActualFederalInformation = ssdResult.SSDShowMoreFIPSIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreFIPSIcon));
		 System.out.println("Federal Information Processing Std Tool Tip :- " + ActualFederalInformation);
		 Assert.assertEquals(ActualFederalInformation, ExpectedFederalInformation);
	 }
	 
	 @Test(priority = 42, description = " To Verify The Mouse Over Text For Non Disruptive Update Tool Tip")
	 public void MouseTextForNonDisruptiveUpdateToolTip()
	 {
		 WebDriverWait MouseOverwait = new WebDriverWait(driver, 1);
		 Actions MouseOver = new Actions(driver);
		 MouseOver.moveToElement(ssdResult.SSDShowMoreNDUIcon).perform();
		 //To Verify Tool Tip text For Sanitize Block Erase
		 String ExpectedNonDisruptive = "Non Disruptive Update is a software upgrade, hardware expansion, and/or replacement that doesnt impact data availability or performance.";
		 String ActualNonDisruptive = ssdResult.SSDShowMoreNDUIcon.getAttribute("title");
		 MouseOverwait.until(ExpectedConditions.visibilityOf(ssdResult.SSDShowMoreNDUIcon));
		 System.out.println("Non Disruptive Update Tool Tip :- " + ActualNonDisruptive);
		 Assert.assertEquals(ActualNonDisruptive, ExpectedNonDisruptive);
	 }
	 
	 @Test(priority = 43, description = "To Click on Start Over")
	 public void ToVerifyHomePageDisplay()
	 {
		 JavascriptExecutor ScrollUp = (JavascriptExecutor)driver;
		 ScrollUp.executeScript("arguments[0].scrollIntoView();", ssdResult.SSDResRefineResults);
		 //Click on Start Over
		 ssdResult.SSDResultStartOverLink.click();
	 }
	 
	 @Test(priority = 44, description = "Click on Help Me Choose")
	 public void ToVerifyHepMeChoose()
	 {
		 ssdHomepage.ClickAgreeButton();
		 
		 ssdHomepage.ClickOnHelpMeBtn();
		 
		 
		 ssdWorkload = new SSDWorkloadPage();
		 ssdWorkload.WorkloadPageSelectAll();
		 
		 ssdWorkload.SelectReadWorkload.click();
		 
		// Assert.assertFalse(ssdWorkload.SelectAllOption(), "Select All Option is Not Selected");
		 
		 ssdWorkload.ClickNextBtn();
		 
		 ssdSSDType = new SSDSSDTypePage();
		 ssdSSDType.SSDBackBtn();
		 Assert.assertFalse(ssdWorkload.SelectAllOption(), "Select All Option is Not Selected");
		 
		 ssdWorkload.SelectReadWorkload.click();
		 
		 Assert.assertTrue(ssdWorkload.SelectAllOption(), "Select All Option is Not Selected");
		 
		 ssdWorkload.DeselectReadIntensiveWorkload();
		 Assert.assertFalse(ssdWorkload.SelectAllOption(), "Select All Option is Not Selected");
		 
		 ssdWorkload.SelectReadALL();
		 
		 ssdWorkload.ClickNextBtn();
		 
	 }
	 
	 @Test(priority = 45, description = "")
	 public void ToVerifySSDPageOptions()
	 {
		 ssdSSDType.SSDNextBtn();
	 }
	 
	 @Test(priority = 46, description = "")
	 public void ToVerifyServerTypePageOptions()
	 {
		 Select ServerType = new Select(ssdServertype.SSDServerType);
		 ServerType.selectByVisibleText(Prop.getProperty("ServerApollo"));
		WebElement SelectedServerType = ServerType.getFirstSelectedOption();
		String ServerTypePageSelectedServerType = SelectedServerType.getText();
		
		// Click on Capacity Part
		ssdServertype.SelectCapacityMoveMintoMax();
		
		ssdServertype.ClickServerTypeBackBtn();
		
		ssdSSDType.SSDNextBtn();
		
		//
		ssdServertype.ClickServerTypeNextBtn();
	 }
	 
	 @Test(priority = 47, description = "")
	 public void ToVerifyInterfaceOption()
	 {
		 ssdInterface.InterfaceBackBtn();
		 
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		 JavascriptExecutor scrollDown = (JavascriptExecutor)driver;
		 scrollDown.executeScript("arguments[0].scrollIntoView", ssdServertype.SSDBackBtn);
		 
		 scrollDown.executeScript("arguments[0].click()", ssdServertype.SSDBackBtn);
		 //ssdServertype.ClickServerTypeBackBtn();
		 
		 ssdSSDType.SSDReadIntensiveWorkloadSelected.click();
		 
		 ssdSSDType.SSDVeryReadOptimizedWorkloadSelected.click();
		 
		 ssdSSDType.SSDMixedUseWorkloadSelected.click();
		 
		 ssdSSDType.SSDNextBtn();
	 }
	 
	 @Test(priority = 48, description = "")
	 public void ToVerifyServerTypeOptions() 
	 {
		 System.out.println("Capacity Selected Value :- " + ssdServertype.SSDSelectedCapacityValue.getText());
		 String ExpectedWriteIntensiveCapacityValue = "1.6";
		 String ActualWriteIntesiveCapacityValue = ssdServertype.SSDSelectedCapacityValue.getText();
		 Assert.assertEquals(ActualWriteIntesiveCapacityValue, ExpectedWriteIntensiveCapacityValue); 
	 }
	 
	 /*@Test(priority = 49, description = "")
	 public void ToVerifySeverTypeOptions1()
	 {
		 ssdServertype.SelectCapacityMoveMintoMax();
		 
		 ssdServertype.ClickServerTypeNextBtn();
		 
		 ssdInterface.InterfaceBackBtn();
		 
		 ssdServertype.ClickServerTypeBackBtn();
		 
		 ssdSSDType.SSDReadIntensiveWorkloadSelected.click();
		 
		 ssdSSDType.SSDWriteIntensiveWorkloadSelected.click();
		 
		 ssdSSDType.SSDNextBtn();
	 }
	 
	 @Test(priority = 50, description = "")
	 public void ToVerifyServerTypeOptions2() 
	 {
		 System.out.println("Capacity Selected Value :- " + ssdServertype.SSDSelectedCapacityValue.getText());
		 String ExpectedWriteIntensiveCapacityValue = "15.36";
		 String ActualWriteIntesiveCapacityValue = ssdServertype.SSDSelectedCapacityValue.getText();
		 Assert.assertEquals(ActualWriteIntesiveCapacityValue, ExpectedWriteIntensiveCapacityValue); 
	 }
	 @AfterTest(description = "Once All TestCases are Executed, then Close the Opened Browser")
		public void SSDBrowserClose()
		{
			driver.close();
		}  */
	
}
