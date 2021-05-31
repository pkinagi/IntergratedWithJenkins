package hpessdPageObjects;

import java.io.File;

import org.apache.tools.ant.taskdefs.Java;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import hpessdResource.BaseClass;

import hpessdPageObjects.SSDServerTypePage;
//import junit.framework.Assert;

public class SSDResultPage extends BaseClass
{
	SSDServerTypePage ssdServertype;
	
	// Result Page Web Elements
	@FindBy(xpath = "//*[@id=\"startOverLink\"]")
	WebElement SSDStartOver;
	
	// SSD Workload Webelement
	@FindBy(xpath = "//*[@id=\"id-ssdtype_VRO\"]")
	public
	WebElement SSDResVRO;
	
	@FindBy(xpath = "//*[@id=\"id-ssdtype_RI\"]")
	public
	WebElement SSDResReadIntensive;
	//*[@id="id-ssdtype_RI"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdtype_MU\"]")
	public
	WebElement SSDResMixedUse;
	//*[@id="id-ssdtype_MU"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdtype_WI\"]")
	public
	WebElement SSDResWriteIntensive;
	//*[@id="id-ssdtype_WI"]
	
	// SSD Workloads Labels
	
	@FindBy(xpath = "//span[contains(text(),'Very Read Optimization')]")
	public
	WebElement SSDResVROlabel;
	
	@FindBy(xpath = "//span[contains(text(),'Read Intensive')]")
	public
	WebElement SSDResReadIntensiveLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Mixed Use')]")
	public
	WebElement SSDResMixedUselabel;
	
