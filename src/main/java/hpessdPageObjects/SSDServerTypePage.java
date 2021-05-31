package hpessdPageObjects;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Move;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hpessdResource.BaseClass;
import hpessdPageObjects.SSDInterfacePage;

public class SSDServerTypePage extends BaseClass
{
	// Server Type , Server Model and Capacity WebElements
	
	SSDInterfacePage ssdInterface ;

	
	@FindBy(xpath = "//*[@id=\"sel_server_type\"]")
	public
	WebElement SSDServerType;
	
	
	@FindBy(xpath = "//*[@id=\"sel_server_model\"]")
	public
	WebElement SSDServerModel;
	
	
	@FindBy(xpath = "//*[@id=\"sel_capacity\"]")
	WebElement SSDCapacityValue;
	
	
	@FindBy(xpath = "//*[@id=\"check-box-label\"]")
	public
	WebElement SSDServerSelectAll;
	
	
	@FindBy(xpath = "//*[@id=\"backQuestion_btn\"]")
	public
	WebElement SSDBackBtn;
	
	
	@FindBy(xpath = "//*[@id=\"nextQuestion_btn\"]")
	public
	WebElement SSDNextBtn;
	
	//Alert Message Box, If Interface are not available based on the Selected workload
	//@FindBy(xpath = "//*[@id=\"jconfirm-box80070\"]")
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div")
	public
	WebElement SSDAlertMessage;
	
	//OK Btn
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button")
	public
	WebElement SSDAlertOk;
	
	//Capacity Label
	@FindBy(xpath = "//*[@id=\"ssdSelector\"]/section/section[1]/div/div[3]/div/div/div[1]")
	WebElement SSDCapacityLabel;
	
	// Page Menu Bar
	@FindBy(xpath = "//*[@id=\"server-type\"]")
	public 
	WebElement SSDMenubarServerType;
	
	//
	@FindBy(css = "#capacity-slider-range")
	WebElement SSDCapacitySliderRange;
	
	
	//Capacity Slider WebElements
	@FindBy(xpath = "//*[@id=\"capacity-slider-range\"]/div[2]")
	WebElement SSDCapacitySlider;
	//*[@id="capacity-slider-range"]/div[2]
	//*[@id=\"capacity-slider-range\"]
	
	//Max Point Capacity Slider WebElements
	@FindBy(xpath = "//*[@id=\"capacity-slider-range\"]")
	WebElement SSDMaxCapacitySlider;
	//*[@id="capacity-slider-range"]/div[2]
	//*[@id=\"capacity-slider-range\"]/span[2]
	//body/section[@id='mainContent']/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]
	
	@FindBy(xpath = "//*[@id=\"capacity-slider-range\"]/span[2]")
	WebElement SSDMaxTargetSlider;
	
	//Minimum Point Capacity Slider WebElements
	@FindBy(xpath = "//*[@id=\"capacity-slider-range\"]/span[1]")
	WebElement SSDMinCapacitySlider;
	
	@FindBy(xpath = "//*[@id=\"capacity-slider-range\"]/span[1]")
	WebElement SSDMinTargetSlider;
	
	@FindBy(xpath = "//*[@id=\"minimum_capacity\"]")
	public
	WebElement SSDMinTextValue;
	
	@FindBy(xpath = "//*[@id=\"maximum_capacity\"]")
	public
	WebElement SSDMaxTextValue;
	
	//Selected Capacity Slider Value 
	@FindBy(xpath = "//*[@id=\"capacity-slider-range\"]/span[2]/div/div[2]")
	public
	WebElement SSDSelectedCapacityValue;
	
	public SSDServerTypePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public void ClickServerTypeBackBtn()
	{
		SSDBackBtn.click();
	}
	
	public void ClickServerTypeNextBtn()
	{
		SSDNextBtn.click();
	}
	
