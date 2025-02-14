package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.driverfactory.DriverFactory;
import com.utilities.SeleniumUtilities;

public class HomePage extends DriverFactory{
	
	

	SeleniumUtilities utils=new SeleniumUtilities();

	By MyAccouts=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
	By Register=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
	By Login=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	By ErrorMessage=By.xpath("//*[@class=\"alert alert-danger alert-dismissible\"]");
	
	
	
	public void clickMyAccounts()
	{
		utils.waitandclickelement(MyAccouts);
	}
	
	
	public void clickRegister()
	{
		//utils.waitandclickelementbyjs(Register);
		utils.waitandclickelement(Register);
	}
	
	public void clickLogin()
	{
		utils.waitandclickelement(Login);
	}
	
	public String geterrormessage()
	{
		return utils.getMessage(ErrorMessage);
	}

}
