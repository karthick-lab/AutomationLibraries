package com.stepdefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.config.ConfigProperties;
import com.driverfactory.DriverFactory;
import com.utilities.DataProviderUtility;
import com.utilities.ExcelReader;
import com.pageobjectmodel.HomePage;
import com.pageobjectmodel.RegistrationPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends DriverFactory {
	Base base = new Base();
	RegistrationPage regpage = new RegistrationPage();
	HomePage homepage = new HomePage();
	ExcelReader excel = new ExcelReader("Registration page.xls", "Registration details");

	@Given("User have launched the application")
	public void user_have_launched_the_application() {

		String apptitile = driver().getTitle();
		System.out.println(apptitile);
	}

	@When("I click on Registration link")
	public void i_click_on_registration_link() {

		homepage.clickMyAccounts();
		homepage.clickRegister();

	}

	
	
	
	@When("I enter the registration details")
	public void i_enter_the_registration_details(DataTable dataTable) throws InterruptedException {
	    
		List<Map<String,String>> userList=dataTable.asMaps();
		for(int i=0;i<userList.size();i++)
		{
			regpage.enterFirstName(userList.get(i).get("First Name"));
			regpage.enterLastName(userList.get(i).get("Last Name"));
			regpage.enterEmail(userList.get(i).get("Email"));
			regpage.enterTelephone(userList.get(i).get("Telephone"));
			regpage.enterPassword(userList.get(i).get("Password"));
			regpage.enterConfirmPassword(userList.get(i).get("ConfirmPassword"));
			// regpage.enterFirstName(excel.getdata("First Name", i));
			regpage.selectsubscribe(userList.get(i).get("Subscribe"));
			regpage.clickPrivacyPolicy();
			regpage.clickContinueButton();
			Thread.sleep(5000);
		}
		
		
		
	}
	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {

		Assert.assertTrue(true);
	}

}
