package hpessdPageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import hpessdResource.BaseClass;

public class SSDWorkloadPage extends BaseClass
{
	//Declarations
			//@FindBy (css = "span#check-box-label")
			//To Learn More Workload
			@FindBy(xpath = "//*[@id=\"ssdSelector\"]/section/section[1]/div/div[1]/div/div/a")
			WebElement LearnMoreWorkloadPDF;
			
			//@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Active Archiving']")
			//WebElement SelectReadWorkload;
			
			//To find Read Intensive 
			@FindBy (xpath = "//div[@id=\"disp_col_0\"]//span[@id=\"check-box-label\"]")
			//@FindBy (id = "ssd-workload_ri")
			WebElement ReadCheck;
			
			//To find Read Intensive Label
			@FindBy (xpath = "//*[@id=\"disp_col_0\"]/div[2]")
			public WebElement ReadIntensiveLabel;
			
			//To find Mixed Intensive
			@FindBy (xpath = "//div[@id=\"disp_col_1\"]//span[@id=\"check-box-label\"]")
			WebElement MixedCheck;
			
			//To find Mixed Intensive Label
			@FindBy (xpath = "//*[@id=\"disp_col_1\"]/div[2]")
			public WebElement MixedIntensiveLabel;
			
			//To find Write Intensive
			@FindBy (xpath = "//div[@id=\"disp_col_3\"]//span[@id=\"check-box-label\"]")
			WebElement WriteCheck;
			
			//To find Write Intensive Label
			@FindBy (xpath = "//*[@id=\"disp_col_3\"]/div[2]")
			public WebElement WriteIntensiveLabel;
			
			//To find VRO Intensive
			@FindBy (xpath = "//div[@id=\"disp_col_0\"]//span[@id=\"check-box-label\"]")
			WebElement VROCheck;
			
			//To find VRO Intensive Label
			@FindBy (xpath = "//*[@id=\"disp_col_3\"]/div[2]")
			public WebElement VROIntensiveLabel;
			
			//Single Workload Selecting  for Read Intensive
			@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Active Archiving']")
			public WebElement SelectReadWorkload;
			
			// Single Workload Selecting  for Mixed Use
			@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Business Processing']")
			public WebElement SelectMixedWorkload;
			
