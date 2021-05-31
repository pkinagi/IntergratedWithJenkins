package hpessdPageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hpessdResource.BaseClass;

public class SSDInterfacePage extends BaseClass
{
	// Interface Page WebElements
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_SAS\"]")
	WebElement SSDInterfaceSAS;
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_VALUESAS\"]")
	WebElement SSDInterfaceValueSAS;
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_SATA\"]")
	WebElement SSDInterfaceSATA;
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_SATAVRO\"]")
	WebElement SSDInterfaceVROSATA;
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_NVMeMainstream\"]")
	WebElement SSDInterfaceNVMeMainstream;
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_NVMeHighPerformance\"]")
	WebElement SSDInterfaceNVMeHighPerformance;
	
	@FindBy(xpath = "//*[@id=\"ssd-iDontKnow\"]")
	public
	WebElement SSDInterfaceSelectAll;
	
	@FindBy(xpath = "//*[@id=\"backQuestion_btn\"]")
	public
	WebElement SSDInterfaceBackBtn;
	
	@FindBy(xpath = "//*[@id=\"nextQuestion_btn\"]")
	WebElement SSDInterfaceNextBtn;
	
	
	// Page Menu Bar
	@FindBy(xpath = "//*[@id=\"interface-type\"]")
	public 
	WebElement SSDMenubarInterfacepageType;
	
	
	
	//Interface Types
	@FindBy(xpath = "//*[@id=\"div_sata\"]")
	public
	WebElement SSDInterfaceTypeSATA;
	
	@FindBy(xpath = "//*[@id=\"div_sas\"]")
	public
	WebElement SSDInterfaceTypeSAS;
	
	@FindBy(xpath = "//*[@id=\"div_nvme\"]")
	public
	WebElement SSDInterfaceTypeNVMe;
	
	
	public SSDInterfacePage()
	{
		PageFactory.initElements(driver, this);
	}

	public void InterfaceBackBtn()
	{
		SSDInterfaceBackBtn.click();
	}
	
	public void InterfaceNextBtn()
	{
		SSDInterfaceNextBtn.click();
	}
	
	public boolean NextBtn()
	{
		return SSDInterfaceNextBtn.isEnabled();
	}
	public boolean InterfaceSASSelected()
	{
		return SSDInterfaceSAS.isSelected();
	}
	
	public boolean InterfaceValueSASSelected()
	{
		return SSDInterfaceValueSAS.isSelected();
	}
	
	public boolean InterfaceSATASelected()
	{
		return SSDInterfaceSATA.isSelected();
	}
	
	public boolean InterfaceSATAVROSelected()
	{
		return SSDInterfaceVROSATA.isSelected();
	}
	
	public boolean InterfaceNVMeMainstream()
	{
		return SSDInterfaceNVMeMainstream.isSelected();
	}
	
	public boolean InterfaceNVMeHighPerformance()
	{
		return SSDInterfaceNVMeHighPerformance.isSelected();
	}
	
	public void EnInterfaceNxtBtn()
	{
		if(SSDInterfaceSAS.isSelected() || SSDInterfaceValueSAS.isSelected() || SSDInterfaceSATA.isSelected() 
				|| SSDInterfaceVROSATA.isSelected() || SSDInterfaceNVMeMainstream.isSelected() 
				||SSDInterfaceNVMeHighPerformance.isSelected())
		{
				InterfaceNextBtn();
		}
	}
	
	public boolean MenubarInterfaceType()
	{
		return SSDMenubarInterfacepageType.isEnabled();
	}
	
	public boolean InterfacetypeSATA()
	{
		return SSDInterfaceTypeSATA.isEnabled();
	}
	
	public boolean InterterfaceSAS()
	{
		return SSDInterfaceTypeSAS.isEnabled();
	}
	
	public boolean InterfaceNVMe()
	{
		return SSDInterfaceTypeNVMe.isEnabled();
	}
	
	public boolean InterfaceSelectAll()
	{
		if(SSDInterfaceSATA.isSelected() & SSDInterfaceVROSATA.isSelected() & SSDInterfaceSAS.isSelected() & SSDInterfaceValueSAS.isSelected() & SSDInterfaceNVMeMainstream.isSelected() & SSDInterfaceNVMeHighPerformance.isSelected())
		{
			return SSDInterfaceSelectAll.isSelected();
		}
		else
		{
			return false;
		}
	}
	
	public boolean EditInterfaceSelectAll()
	{
		if(SSDInterfaceSelectAll.isSelected())
		{
			JavascriptExecutor InterfaceClick = (JavascriptExecutor)driver;
			InterfaceClick.executeScript("arguments[0].click()", SSDInterfaceSAS);
			return SSDInterfaceSelectAll.isSelected();
		}
		else
		{
			return false;
		}
	}
	
	public boolean ReadSelectInterfaceOptions()
	{
		if(SSDInterfaceSATA.isSelected() || SSDInterfaceSAS.isSelected() || SSDInterfaceValueSAS.isSelected() || SSDInterfaceNVMeMainstream.isSelected() || SSDInterfaceNVMeHighPerformance.isSelected())
		{
			return SSDInterfaceSelectAll.isSelected();
		}
		else
		{
			return false;
		}
	}
	
	public void InterfaceOptionRetainAsItIs()
	{
		JavascriptExecutor InterfaceClick = (JavascriptExecutor)driver;
		InterfaceClick.executeScript("arguments[0].click()", SSDInterfaceSelectAll);
	}
	
	public boolean WriteInterfaceOptions()
	{
		if(SSDInterfaceSAS.isSelected() || SSDInterfaceNVMeHighPerformance.isSelected())
		{
			return SSDInterfaceSelectAll.isSelected();
		}
		else
		{
			return false;
		}
	}
	
	public boolean VeryReadOptimizedInterfaceOption()
	{
		return SSDInterfaceVROSATA.isSelected();
	}
	
	public boolean EditVROInterfaceOption()
	{
		JavascriptExecutor VROInterface = (JavascriptExecutor)driver;
		VROInterface.executeScript("arguments[0].click()", SSDInterfaceVROSATA);
		return SSDInterfaceNextBtn.isEnabled();
	}
	
	public void RetainVROInterfaceOption()
	{
		JavascriptExecutor SATAVROInterface = (JavascriptExecutor)driver;
		SATAVROInterface.executeScript("arguments[0].click()", SSDInterfaceVROSATA);
	}
	
	// To Verify Options gets Disable
	public boolean InterfacePageOptionsDisables()
	{
		JavascriptExecutor ClickSelectAll = (JavascriptExecutor)driver;
		ClickSelectAll.executeScript("arguments[0].click()", SSDInterfaceSelectAll);
		if(SSDInterfaceSATA.isSelected() || SSDInterfaceVROSATA.isSelected() 
				|| SSDInterfaceSAS.isSelected() || SSDInterfaceValueSAS.isSelected()
				   || SSDInterfaceNVMeMainstream.isSelected() || SSDInterfaceNVMeHighPerformance.isSelected()
				            ||SSDInterfaceSelectAll.isSelected() || SSDInterfaceNextBtn.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Enable Select All Option In Interface Page
	public void EnableInterfaceSelectAll()
	{
		JavascriptExecutor ClickSelectAll = (JavascriptExecutor)driver;
		ClickSelectAll.executeScript("arguments[0].click()", SSDInterfaceSelectAll);
	}
	
}
