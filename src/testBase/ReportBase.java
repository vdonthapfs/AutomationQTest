package testBase;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ReportBase extends TestBase{
	
	static ExtentReports report;
	static ExtentTest logger;
	public static String TestName;
	private static String repName = null; 
	
	@BeforeMethod(alwaysRun = true)
	public static void StartReport(Method m) throws IOException {
		if(repName == null){
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			String x = dateFormat.format(date);
			System.out.println(x);
		    repName = "UAT_AutomationExecutionReport_"+x+".html";
		}
		TestName = m.getName();
		System.out.println(TestName);
		String fn = repName;	
		report=new ExtentReports("./Report/"+fn,false);
		report.loadConfig(new File("./Report/Report.xml"));
		logger=report.startTest(TestName);
		
	}
	
	public static void LogPass(String Message, String path) throws IOException {
		
		String image= logger.addScreenCapture(path);
		logger.log(LogStatus.PASS, Message, image);
		report.endTest(logger);
		report.flush();
	}
	
	public static void LogFail(String Message, Throwable Error, String path) throws IOException {
		
		String image= logger.addScreenCapture(path);
		logger.log(LogStatus.FAIL, Message, image);
		logger.log(LogStatus.INFO, Error);
		report.endTest(logger);
		report.flush();
	}
	
	/*@AfterMethod(alwaysRun = true)
	public static void EndReport() throws IOException {
		
		report.endTest(logger);
		report.flush();	
	}*/
		
} 
	
	 

	
