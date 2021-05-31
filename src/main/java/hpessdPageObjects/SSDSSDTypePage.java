package hpessdPageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hpessdResource.BaseClass;

public class SSDSSDTypePage extends BaseClass
{

	// WebElements for SSD type Page,
	
	//Read Option is Auto Selected
	@FindBy (xpath = "//*[@id=\"id-ssdtype_RI\"]")
	public
	WebElement SSDReadIntensiveWorkloadSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_MU\"]")
	public
	WebElement SSDMixedUseWorkloadSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_WI\"]")
	public
	WebElement SSDWriteIntensiveWorkloadSelected;
	
	@FindBy (xpath = "//*[@id=\"id-ssdtype_VRO\"]")
	public
	WebElement SSDVeryReadOptimizedWorkloadSelected;
	
	// Select All !-- Select All/I Don't Know yet --!
	@FindBy (xpath = "//*[@id=\"ssd-iDontKnow\"]")
	public
	WebElement SSDSelectAllSelected;
	
	
	// Next Button in SSD Type
	
	@FindBy (xpath = "//*[@id=\"nextQuestion_btn\"]")
	public
	WebElement SSDNextBtn;
	
	//Back Button in SSD Type
	
	@FindBy (xpath = "//*[@id=\"backQuestion_btn\"]")
	WebElement SSDbackBtn;
	
	
	// Page Menu Bar
	@FindBy(xpath = "//*[@id=\"ssd-type\"]")
	public 
	WebElement SSDMenubarSSDType;
	
	
	
	
	
	//Initialization
	public  SSDSSDTypePage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void SSDNextBtn()
	{
		SSDNextBtn.click();
	}
	
	public void SSDBackBtn()
	{
		SSDbackBtn.click();
	}
	
	public boolean EditSSDOptions()
	{
		if(SSDReadIntensiveWorkloadSelected.isSelected() & SSDVeryReadOptimizedWorkloadSelected.isSelected() & SSDWriteIntensiveWorkloadSelected.isSelected() & SSDMixedUseWorkloadSelected.isSelected())
		{
				SSDSelectAllSelected.isSelected();
				return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean EditSSDSelectAll()
	{
		if(SSDSelectAllSelected.isSelected())
		{
			JavascriptExecutor SSDWorkload = (JavascriptExecutor)driver;
			//SSDWorkload.executeScript("arguments[0].scrollIntoView()", SSDNextBtn);
			SSDWorkload.executeScript("arguments[0].click()", SSDReadIntensiveWorkloadSelected);
			//SSDReadIntensiveWorkloadSelected.click();
			return SSDSelectAllSelected.isSelected();
		}
		else
		{
			return SSDSelectAllSelected.isSelected();
		}
	}
	
	public boolean ReadOptionSelected()
	{
		return SSDReadIntensiveWorkloadSelected.isSelected();
	}
	
	public boolean MixedUseSelected()
	{
		return SSDMixedUseWorkloadSelected.isSelected();
	}
	
	public boolean WriteOptionSelected()
	{
		return SSDWriteIntensiveWorkloadSelected.isSelected();
	}
	
	public boolean VeryReadOptionSelected()
	{
		return SSDVeryReadOptimizedWorkloadSelected.isSelected();
	}
	
	public boolean MenubarSSDType()
	{
		return SSDMenubarSSDType.isEnabled();
	}
	
	public boolean NextBtn()
	{
		return SSDNextBtn.isEnabled();
	}
	
	public boolean ReadWorkloadSelected()
	{
		System.out.println("SSD Type Page VRO IS not Selected :- " + SSDVeryReadOptimizedWorkloadSelected.isEnabled());
		if(SSDVeryReadOptimizedWorkloadSelected.isEnabled() & SSDMixedUseWorkloadSelected.isEnabled() & SSDWriteIntensiveWorkloadSelected.isEnabled())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
