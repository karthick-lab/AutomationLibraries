package com.hooks;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.base.Base;
import com.config.ConfigProperties;
import com.driverfactory.DriverFactory;
import com.utilities.SeleniumUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverFactory {
	
	ConfigProperties properties;
	Base base;
	SeleniumUtilities utils;
	public static String scenarioname;
	
	@BeforeMethod
	
	public void launchbrowser(Scenario scenario)
	{
		scenarioname=scenario.getName();
		properties=new ConfigProperties();
		initdriver(properties.getProperties("config.properties", "browser"));
		base=new Base();
		//maximize using java script executor -----> this is not working 
		//base.maximizewindow();
		//maximize using java
		//driver().manage().window().setSize(base.getscreensize());
		//usual method
		utils= new SeleniumUtilities();
		utils.maximizeWindow();
		driver().get(properties.getProperties("config.properties", "url"));
		
	}
	
	
	@After
	
	public void teardown(Scenario scenario)
	{
		scenario.attach(utils.takescreenshot(scenarioname),"image/png", scenarioname+base.getcurrentdatetime());
		driver().close();
	}

}
