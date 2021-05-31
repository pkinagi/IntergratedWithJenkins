package hpessdResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseClass implements ConfigPath
{
	public static WebDriver driver;
	public static Properties Prop;
	public String ConfigurationPath = ".\\src\\main\\java\\config\\Config.Properties";
	public String ConfigurationStgPath = ".\\src\\main\\java\\config\\ConfigStg.Properties";
	public String ConfigurationNewStgPath = ".\\src\\main\\java\\config\\ConfigNewStg.Properties";
	public static EventFiringWebDriver e_driver;
	
	
	
	public BaseClass()
	{
		;
		try
		{
			Prop = new Properties();
			FileInputStream ConfigFile  = new FileInputStream(ConfigurationNewStgPath);
			Prop.load(ConfigFile);	
		}
		
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void Intialization()
	{
		//workbook = new HSSFWorkbook();
		//sheet = workbook.createSheet("Test Results");
		//testresultdata = new LinkedHashMap<String, Object[]>();
		//testresultdata.put("1", new Object[] {"Test ID", "Action", "Excepted Results", "Actual Results"});
		
		// If below Line is commented means, This is Project can be run through Jenkins Console. 
		//If u want to run in eclipse, Uncomment it and Save it Build the Project.
		
		//String Browsername = Prop.getProperty("browser");
		
		// To Integration with Jenkins for Selecting the Browser 
		//mvn test -DBrowsername=chrome
		
		String Browsername = System.getProperty("browser");
		// The above line is uncomment, Then we need run this project in Jenkins Console.
		String FileDownloadPath = System.getProperty("user.dir");
		HashMap<String,Object> chromPerfs = new HashMap<String, Object>();
		chromPerfs.put("profile.default_content_settings.popups",0);
		chromPerfs.put("download.default_directory",FileDownloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs",chromPerfs);
		if(Browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			driver = new ChromeDriver(options);	
		}
		else if (Browsername.equals("MicrosoftEdge"))
		{
			System.setProperty("webdriver.edge.driver", ".\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if (Browsername.equals("Firefox"))
		{
			FirefoxOptions optionsFF = new FirefoxOptions();
			ProfilesIni allProfiles = new ProfilesIni();
			FirefoxProfile selenium_Profile = allProfiles.getProfile("QATest");
			optionsFF.setProfile(selenium_Profile);
			optionsFF.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
		//	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(optionsFF);
		}
		e_driver = new EventFiringWebDriver(driver);
		driver = e_driver;
		driver.manage().window().maximize();  // Maximize the Window
		driver.manage().deleteAllCookies();   // Delete the Cookies in the Browser
		System.out.println("------!!Specified URL is Launched in the Browser!!-------------");
		driver.get(Prop.getProperty("URL"));   // For Launching the URL
	}
	// For Failed Test Cases Taking Screen Shot
	public String TakeScreenShot(String testCaseName,WebDriver driver) throws IOException
	{
		Date dt = new Date();
		String CurrentDate = dt.toString().replace(":", "_");
		File SrcFile = (File) (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));
		String DestinationFile = System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png";
		FileUtils.copyFile(SrcFile, new File (DestinationFile));
		return DestinationFile;
	}
	
	
/*	public String TakeScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		Date dt = new Date();
		String CurrentDate = dt.toString().replace(":", "_");
		//TakesScreenshot TakeScreen = (TakesScreenshot) driver;
		//File SrcFile = TakeScreen.getScreenshotAs(OutputType.FILE);
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String DestinationFile = System.getProperty("user.dir")+"\\Reports\\"+testCaseName+".png";
		FileUtils.copyFile(SrcFile, new File(DestinationFile));
		//File DstFile = new File(".\\ScreenShots\\"+CurrentDate+testCaseName+"_ScreenShot.png");
		/*try
		{
			FileHandler.copy(SrcFile, DstFile);
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return DestinationFile;
	}*/
}
