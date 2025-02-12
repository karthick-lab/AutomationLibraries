package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base;
import com.driverfactory.DriverFactory;


public class SeleniumUtilities extends DriverFactory{
	
	Base base=new Base();
	
	public static void maximizeWindow()
	{
		driver().manage().window().maximize();
	}
	
	public byte[] takescreenshot(String scenarioname)
	{
		byte[] byteArr = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);
		File src=((TakesScreenshot)driver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\"+scenarioname+base.getcurrentdatetime()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(System.getProperty("user.dir")+"\\Screenshots\\"+scenarioname+base.getcurrentdatetime()+".jpg");
	    return byteArr;
	}
	
	public void waitandclickelement(By by)
	{
		WebDriverWait wait=new WebDriverWait(driver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver().findElement(by).click();
	}
	
	public void waitandclickelementbyjs(By by)
	
	{
		JavascriptExecutor js=((JavascriptExecutor) driver());
		WebDriverWait wait=new WebDriverWait(driver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		js.executeScript("aruguments[0].click();", driver().findElement(by));
				
	}
	
	
	public void waitandentervalue(By by,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		driver().findElement(by).clear();
		driver().findElement(by).sendKeys(value);	
		
	}
	
	public String getMessage(By by)
	{
		WebDriverWait  wait =new WebDriverWait(driver(),30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver().findElement(by).getText();
	}
	
	
	public void HighlightPass(By by)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver());
		js.executeScript("arguments[0].setAttribute('style','background:green; border:6px solid red;');", driver().findElement(by));
		
	}
	
	public void HighlightFail(By by)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver());
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border:6px solid black;');", driver().findElement(by));
	
	}
	

}
