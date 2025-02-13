package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources",
		glue={"com.stepdefinition","src\\test\\hooks\\com.hooks1"},
		plugin={"com.aventstack.chaintest.plugins.ChainTestCucumberListener:"},
		monochrome=true,
		dryRun=false
		)

public class TestRunner {

}
