package testBase;

import java.io.IOException;

import pageObjects.BarbourHomePopup;
import bsh.ParseException;

public class FuncBase extends ReportBase {
	
	public static void UKLaunchApplication() throws IOException, InterruptedException, ParseException
	{
		 dr.get("https://89.234.32.58/uk?forceCountryCode=UK");
	 	 BarbourHomePopup.CloseBtn(dr).click();
	 	 BarbourHomePopup.CoockiesCloseIcon(dr).click();
    	 Thread.sleep(5000);
    	 System.out.println("UK Application Launched successfully");
    }
	

			
}
	 
	 

