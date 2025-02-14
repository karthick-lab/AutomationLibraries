package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resources\\Registration.feature",
				"src\\test\\resources\\Login.feature"},
		glue={"com.stepdefinition","\\src\\test\\java\\com\\hooks"},
		plugin={"pretty","html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "json:target/cucumber-reports/CucumberTestReport.json"},
		monochrome=true,
		dryRun=false
		)

public class TestRunner {

}