			// Single Workload Selecting  for Write Intensive
			@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='Big Data Analytics']")
			public WebElement SelectWriteWorkLoad;
			
			// Single Workload Selecting  for VRO
			@FindBy (xpath = "//span[@id=\"check-box-label\"]/span[text()='AI']")
			public WebElement SelectVROWorkLoad;
					
			@FindBy (xpath = "//button[@id=\"nextQuestion_btn\"]")
			WebElement NextBtn;
			
			@FindBy(xpath = "//*[@id=\"backQuestion_btn\"]")
			WebElement WorkLoadBackBtn;
			
			// Select All 
			@FindBy (xpath = "//*[@id=\"ssd-iDontKnow\"]")
			public WebElement WorkloadSelectAll;
			
			// Page Menu Bar
			@FindBy(xpath = "//*[@id=\"workload\"]")
			public
			WebElement SSDMenubarWorkload;
			
			// Individual Workloads 
			
			@FindBy(xpath = "//*[@id=\"check-box-label\"]/span[text()='AI']")
			WebElement SSDVROWorkload;
			
			@FindBy(xpath = "//*[@id=\"check-box-label\"]/span[text()='Active Archiving']")
			WebElement SSDReadIntensiveWorkload;
			
			@FindBy(xpath = "//*[@id=\"check-box-label\"]/span[text()='Business Processing']")
			WebElement SSDMixedUseWorkload;
			
			@FindBy(xpath = "//*[@id=\"check-box-label\"]/span[text()='Big Data Analytics']")
			WebElement SSDWriteIntensiveWorkload;
			
			// Workload Columns 
			
			@FindBy(xpath = "//*[@id=\"disp_col_0\"]")
			public
			WebElement SSDVROColumn;
			
			@FindBy(xpath = "//*[@id=\"disp_col_1\"]")
			public
			WebElement SSDReadColumn;
			
			@FindBy(xpath = "//*[@id=\"disp_col_2\"]")
			public
			WebElement SSDMixedColumn;
			
			@FindBy(xpath = "//*[@id=\"disp_col_3\"]")
			public
			WebElement SSDWriteColumn;
			
			
			//Intialization
			public SSDWorkloadPage()
			{
				PageFactory.initElements(driver, this);
			}
			
			public void CoordinatesofWorkloads()
			{
				int VROXaxis = SSDVROWorkload.getLocation().getX();
				int VROYaxis = SSDVROWorkload.getLocation().getY();
				
				System.out.println("VRO XAxis :-" + VROXaxis);
				System.out.println("VRO YAxis :-" + VROYaxis);
				
				//
				int VROX = SSDVROColumn.getLocation().getX();
				int VROY = SSDVROColumn.getLocation().getY();
				
				System.out.println("VRO X Column :-" + VROX);
				System.out.println("VRO Y Column :-" + VROY);
				
				// Write Intensive
				int WIX = SSDWriteColumn.getLocation().getX();
				int WIY = SSDWriteColumn.getLocation().getY();
				
				System.out.println("Write X Column :-" + WIX);
				System.out.println("Write Y Column :-" + WIY);
				
				//Read Intensive
				int RIX = SSDReadColumn.getLocation().getX();
				int RIY = SSDReadColumn.getLocation().getY();
				
				System.out.println("Read X Column :-" + RIX);
				System.out.println("Read Y Column :-" + RIY);
				
				//Mixed Use
				int MUX = SSDMixedColumn.getLocation().getX();
				int MUY = SSDMixedColumn.getLocation().getY();
				
				System.out.println("Mixed X Column :-" + MUX);
				System.out.println("Mixed Y Column :-" + MUY);

				
			}
			
			// VRO Coordinates
			public boolean CoordinatesofVROWorkloads()
			{
				int VROX = SSDVROColumn.getLocation().getX();
				int ExpectedVeryReadOptimizedX = -104;
				if(VROX == ExpectedVeryReadOptimizedX)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			// Write Intensive Coordinates
			public boolean CoordinatesofWriteIntensiveWorkloads()
			{
				int WriteIntensiveX = SSDWriteColumn.getLocation().getX();
				int ExpectedWriteIntensiveX = -967;
				if(WriteIntensiveX == ExpectedWriteIntensiveX)
				{
					return true;
				}
				else
				{
					return false;
				}
				
			}
			
			// Read Intensive Coordinates
			public boolean CoordinatesofReadIntensiveWorkloads()
			{
				int ReadIntensiveX = SSDReadColumn.getLocation().getX();
				int ExpectedReadIntensiveX = -391;
				if(ReadIntensiveX == ExpectedReadIntensiveX)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			//Mixed Use Coordinates
			public boolean CoordinatesofMixedUseWorkloads()
			{
				int MixedUseX = SSDMixedColumn.getLocation().getX();
				int ExpectedMixedUseX = -679;
				if(MixedUseX == ExpectedMixedUseX)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			public boolean WorkloadComponents()
			{
				if(SSDVROColumn.isDisplayed() & SSDReadColumn.isDisplayed() & SSDMixedColumn.isDisplayed() & SSDWriteColumn.isDisplayed() & LearnMoreWorkloadPDF.isDisplayed() & WorkLoadBackBtn.isEnabled())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			
			public boolean WorkloadPageComponentsNotSelected()
			{
				//System.out.println("Select All Option is Not Selected :- " + WorkloadSelectAll.isSelected());
				return WorkloadSelectAll.isSelected();
			}
			public void ClickWorkload()
			{
				SelectReadWorkload.click();
			}
			
			public void ClickMixedWorkload()
			{
				SelectMixedWorkload.click();
			}
			
			public void ClickWriteWorkload()
			{
				SelectWriteWorkLoad.click();
			}
			// Clicking Next Button in the Workload Page
			public void ClickNextBtn()
			{
				NextBtn.click();
			}
			
			public boolean UnClickNextBtn()
			{
					if (NextBtn.isEnabled())
					{
						//System.out.println("Next is  Selected");
					}
					else
					{
						System.out.println("Next is not Selected");
					}
					return false;
				
			}
			public boolean IsClicked()
			{
				return ReadCheck.isSelected();
			}
			public void SelectReadALL()
			{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//*[@id=\"ssd-workload_ri\"]"));
				int TotalCheckbox = AllCheckboxes.size();
				Actions Mousemove = new Actions(driver);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)");
				System.out.println("Total Number of Read Intensive Workloads Selected " + TotalCheckbox);
				int i=0;
				i = TotalCheckbox;
					for(WebElement Checkbox : AllCheckboxes)
						{		
								jse.executeScript("arguments[0].click()", Checkbox);
							  // Checkbox.click();
							   i++;
						}
			}
			public boolean NextButtonEnabled()
			{
				return NextBtn.isEnabled();
				
			}
			public void WorkloadPDF()
			{
				LearnMoreWorkloadPDF.click();
				String WorkloadMainWindow = driver.getWindowHandle();
				Set<String> PDFFileOpened = driver.getWindowHandles();
				Iterator<String> PDFI1 = PDFFileOpened.iterator();
				while(PDFI1.hasNext())
				{
					String PDFFileChild = PDFI1.next();
					if(!WorkloadMainWindow.equalsIgnoreCase(PDFFileChild))
					{
						driver.switchTo().window(PDFFileChild);
						driver.getCurrentUrl();
						String ActualString = Prop.getProperty("PDFPage"); //"https://ssdhpestage.azurewebsites.net//content/resource/The%20Pan-HPE%20Workloads%20Taxonomy.pdf";
						String ExpectedString = driver.getCurrentUrl();
						Assert.assertEquals(ActualString,ExpectedString);
						System.out.println("Learn About Workload PDF File Is Opened");
						driver.close();	
					}
				}
				driver.switchTo().window(WorkloadMainWindow);
				//String ActualString = "https://ssdhpestage.azurewebsites.net//content/resource/The%20Pan-HPE%20Workloads%20Taxonomy.pdf";
				//String ExpectedString = driver.getCurrentUrl();
				//Assert.assertEquals(ActualString,ExpectedString);
				
			}
			public void DeslectReadAll()
			{
				SelectReadALL();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_1\"]//span[@id=\"check-box-label\"]"));
				int TotalCheckbox = AllCheckboxes.size();
				System.out.println("Total Number of Read Intensive Workloads are Delselected" + TotalCheckbox);
				int j ;
				j = TotalCheckbox;
					for(WebElement Checkbox : AllCheckboxes)
						{ 
							Checkbox.click();
							j++;
						}
				
			}
			
			// For De selecting the Read Intensive Workloads
			public void DeselectReadIntensiveWorkload()
			{
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_1\"]//span[@id=\"check-box-label\"]"));
				int TotalCheckbox = AllCheckboxes.size();
				System.out.println("Total Number of Read Intensive Workloads are Delselected" + TotalCheckbox);
				int j ;
				j = TotalCheckbox;
					for(WebElement Checkbox : AllCheckboxes)
						{ 
							Checkbox.click();
							j++;
						}
			}
			// For Selecting "Select All/I Don't Yet" Option in Workload Page
			public void WorkloadPageSelectAll()
			{
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click()", WorkloadSelectAll);
			}
			
			public void SelectMixedALL()
			{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_2\"]//span[@id=\"check-box-label\"]"));
				int TotalCheckbox = AllCheckboxes.size();
				Actions Mousemove = new Actions(driver);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)");
				System.out.println("Total Number of Mixed USe Intensive Workload are " + TotalCheckbox);
				int i = TotalCheckbox;
					for(WebElement Checkbox : AllCheckboxes)
						{		
							jse.executeScript("arguments[0].click()", Checkbox);
							//Checkbox.click();
							   i++;  
						}
			}
			
			public void SelectWriteALL()
			{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_3\"]//span[@id=\"check-box-label\"]"));
				int TotalCheckbox = AllCheckboxes.size();
				//Actions Mousemove = new Actions(driver);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)");
				System.out.println("Total Number of WRITE Intensive Workload are " + TotalCheckbox);
				int i = TotalCheckbox;
				for(WebElement Checkbox : AllCheckboxes)
					{		
						jse.executeScript("arguments[0].click()", Checkbox);
						//Checkbox.click();
						i++;	   
					}
			}
			public void SelectVROALL()
			{
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//div[@id=\"disp_col_0\"]//span[@id=\"check-box-label\"]"));
				int TotalCheckbox = AllCheckboxes.size();
				//Actions Mousemove = new Actions(driver);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("scroll(0, 250)");
				System.out.println("Total Number of Very Read Optimized Workloads are " + TotalCheckbox);
				int i = TotalCheckbox;
					for(WebElement Checkbox : AllCheckboxes)
						{		
							jse.executeScript("arguments[0].click()", Checkbox);
							//Checkbox.click();
							i++;   
						}
			}
			public void AllWorkloadSelect()
			{
				SelectReadWorkload.click();
				SelectMixedWorkload.click();
				SelectWriteWorkLoad.click();
				SelectVROWorkLoad.click();
				System.out.println("All Types of Workload Selected from Column Such as Read Intensive , Mixed Use, Write Intensive and Very Read Optimization");
			}
			
			// To Verify All Read Intensive Workloads are selected
			public boolean VerifyAllReadIntensiveSelected()
			{
				List<WebElement> CheckBoxEnabled = driver.findElements(By.xpath("//*[@id=\"ssd-workload_ri\"]"));
				int TotalCheckBoxSelected = CheckBoxEnabled.size();
				int i = TotalCheckBoxSelected, count = 0;
				for (WebElement CheckBoxSelected : CheckBoxEnabled)
				{
					//System.out.println(CheckBoxSelected.isSelected());
					CheckBoxSelected.isSelected();
					count++;
					//System.out.println("Value of i "+count);
				}
				if(count==TotalCheckBoxSelected)
				{
					return true;
				}
				else
					return false;
				
			}
			
			// To Verify All Mixed Use Workloads are Selected
			public boolean VerifyMixedUseWorkloadsSelected()
			{
				List<WebElement> CheckBoxEnabled = driver.findElements(By.xpath("//*[@id=\"disp_col_2\"]"));
				int TotalCheckBoxSelected = CheckBoxEnabled.size();
				int i = TotalCheckBoxSelected, count = 0;
				for (WebElement CheckBoxSelected : CheckBoxEnabled)
				{
					//System.out.println(CheckBoxSelected.isSelected());
					CheckBoxSelected.isSelected();
					count++;
					//System.out.println("Value of i "+count);
				}
				if(count==TotalCheckBoxSelected)
				{
					return true;
				}
				else
					return false;
			}
			
			// To Verify All Write Intensive Workloads are Selected
				public boolean VerifyWriteIntensiveWorkloadsSelected()
					{
						List<WebElement> CheckBoxEnabled = driver.findElements(By.xpath("//*[@id=\"disp_col_3\"]"));
						int TotalCheckBoxSelected = CheckBoxEnabled.size();
						int i = TotalCheckBoxSelected, count = 0;
						for (WebElement CheckBoxSelected : CheckBoxEnabled)
						{
							//System.out.println(CheckBoxSelected.isSelected());
							CheckBoxSelected.isSelected();
							count++;
							//System.out.println("Value of i "+count);
						}
						if(count==TotalCheckBoxSelected)
						{
							return true;
						}
						else
							return false;
					}
				
				// To Verify All Write Intensive Workloads are Selected
				public boolean VerifyVeryReadOptimizedWorkloadsSelected()
					{
						List<WebElement> CheckBoxEnabled = driver.findElements(By.xpath("//*[@id=\"disp_col_0\"]"));
						int TotalCheckBoxSelected = CheckBoxEnabled.size();
						int i = TotalCheckBoxSelected, count = 0;
						for (WebElement CheckBoxSelected : CheckBoxEnabled)
						{
							//System.out.println(CheckBoxSelected.isSelected());
							CheckBoxSelected.isSelected();
							count++;
							//System.out.println("Value of i "+count);
						}
						if(count==TotalCheckBoxSelected)
						{
							return true;
						}
						else
							return false;
					}	
			
			public boolean SelectAllOption()
			{
				return WorkloadSelectAll.isSelected();
			}
			
			public boolean MenubarWorkload()
			{
				return SSDMenubarWorkload.isEnabled();
			}
			
			public void BackBtn()
			{
				WorkLoadBackBtn.click();
			}
			
			
}
