package hpe.NewSSD;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import hpessdPageObjects.HomePage;
import hpessdPageObjects.SSDBestAvailabilityPage;
import hpessdPageObjects.SSDFormFactorPage;
import hpessdPageObjects.SSDWorkloadPage;
import hpessdPageObjects.SSDSSDTypePage;
import hpessdPageObjects.SSDServerTypePage;
import hpessdPageObjects.SSDInterfacePage;
import hpessdPageObjects.SSDResultPage;
import hpessdResource.BaseClass;

public class SSDServertype extends BaseClass 
{
	private static final TimeUnit TimeUnit = null;
	
	HomePage          ssdHomepage;
	SSDWorkloadPage   ssdWorkload;
	SSDSSDTypePage    ssdSSDType;
	SSDServerTypePage ssdServertype;
	SSDInterfacePage  ssdInterface;
	SSDFormFactorPage ssdFormfactor;
	SSDBestAvailabilityPage ssdBestavailability;
	SSDResultPage     ssdResult;
	
	
	
	public SSDServertype()
	{
		super();
	}
	
	
	
	@Test(priority = 0, description = "To Verify the Server type Page URL")
	public void ToVerifyServerTypePageURL()
	{
		ssdWorkload = new SSDWorkloadPage();
		ssdServertype = new SSDServerTypePage();
		ssdSSDType = new SSDSSDTypePage();
		String ActualServerTypeURL = Prop.getProperty("ServerTypePage");
		String ExpectedServerTypeULR = driver.getCurrentUrl();
		Assert.assertEquals(ActualServerTypeURL,ExpectedServerTypeULR);
	}
	@Test(priority = 1, description = "To Verify Server type Label in Server Type Tab")
	public void ToVerifyServerTypeLabel()
	{
		ssdServertype = new SSDServerTypePage();
		Assert.assertTrue(ssdServertype.ServerTypeLabel(),"Please Select Type Label is displayed");
	}
	
	@Test(priority = 2, description = "To Verify Server Model Label in Server Model Tab")
	public void ToVerifyServerModelLabel()
	{
		Assert.assertTrue(ssdServertype.ServerModelLabel(), "Please Select Server Model Label is displayed");
	}
	
	@Test(priority = 3, description = "To Verify Capacity Label in Capacity Tab ")
	public void ToVerifyCapacityLabel()
	{
		Assert.assertTrue(ssdServertype.CapacityLabel(),"Select Capacity is displayed");
	}
	
	@Test(priority = 4, description = "To Verify the Menu Bar page highlighten details")
	public void ToVerifyServerTypeMenubar()
	{
		ssdServertype = new SSDServerTypePage();
		Assert.assertTrue(ssdServertype.MenuBarServerType(), "Server Type is Highlighten in Server Page");
	}
	
	@Test(priority = 5, description = "To Verify Menu bar from begining")
	public void ToVerifyMenuBar()
	{
		Assert.assertTrue(ssdWorkload.MenubarWorkload(), "In Menubar Workload is enabled");
		Assert.assertTrue(ssdSSDType.MenubarSSDType(), "In Menubar SSD Type is enabled");
	}
	
	/*@Test(priority = 6, description = "To Compare and Verify the Server Types and Server Model List")
	public void ToVerifyServerTypeServerModel() throws InterruptedException
	{
		if(ssdServertype.CompareServerTypeServerModel()  == true)
		{
			Assert.assertTrue(true, "Server Type and Server Model List Is Mapping");
		}
		else
		{
			Assert.assertFalse(false, "Server Type and Server Model List is not Mapping");
		}
	}*/
	
	@Test(priority = 7, description = "To Select the Server type in the list ")
	public void ToSelectServerType()
	{
		ssdServertype.SelectServerType();
	}
	
	@Test(priority = 8, description = "To Select the Server Model from the List")
	public void ToSelectServerModel()
	{
		ssdServertype.SelectServerModel();
	}
	
	//@SuppressWarnings("static-access")
	@Test(priority = 9, description  = "Verify the Alert Appering for invalid Capacity Selected")
	public void ToSelectCapacity() throws InterruptedException
	{
		ssdServertype.SelectCapacityMoveMaxtoMin();
		Thread.sleep(1000);
		ssdServertype.ServerNextClickBtn();           // In Server type Page, Next Button is Clicked
		Assert.assertTrue(ssdServertype.VerifyAlertMessageDisplayed(), "There are no interface types based on your selection(s). Change your capacity or ssd type\\r\\n\" + \r\n" + 
			"				\"OK\"");
		ssdServertype.ClickAlertOk();
	}
	
