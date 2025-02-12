package com.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static ThreadLocal<WebDriver> tldriver;
	
	public void initdriver(String browser)
	{
		tldriver=new ThreadLocal<WebDriver>();
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		    tldriver.set(new ChromeDriver()); 
		        
		}
		
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
		    tldriver.set(new FirefoxDriver()); 
		        
		}
		
		
		
	
	}
	
	
	public static WebDriver driver()
	{
		
		return tldriver.get();
	}

}
