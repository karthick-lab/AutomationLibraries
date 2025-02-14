package com.stepdefinition;

import org.testng.Assert;

import com.base.Base;
import com.driverfactory.DriverFactory;
import com.pageobjectmodel.HomePage;
import com.pageobjectmodel.LoginPage;
import com.utilities.SeleniumUtilities;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginpageStepDefinition extends DriverFactory {
	
	HomePage homepage=new HomePage();
	LoginPage loginpage=new LoginPage();
	Base base=new Base();
	SeleniumUtilities utils=new SeleniumUtilities();
	
	@When("I click on Login link")
	public void i_click_on_Login_link() {

		homepage.clickMyAccounts();
		homepage.clickLogin();

	}
	
	@When("I enter {string} and {string}")
	public void i_enter_and(String email, String password) {
	   
		loginpage.enterEmail(email);
		loginpage.enterPasswod(password);
		loginpage.clickLogin();
		
	}

	@Then("I verify the error message {string}")
	public void i_verify_the_status(String errormessage) throws InterruptedException {
	    
		Assert.assertTrue(loginpage.verifymessage(errormessage));
	}

}