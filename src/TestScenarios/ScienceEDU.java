package TestScenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import bsh.ParseException;

public class ScienceEDU{
	
	public static WebDriver dr = null;
	
     @Test
     public static void UKSiteLaunch() throws InterruptedException, IOException, ParseException {
		 
    	 System.out.println("Chrome Browser");
		 System.setProperty("webdriver.chrome.driver","C:\\SeleniumDrivers\\chromedriver.exe");
		 dr = new ChromeDriver();
		 System.out.println("CHROME Browser");
		 dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 dr.manage().window().maximize();
		 System.out.println("Chrome Browser Launched Successfully");
		 
    	 dr.get("https://www.science.edu");
    	 Thread.sleep(5000);
    	 System.out.println("Science EDU Site Launched Successfully");
    	 
		 dr.quit(); 
		 
     }
}