	@Test(priority = 10,description = "To Retaine the Capacity Value")
	public void ToRetainCapacityValue()
	{
		ssdServertype.SelectCapacityMoveMintoMax();
		
		//Next Button
		System.out.println("----------------!Server Type Test Cases are Executed Successfully!---------------------");
		ssdServertype.ClickServerTypeNextBtn();
		
	}
	
	/*@Test(priority = 11, description = "To Verify Selected Value will be retained click on Back Btn in the Server type Page")
	public void ToVerifySelectedCapacityValue() throws InterruptedException
	{
		ssdServertype.ClickServerTypeBackBtn();
		Thread.sleep(1000);
		Assert.assertFalse(ssdSSDType.EditSSDSelectAll(),"SelectAll/I Know Don't Know Yet Option is deselected in SSD Type");
		ssdSSDType.SSDNextBtn.click();
		Thread.sleep(1000);
		ssdServertype.SelectedServerTypePageValues();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		ssdServertype.SelectCapacityMoveMintoMax();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		ssdServertype.ClickServerTypeNextBtn();
		
		//ssdServertype.SelectedCapacityValue();
	}
	
	/*@Test(priority = 9, description = "To Verify Capacity Value in Server type page")
	public void ToVerifyChangeCapacityValue()
	{
		ssdServertype.ChangeCapacityValue();
	} 
	
	@Test(priority = 10, description = "To Verfiy Alert Message is displayed in Server type page")
	public void ToVerifyAlertMessage()
	{
		ssdServertype.ClickServerTypeNextBtn();
		String ActualAlertMessage = "There are no interface types based on your selection(s). Change your capacity or ssd type\r\n" + 
				"OK";
		String ExpectedAlertMessage = ssdServertype.SSDAlertMessage.getText();
		//Assert.assertEquals(ActualAlertMessage, ExpectedAlertMessage);
		//Assert.assertEquals(ssdServertype.SSDAlertMessage.getText(),"There are no interface types based on your selection(s). Change your capacity or ssd type");
		ssdServertype.SSDAlertOk.click();
	} */
	
	/*@Test(priority = 11, description = "To Verify the Menu Bar page highlighten details")
	public void ToVerifyServerTypeMenubar()
	{
		ssdServertype = new SSDServerTypePage();
		Assert.assertTrue(ssdServertype.MenuBarServerType(), "Server Type is Highlighten in Server Page");
	}
	
	@Test(priority = 12, description = "To Verify Menu bar from begining")
	public void ToVerifyMenuBar()
	{
		Assert.assertTrue(ssdWorkload.MenubarWorkload(), "In Menubar Workload is enabled");
		Assert.assertTrue(ssdSSDType.MenubarSSDType(), "In Menubar SSD Type is enabled");
	} */
	/*@Test(priority = 13, description = "To Verify Server Type , Server Model and Capacity Values")
	public void ToVerifySelectionServerTypeModel()
	{
		//JavascriptExecutor ServerScrollDown = (JavascriptExecutor)driver;
		ssdServertype = new SSDServerTypePage();
		ssdInterface = new SSDInterfacePage();
		
		ssdServertype.SelectedServerType();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		ssdServertype.SelectedServerModel();
		//ServerScrollDown.executeScript("arguments[0].scrollIntoView();", ssdServertype.SSDServerSelectAll);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		ssdServertype.CapacitySlideMaxtoMin();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		ssdServertype.SelectedMinCapacityValue();
		System.out.println(ssdServertype.SelectedMinCapacityValue());
		
		ssdServertype.SelectedMaxCapacityValue();
		System.out.println(ssdServertype.SelectedMaxCapacityValue());
		
		//ssdServertype.CapacitySliderMintoMax();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		ssdServertype.ServerNextClickBtn();
	} */
	/*@Test(priority = 11, description = "To Verify the Drop down Values")
	public void ToVerifyServerTypeServerModelCapacityDropDown() throws InterruptedException
	{
		ssdServertype  = new SSDServerTypePage();
		ssdInterface = new SSDInterfacePage();
		ssdServertype.CheckingServerTypeServerModelCapacity();
		Assert.assertTrue(ssdInterface.NextBtn());
	}*/
	
/*	@Test(priority = 14, description = "To Verify Menubar in Interface type Page")
	public void ToVerifyMenubarInterfaceType()
	{
		ssdInterface = new SSDInterfacePage();
		Assert.assertTrue(ssdInterface.MenubarInterfaceType(),"Interface Type is enabled in Menu Bar");
	}
	
	/*@Test(priority = 15, description = "To Verify Elements are selected in the Server Type, Server Model and Capacity")
	public void ToVerifyElementsSelected()
	{
		Assert.assertTrue(ssdServertype.SeverTypePageElementsSelected(),"In Server Type Page all elements are enabled");
	} */
	