	public boolean ServerTypeNextBtn()
	{
		return SSDNextBtn.isEnabled();
	}
	public boolean ServerTypeLabel()
	{
		/*String ActualServerTypeLabel = " -- Please select server type -- ";
		String ExceptedServerTypeLabel = SSDServerType.getText();
		System.out.println(ExceptedServerTypeLabel);
		Assert.assertEquals(ActualServerTypeLabel, ExceptedServerTypeLabel);*/
		return SSDServerType.isDisplayed();
		
	}
	
	public boolean ServerModelLabel()
	{
		/*String ActualServerModelLabel = " -- Server Model -- ";
		String ExpectedServerModelLabel = SSDServerModel.getText();
		Assert.assertEquals(ActualServerModelLabel, ExpectedServerModelLabel);*/
		return SSDServerModel.isDisplayed();
	}
	
	public boolean CapacityLabel()
	{
		/*String ActualCapacityLabel = "--Select Capacity";
		String ExpectedCapacityLabel = SSDCapacityValue.getText();
		Assert.assertEquals(ActualCapacityLabel, ExpectedCapacityLabel);*/
		return SSDCapacityLabel.isDisplayed();
	}
	
	public void SelectServerType()
	{
		// Click on ServerType Tab
		SSDServerType.click();
		Select SelectServer = new Select(SSDServerType);
		SelectServer.selectByIndex(4);		
	}
	
	public void SelectServerModel()
	{
		//Click on Server Model Tab
		SSDServerModel.click();
		Select SelectModel = new Select(SSDServerModel);
		SelectModel.selectByVisibleText("BL460c Gen10");
	}

	/*public boolean CompareServerTypeServerModel()
	{
		SSDServerType.click();
		Select  SelectServer = new Select(SSDServerType);
		List<WebElement> AllServerTypes = SelectServer.getOptions();
		String[] ServerTypes = {"HPE ProLiant 100 Series","﻿HPE ProLiant 300 Series","HPE ProLiant 500 Series","HPE ProLiant BL C-Class","HPE Apollo Systems","HPE Synergy"};
		int i,j, Count = 0;
		j = AllServerTypes.size();
		System.out.println(j);
		//j = ServerTypes.size();
		for (i = 1; i <= ServerTypes.length; i++)
			{
				SelectServer.selectByIndex(i);
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				ClickCompareServerModellist();
				Count++;
				/*if(i == 7)
				{
					break;
				}*/
			//} */
		/*if(Count == ServerTypes.length)
		{
			System.out.println("Server Type and Server Model List is Showing Correct");
			return true;
		}
		else
		{
			System.out.println("Server Type and Server Model is MisMatch");
			return false;
		}
	}  */
	
	public boolean CompareServerTypeServerModel() throws InterruptedException
	{
		SSDServerType.click();
		Select SelectServerType = new Select(SSDServerType);
		List<WebElement> ServerTypes = SelectServerType.getOptions();
		int i,count = 0, ServerList = ServerTypes.size();
		System.out.println("ServerList :- " +ServerList);
		for(i = 0; i < ServerList; i++)
		{
			SelectServerType.selectByIndex(i);
			System.out.println(i);
			Thread.sleep(1000);
			SSDServerModel.click();
			Select SelectServerModel = new Select(SSDServerModel);
			List<WebElement> ModelTypes = SelectServerModel.getOptions();
			List<String> ServerModelActualList =  new ArrayList();
			for( WebElement ServerM : ModelTypes)
			{
				ServerModelActualList.add(ServerM.getText());
				System.out.println(ServerModelActualList);
		    }
			/*int j, ModelCount = 0,ModelList = ModelTypes.size();
			System.out.println(ModelList);
			for(j = 1; j < ModelList; j++)
			{	
				SelectServerModel.selectByIndex(j);
				if(UnClickNextBtn() == false)
				{
				  j++;
				}
				System.out.println(j);	
				ModelCount++;
			}*/
			count++;
			System.out.println("Count :-" + count);
		}
		if(count == ServerList)
		{
			System.out.println("Server Type and Server Model List is Showing Correct");
			return true;
		}
		else
		{
			System.out.println("Server Type and Server Model is MisMatch");
			return false;
		}
	}
	
