package hpessdPageObjects;

import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hpessdResource.BaseClass;

public class SSDBestAvailabilityPage extends BaseClass
{
	// Best Availability Web elements
	
	@FindBy(xpath = "//*[@id=\"ssdCategory_Main\"]")
	public
	WebElement SSDBestAvailMainstream;
	//*[@id="ssdCategory_Main"]
	
	@FindBy(xpath = "//*[@id=\"ssdCategory_Nonmain\"]")
	public
	WebElement SSDBestAvailNonMainstream;
	//*[@id="ssdCategory_Nonmain"]
	
	@FindBy(xpath = "//*[@id=\"ssd-iDontKnow\"]")
	public
	WebElement SSDBestAvailSelectAll;
	//*[@id="ssd-iDontKnow"]
	
	@FindBy(xpath = "//*[@id=\"backQuestion_btn\"]")
	public
	WebElement SSDBestAvailBackBtn;
	//*[@id="backQuestion_btn"]
	
	@FindBy(xpath = "//*[@id=\"nextQuestion_btn\"]")
	public
	WebElement SSDBestAvailNextBtn;
	//*[@id="nextQuestion_btn"]
	
	// Page Menu Bar
	@FindBy(xpath = "//*[@id=\"category\"]")
	public 
	WebElement SSDMenubarBestAvailability;
	
	
	
	public SSDBestAvailabilityPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void BestAvailBackBtn()
	{
		SSDBestAvailBackBtn.click();
	}
	
	public void BestAvailNextBtn()
	{
		SSDBestAvailNextBtn.click();
	}
	
	public boolean BestAvailMainstream()
	{
		return SSDBestAvailMainstream.isSelected();
	}
	
	public boolean BestAvailNonMainstream()
	{
		return SSDBestAvailNonMainstream.isSelected();
	}
	
	public boolean BestAvailSelectAll()
	{
		return SSDBestAvailSelectAll.isSelected();
	}
	
	public boolean MenubarBestAvailability()
	{
		return SSDMenubarBestAvailability.isEnabled();
	}
	
	public boolean ClickOnNonMainstream()
	{
		JavascriptExecutor SSDNonMainstream = (JavascriptExecutor)driver;
		SSDNonMainstream.executeScript("arguments[0].click()", SSDBestAvailNonMainstream);
		//SSDBestAvailNonMainstream.click();
		if(SSDBestAvailSelectAll.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean BestAvailabilityNextBtn()
	{
		return SSDBestAvailNextBtn.isEnabled();
	}
	
	public boolean EditMainStreamOption()
	{
		JavascriptExecutor SSDMainstream = (JavascriptExecutor)driver;
		SSDMainstream.executeScript("arguments[0].click();", SSDBestAvailMainstream);
		return SSDBestAvailNextBtn.isEnabled();
	}
	
	public boolean ReadEditMainstream()
	{
		JavascriptExecutor SSDMainstream = (JavascriptExecutor)driver;
		SSDMainstream.executeScript("arguments[0].click();", SSDBestAvailMainstream);
		SSDMainstream.executeScript("arguments[0].click();", SSDBestAvailNonMainstream);
		return SSDBestAvailSelectAll.isSelected();
	}
	
	public void EditNonMainstream()
	{
		JavascriptExecutor SSDNonMainstream = (JavascriptExecutor)driver;
		SSDNonMainstream.executeScript("arguments[0].click();", SSDBestAvailNonMainstream);
	}
	
	// Best Availability Options Are Not Selected
	public boolean BestAvailabilityOptionDisabled()
	{
		JavascriptExecutor ClickSelectAll = (JavascriptExecutor)driver;
		ClickSelectAll.executeScript("arguments[0].click()", SSDBestAvailSelectAll);
		//To Verify All Options are in Disable State
		if(SSDBestAvailMainstream.isSelected() & SSDBestAvailNonMainstream.isSelected() & SSDBestAvailSelectAll.isSelected() & SSDBestAvailNextBtn.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
