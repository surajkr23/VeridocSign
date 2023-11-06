package com.VeridocSign.TestWellTechnologies.genericLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot{
	/**
	 * It is used to take Scrennshots
	 * @param driver
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String takescreenshot(WebDriver driver, String name) throws IOException
	{
		Date d= new Date();
		String date = d.toString().replaceAll(":", "-");
		TakesScreenshot ts= (TakesScreenshot)driver;
		File ram = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(AutoConstant.photopath+name+date+".png");
		FileUtils.copyFile(ram, dest);
		return date;
	}
}