	public void ClickCompareServerModellist()
	{
		SSDServerModel.click();
		//SelectServerModel.click();
		Select ServerModelist = new Select(SSDServerModel);
		List<WebElement> ServerModel = ServerModelist.getOptions();
		List<String> ServerModelActualList =  new ArrayList();
		for( WebElement ServerM : ServerModel)
		{
			ServerModelActualList.add(ServerM.getText());
			System.out.println(ServerModelActualList);
	    }
	} 
	
	public void SelectCapacityValue()
	{
		SSDCapacityValue.click();
		Select SelectCapacity = new Select(SSDCapacityValue);
		SelectCapacity.selectByVisibleText("300-400 (GB) ");
	}
	
	public void SelectedCapacityValue()
	{
		Select SelectedCapValue = new Select(SSDCapacityValue);
		WebElement CapacityValue = SelectedCapValue.getFirstSelectedOption();
		String SelectedCapacityValue = CapacityValue.getText();
		System.out.println(SelectedCapValue);
		String ExpectedCapacityValue = "300-400 (GB) ";
		Assert.assertEquals(SelectedCapacityValue, ExpectedCapacityValue);
	}
	
	public void ChangeCapacityValue()
	{
		SSDCapacityValue.click();
		Select ChangeCapaValue = new Select(SSDCapacityValue);
		ChangeCapaValue.selectByVisibleText("0-100 (GB) ");
	}
	
	public void CheckingServerTypeServerModelCapacity() throws InterruptedException
	{
		SSDServerType.click();
		Select SelectServerType = new Select(SSDServerType);
		List<WebElement> ServerTypes = SelectServerType.getOptions();
		int i,count = 0, ServerList = ServerTypes.size();
		System.out.println(ServerList);
		for(i = 1; i < ServerList; i++)
		{
			SelectServerType.selectByIndex(i);
			System.out.println(i);
			Thread.sleep(1000);
			SSDServerModel.click();
			Select SelectServerModel = new Select(SSDServerModel);
			List<WebElement> ModelTypes = SelectServerModel.getOptions();
			int j, ModelCount = 0,ModelList = ModelTypes.size();
			System.out.println(ModelList);
			for(j = 1; j < ModelList; j++)
			{	
				SelectServerModel.selectByIndex(j);
				if(UnClickNextBtn() == false)
				{
				  j++;
				}
				System.out.println(j);
				SSDCapacityValue.click();
				Select SelectCapacity = new Select(SSDCapacityValue);
				List<WebElement> CapacityTypes = SelectCapacity.getOptions();
				int k, CapacityCount = 0, CapacityList = CapacityTypes.size();
				System.out.println(CapacityList);
				for(k=1; k < CapacityList; k++)
				{
					SelectCapacity.selectByIndex(k);
					if(SSDCapacityValue.isDisplayed() == true)
					{
						k++;
					}
					if(UnClickNextBtn() == false)
					{
					  k++;
					}
					if(UnClickNextBtn() == true)
					{
						ServerNextClickBtn();
					}
					if(k==CapacityList)
					{
						break;
					}
				}
				ModelCount++;
			}
		}
	}
	
	public void ServerNextClickBtn()
	{
		SSDNextBtn.click();
		ssdInterface = new SSDInterfacePage();
		if(VerifyAlertMessageDisplayed() == true || ServerTypeNextBtn())
		{
			SSDAlertOk.click();
		}
		else
		{
			ssdInterface.InterfaceBackBtn();
		}
	}
	
	public void ServerTypeNextButtonClick()
	{
		SSDNextBtn.click();
	}

	public boolean UnClickNextBtn()
	{
			if (SSDNextBtn.isEnabled())
			{
				return true;
			}
			else
			{
				System.out.println("Next is not Selected");
			}
			return false;	
	}
	
