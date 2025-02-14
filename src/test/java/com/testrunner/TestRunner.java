package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "E:\\Workspace Selenium Libraries\\AutomationLibraries\\com.feature\\Login.feature",
		glue={"com.stepdefinition","\\src\\test\\java\\com\\hooks"},
		plugin={"pretty"},
		monochrome=true,
		dryRun=false
		)

public class TestRunner {

}