 /*	@Test(priority = 16, description = "To Verify Server Type,Server Model and Capacity Results in Interface Page")
	public void ToVerifyInterfaceOptions()
	{
		ssdInterface.EnInterfaceNxtBtn();
	} 
	
	@Test(priority = 17, description = "To Verify FormFactor Type is enabled in Menu Bar")
	public void ToVerifyMenuBarFormFactor()
	{
		ssdFormfactor =  new SSDFormFactorPage();
		Assert.assertTrue(ssdFormfactor.MenubarFormFactor(), "Form Factor Type is enabled in Menu Bar");
	}
	
	@Test(priority = 18, description = "To Verify Form Factor ")
	public void ToVerifyFormFactorNextBtn()
	{
		//ssdFormfactor = new SSDFormFactorPage();
		Assert.assertTrue(ssdFormfactor.FormFactorSelectAll());
		ssdFormfactor.FormFactorNextBtn();
	}
	
	@Test(priority = 19, description = "To Verify Best Avaiability Type is enabled in Menu Bar")
	public void ToVerifyMenuBarBestAvailability()
	{
		ssdBestavailability = new SSDBestAvailabilityPage();
		Assert.assertTrue(ssdBestavailability.MenubarBestAvailability(), "Best Availability Type is enabled in Menu Bar");
	}
	@Test(priority = 20, description = "To Verify Best Availability Page")
	public void ToVerifyBestAvailabilitySelectedOptions()
	{
		//ssdBestavailability = new SSDBestAvailabilityPage();
		Assert.assertFalse(ssdBestavailability.BestAvailNonMainstream(), "NonMainstream Option is not Selected");
	}
	
	@Test(priority = 21, description = "To Verify Best Availability Select All Option")
	public void ToVerifyBestAvailabilitySelectAll()
	{
		Assert.assertFalse(ssdBestavailability.BestAvailSelectAll()," Select All Option is not Selected");
	}
	
	@Test(priority = 22, description = "To Verify Best Availability Mainstream Option")
	public void ToVerifyBestAvailabilityMainstream()
	{
		Assert.assertTrue(ssdBestavailability.BestAvailMainstream(), "Mainstream Option is selected");
		ssdBestavailability.BestAvailNextBtn();
	}
	
	@Test(priority = 23, description = " To Verify Result page is displayed")
	public void ToVerifyResultPageIsDisplayed()
	{
		ssdResult = new SSDResultPage();
		String ActualResultURL = Prop.getProperty("ResultPage");
		String ExpectedResultURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualResultURL, ExpectedResultURL);
	} 
	 
	/*@Test(priority = 24, description = "To Verify Min Capacity Slider value in Result Page")
	public void ToVerifyResultMinCapacitySlider()
	{
		 ssdResult.SSDCapacityMinSliderText();
	}
	
	@Test(priority = 25, description = "To Verify Max Capacity Slider Value in Result Page")
	public void ToVerifyResultMaxCapacitySlider()
	{
		ssdResult.SSDCapacityMaxSliderText();
	}
	
	@Test(priority = 26, description = "To Verify the Selected Server Type")
	public void ToVerifySelectedServerTypeDisplay()
	{
		ssdResult.SSDServerType();
	}
	
	@Test(priority = 27, description = "To Verify the Selected Server Model")
	public void ToVerifySelectedServerModelDisplay()
	{
		ssdResult.SSDServerModel();
	}  */
	
	/*@Test(priority = 28, description = "To Verify the Selected Capacity Value is displayed in Result Page")
	public void ToVerifySelectedMinCapacityValue()
	{
		//String ActualMinCapacityValue = ssdServertype.SSDMinTextValue.getText();
		String ServerPageMinCapacity = ssdServertype.SelectedMinCapacityValue();
		String ExceptedMinCapacityValue = ssdResult.SSDResultPageMinCapSlider.getText();
		System.out.println(ServerPageMinCapacity+ ":::");
		Assert.assertEquals(ServerPageMinCapacity, ExceptedMinCapacityValue);
	}*/
}
