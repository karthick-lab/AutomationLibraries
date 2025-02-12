package com.pageobjectmodel;

import org.openqa.selenium.By;

import com.base.Base;
import com.driverfactory.DriverFactory;
import com.utilities.ExcelReader;
import com.utilities.SeleniumUtilities;

public class RegistrationPage extends DriverFactory{

	SeleniumUtilities utils=new SeleniumUtilities();
	Base base=new Base();
	ExcelReader datareader=new ExcelReader("Registration page.xls", "Registration details");

	By FirstName=By.xpath("//*[@name=\"firstname\"]");
	By LastName=By.xpath("//*[@name=\"lastname\"]");
	By Email=By.xpath("//*[@name=\"email\"]");
	By Telephone=By.xpath("//*[@name=\"telephone\"]");
	By Password=By.xpath("//*[@name=\"password\"]");
	By ConfirmPassword=By.xpath("//*[@name=\"confirm\"]");
	By SubscribeYes=By.xpath("(//*[@name=\"newsletter\"])[1]");
	By SubscribeNo=By.xpath("(//*[@name=\"newsletter\"])[2]");
	By PrivacyPolicy=By.xpath("//*[@name=\"agree\"]");
	By ContinueButton=By.xpath("//*[@value=\"Continue\"]");
	
	public void enterFirstName(String firstname)
	{
		utils.waitandentervalue(FirstName, firstname);
	}
	
	public void enterLastName(String lastname)
	{
		utils.waitandentervalue(LastName, lastname);
	}
	
	public void enterEmail(String email)
	{
		utils.waitandentervalue(Email, email);
	}
	
	public void enterTelephone(String telephone)
	{
		utils.waitandentervalue(Telephone, telephone);
	}
	
	public void enterPassword(String password)
	{
		String dpassword=base.decoder(password);
		System.out.println("password is "+dpassword);
		utils.waitandentervalue(Password, dpassword);
	}
	
	public void enterConfirmPassword(String confirmpassword)
	{
		String dconfirmpassword=base.decoder(confirmpassword);
		System.out.println("Confirm password "+dconfirmpassword);
		utils.waitandentervalue(ConfirmPassword, dconfirmpassword);
	}
	
	public void selectsubscribe(String subscribe)
	{
		
		if(subscribe.equals("yes"))
		{
			utils.waitandclickelement(SubscribeYes);
			
		}
		else
		{
			utils.waitandclickelement(SubscribeNo);
		}
	}
	
	public void clickPrivacyPolicy()
	{
		utils.waitandclickelement(PrivacyPolicy);
	}
	
	public void clickContinueButton()
	{
		utils.waitandclickelement(ContinueButton);
	}
	
	
	
	
	
}
