package com.learncucumber.testrunner;

/********************************Runs with TestNG********************************************/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="Features", glue={"com.learncucumber.stepdefinition"},
tags="not @ignore",
plugin={"html:target/cucumber-html-report/report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@AfterTest
	public void reporting() {
		System.out.println("after every method");
	}

}



