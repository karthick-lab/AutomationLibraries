package com.TestNG;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.config.ConfigProperties;
import com.driverfactory.DriverFactory;
import com.pageobjectmodel.HomePage;
import com.pageobjectmodel.RegistrationPage;
import com.utilities.DataProviderUtility;
import com.utilities.SeleniumUtilities;

public class TestNGRunner extends DriverFactory{
	
	HomePage homepage=new HomePage();
	RegistrationPage regpage=new RegistrationPage();
	ConfigProperties properties;
	Base base;
	SeleniumUtilities utils;
	
	@BeforeMethod()
	
	public void launchURL()
	{
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
		homepage.clickMyAccounts();
		homepage.clickRegister();
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		return DataProviderUtility.getDataFromExcel().iterator();

	}

	@Test(dataProvider = "getTestData")
	public void testRegPage(String firstName, String lastName, String email, String telephone,
			String password, String confirmPassword, String subscribe) throws InterruptedException {

			regpage.enterFirstName(firstName);
			regpage.enterLastName(lastName);
			regpage.enterEmail(email);
			regpage.enterTelephone(telephone);
			regpage.enterPassword(password);
			regpage.enterConfirmPassword(confirmPassword);
			// regpage.enterFirstName(excel.getdata("First Name", i));
			regpage.selectsubscribe(subscribe);
			regpage.clickPrivacyPolicy();
			regpage.clickContinueButton();
			Thread.sleep(5000);
		

	}
	
	@AfterMethod
	public void teardown()
	{
		driver().close();
	}

}
