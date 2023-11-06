package com.VeridocSign.TestWellTechnologies.genericLib;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest; 
/**
 * 
 * @author surajkumar
 *
 */
public class BaseClass {
	public WebDriver driver;

	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	FileUtilities fu=new FileUtilities();
	public WebdriverUtilities utilities=new WebdriverUtilities();
	@BeforeSuite
	public static void configBS(ITestContext context)
	{
		 String fullClassName = context.getAllTestMethods()[0].getRealClass().getName();
		 String className = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
		 // Create the ExtentHtmlReporter with the class name
		 htmlreport = new ExtentHtmlReporter(AutoConstant.reportpath + className + "-extent-report.html");
	     htmlreport.config().setReportName("VeridocSignReport - " + className);
		 htmlreport.config().setTheme(Theme.DARK);
		 reports = new ExtentReports();
		 reports.attachReporter(htmlreport);
		
	}
	@BeforeMethod
	public void openApp(Method method) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("-disable-notifications");
		driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(fu.getPropertyFile("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        test = reports.createTest(method.getName());

	}
	@AfterMethod
	public void closeApp(ITestResult res) throws IOException
	{
		int result = res.getStatus();
		String name = res.getName();
		if(result==ITestResult.FAILURE)
		{
			Screenshot s=new Screenshot();
			String date = s.takescreenshot(driver,name);
			test.log(Status.FAIL,name+": Test Case Failed" );
			test.log(Status.FAIL,res.getThrowable()+"Test case failed exception");
			test.log(Status.FAIL, "Screenshot taken at: "+date);
			
		}
		if(result== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, name+": Test Case Passed");
		}
		if(result== ITestResult.SKIP)
		{
			test.log(Status.SKIP, name+": Test Case Skipped");
		}
		
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		reports.flush();
	}

}