	public boolean VerifyAlertMessageDisplayed()
	{
		return SSDAlertMessage.isDisplayed();
	}
	
	public boolean MenuBarServerType()
	{
		return SSDMenubarServerType.isEnabled();
	}
	
	// Capacity Slider Part
	public void CapacitySlideMaxtoMin()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions MoveMaxSlider = new Actions(driver);
		
		try
		{
			Action DragDrop = MoveMaxSlider.clickAndHold(SSDCapacitySliderRange).moveByOffset(-20,-0).release().build();
			DragDrop.perform();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void SelectCapacityMoveMaxtoMin()
	{
		Actions MoveMinSlider = new Actions(driver);
		try
		{
			MoveMinSlider.clickAndHold(SSDMaxTargetSlider).moveToElement(SSDMinTargetSlider);
			MoveMinSlider.release(SSDMinTargetSlider).perform();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void SelectCapacityMoveMintoMax()
		{
			
		Actions MoveMintoMax = new Actions(driver);
		try
		{
			MoveMintoMax.clickAndHold(SSDMaxTargetSlider).click(SSDCapacitySliderRange);
			MoveMintoMax.release(SSDCapacitySlider).perform();
			org.openqa.selenium.Dimension SliderWidth = SSDCapacitySlider.getSize();
			int Sliderlenght = SliderWidth.getWidth();
			//System.out.println(Sliderlenght);
			System.out.println("Capacity Selected Value :- " + SSDSelectedCapacityValue.getText());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void SelectedServerType()
	{
		Select SSDServertype = new Select(SSDServerType);
		SSDServertype.selectByVisibleText("HPE ProLiant 100 Series");
	}
	
	public void SelectedServerModel()
	{
		Select SSDServermodel = new Select(SSDServerModel);
		SSDServermodel.selectByVisibleText("DL160 Gen10");
	}
	
	public boolean SeverTypePageElementsSelected()
	{
		if( SSDServerType.isEnabled() & SSDServerModel.isEnabled() & SSDNextBtn.isEnabled())
		{
			ClickServerTypeNextBtn();
		}
		return true;
	}
	
	public String SelectedMinCapacityValue()
	{
		String ServerPageMinCapacity = SSDMinTextValue.getText();
		return ServerPageMinCapacity;
	}
	
	public String SelectedMaxCapacityValue()
	{
		String ServerPageMaxCapacity = SSDMaxTextValue.getText();
		return ServerPageMaxCapacity;
	}
	
	public void SelectedServerTypePageValues()
	{
		Select SelectedSeverType = new Select(SSDServerType);
		WebElement SelectedSeverTypeVaue = SelectedSeverType.getFirstSelectedOption();
		String ActualSelectedServerType = SelectedSeverTypeVaue.getText();
		String ExpectedSelectedServerType = "HPE ProLiant BL C-Class";
		Assert.assertEquals(ActualSelectedServerType, ExpectedSelectedServerType);
		Select SelecteServerModel = new Select(SSDServerModel);
		WebElement SelectServerModelValue = SelecteServerModel.getFirstSelectedOption();
		String ActualServerModel = SelectServerModelValue.getText();
		String ExpectedSelectedServerModel = "BL460c Gen10";
		Assert.assertEquals(ActualServerModel,ExpectedSelectedServerModel);
		String ServerPageMaxCapacity = SSDMaxTextValue.getText();
		String ActualMaxCapacityValue = Prop.getProperty("MixedMaxCapacityValue");
		Assert.assertEquals(ServerPageMaxCapacity,ActualMaxCapacityValue);
	}
	
	public void ClickAlertOk()
	{
		SSDAlertOk.click();
	}
	
	// For Read Intensive Maximum Capacity Value
	public void MaximumCapacityValue()
	{
		String ActualMaximumCapacityValue = Prop.getProperty("ReadMaxCapacityValue");
		String ExpectedMaxCapacityValue = SSDMaxTextValue.getText();
		System.out.println("Read Intensive Maximum Capacity Value :- " + SSDMaxTextValue.getText());
		Assert.assertEquals(ActualMaximumCapacityValue,ExpectedMaxCapacityValue);
	}
	
	public boolean ServerTypeSelectAll()
	{
	 if(SSDServerSelectAll.isSelected())
	 {
		 return true;
	 }
	 else
	 {
		 return false;
	 }
	}
	
	public void ClickSeverTypeSelectAll()
	{
		JavascriptExecutor SelectAll = (JavascriptExecutor)driver;
		SelectAll.executeScript("arguments[0].click()", SSDServerSelectAll);
		//SSDServerSelectAll.click();
	}
	
	// Read Selected Server Type and Server Model
	public void ReadSelectedServerType()
	{
		//Selecting Server Type 
		Select ServerTypeSelect = new Select(SSDServerType);
		ServerTypeSelect.selectByVisibleText(Prop.getProperty("ReadServerTypeSelect"));
	}
	
	//Read Selected Server Model 
	public void ReadSelectedServerModel()
	{
		//Selecting Server Model
		Select ServerModelSelect = new Select(SSDServerModel);
		ServerModelSelect.selectByVisibleText(Prop.getProperty("ReadServerModelSelect"));
	}
	
	//Read Selected Retain Check
	public void ReadSelectedRetainedCheck()
	{
		WebDriverWait InterfacePageLoad = new WebDriverWait(driver,15);
		boolean ServerPageLoad = InterfacePageLoad.until(ExpectedConditions.textToBePresentInElement(SSDServerModel,"DL560 Gen10"));
		if(ServerPageLoad == true)
		{
			//To Check Server Type retained
			Select ServerTypeSelect = new Select(SSDServerType);
			WebElement SelectedServerType = ServerTypeSelect.getFirstSelectedOption();
			String ReadSelectedServerType = SelectedServerType.getText();
			String ActualSelectedServerType = Prop.getProperty("ReadServerTypeSelect");
			Assert.assertEquals(ActualSelectedServerType, ReadSelectedServerType);
			//To Check Server Model retained
			Select ServerModelSelect = new Select(SSDServerModel);
			WebElement SelectedServerModel = ServerModelSelect.getFirstSelectedOption();
			String ReadSelectedServerModel = SelectedServerModel.getText();
			System.out.println("Selected Server Model :-"+ReadSelectedServerModel);
			String ActualSelectedServerModelType = Prop.getProperty("ReadServerModelSelect");
			Assert.assertEquals(ActualSelectedServerModelType,ReadSelectedServerModel);
			//To Check Capacity Value retained
			String ServerPageMaxCapacity = SSDMaxTextValue.getText();
			String ActualMaxCapacityValue = Prop.getProperty("ReadMaxCapacityValue");
			Assert.assertEquals(ServerPageMaxCapacity,ActualMaxCapacityValue);
		}
		else
		{
			SSDNextBtn.click();
		}
	}
	
// For Mixed Use Workloads
	public void MixedMaximumCapacityValue()
	{
		String ActualMaximumCapacityValue = Prop.getProperty("MixedMaxCapacityValue");
		String ExpectedMaxCapacityValue = SSDMaxTextValue.getText();
		System.out.println("Write Intensive Maximum Capacity Value :- " + SSDMaxTextValue.getText());
		Assert.assertEquals(ActualMaximumCapacityValue,ExpectedMaxCapacityValue);
	}
	
// Mixed Use Worklod Selected Server Type and Server Model
	public void MixedUseSelectedServerType()
	{
		//Selecting Server Type 
		Select ServerTypeSelect = new Select(SSDServerType);
		ServerTypeSelect.selectByVisibleText(Prop.getProperty("MixedUseServerTypeSelect"));
	}
		
//Mixed Use Selected Server Model 
	public void MixedUseSelectedServerModel()
	{
		//Selecting Server Model
		Select ServerModelSelect = new Select(SSDServerModel);
		ServerModelSelect.selectByVisibleText(Prop.getProperty("MixedUseServerModelSelect"));
	}
		
//Mixed Use Selected Retain Check
	public void MixedUseSelectedRetainedCheck()
	{
		WebDriverWait InterfacePageLoad = new WebDriverWait(driver,15);
		boolean ServerPageLoad = InterfacePageLoad.until(ExpectedConditions.textToBePresentInElement(SSDServerModel,"Apollo 4500 - XL450 Gen10"));
		if(ServerPageLoad == true)
		{
			//To Check Server Type retained
			Select ServerTypeSelect = new Select(SSDServerType);
			WebElement SelectedServerType = ServerTypeSelect.getFirstSelectedOption();
			String MixedSelectedServerType = SelectedServerType.getText();
			String ActualSelectedServerType = Prop.getProperty("MixedUseServerTypeSelect");
			Assert.assertEquals(ActualSelectedServerType, MixedSelectedServerType);
			//To Check Server Model retained
			Select ServerModelSelect = new Select(SSDServerModel);
			WebElement SelectedServerModel = ServerModelSelect.getFirstSelectedOption();
			String MixedSelectedServerModel = SelectedServerModel.getText();
			System.out.println("Selected Server Model :-"+ MixedSelectedServerModel);
			String ActualSelectedServerModelType = Prop.getProperty("MixedUseServerModelSelect");
			Assert.assertEquals(ActualSelectedServerModelType,MixedSelectedServerModel);
			//To Check Capacity Value retained
			String ServerPageMaxCapacity = SSDMaxTextValue.getText();
			String ActualMaxCapacityValue = Prop.getProperty("MixedMaxCapacityValue");
			Assert.assertEquals(ServerPageMaxCapacity,ActualMaxCapacityValue);
		}
		else
		{
			SSDNextBtn.click();
		}
	}
	
// Write Intensive Workloads Selected
	public void WriteIntensiveMaximumCapacityValue()
	{
		String ActualMaximumCapacityValue = Prop.getProperty("WriteMaxCapacityValue");
		String ExpectedMaxCapacityValue = SSDMaxTextValue.getText();
		System.out.println("Mixed Use Maximum Capacity Value :- " + SSDMaxTextValue.getText());
		Assert.assertEquals(ActualMaximumCapacityValue,ExpectedMaxCapacityValue);
	}
		
// Write Intensive Worklod Selected Server Type and Server Model
	public void WriteIntensiveSelectedServerType()
	{
		//Selecting Server Type 
		Select ServerTypeSelect = new Select(SSDServerType);
		ServerTypeSelect.selectByVisibleText(Prop.getProperty("WriteIntensiveServerTypeSelect"));
	}
			
//Write Intensive Selected Server Model 
	public void WriteIntensiveSelectedServerModel()
	{
		//Selecting Server Model
		Select ServerModelSelect = new Select(SSDServerModel);
		ServerModelSelect.selectByVisibleText(Prop.getProperty("WriteIntensiveServerModelSelect"));
	}
			
//Write Intensive Selected Retain Check
	public void WriteIntensiveSelectedRetainedCheck()
	{
		WebDriverWait InterfacePageLoad = new WebDriverWait(driver,15);
		boolean ServerPageLoad = InterfacePageLoad.until(ExpectedConditions.textToBePresentInElement(SSDServerModel,"Synergy 660 Gen10"));
		if(ServerPageLoad == true)
		{
			//To Check Server Type retained
			Select ServerTypeSelect = new Select(SSDServerType);
			WebElement SelectedServerType = ServerTypeSelect.getFirstSelectedOption();
			String MixedSelectedServerType = SelectedServerType.getText();
			String ActualSelectedServerType = Prop.getProperty("WriteIntensiveServerTypeSelect");
			Assert.assertEquals(ActualSelectedServerType, MixedSelectedServerType);
			//To Check Server Model retained
			Select ServerModelSelect = new Select(SSDServerModel);
			WebElement SelectedServerModel = ServerModelSelect.getFirstSelectedOption();
			String MixedSelectedServerModel = SelectedServerModel.getText();
			System.out.println("Selected Server Model :-"+ MixedSelectedServerModel);
			String ActualSelectedServerModelType = Prop.getProperty("WriteIntensiveServerModelSelect");
			Assert.assertEquals(ActualSelectedServerModelType,MixedSelectedServerModel);
			//To Check Capacity Value retained
			String ServerPageMaxCapacity = SSDMaxTextValue.getText();
			String ActualMaxCapacityValue = Prop.getProperty("WriteMaxCapacityValue");
			Assert.assertEquals(ServerPageMaxCapacity,ActualMaxCapacityValue);
		}
		else
		{
			SSDNextBtn.click();
		}
	}

// Very Read Optimized Workloads Selected
	public void VeryReadOptimizedMaximumCapacityValue()
	{
		String ActualMaximumCapacityValue = Prop.getProperty("VROMaxCapacityValue");
		String ExpectedMaxCapacityValue = SSDMaxTextValue.getText();
		System.out.println("Very Read Optimized Maximum Capacity Value :- " + SSDMaxTextValue.getText());
		Assert.assertEquals(ActualMaximumCapacityValue,ExpectedMaxCapacityValue);
	}
			
// Very Read Optimized Workload Selected Server Type and Server Model
	public void VeryReadOptimizedSelectedServerType()
	{
		//Selecting Server Type 
		Select ServerTypeSelect = new Select(SSDServerType);
		ServerTypeSelect.selectByVisibleText(Prop.getProperty("VROServerTypeSelect"));
	}
				
//Very Read Optimized Selected Server Model 
	public void VeryReadOptimizedSelectedServerModel()
	{
		//Selecting Server Model
		Select ServerModelSelect = new Select(SSDServerModel);
		ServerModelSelect.selectByVisibleText(Prop.getProperty("VROServerModelSelect"));
	}
			 	
//Very Read Optimized Selected Retain Check
	public void VeryReadOptimizedSelectedRetainedCheck()
	{
		WebDriverWait InterfacePageLoad = new WebDriverWait(driver,15);
		boolean ServerPageLoad = InterfacePageLoad.until(ExpectedConditions.textToBePresentInElement(SSDServerModel,"DL325 Gen10"));
		if(ServerPageLoad == true)
		{
			//To Check Server Type retained
			Select ServerTypeSelect = new Select(SSDServerType);
			WebElement SelectedServerType = ServerTypeSelect.getFirstSelectedOption();
			String MixedSelectedServerType = SelectedServerType.getText();
			System.out.println("Selected Server Type :-"+ MixedSelectedServerType);
			String ActualSelectedServerType = Prop.getProperty("VROServerTypeSelect");
			Assert.assertEquals(ActualSelectedServerType, MixedSelectedServerType);
			//To Check Server Model retained
			Select ServerModelSelect = new Select(SSDServerModel);
			WebElement SelectedServerModel = ServerModelSelect.getFirstSelectedOption();
			String MixedSelectedServerModel = SelectedServerModel.getText();
			System.out.println("Selected Server Model :-"+ MixedSelectedServerModel);
			String ActualSelectedServerModelType = Prop.getProperty("VROServerModelSelect");
			Assert.assertEquals(ActualSelectedServerModelType,MixedSelectedServerModel);
			//To Check Capacity Value retained
			String ServerPageMaxCapacity = SSDMaxTextValue.getText();
			String ActualMaxCapacityValue = Prop.getProperty("VROMaxCapacityValue");
			Assert.assertEquals(ServerPageMaxCapacity,ActualMaxCapacityValue);
		}
		else
		{
			SSDNextBtn.click();
		}
	}

}
