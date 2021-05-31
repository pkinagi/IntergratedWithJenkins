package hpessdPageObjects;



import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hpessdResource.BaseClass;

public class SSDFormFactorPage extends BaseClass
{
	// Form Factor WebElements
	
	//@FindBy(xpath = "//input[@id='id-ssdInterface_SFF']")
	//@FindBy(css = "#id-ssdInterface_SFF")
	@FindBy(xpath = "//*[@id=\"check-box-label\"][text()='2.5\" SFF']")
	public
	WebElement SSDFormFactorSFF;
	//*[@id="id-ssdInterface_SFF"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterface_LFF\"]")
	public
	WebElement SSDFormFactorLFF;
	//*[@id="id-ssdInterface_LFF"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterface_mez\"]")
	public
	WebElement SSDFormFactorM2;
	//*[@id="id-ssdInterface_mez"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterface_AIC\"]")
	public
	WebElement SSDFormFactorAIC;
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterface_mezE\"]")
	public
	WebElement SSDFormFactorM2Kit;
	
	@FindBy(xpath = "//*[@id=\"ssd-iDontKnow\"]")
	public
	WebElement SSDFormFactorSelectAll;
	//*[@id="ssd-iDontKnow"]
	
	@FindBy(xpath = "//*[@id=\"backQuestion_btn\"]")
	WebElement SSDFormFactorBackBtn;
	//*[@id="backQuestion_btn"]
	
	@FindBy(xpath = "//*[@id=\"nextQuestion_btn\"]")
	public 
	WebElement SSDFormFactorNextBtn;
	//*[@id="nextQuestion_btn"]
	
	// Page Menu Bar
	@FindBy(xpath = "//*[@id=\"form-factor\"]")
	public
	WebElement SSDMenubarFormFactorpageType;
	
	// Form Factor Images
	@FindBy(xpath = "//*[@id=\"SFF\"]/img")
	public
	WebElement SSDFormFactorSFFImage;
	
	@FindBy(xpath = "//*[@id=\"LFF\"]/img")
	public
	WebElement SSDFormFactorLFFImage;
	
	@FindBy(xpath = "//*[@id=\"AIC\"]/img")
	public
	WebElement SSDFormFactorAICImage;
	
	@FindBy(xpath = "//*[@id=\"M.2\"]/img")
	public
	WebElement SSDFormFactorM2Image;
	
	@FindBy(xpath = "//*[@id=\"M.2e\"]/img")
	public
	WebElement SSDFormFactorM2eImage;

	
	public SSDFormFactorPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void FormFactorBackBtn()
	{
		SSDFormFactorBackBtn.click();
	}
	
	public void FormFactorNextBtn()
	{
		SSDFormFactorNextBtn.click();
	}
	
	public boolean FormFactorSFF()
	{
		return SSDFormFactorSFF.isSelected();
	}
	
	public boolean FormFactorLFF()
	{
		return SSDFormFactorLFF.isSelected();
	}
	
	public boolean FormFactorM2()
	{
		return SSDFormFactorM2.isSelected();
	}
	
	public boolean FormFactorSelectAll()
	{
		if(SSDFormFactorSFF.isSelected() & SSDFormFactorLFF.isSelected() & SSDFormFactorM2.isSelected() & SSDFormFactorAIC.isSelected() & SSDFormFactorM2Kit.isSelected())
		{
			SSDFormFactorSelectAll.isSelected();
		}
		return true;
	}
	
	public boolean MenubarFormFactor()
	{
		return SSDMenubarFormFactorpageType.isEnabled();
	}
	
	public boolean FormFactorImageSFF()
	{
		return SSDFormFactorSFFImage.isDisplayed();
	}
	
	public boolean FormFactorImageLFF()
	{
		return SSDFormFactorLFFImage.isDisplayed();
	}
	
	public boolean FormFactorImageAIC()
	{
		return SSDFormFactorAICImage.isDisplayed();
	}
	
	public boolean FormFactorImageM2()
	{
		return SSDFormFactorM2Image.isDisplayed();
	}
	
	public boolean FormFactorImageM2e()
	{
		return SSDFormFactorM2eImage.isDisplayed();
	}
	
	public boolean FormFactorCheckBoxes()
	{
		if(SSDFormFactorSFF.isSelected() & SSDFormFactorLFF.isSelected() & SSDFormFactorAIC.isSelected()
				 & SSDFormFactorM2Kit.isSelected() & SSDFormFactorSelectAll.isSelected() & SSDFormFactorNextBtn.isEnabled())
		{
			return true;
		}
		else
		{
			return SSDFormFactorSelectAll.isSelected();
		}
	}
	
	public boolean FormFactorAllOptionsDisabled()
	{
		JavascriptExecutor ClickFormFactor = (JavascriptExecutor)driver;
		ClickFormFactor.executeScript("arguments[0].click()", SSDFormFactorSelectAll);
		if(SSDFormFactorSFF.isSelected() || SSDFormFactorLFF.isSelected() || SSDFormFactorAIC.isSelected()
				 || SSDFormFactorM2Kit.isSelected() 
				  || SSDFormFactorSelectAll.isSelected() || SSDFormFactorNextBtn.isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void EditFormFactorTypes()
	{
		//if(SSDFormFactorSFF.isSelected() & SSDFormFactorLFF.isSelected() & SSDFormFactorAIC.isSelected() & SSDFormFactorM2Kit.isSelected())
		if(SSDFormFactorSelectAll.isSelected())
		{
			JavascriptExecutor SSDFormFactor = (JavascriptExecutor)driver;
			//SSDFormFactor.executeScript("arguments[0].click()", SSDFormFactorM2);
			// To Uncheck the Form Factor Options M2 and LFF
			SSDFormFactor.executeScript("arguments[0].click()",SSDFormFactorLFF);
		}
	}
	
	public boolean AllImagesDisplayed()
	{
		if(SSDFormFactorSelectAll.isSelected())
		{
			if(SSDFormFactorSFFImage.isDisplayed() & SSDFormFactorLFFImage.isDisplayed() 
					& SSDFormFactorAICImage.isDisplayed()  
					& SSDFormFactorM2eImage.isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	// Read Intensive Workload Selected
	public boolean ReadSelectFormFactorType()
	{
		if(SSDFormFactorSFF.isSelected() || SSDFormFactorLFF.isSelected() || SSDFormFactorM2.isSelected())
		{
			return SSDFormFactorSelectAll.isSelected();
		}
		else
		{
			return false;
		}
	}
	
	public boolean ReadEditFormFactorOption()
	{
		if(SSDFormFactorSelectAll.isSelected())
		{
			JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
			FormFactor.executeScript("arguments[0].click();", SSDFormFactorLFF);
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean ReadFormFactorAsItIs()
	{
		JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
		FormFactor.executeScript("arguments[0].click();", SSDFormFactorSelectAll);
		return SSDFormFactorSelectAll.isSelected();
	}

	// Mixed Use Workload Selected
	public boolean MixedUseSelectFormFactorType()
	{
		if(SSDFormFactorSFF.isSelected() & SSDFormFactorLFF.isSelected() & SSDFormFactorAIC.isSelected() & SSDFormFactorM2Kit.isSelected())
		{
			return SSDFormFactorSelectAll.isSelected();
		}
		else
		{
			return SSDFormFactorSelectAll.isSelected();
		}
	}
	
	public boolean MixedUseEditFormFactorOption()
	{
		if(SSDFormFactorSelectAll.isSelected())
		{
			JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
			FormFactor.executeScript("arguments[0].click();", SSDFormFactorLFF);
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean MixedUseFormFactorAsItIs()
	{
		JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
		FormFactor.executeScript("arguments[0].click();", SSDFormFactorSelectAll);
		return SSDFormFactorSelectAll.isSelected();
	}

// Write Intensive Workload Selected
	public boolean WriteIntensiveSelectFormFactorType()
	{
		if(SSDFormFactorSFF.isSelected() & SSDFormFactorAIC.isSelected())
		{
			return SSDFormFactorSelectAll.isSelected();
		}
		else
		{
			return false;
		}
	}
		
	public boolean WriteIntensiveEditFormFactorOption()
	{
		if(SSDFormFactorSelectAll.isSelected())
		{
			JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
			FormFactor.executeScript("arguments[0].click();", SSDFormFactorSFF);
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean WriteIntensiveFormFactorAsItIs()
		{
			JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
			FormFactor.executeScript("arguments[0].click();", SSDFormFactorSelectAll);
			return SSDFormFactorSelectAll.isSelected();
		}

// Very Read Optimized Form Factor Options are Selected
	public boolean VeryReadOptimizedSelectFormFactorType()
	{
		if(SSDFormFactorSFF.isSelected() & SSDFormFactorLFF.isSelected())
		{
			return SSDFormFactorSelectAll.isSelected();
		}
		else
		{
			return false;
		}
	}
		
	public boolean VeryReadOptimizedEditFormFactorOption()
	{
		if(SSDFormFactorSelectAll.isSelected())
		{
			JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
			FormFactor.executeScript("arguments[0].click();", SSDFormFactorSFF);
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean VeryReadOptimizedFormFactorAsItIs()
		{
			JavascriptExecutor FormFactor = (JavascriptExecutor)driver;
			FormFactor.executeScript("arguments[0].click();", SSDFormFactorSelectAll);
			return SSDFormFactorSelectAll.isSelected();
		}

	
}
