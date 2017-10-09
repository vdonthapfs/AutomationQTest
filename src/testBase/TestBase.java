package testBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import bsh.ParseException;


public class TestBase {
public static WebDriver dr = null;
public static Properties CG = null;

public static Logger Log = Logger.getLogger(Log.class.getName());


		@BeforeClass(alwaysRun = true)
		public static void Initialise() throws IOException {
		
		System.out.println("==========================initialising Browser==================================================");
		CG = new Properties();
		FileInputStream is = new FileInputStream ("./src/config/Config.Properties");
		CG.load(is);
		System.out.println(CG.getProperty("browser"));
				if (CG.getProperty("browser").equals("ff")) {			
				System.out.println("Firefox Browser");
				dr = new FirefoxDriver();
				dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				dr.manage().window().maximize();
			}else if (CG.getProperty("browser").equals("ie")) {
				System.out.println("Internet Explorer Browser");
				System.setProperty("webdriver.ie.driver","C:\\AutomationWorkspace\\SeleniumDrivers\\IEDriverServer.exe");		
				DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
		        capabilitiesIE.setCapability("ignoreZoomSetting", true);
				dr = new InternetExplorerDriver(capabilitiesIE);
				capabilitiesIE.setCapability("nativeEvents",false);
				System.out.println("Internet Explorer Browser");
				dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				dr.manage().window().maximize();
			}else if (CG.getProperty("browser").equals("ch")) {
				System.out.println("Chrome Browser");
				System.setProperty("webdriver.chrome.driver","C:\\AutomationWorkspace\\SeleniumDrivers\\chromedriver.exe");
				dr = new ChromeDriver();
				System.out.println("CHROME Browser");
				dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				dr.manage().window().maximize();
			}
			System.out.println("=============INITIALISATION DONE============================================");
		
}
		
		

	
	
	
	//this is to highlight the element
	public static WebElement elementHighlight(WebElement element) throws InterruptedException {
		
		for (int i=0; i<2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) dr;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "border: 3px solid red;");
			Thread.sleep(50);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
		}
			return element;
			
		
	}
	
	// The below method is to find visible object
	
	@SuppressWarnings("unused")
	public static WebElement Locate(String ky, String type) throws InterruptedException {
	
		try{
	WebElement s = null;
	System.out.println(ky);
	System.out.println(type);
	//String m = ky.substring(ky.length() - 2);
	//System.out.println(m);
	switch (type) {
	
	case "id": // find element by object id
		//System.out.println("find element by object id");
		List<WebElement> ele1 = getObjectListById(ky);
		int n1 = 0;
		for(int i=0; i<ele1.size(); i++) {
		if (ele1.get(i).isDisplayed()) {
			n1 = i;
			}
		}
		s = ele1.get(n1);
		break;
		
	case "xp": // find element by object X-path 
		
		//System.out.println("find element by xpath");
		List<WebElement> ele2= getObjectListByXpath(ky);
		int n2 = 0;
		for(int i=0; i<ele2.size(); i++) {
		if (ele2.get(i).isDisplayed()) {
			n2 = i;
			}
		}
		s = ele2.get(n2);
		break;
		
	case "cn": // find element by class name
		
		//System.out.println("find element by calss name");
		List<WebElement> ele3= getObjectListByClassName(ky);
		int n3 = 0;
		for(int i=0; i<ele3.size(); i++) {
		if (ele3.get(i).isDisplayed()) {
			n3 = i;
			}
		}
		s = ele3.get(n3);
		break;
		
		
	case "lt": // find element by link text
		
		System.out.println("find element by link text");
		List<WebElement> ele4= getObjectListByLinkText(ky);
		int n4 = 0;
		for(int i=0; i<ele4.size(); i++) {
		if (ele4.get(i).isDisplayed()) {
			n4 = i;
			}
		}
		s = ele4.get(n4);
		break;
	
	case "pl": // find element by partial link text
		
		System.out.println("find element by partial link text");
		List<WebElement> ele5 = dr.findElements(By.tagName("a"));
		int n5 = 0;
		for(int i=0 ; i<ele5.size() ; i++)
		{
		    if(ele5.get(i).getAttribute("href").contains(ky)){
		    	n5=i;
		        
		    }
		    break;
		}
		
		s = ele5.get(n5);
		break;
		
	case "cs": // find element by css selector
		
		System.out.println("find element by css selector");
		List<WebElement> ele6= dr.findElements(By.cssSelector(ky));
		int n6 = 0;
		for(int i=0; i<ele6.size(); i++) {
		if (ele6.get(i).isDisplayed()) {
			n6 = i;
			}
		}
		s = ele6.get(n6);
		break;
		
	case "on": // find element by object name
		
		System.out.println("find element by object name");
		List<WebElement> ele7= dr.findElements(By.name(ky));
		int n7 = 0;
		for(int i=0; i<ele7.size(); i++) {
		if (ele7.get(i).isDisplayed()) {
			n7 = i;
			}
		}
		s = ele7.get(n7);
		break;
		}
	System.out.println("Element found---"+ky);
	return elementHighlight(s);
	} catch(Exception e){
		System.out.println("Element not found---"+ky);
		System.out.println(e.getMessage());
		throw e;
		}
	}
	
	
	
	
	// This method is to Select a value from DropDown
	
	public static Select Fromdropdown(String ky, String type) throws InterruptedException {
		
		Select dd = new Select (Locate(ky, type));
		return dd;
		
	}
	
	
	
	
	// The below methods are to find objects using list
	
	public static List<WebElement> getObjectListById (String ky) {
		
		return (List<WebElement>) dr.findElements(By.id(ky));
		}
	
	public static List<WebElement> getObjectListByClassName (String ky) {
		
		return (List<WebElement>) dr.findElements(By.className(ky));
		}
    public static List<WebElement> getObjectListByLinkText (String ky) {
		
		return (List<WebElement>) dr.findElements(By.linkText(ky));
		}
    public static List<WebElement> getObjectListByPartialLinkText (String ky) {
		
		return (List<WebElement>) dr.findElements(By.partialLinkText(ky));
		}
    
    public static List<WebElement> getObjectListByXpath (String ky) {
		
		return (List<WebElement>) dr.findElements(By.xpath(ky));
		}
	
	//below code is to hover mouse over a menu item
	public static void moveMouseOver (String MenuName) {
		
		List<WebElement> link= getObjectListById(MenuName);
		System.out.println(link.size());
		int n = 0;
		for(int i=0; i<link.size(); i++) {
		String x = link.get(i).getText();
		Boolean y = link.get(i).isDisplayed();
		System.out.println(i + "---" + x + "---" + y);
		if (link.get(i).isDisplayed()) {
			n = i;
		}
		}
		System.out.println(n);
		//link.get(n).click();
		Actions action = new Actions(dr);
		WebElement we = link.get(n);
		action.moveToElement(we).build().perform();
	}
	
	//below code is to click on the visible object
		public static void ClickVisibleObject (String ele) {
			
			List<WebElement> link= getObjectListById(ele);
			System.out.println(link.size());
			int n = 0;
			for(int i=0; i<link.size(); i++) {
			String x = link.get(i).getText();
			Boolean y = link.get(i).isDisplayed();
			System.out.println(i + "---" + x + "---" + y);
			if (link.get(i).isDisplayed()) {
				n = i;
			}
			}
			System.out.println(n);
			link.get(n).click();
			}
		
		
				
	//below code is to hover mouse over a menu item and click on Sub menu
	public static void moveMouseOver_AndClickSubMenu (String MenuName, String ele) {
					
	List<WebElement> link= getObjectListById(MenuName);
	System.out.println(link.size());
	int n = 0;
	for(int i=0; i<link.size(); i++) {
	String x = link.get(i).getText();
	Boolean y = link.get(i).isDisplayed();
	System.out.println(i + "---" + x + "---" + y);
	if (link.get(i).isDisplayed()) {
		n = i;
	}
	}
	System.out.println(n);
	//link.get(n).click();
	Actions action = new Actions(dr);
	WebElement we = link.get(n);
	action.moveToElement(we).build().perform();
	
	List<WebElement> link1= getObjectListByLinkText(ele);
	System.out.println(link1.size());
	int n1 = 0;
	for(int i=0; i<link1.size(); i++) {
	String x = link1.get(i).getText();
	Boolean y = link1.get(i).isDisplayed();
	System.out.println(i + "---" + x + "---" + y);
	if (link1.get(i).isDisplayed()) {
		n1 = i;
	}
	}
	System.out.println(n1);
	link1.get(n1).click();
	}
	
 	// this is to take screen shot for PASS
	public static String TakeScreenShotPass (String tname) throws IOException, ParseException {
		
		File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		int ran = (new Random()).nextInt(999-111);
		String path = ("C:/Users/vdontha/Desktop/Automation-Screenshots/ScreenShot"+ tname +"-PASS-"+ran + ".png");
		System.out.println(path);
		FileUtils.copyFile(scrFile, new File(path));
		return path;
		
	}
	
	// this is to take screen shot for FAIL
		public static String TakeScreenShotFail (String tname) throws IOException, ParseException {
			
			File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
			int ran = (new Random()).nextInt(99999-11111);
			String path = ("C:/Users/vdontha/Desktop/Automation-Screenshots/ScreenShot"+ tname +"-FAIL-"+ran + ".png");
			System.out.println(path);
			FileUtils.copyFile(scrFile, new File(path));
			return path;
			
		}
		
} 
	
	 

	