	@FindBy(xpath = "//span[contains(text(),'Write Intensive')]")
	public
	WebElement SSDResWriteIntensiveLabel;
	//Interface Type  Web Elements 
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_SAS\"]")
	public
	WebElement SSDResInterfaceSAS;
	//*[@id="id-ssdInterfaceType_SAS"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_VALUESAS\"]")
	public
	WebElement SSDResInterfaceValueSAS;
	//*[@id="id-ssdInterfaceType_VALUESAS"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_SATA\"]")
	public
	WebElement SSDResInterfaceSATA;
	//*[@id="id-ssdInterfaceType_SATA"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_SATAVRO\"]")
	public
	WebElement SSDResInterfaceSATAVRO;
	//*[@id="id-ssdInterfaceType_SATAVRO"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_NVMeMainstream\"]")
	public
	WebElement SSDResInterfaceNVMeMainstream;
	//*[@id="id-ssdInterfaceType_NVMeMainstream"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdInterfaceType_NVMeHighPerformance\"]")
	public
	WebElement SSDResInterfaceNVMeHigh;
	//*[@id="id-ssdInterfaceType_NVMeHighPerformance"]
	
	// Interface Types Labels
	
	@FindBy(xpath = "//span[contains(text(),'SATA VRO')]")
	public
	WebElement SSDResInterfaceTypeSATAVROLabel;
	
	@FindBy(xpath = "//span[contains(text(),'SATA')]")
	public
	WebElement SSDResInterfaceTypeSATALabel;
	
	@FindBy(xpath = "//span[contains(text(),'VALUE SAS')]")
	public
	WebElement SSDResInterfaceTypeValueSASLabel;
	
	@FindBy(xpath = "//span[contains(text(),'SAS')]")
	public
	WebElement SSDResInterfaceTypeSASLabel;
	
	@FindBy(xpath = "//span[contains(text(),'NVMe Mainstream')]")
	public
	WebElement SSDResInterfaceTypeNVMeMainstreamLabel;
	
	@FindBy(xpath = "//span[contains(text(),'NVMe High Performance')]")
	public
	WebElement SSDResInterfaceTypeNVMeHighPerformanceLabel;
	
	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div[4]/div/div[2]/div[1]/div[3]/div[1]")
	public 
	WebElement SSDResFormFactor;
	
	// Form Factor Web Elements
	
	@FindBy(xpath = "//*[@id=\"id-ssdFormFactor_SFF\"]")
	public
	WebElement SSDResFFSFF;
	//*[@id="id-ssdFormFactor_SFF"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdFormFactor_LFF\"]")
	public
	WebElement SSDResFFLFF;
	//*[@id="id-ssdFormFactor_LFF"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdFormFactor_AIC\"]")
	public
	WebElement SSDResFFAIC;
	//*[@id="id-ssdFormFactor_AIC"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdFormFactor_M2\"]")
	public
	WebElement SSDResM2;
	//*[@id="id-ssdFormFactor_M2"]
	
	@FindBy(xpath = "//*[@id=\"id-ssdFormFactor_M2e\"]")
	public
	WebElement SSDResM2E;
	//*[@id="id-ssdFormFactor_M2e"]
	
	// Form Factor Labels
	
	@FindBy(xpath = "//span[contains(text(),'2.5\" SFF')]")
	public
	WebElement SSDFormFactorSFFLabel;
	
	@FindBy(xpath = "//span[contains(text(),'3.5\" LFF')]")
	public
	WebElement SSDFormFactorLFFLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Add-In Card')]")
	public
	WebElement SSDFormFactorAddInCardLabel;
	
	@FindBy(xpath = "//span[contains(text(),'M.2 Enablement Kit')]")
	public
	WebElement SSDFormFactorM2EKitlabel;
	
	// Certifications 
	
	@FindBy(xpath = "//*[@id=\"id-certifications_0\"]")
	WebElement SSDResCerVSAN;
	//*[@id="id-certifications_0"]
	
	@FindBy(xpath = "//*[@id=\"id-certifications_1\"]")
	WebElement SSDResCerMS2016;
	//*[@id="id-certifications_1"]
	
	@FindBy(xpath = "//*[@id=\"id-certifications_2\"]")
	WebElement SSDResCerSDDC2016;
	//*[@id="id-certifications_2"]
	
	@FindBy(xpath = "//*[@id=\"id-certifications_3\"]")
	WebElement SSDResCerMS2019;
	//*[@id="id-certifications_3"]
	
	@FindBy(xpath = "//*[@id=\"id-certifications_4\"]")
	WebElement SSDResCerSDDC2019;
	//*[@id="id-certifications_4"]
	
	// Best Availability
	
	@FindBy(xpath = "//*[@id=\"stream_Yes\"]")
	public
	WebElement SSDResMainstream;
	//*[@id="stream_Yes"]
	
	@FindBy(xpath = "//*[@id=\"stream_No\"]")
	public
	WebElement SSDResNonMainstream;
	//*[@id="stream_No"]
	
	//Link for Pricing and Availability
	
	@FindBy(xpath = "//*[@id=\"id-refineYourResults\"]")
	public
	WebElement SSDResSelectAll;
	//*[@id="id-refineYourResults"]
	
	//Collapse link in the Result Page
	
	@FindBy(linkText = "here")
	WebElement SSDResPriceLink;
	
	@FindBy(linkText = "Refine your results")
	public
	WebElement SSDResRefineResults;
	
	@FindBy(linkText = "SSD Portfolio Alignment")
	public
	WebElement SSDResPortfolioImage;
	
	@FindBy(xpath = "//*[@id=\"panel-ggroup2\"]")
	public
	WebElement SSDResPortImage;
	
	//SSD Portfolio Alignment Image
	@FindBy(xpath = "//*[@id=\"collapse2\"]/div/div/div/div/img" )
	public 
	WebElement SSDPortfolioImage;
	
	//@FindBy(partialLinkText = " -  SSDs meet your requirements")
	@FindBy(xpath = "//*[@id=\"panel-ggroup3\"]/div/div[1]/h4/a/span")
	public
	WebElement SSDResResultDisplayLink;
	
	@FindBy(partialLinkText = " -  SSDs meet your requirements")
	public
	boolean SSDResResultDisplayLink1;
	
	
	//Search Tab
	@FindBy(xpath = "//*[@id=\"searchfield\"]")
	public
	WebElement SSDResSearchTab;
	//*[@id="searchfield"]
	
	// Searched Result WebElement
	@FindBy(xpath = "//*[@id=\"result_content\"]/div/span")
	public
	WebElement SearchedSKUResult;
	
	//Search Icon
	@FindBy(xpath = "//*[@id=\"icon-search\"]")
	WebElement SSDResSearchIcon;
	//*[@id="icon-search"]
	
	//Server Type and Server Model
	
	@FindBy(xpath = "//*[@id=\"sel_server_type\"]")
	public
	WebElement SSDResSelectServerType;
	
	@FindBy(xpath = "//*[@id=\"sel_server_model\"]")
	public
	WebElement SSDResSelectServerModel;
	
	// Slider Web Elements
	
	@FindBy(xpath = "//*[@id=\"min_capacity\"]")
	public
	WebElement SSDResultPageMinCapSlider;
	//*[@id="min_capacity"]
	
	@FindBy(xpath = "//*[@id=\"max_capacity\"]")
	public 
	WebElement SSDResultPageMaxCapSlider;
	//*[@id="max_capacity"]
	
	//Max Tool Tip
	@FindBy(xpath = "//*[@id=\"slider-range\"]/span[2]/div/div[2]")
	public 
	WebElement SSDResultPageMaxToolTip;
		
	//Min Tool Tip
	@FindBy(xpath = "//*[@id=\"slider-range\"]/span[1]/div/div[2]")
	public 
	WebElement SSDResultPageMinToolTip;
	
	// Slider
	@FindBy(xpath = "//*[@id=\"slider-range\"]")
	public 
	WebElement	SSDResSliderRange;
	
	//Slider Labels in Result Page
	
	@FindBy(xpath = "//div[contains(text(),'Capacity')]")
	WebElement SSDResCapacityLabel;
	//div[contains(text(),'Capacity')]
	
	@FindBy(xpath = "//div[contains(text(),'Endurance')]")
	WebElement SSDResEnduranceLabel;
	//div[contains(text(),'Endurance')]
	
	@FindBy(xpath = "//div[contains(text(),'4K Q16 Random Read IOPS')]")
	WebElement SSDResRandomReadIOPS;
	
	@FindBy(xpath = "//div[contains(text(),'4K Q16 Random Write IOPS')]")
	WebElement SSDResRandomWriteIOPS;
	//div[contains(text(),'4K Q16 Random Write IOPS')]
	
	@FindBy(xpath = "//div[contains(text(),'4K MAX Random Read IOPS')]")
	WebElement SSDResMaxRandomRead;
	//div[contains(text(),'4K MAX Random Read IOPS')]
	
	@FindBy(xpath = "//div[contains(text(),'4K MAX Random Write IOPS')]")
	WebElement SSDResMaxRandomWrite;
	//div[contains(text(),'4K MAX Random Write IOPS')]
	
	@FindBy(xpath = "//div[contains(text(),'Max Power')]")
	WebElement SSDResMaxPower;
	//div[contains(text(),'Max Power')]
	
	// Slider Min and Max Web Elements
	
	@FindBy(xpath = "//*[@id='min_endurance']")
	WebElement SSDResMinEndurance;
	//*[@id='min_endurance']
	
	@FindBy(xpath = "//*[@id='max_endurance']")
	WebElement SSDResMaxEndurance;
	//*[@id='max_endurance']
	
	@FindBy(xpath = "//*[@id='min_readiops']")
	WebElement SSDResMinReadIOPS;
	//*[@id='min_readiops']
	
	@FindBy(xpath = "//*[@id='max_readiops']")
	WebElement SSDResMaxReadIOPS;
	//*[@id='max_readiops']
	
	@FindBy(xpath = "//*[@id='min_writeiops']")
	WebElement SSDResMinWriteIOPS;
	//*[@id='min_writeiops']
	
	@FindBy(xpath = "//*[@id='max_writeiops']")
	WebElement SSDResMaxWriteIOPS;
	//*[@id='max_writeiops']
	
	@FindBy(xpath = "//*[@id='min_randread']")
	WebElement SSDResMinRandomRead;
	//*[@id='min_randread']
	
	@FindBy(xpath = "//*[@id='max_randread']")
	WebElement SSDResMaxRandRead;
	//*[@id='max_randread']
	
	@FindBy(xpath = "//*[@id='min_randwrite']")
	WebElement SSDResMinRandWrite;
	//*[@id='min_randwrite']
	
	@FindBy(xpath = "//*[@id='max_randwrite']")
	WebElement SSDResMaxRandWrite;
	//*[@id='max_randwrite']
	
	@FindBy(xpath = "//*[@id=\"min_power\"]")
	WebElement SSDResMinPower;
	//*[@id="min_power"]
	
	@FindBy(xpath = "//*[@id=\"max_power\"]")
	WebElement SSDResMaxPow;
	//*[@id="max_power"]
	
	// Alert Message Displayed on Mainstream
	
	//@FindBy(xpath = "//*[@id=\"jconfirm-box36739\"]")
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[3]")
	WebElement SSDResultAlertMessageBox;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button")
	WebElement SSDResultAlertMessageOK;
	
	// For Reset The SSD Results
	
	//@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[3]")
	//@FindBy(xpath = "//*[@id=\"jconfirm-box45235\"]/div/text()")
	@FindBy(xpath = "/html/body/div[4]/div[2]/div/div/div/div/div/div/div/div[3]")
	WebElement SSDResultResertAlertMessage;
	
	//@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button[1]")
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement SSDResultResetYes;
	
	//@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div[4]/button[2]")
	@FindBy(xpath = "//button[contains(text(),'No')]")
	WebElement SSDResultResetNo;
	
	
	// For No Results Message Display
	@FindBy(xpath = "//p[contains(text(),'There are no results based on your selection. Plea')]")
	//@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/p[1]/text()")
	public
	WebElement SSDResNoSSDMessageDisplay;
	
	// Export Excel File, Export CSV File, 
	
	// Feedback Link 
	@FindBy(xpath = "//a[contains(text(),'Feedback')]")
	public
	WebElement SSDResultFeedbackLink;
	
	@FindBy(css = "#downloadAllRec")
	public
	WebElement SSDResultExportExcel;
	
	@FindBy(css = "#downloadAllCSV")
	public
	WebElement	SSDResultExportCSV;
	
	@FindBy(css = "#printToLink")
	public
	WebElement SSDResultPrintLink;
	
	@FindBy(css = "#startOverLink")
	public
	WebElement SSDResultStartOverLink;
	
	// Indiviual SSD Excel File and PDF File.
	
	@FindBy(xpath = "//*[@id=\"download_1\"]")
	WebElement SSDResultExcelFileDownload;
	
	@FindBy(xpath = "//*[@id=\"downloadPDF\"]")
	WebElement SSDResultPDFFileDownload;
	
	@FindBy(xpath = "//button[contains(text(),'Show more')]")
	public
	WebElement SSDResultShowmoreLink;
	
	//When Only Very Read Intensive is Selected
	@FindBy(xpath = "//div[contains(text(),'Very Read Optimized')]")
	public
	WebElement SSDOnlyVROResults;
	
	// When Only Read Intensive is Selected
	@FindBy(xpath = "//div[contains(text(),'Read Intensive')]")
	public
	WebElement SSDOnlyReadIntensiveResults;
	
	// When only Mixed Use is Selected
	@FindBy(xpath = "//div[contains(text(),'Mixed Use')]")
	public
	WebElement SSDOnlyMixedUseResults;
	
	//When only Write Intensive is Selected
	@FindBy(xpath = "//div[contains(text(),'Write Intensive')]")
	public
	WebElement	SSDOnlyWriteIntensiveResults;
	
	//When Only SATA Interface is Selected
	@FindBy(xpath = "//div[contains(text(),'SATA')]")
	public
	WebElement SSDOnlySATAInterfaceResults;
	
	//When Only VALUESAS Interface is Selected
	@FindBy(xpath = "//div[contains(text(),'Value SAS')]")
	public
	WebElement SSDOnlyValueSASInterfaceResults;
	
	//When Only SAS Interface is Selected
	@FindBy(xpath = "//div[contains(text(),'SAS')]")
	public
	WebElement SSDOnlySASInterfaceResults;
	
	//When Only NVMe Mainstream Interface is Selected
	@FindBy(xpath = "//div[contains(text(),'Mainstream Performance')]")
	public
	WebElement SSDOnlyNVMeMainstreamInterfaceResults;
	
	//When Only NVMe High Performance Interface is Selected
	@FindBy(xpath = "//div[contains(text(),'High Performance')]")
	public
	WebElement SSDOnlyNVMeHighPerformanceInterfaceResults;
	
	//When Only 2.5 SFF Form Factor is Selected
	@FindBy(xpath = "//div[contains(text(),'SFF')]")
	public
	WebElement SSDOnlySFFFormFactorResults;
	
	//When Only 3.5 LFF Form Factor is Selected
	@FindBy(xpath = "//div[contains(text(),'LFF')]")
	public
	WebElement SSDOnlyLFFFormFactorResults;
	
	//When Only Add-In-Card Form Factor is Selected
	@FindBy(xpath = "//div[contains(text(),'AIC')]")
	public
	WebElement SSDOnlyAICFormFactorResults;
	
	//When Only M.2 Form Factor is Selected
	@FindBy(xpath = "//div[contains(text(),'M.2')]")
	public
	WebElement SSDOnlyM2Results;
	
	//When Only M.2E Form Factor is Selected
	@FindBy(xpath = "//div[contains(text(),'Enablement Kit')]")
	public
	WebElement SSDOnlyM2EResults;
	
	//For Mainstream Label
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[2]/span")
	WebElement SSDResMainstreamLabel;
	
	// For Non-Mainstream Label
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[2]/div[2]/div[2]/span")
	WebElement SSDResNonMainstreamLabel;
	
	
	// For Individual Xls file Download
	@FindBy(xpath = "//img[@id='download_22']")
	WebElement SSDIndividualExcelDownload;
	
	// For Individual pdf file Download
	@FindBy(xpath = "//body/section[@id='mainContent']/div[5]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[2]/a[2]/img[1]")
	WebElement SSDIndividualPDFDownload;
	
	//For Best Availability 
	@FindBy(xpath = "//*[@id=\"collapse1\"]/div/div[4]/div/div[2]/div[1]/div[5]/div[1]")
	public
	WebElement SSDResBestAvailability;
	
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[1]/i")
	////*[@id=\"collapse3\"]/div/div/div/div/div/div[6]/div[2]/div[4]/div[1]/div[2]/div[1]/i
	public
	WebElement	SSDShowMoreSBEIcon;
	
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/i")
	public
	WebElement	SSDShowMoreSCEIcon;
	
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[3]/i")
	public
	WebElement	SSDShowMoreSEIcon;
	
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[4]/i")
	public
	WebElement	SSDShowMoreTIcon;
		
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[5]/i")
	public
	WebElement	SSDShowMoreSEDIcon;
	
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[6]/i")
	public
	WebElement	SSDShowMoreDSFIcon;
	
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[7]/i")
	public
	WebElement	SSDShowMorePTIcon;
	
	//Icon xpath 
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[2]/div[8]/i")
	public
	WebElement	SSDShowMoreTAAIcon;
	
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[1]/div[15]/i")
	public
	WebElement SSDShowMoreFIPSIcon;
	
	@FindBy(xpath = "//*[@id=\"collapse3\"]/div/div/div/div/div/div[3]/div[2]/div[4]/div[1]/div[1]/div[16]/i")
	public
	WebElement SSDShowMoreNDUIcon;
	
	public SSDResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean SSDVRO()
	{
		return SSDResVRO.isSelected();
	}
	
	public boolean SSDReadIntensive()
	{
		return SSDResReadIntensive.isSelected();
	}
	
	public boolean SSDMixedUse()
	{
		return SSDResMixedUse.isSelected();
	}
	
	public boolean SSDWriteIntensive()
	{
		return SSDResWriteIntensive.isSelected();
	}
	
	public boolean SSDSAS()
	{
		return SSDResInterfaceSAS.isSelected();
	}
	
	public boolean SSDValueSAS()
	{
		return SSDResInterfaceValueSAS.isSelected();
	}
	
	public boolean SSDSATA()
	{
		return SSDResInterfaceSATA.isSelected();
	}
	
	public boolean SSDSATAVRO()
	{
		return SSDResInterfaceSATAVRO.isSelected();
	}
	
	public boolean SSDNVMeMainstream()
	{
		return SSDResInterfaceNVMeMainstream.isSelected();
	}
	
	public boolean SSDNVMeHighPerformance()
	{
		return SSDResInterfaceNVMeHigh.isSelected();
	}
	
	public boolean SSDSFF()
	{
		return SSDResFFSFF.isSelected();
	}
	
	public boolean SSDLFF()
	{
		return SSDResFFLFF.isSelected();
	}
	
	public boolean SSDM2()
	{
		return SSDResM2.isSelected();
	}
	
	public boolean SSDM2E()
	{
		return SSDResM2E.isSelected();
	}
	
	public boolean SSDAIC()
	{
		return SSDResFFAIC.isSelected();
	}
	
	public boolean SSDMainstream()
	{
		return SSDResMainstream.isSelected();
	}
	
	public void SSDResultPageSelectAll()
	{
		SSDResSelectAll.click();
	}
	
	public boolean SSDVSAN()
	{
		return SSDResCerVSAN.isSelected();
	}
	
	public boolean SSDMS2016()
	{
		return SSDResCerMS2016.isSelected();
	}
	
	public boolean SSDSDDC2016()
	{
		return SSDResCerSDDC2016.isSelected();
	}
	
	public boolean SSDMS2019()
	{
		return SSDResCerMS2019.isSelected();
	}
	
	public boolean SSDSDDC2019()
	{
		return SSDResCerSDDC2019.isSelected();
	}
	
	public void SSDPortfolioImage()
	{
		SSDResPortfolioImage.click();
	}
	
	public void SSDPortImage()
	{
		JavascriptExecutor ResultPageScroll = (JavascriptExecutor)driver;
		ResultPageScroll.executeScript("arguments[0].scrollIntoView();", SSDResPortfolioImage);
	}
	
	// Click on SSD Meets your Requirements Link
	
	public void SSDMeetRequirementLink()
	{
		JavascriptExecutor	ClickSSDResults = (JavascriptExecutor)driver;
		ClickSSDResults.executeScript("arguments[0].click()", SSDResResultDisplayLink);
	}
	
	
	//@SuppressWarnings("deprecation")
	public void SSDCapacityMinSliderText()
	{
		ssdServertype = new SSDServerTypePage();
		String ActualMinCapacitySlider = "6.8";
		String ExpectedMinCapacitySlider = SSDResultPageMinCapSlider.getText();
		Assert.assertEquals(ActualMinCapacitySlider, ExpectedMinCapacitySlider);
	}
	
	public void SSDCapacityMaxSliderText()
	{
		String ActualMaxCapacitySlider = Prop.getProperty("ReadMaxCapacityValue");
		String ExpectedMaxCapacitySlider = SSDResultPageMaxCapSlider.getText();
		Assert.assertEquals(ActualMaxCapacitySlider, ExpectedMaxCapacitySlider);
	}
	
	public void SSDServerType()
	{
		Select ServerType = new Select(SSDResSelectServerType);
		WebElement SelectedServerType = ServerType.getFirstSelectedOption();
		String SelectedType = SelectedServerType.getText();
		System.out.println(SelectedType);
		String ActualSelectedType = "HPE ProLiant 100 Series";
		Assert.assertEquals(ActualSelectedType, SelectedType);
	}
	
	public void SSDServerModel()
	{
		Select ServerModel = new Select(SSDResSelectServerModel);
		WebElement SelectedServerModel = ServerModel.getFirstSelectedOption();
		String SelectedModel = SelectedServerModel.getText();
		System.out.println(SelectedModel);
		String ActualSelectedModel = "DL160 Gen10";
		Assert.assertEquals(ActualSelectedModel,SelectedModel);
	}
	
	public void SSDSearchTab()
	{
		SSDResSearchTab.sendKeys("P0212");
		SSDResSearchIcon.click();
	}
	
	public void SSDSearchTabText()
	{
		String ActualSearchTabText = "Search by SKU";
		String ExpectedSearchTabText = SSDResSearchTab.getText();
		Assert.assertEquals(ActualSearchTabText, ExpectedSearchTabText);
	}
	
	// In Search Tab, For InValid SKU Search
	public void InValidSKUSearch()
	{
		SSDResSearchTab.sendKeys("P0212");
		SSDResSearchIcon.click();
	}

	// In Search Tab, For Valid SKU Search 
	public void ValidSearch()
	{
		SSDResSearchTab.sendKeys("P04560-B21");
		SSDResSearchIcon.click();
	}
	
	// For Clear The Search Tab
	public void ClearSearchTab()
	{
		SSDResSearchTab.clear();
	}
	public void SSDServerTypeLabel()
	{
		Select ServerType = new Select(SSDResSelectServerType);
		WebElement SelectedServerType = ServerType.getFirstSelectedOption();
		String SelectedType = SelectedServerType.getText();
		System.out.println("Result Page Server Type :-" +SelectedType);
		String ActualSelectedType = "-- Please select server type --";
		Assert.assertEquals(ActualSelectedType, SelectedType);
		
		/*String ActualServerTypeText = " -- Please select server type -- ";
		String ExpectedServerTypeText = SSDResSelectServerType.getText();
		System.out.println(ExpectedServerTypeText);
		Assert.assertEquals(ActualServerTypeText, ExpectedServerTypeText); */
	}
	public void SSDServerModelLabel()
	{
		Select ServerModel = new Select(SSDResSelectServerModel);
		WebElement SelectedServerModel = ServerModel.getFirstSelectedOption();
		String SelectedModel = SelectedServerModel.getText();
		System.out.println("Result Page Server Model:-" + SelectedModel);
		String ActualSelectedModel = "--Choose a server model--";
		Assert.assertEquals(ActualSelectedModel,SelectedModel);
		
		/*String ActualServerModelText = "--Choose a server model--";
		String ExpectedServerModelText = SSDResSelectServerModel.getText();
		Assert.assertEquals(ActualServerModelText, ExpectedServerModelText); */
	}
	
	public boolean SSDServerTypeEnable()
	{
		return SSDResSelectServerType.isEnabled();
	}
	
	public boolean SSDServerModelDisable()
	{
		System.out.println("Result Page Server Model Tab :-" + SSDResSelectServerModel.isEnabled());
		return SSDResSelectServerModel.isEnabled();
	}
	
	public boolean SSDEnduranceLabel()
	{
		return SSDResEnduranceLabel.isDisplayed();
	}
	
	public boolean SSDRandReadIOPSLabel()
	{
		return SSDResRandomReadIOPS.isDisplayed();
	}
	
	public boolean SSDRandomWriteIOPSLable()
	{
		return SSDResRandomWriteIOPS.isDisplayed();
	}
	
	public boolean SSDRandomMaxReadLabel()
	{
		return SSDResMaxRandomRead.isDisplayed();
	}
	
	public boolean SSDRandomMaxWriteLabel()
	{
		return SSDResMaxRandomWrite.isDisplayed();
	}
	
	public boolean SSDMaxPowerLabel()
	{
		return SSDResMaxPower.isDisplayed();
	}
	
	public boolean SSDNonMainstreamLabel()
	{
		return SSDResNonMainstreamLabel.isDisplayed();
	}
	
	public boolean SSDMainstreamLabel()
	{
		return SSDResMainstreamLabel.isDisplayed();
	}
	// Select All Elements In Result Page
	
	public boolean SelectAllWorkloadResultPage()
	{
		JavascriptExecutor WorkloadScrollUp = (JavascriptExecutor)driver;
		WorkloadScrollUp.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
		if(SSDResVRO.isSelected() & SSDResReadIntensive.isSelected() & SSDResMixedUse.isSelected() & SSDResWriteIntensive.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean SelectAllInterfaceResultPage()
	{
		if(SSDResInterfaceSATAVRO.isSelected() & SSDResInterfaceSATA.isSelected() & SSDResInterfaceValueSAS.isSelected() & SSDResInterfaceNVMeHigh.isSelected() & SSDResInterfaceNVMeMainstream.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean SelectAllFactorFactorResultPage()
	{
		if(SSDResFFSFF.isSelected() & SSDResFFAIC.isSelected() & SSDResM2E.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean CertificationResultPage()
	{
		if(SSDResCerMS2016.isSelected() & SSDResCerMS2019.isSelected() & SSDResCerSDDC2016.isSelected() & SSDResCerSDDC2019.isSelected() & SSDResCerVSAN.isSelected())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean BestAvailabilityResults()
	{
		if(SSDResMainstream.isSelected() & SSDResNonMainstream.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean SSDResultSelectALL()
	{
		return SSDResSelectAll.isSelected();
	}
	
	public void SSDResultSelectAllSelected()
	{
		JavascriptExecutor SSDSelectAll = (JavascriptExecutor)driver;
		SSDSelectAll.executeScript("arguments[0].click()", SSDResSelectAll);
		SSDResultResetMessage();
	}
	
	public void SSDResultResetMessage()
	{
		/*WebDriverWait AlertMessageDisplayed = new WebDriverWait(driver, 1);
		boolean AlertMessage = AlertMessageDisplayed.until(ExpectedConditions.textToBePresentInElement(SSDResultResertAlertMessage, Prop.getProperty("ResetAlertMessage")));
		String ActualResetAlertMessage = Prop.getProperty("ResetAlertMessage");
		String ExpcetedResetAlertMessage = SSDResultResertAlertMessage.getText();
		System.out.println("Reset Alert Message :-" + ExpcetedResetAlertMessage);
		// Click on Yes Btn in Alert Message 
		Assert.assertEquals(ActualResetAlertMessage, ExpcetedResetAlertMessage);*/
		SSDResultResetYes.click();
	}
	
	public void SSDResultClickNoOnResetMessage()
	{
		/*String ActualResetAlertMessage = "You are performing a reset on the data selected. Are you sure you want to reset your selection(s)?";
		String ExpcetedResetAlertMessage = SSDResultResertAlertMessage.getText();
		System.out.println("Reset Alert Message :-" + ExpcetedResetAlertMessage);
		// Click on Yes Btn in Alert Message 
		Assert.assertEquals(ActualResetAlertMessage, ExpcetedResetAlertMessage);*/
		SSDResultResetNo.click();
	}
	
	public void SSDResultNonMainstream()
	{
		// Click on Non-Mainstream,To View the Mainstream SSDs
		JavascriptExecutor SSDNonMainstream = (JavascriptExecutor)driver;
		SSDNonMainstream.executeScript("arguments[0].click()", SSDResNonMainstream);
	}
	
	public void SSDResultMainstream()
	{
		JavascriptExecutor SSDMainstream = (JavascriptExecutor)driver;
		SSDMainstream.executeScript("arguments[0].click()", SSDResMainstream);
	}
	
	public void SSDResultAlertMessageDisplayed()
	{
		String ActualAlertMessageText = Prop.getProperty("AlertMessageText");
		String ExpectedAlertMessage = SSDResultAlertMessageBox.getText();
		System.out.println("Alert Message Display:-" + ExpectedAlertMessage);
		Assert.assertEquals(ActualAlertMessageText, ExpectedAlertMessage);
		if(SSDResultAlertMessageBox.isDisplayed())
		{
			SSDResultAlertMessageOK.click();
			//return true;
		}
	}
	
	public void SSDResultPriceLink()
	{
		String SSDMainWindow = driver.getWindowHandle();
		SSDResPriceLink.click();
		String ActualPriceURLPageTitle = Prop.getProperty("PriceURLPageTitle");
		String ExpectedPriceURLPageTitle = driver.getTitle();
		System.out.println("Price URL Link Page Title :- " + ExpectedPriceURLPageTitle);
		Assert.assertEquals(ActualPriceURLPageTitle, ExpectedPriceURLPageTitle);
		driver.switchTo().window(SSDMainWindow);
	}
	
	public void SSDResultShowmoreLink()
	{
		SSDResultShowmoreLink.click();
		System.out.println("Successfully Clicked on Show More Link In SSD Result Page");
	}
	
	public void SSDResultExcelDownload()
	{
		
	}
	
	public void SSDResultCSVDownload()
	{
		
	}
	
	// Only Read Intensive Workload Selected from the Workload page
	
	public boolean SSDReadWorkloadSelected()
	{
		if(SSDResVRO.isSelected() & SSDResMixedUse.isSelected() & SSDResWriteIntensive.isSelected())
		{
			return SSDResReadIntensive.isSelected();
		}
		else
		{
			return false;
		}
	}
	
	//Read Intensive Workloads Selected ,Selected Interfaces as below
	public boolean SSDIntensiveTypeSelected()
	{
		if(SSDResInterfaceSATA.isSelected() & SSDResInterfaceSAS.isSelected() & SSDResInterfaceValueSAS.isSelected() & SSDResInterfaceNVMeHigh.isSelected() & SSDResInterfaceNVMeMainstream.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Read Intensive Workloads Selected ,Selected Form Factor as below
	public boolean SSDFormFactorTypeSelected()
	{
		if(SSDResFFLFF.isSelected() & SSDResFFSFF.isSelected() & SSDResM2.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean BestCatergorySelected()
	{
		if(SSDResMainstream.isSelected() & SSDResNonMainstream.isSelected())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	//Read Intensive Workloads Selected ,Selected Server Type as below
	public void ReadSelectedResultPageServerType()
	{
		Select SSDResServerType = new Select(SSDResSelectServerType);
		WebElement ResultServerType = SSDResServerType.getFirstSelectedOption();
		String ExpectedServerType = ResultServerType.getText();
		String ActualServerType = "HPE ProLiant 500 Series";
		Assert.assertEquals(ActualServerType,ExpectedServerType);
	}
	
	//Read Intensive Workloads Selected ,Selected Server Model as below
	public void ReadSelectedResultPageServerModel()
	{
		Select SSDResServerModel = new Select(SSDResSelectServerModel);
		WebElement ResultServerModel = SSDResServerModel.getFirstSelectedOption();
		String ExpectedServerModel = ResultServerModel.getText();
		String ActualServerModel = "DL560 Gen10";
		Assert.assertEquals(ActualServerModel, ExpectedServerModel);
	}
	
	//In Result Page, Server type and Server Model changed to please Select Server type
	public void ToChangeServerTypeToPleaseSeverType()
	{
		JavascriptExecutor ScrollUpRefine = (JavascriptExecutor)driver;
		ScrollUpRefine.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
		Select ChangeServerType = new Select(SSDResSelectServerType);
		ChangeServerType.selectByVisibleText("-- Please select server type --");
	}
	
// For Download All SSDs in Excel File, Export CSV
	
	public boolean DownloadExcelFile() throws InterruptedException
	{
		String FileDownloadPath = System.getProperty("user.dir");
		// To Scroll Up browser 
		JavascriptExecutor ResultPageLink = (JavascriptExecutor)driver;
		ResultPageLink.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
		//To click on Export Excel For Downloading SSD in Excel File
		SSDResultExportExcel.click();
		Thread.sleep(1000);
		File ExcelFileDownload = new File (FileDownloadPath+"\\ssdresult.xlsx");
		if(ExcelFileDownload.exists())
		{
			System.out.println("Excel File Downloaded Successfully");
			return true;
		}
		else
		{
			System.out.println("File Not Found");
			return false;
		}
		
	}
	
	public boolean DownloadCSVFile() throws InterruptedException
	{
		String FileDownloadPath = System.getProperty("user.dir");
		// To Scroll Up browser 
		JavascriptExecutor ResultPageLink = (JavascriptExecutor)driver;
		ResultPageLink.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
		//To click on Export Excel For Downloading SSD in Excel File
		SSDResultExportCSV.click();
		Thread.sleep(1000);
		File ExcelFileDownload = new File (FileDownloadPath +"\\ssdresult.csv");
		System.out.println(ExcelFileDownload);
		if(ExcelFileDownload.exists())
		{
			System.out.println(".CSV Downloaded Successfully");
			return true;
		}
		else
		{
			System.out.println("File Not Found");
			return false;
		}
	}
	
	
//For Individual PDF File Download
	public boolean DownloadPDFFile() throws InterruptedException
	{
		String FileDownloadPath = System.getProperty("user.dir");
		// To Scroll Up browser 
		JavascriptExecutor ResultPageLink = (JavascriptExecutor)driver;
		ResultPageLink.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
		//To click on Export Excel For Downloading SSD in Excel File
		SSDIndividualPDFDownload.click();
		Thread.sleep(1000);
		File ExcelFileDownload = new File (FileDownloadPath+"\\SSDResults.pdf");
		if(ExcelFileDownload.exists())
		{
			System.out.println("Individual .pdf Downloaded Successfully");
			return true;
		}
		else
		{
			System.out.println("File Not Found");
			return false;
		}
	}

// For Download All SSDs in Excel File, Export CSV
	public boolean DownloadIndividualExcelFile() throws InterruptedException
		{
			String FileDownloadPath = System.getProperty("user.dir");
			// To Scroll Up browser 
			JavascriptExecutor ResultPageLink = (JavascriptExecutor)driver;
			ResultPageLink.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
			//To click on Export Excel For Downloading SSD in Excel File
			SSDIndividualExcelDownload.click();
			Thread.sleep(1000);
			File ExcelFileDownload = new File (FileDownloadPath+"\\ssdresult.xlsx");
			if(ExcelFileDownload.exists())
			{
				System.out.println("Individual Excel File Downloaded Successfully");
				return true;
			}
			else
			{
				System.out.println("File Not Found");
				return false;
			}
		}
	
	// For Mixed Use workload Selected Interface as below
	
// For Mixed User Workload Selected Form Factor as below.
	public boolean MixedUseSSDFormFactorTypeSelected()
	{
		if(SSDResFFSFF.isSelected() & SSDResFFLFF.isSelected() & SSDResFFAIC.isSelected() & SSDResM2E.isSelected())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

//Mixed Use Workloads Selected ,Selected Server Type as below
	public void MixedUseSelectedResultPageServerType()
		{
			Select SSDResServerType = new Select(SSDResSelectServerType);
			WebElement ResultServerType = SSDResServerType.getFirstSelectedOption();
			String ExpectedServerType = ResultServerType.getText();
			String ActualServerType = "HPE Apollo Systems";
			Assert.assertEquals(ActualServerType,ExpectedServerType);
		}
		
//Mixed Use Workloads Selected ,Selected Server Model as below
	public void MixedUseSelectedResultPageServerModel()
		{
			Select SSDResServerModel = new Select(SSDResSelectServerModel);
			WebElement ResultServerModel = SSDResServerModel.getFirstSelectedOption();
			String ExpectedServerModel = ResultServerModel.getText();
			String ActualServerModel = "Apollo 4500 - XL450 Gen10";
			Assert.assertEquals(ActualServerModel, ExpectedServerModel);
		}
// Mixed Use Max Capacity Value	In Server Type Page
	public void MixedUseSSDCapacityMaxSliderText()
	{
		String ActualMaxCapacitySlider = Prop.getProperty("MixedMaxCapacityValue");
		String ExpectedMaxCapacitySlider = SSDResultPageMaxCapSlider.getText();
		Assert.assertEquals(ActualMaxCapacitySlider, ExpectedMaxCapacitySlider);
	}
// Mixed Use Max Capacity Value	In Result Page
	public void ResultPageMixedUseSSDCapacityMaxSliderText()
	{
		String ActualMaxCapacitySlider = Prop.getProperty("MixedMaxCapacityValue");
		String ExpectedMaxCapacitySlider = SSDResultPageMaxCapSlider.getText();
		Assert.assertEquals(ActualMaxCapacitySlider, ExpectedMaxCapacitySlider);
	}
	
// For Write Intensive Workload Selected Interface Type as below.
		public boolean WriteIntensiveSSDInterfaceTypeSelected()
		{
			if(SSDResInterfaceNVMeHigh.isSelected() &SSDResInterfaceSAS.isSelected())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
// For Write Intensive Workload Selected Form Factor as below.
		public boolean WriteIntensiveSSDFormFactorTypeSelected()
		{
			if(SSDResFFSFF.isSelected() & SSDResFFAIC.isSelected())
			{
				return true;
			}
			else
			{
				return false;
			}
		}

//Write Intensive Workloads Selected ,Selected Server Type as below
		public void WriteIntensiveSelectedResultPageServerType()
			{
				Select SSDResServerType = new Select(SSDResSelectServerType);
				WebElement ResultServerType = SSDResServerType.getFirstSelectedOption();
				String ExpectedServerType = ResultServerType.getText();
				String ActualServerType = "HPE Synergy";
				Assert.assertEquals(ActualServerType,ExpectedServerType);
			}
			
//Write Intensive Workloads Selected ,Selected Server Model as below
		public void WriteIntensiveSelectedResultPageServerModel()
			{
				Select SSDResServerModel = new Select(SSDResSelectServerModel);
				WebElement ResultServerModel = SSDResServerModel.getFirstSelectedOption();
				String ExpectedServerModel = ResultServerModel.getText();
				String ActualServerModel = "Synergy 660 Gen10";
				Assert.assertEquals(ActualServerModel, ExpectedServerModel);
			}
// Write Intensive Max Capacity Value	In Server Type Page
		public void WriteIntensiveSSDCapacityMaxSliderText()
		{
			String ActualMaxCapacitySlider = Prop.getProperty("WriteMaxCapacityValue");
			String ExpectedMaxCapacitySlider = SSDResultPageMaxCapSlider.getText();
			Assert.assertEquals(ActualMaxCapacitySlider, ExpectedMaxCapacitySlider);
		}
// Write Intensive Max Capacity Value	In Result Page
		public void ResultPageWriteIntensiveSSDCapacityMaxSliderText()
		{
			String ActualMaxCapacitySlider = Prop.getProperty("WriteMaxCapacityValue");
			String ExpectedMaxCapacitySlider = SSDResultPageMaxCapSlider.getText();
			Assert.assertEquals(ActualMaxCapacitySlider, ExpectedMaxCapacitySlider);
		}


// For Very Read Optimized Workload Selected Form Factor as below.
		public boolean VeryReadOptimizedSSDFormFactorTypeSelected()
		{
			if(SSDResFFSFF.isSelected() & SSDResFFLFF.isSelected())
				{
					return true;
				}
				else
				{
					return false;
				}
			}

//For Very Read Optimized Workloads Selected ,Selected Server Type as below
		public void VeryReadOptimizedSelectedResultPageServerType()
		 {
			Select SSDResServerType = new Select(SSDResSelectServerType);
			WebElement ResultServerType = SSDResServerType.getFirstSelectedOption();
			String ExpectedServerType = ResultServerType.getText();
			String ActualServerType = "HPE ProLiant 300 Series";
			Assert.assertEquals(ActualServerType,ExpectedServerType);
		}
					
//For Very Read Optimized Workloads Selected ,Selected Server Model as below
		public void VeryReadOptimizedSelectedResultPageServerModel()
			{
				Select SSDResServerModel = new Select(SSDResSelectServerModel);
				WebElement ResultServerModel = SSDResServerModel.getFirstSelectedOption();
				String ExpectedServerModel = ResultServerModel.getText();
				String ActualServerModel = "DL325 Gen10";
				Assert.assertEquals(ActualServerModel, ExpectedServerModel);
			}
//For Very Read Optimized Max Capacity Value In Server Type Page
		public void VeryReadOptimizedSSDCapacityMaxSliderText()
			{
				String ActualMaxCapacitySlider = Prop.getProperty("VROMaxCapacityValue");
				String ExpectedMaxCapacitySlider = SSDResultPageMaxCapSlider.getText();
				Assert.assertEquals(ActualMaxCapacitySlider, ExpectedMaxCapacitySlider);
			}
//For Very Read Optimized Max Capacity Value In Result Page
		public void ResultPageVeryReadOptimizedSSDCapacityMaxSliderText()
			{
				String ActualMaxCapacitySlider = Prop.getProperty("VROMaxCapacityValue");
				String ExpectedMaxCapacitySlider = SSDResultPageMaxCapSlider.getText();
				Assert.assertEquals(ActualMaxCapacitySlider, ExpectedMaxCapacitySlider);
			}
		
// I Know What I Need Page
		
		// SSD Workloads
		public boolean ResultPageSSDWorkloads()
		{
			if(SSDResVRO.isSelected() & SSDResReadIntensive.isSelected() & SSDResMixedUse.isSelected() & SSDResWriteIntensive.isSelected())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		// SSD Interface Options
		public boolean ResultPageSSDInterfaceOptions()
		{
			if(SSDResInterfaceSATAVRO.isSelected() & SSDResInterfaceSATA.isSelected() & SSDResInterfaceValueSAS.isSelected() 
					& SSDResInterfaceSAS.isSelected() & SSDResInterfaceNVMeMainstream.isSelected() & SSDResInterfaceNVMeHigh.isSelected())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		// SSD Form Factor Options
		public boolean ResultPageSSDFormFactorOptions()
		{
			if(SSDResFFSFF.isSelected() & SSDResFFLFF.isSelected() & SSDResFFAIC.isSelected() 
					& SSDResM2.isSelected() & SSDResM2E.isSelected())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		// SSD Certifications Options
		public boolean ResultPageSSDCertifications()
		{
			if(SSDResCerVSAN.isSelected() & SSDResCerSDDC2016.isSelected() & SSDResCerSDDC2019.isSelected())
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		
		// SSD Best Availability Options
		public boolean ResultPageSSDBestAvailability()
		{
			if(SSDResMainstream.isSelected() & SSDResNonMainstream.isSelected())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		//SSD SelectAll/UnCheck All Option
		public boolean ResulPageSSDSelectAll()
		{
			return SSDResSelectAll.isSelected();
		}
		
		//Capacity Slider Max Tool Tip Value
		public void CapacitySliderMaxValueToolTip()
		{
			String ActualMaxToolTipValue = Prop.getProperty("ReadMaxCapacityValue");
			String ExpectedMaxToolTipValue = SSDResultPageMaxToolTip.getText();
			Assert.assertEquals(ActualMaxToolTipValue,ExpectedMaxToolTipValue);
		}
		
		//Capacity Slider Min Tool Tip Value
		public void CapacitySliderMinValueToolTip()
		{
			String ActualMinToolTipValue = Prop.getProperty("MinimumCapacityValue");
			String ExpectedMinToolTipValue = SSDResultPageMinToolTip.getText();
			Assert.assertEquals(ActualMinToolTipValue, ExpectedMinToolTipValue);
		}
		
		// SSD Workload Uncheck
		public void UnCheckSSDWorkloads()
		{
			WebDriverWait ToLoadSSD = new WebDriverWait(driver, 3);
			JavascriptExecutor ClickSSDWorkload = (JavascriptExecutor)driver;
			ClickSSDWorkload.executeScript("arguments[0].click()", SSDResVRO);
			ClickSSDWorkload.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
			System.out.println("VRO Workload Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
			boolean loadSSD = ToLoadSSD.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("ReadMixedWriteSSDs")));
			if(loadSSD == true)
			{
				ClickSSDWorkload.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
				ClickSSDWorkload.executeScript("arguments[0].click()", SSDResReadIntensive);
				ClickSSDWorkload.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
				System.out.println("VRO,Read Intensive Workload Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
				loadSSD = ToLoadSSD.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("MixedWriteSSDs")));
				if(loadSSD == true)
				{
					ClickSSDWorkload.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
					ClickSSDWorkload.executeScript("arguments[0].click()", SSDResMixedUse);
					ClickSSDWorkload.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
					System.out.println("VRO, Read Intensive, Mixed Use Workload Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
					loadSSD = ToLoadSSD.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("WriteSSDs")));
					System.out.println("Write Intensive :- " + SSDResResultDisplayLink.getText());
					if(loadSSD == true)
					{
						ClickSSDWorkload.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
						ClickSSDWorkload.executeScript("arguments[0].click()", SSDResWriteIntensive);
						ClickSSDWorkload.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
						System.out.println("VRO, Read Intensive, Mixed Use and Write Intensive Workload Is Deselected, Then Total SSDs Results :- " + SSDResResultDisplayLink.getText());
						loadSSD = ToLoadSSD.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
						System.out.println("Total SSDs :- " + SSDResResultDisplayLink.getText());
					}		
				}
			}
		}
		
		// SSD Interface UnCheck
		public void UnCheckSSDInterface()
		{
			WebDriverWait LoadInterface = new WebDriverWait(driver, 2);
			JavascriptExecutor ClickInterface = (JavascriptExecutor)driver;
			System.out.println("Interface Options Are Deselecting To Verfiy The Filtering Is Working With respect to Functionality");
			ClickInterface.executeScript("arguments[0].click()", SSDResInterfaceSATAVRO);
			ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
			System.out.println("Interface Type :- SATAVRO  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
			boolean InterfaceLoad = LoadInterface.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("SATAValueSASSASNVMeMainstreamNVMeHighPerformance")));
			if(InterfaceLoad == true)
			{
				ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
				ClickInterface.executeScript("arguments[0].click()", SSDResInterfaceSATA);
				ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
				System.out.println("Interface Type :- SATAVRO,SATA  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
				InterfaceLoad = LoadInterface.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("ValueSASSASNVMeMainstreamNVMeHighPerformance")));
				if(InterfaceLoad == true)
				{
					ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
					ClickInterface.executeScript("arguments[0].click()",SSDResInterfaceValueSAS);
					ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
					System.out.println("Interface Type :- SATAVRO,SATA,VALUESAS  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
					InterfaceLoad = LoadInterface.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("SASNVMeMainstreamNVMeHighPerformance")));
					if(InterfaceLoad == true)
					{
						ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
						ClickInterface.executeScript("arguments[0].click()",SSDResInterfaceSAS);
						ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
						System.out.println("Interface Type :- SATAVRO,SATA,VALUESAS,SAS  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
						InterfaceLoad = LoadInterface.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("NVMeMainstreamNVMeHighPerformance")));
						if(InterfaceLoad == true)
						{
							ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
							ClickInterface.executeScript("arguments[0].click()",SSDResInterfaceNVMeMainstream);
							ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
							System.out.println("Interface Type :- SATAVRO,SATA,VALUESAS,SAS,NVMeMainstream  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
							InterfaceLoad = LoadInterface.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("NVMeHighPerformance")));
							if(InterfaceLoad == true)
							{
								ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
								ClickInterface.executeScript("arguments[0].click()",SSDResInterfaceNVMeHigh);
								ClickInterface.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
								System.out.println("Interface Type :- SATAVRO,SATA,VALUESAS,SAS,NVMeMainstream and NVMeHigh Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
								InterfaceLoad = LoadInterface.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
							}
						}
					}
				}
			}
		}
		
	// SSD Form Factor UnCheck
	public void UnCheckFormFactor()
	{
		WebDriverWait LoadFormFactor = new WebDriverWait(driver, 2);
		JavascriptExecutor ClickFormFactor = (JavascriptExecutor)driver;
		System.out.println("Form Factor Options Are Deselecting To Verfiy The Filtering Is Working With respect to Functionality");
		ClickFormFactor.executeScript("arguments[0].click()", SSDResFFSFF);
		ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
		System.out.println("FormFactor Type :- 2.5SFF  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
		boolean FormFactorLoad = LoadFormFactor.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("3.5LFFAddInCardM2M2e")));
		if(FormFactorLoad == true)
		{
			ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
			ClickFormFactor.executeScript("arguments[0].click()", SSDResFFLFF);
			ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
			System.out.println("FormFactor Type :- 2.5SFF,3.5LFF  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
			FormFactorLoad = LoadFormFactor.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("AddInCardM2M2e")));
			if(FormFactorLoad == true)
			{
				ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
				ClickFormFactor.executeScript("arguments[0].click()", SSDResFFAIC);
				ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
				System.out.println("FormFactor Type :- 2.5SFF,3.5LFF,Add-In Card  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
				FormFactorLoad = LoadFormFactor.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("M2M2e")));
				if(FormFactorLoad == true)
				{
					ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
					ClickFormFactor.executeScript("arguments[0].click()", SSDResM2);
					ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
					System.out.println("FormFactor Type :- 2.5SFF,3.5LFF,Add-In Card,M.2  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
					FormFactorLoad = LoadFormFactor.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("M2e")));
					if(FormFactorLoad == true)
					{
						ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResRefineResults);
						ClickFormFactor.executeScript("arguments[0].click()", SSDResM2E);
						ClickFormFactor.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
						System.out.println("FormFactor Type :- 2.5SFF,3.5LFF,Add-In Card,M.2, and M.2E Kit  Is Deselected, Remaining SSDs Results :- " + SSDResResultDisplayLink.getText());
						FormFactorLoad = LoadFormFactor.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("TotalSSDSs")));
					}
				}
			}
		}
	}
	
	// SSD Best Availability UnCheck
	public void UnCheckBestAvailability()
	{
		WebDriverWait LoadBestAvailability = new WebDriverWait(driver, 2);
		JavascriptExecutor ClickBestAvailability = (JavascriptExecutor)driver;
		System.out.println("Best Availability Option Are Deselecting To Verfiy The Filtering Is Working With respect to Functionality");
		// Click on NonMainStream
		ClickBestAvailability.executeScript("arguments[0].click()", SSDResMainstream);
		ClickBestAvailability.executeScript("arguments[0].scrollIntoView();", SSDResResultDisplayLink);
		boolean BestAvailability = LoadBestAvailability.until(ExpectedConditions.textToBePresentInElement(SSDResResultDisplayLink, Prop.getProperty("NonMainsteam")));
		if(BestAvailability == true)
		{
			String ActuaNonMainStreamSSDs = Prop.getProperty("NonMainsteam");
			String ExpectedNonMainStreamSSDs = SSDResResultDisplayLink.getText();
			Assert.assertEquals(ActuaNonMainStreamSSDs, ExpectedNonMainStreamSSDs);
		}
	}
	
	// VRO SSD Results Verify
	public boolean VerifyVROResults()
	{
		if(SSDOnlyMixedUseResults.isDisplayed() & SSDOnlyReadIntensiveResults.isDisplayed() & SSDOnlyWriteIntensiveResults.isDisplayed())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	//Read Intensive SSD Results Verify
	public boolean VerifyReadIntensive()
	{
			return SSDOnlyReadIntensiveResults.isDisplayed();
	}
	
	//Mixed Use SSD Results Verify
	public boolean VerifyMixedUse()
	{
		return SSDOnlyMixedUseResults.isDisplayed();
	}
	
	//Write Intensive SSD Results Verify
	public boolean VerifyWriteIntensive()
	{
		return SSDOnlyWriteIntensiveResults.isDisplayed();
	}
	
	//SATAVRO Interface SSD Result Verify
	public boolean VerifyInterfaceSATAVRO()
	{
		return SSDOnlyVROResults.isDisplayed();
	}
	
	//SATA Interface SSD Results Verify
	public boolean VerifyInterfaceSATA()
	{
		return SSDOnlySATAInterfaceResults.isDisplayed();
	}
	
	//VALUESAS Interface SSD Results Verify
	public boolean VerifyInterfaceVALUESAS()
	{
		return SSDOnlyValueSASInterfaceResults.isDisplayed();
	}
	
	//SAS Interface SSD Results Verify
	public boolean VerifyInterfaceSAS()
	{
		return SSDOnlySASInterfaceResults.isDisplayed();
	}
	
	//NVMe Mainstream Interface SSD Results Verify
	public boolean VerifyInterfaceNVMeMainstream()
	{
		return SSDOnlyNVMeMainstreamInterfaceResults.isDisplayed();
	}
	
	//NVMe HighPerformance Interface SSD Results Verify
	public boolean VerifyInterfaceNVMeHighPerformance()
	{
		return SSDOnlyNVMeHighPerformanceInterfaceResults.isDisplayed();
	}
	
	//2.5 Form Factor SSD Results Verify
	public boolean VerifyFormFactor25SFF()
	{
		return SSDOnlySFFFormFactorResults.isDisplayed();
	}
	
	//3.5 LFF Form Factor SSD Results Verify
	public boolean VerifyFormFactor35LFF()
	{
		return SSDOnlyLFFFormFactorResults.isDisplayed();
	}
	
	//Add-In-Card Form Factor SSD Results Verify
	public boolean VerifyFormFactorAddInCard()
	{
		return SSDOnlyAICFormFactorResults.isDisplayed();
	}
	
	//M2 Form Factor SSD Results Verify
	public boolean VerifyM2()
	{
		return SSDOnlyM2Results.isDisplayed();
	}
	
	//M2E Form Factor SSD Results Verify
	public boolean VerifyM2E()
	{
		return SSDOnlyM2EResults.isDisplayed();
	}
	
	// Move the Slider From Max to Middle
	public void SliderMoveFromMaxtoMiddle()
	{
		Actions MoveMaxtoMiddle = new Actions(driver);
		try
		{
			MoveMaxtoMiddle.clickAndHold(SSDResultPageMaxToolTip).click(SSDResSliderRange);
			MoveMaxtoMiddle.release(SSDResSliderRange).perform();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	//For No SSD Message is Displayed
	public boolean NoSSDResultMessageDisplay()
	{
		return SSDResNoSSDMessageDisplay.isDisplayed();
	}
	
	// For VRO ,Mixed Use and Write Intensive Workloads, Selected Server Type Showed In Result page
	public void VROMixedUseWriteServerType()
	{
		Select VROMUWIServerType = new Select(SSDResSelectServerType);
		WebElement SelectedServerType = VROMUWIServerType.getFirstSelectedOption();
		String ExpectedSelectedServerType = SelectedServerType.getText();
		String  ActualSelectedServerType = Prop.getProperty("VROMixedWriteIntensiveServerType");
		Assert.assertEquals(ActualSelectedServerType, ExpectedSelectedServerType);
	}
	
	//For VRO ,Mixed Use and Write Intensive Workloads, Selected Server Model Showed In Result page
	public void VROMixedUseWriteServerModel()
	{
		Select VROMuWIServerModel = new Select(SSDResSelectServerModel);
		WebElement SelectedServerModel = VROMuWIServerModel.getFirstSelectedOption();
		String ExpectedSelectedServerModel = SelectedServerModel.getText();
		String ActualSelectedServerModel = Prop.getProperty("VROMixedWriteIntensiveServerModel");
		Assert.assertEquals(ActualSelectedServerModel, ExpectedSelectedServerModel);
	}
}
