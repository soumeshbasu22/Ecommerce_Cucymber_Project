package com.learncucumber.testrunner;

import org.testng.annotations.AfterClass;

/********************************Runs with TestNG********************************************/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.learncucumber.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="Features", glue={"com.learncucumber.stepdefinition"},
tags="not @ignore",
plugin={"html:target/cucumber-html-report/report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}



