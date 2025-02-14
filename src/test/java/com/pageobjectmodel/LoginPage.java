package com.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.SeleniumUtilities;

import io.cucumber.java.en.When;

public class LoginPage {
	

	SeleniumUtilities utils=new SeleniumUtilities();
	
	By Email=By.xpath("//*[@name=\"email\"]");
	By Password=By.xpath("//*[@name=\"password\"]");
	By Login=By.xpath("(//*[@class=\"btn btn-primary\"])[2]");
	By ErrorMessage=By.xpath("//*[@class=\"alert alert-danger alert-dismissible\"]");
	
	
	public void enterEmail(String email)
	{
		utils.waitandentervalue(Email, email);
	}
	
	public void enterPasswod(String password)
	{
		utils.waitandentervalue(Password, password);
	}
	
	public void clickLogin()
	{
		utils.waitandclickelement(Login);
	}
	
	public String geterrormessage() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("message is: "+utils.getMessage(ErrorMessage));
		return utils.getMessage(ErrorMessage);
	}
	
	public boolean verifymessage(String expectedmessage) throws InterruptedException
	{
		System.out.println("exp message is: "+expectedmessage);
		if(expectedmessage.equals(geterrormessage()))
		{
		    utils.HighlightPass(ErrorMessage);
		    return true;
		}
		
		else
		{
			utils.HighlightFail(ErrorMessage);
			return false;
		}
		
	}
	

}
