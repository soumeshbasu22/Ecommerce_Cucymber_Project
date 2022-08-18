package com.learncucumber.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterMethod;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="Features", glue={"com.learncucumber.stepdefinition"},
tags="not @ignore",
plugin={"html:target/cucumber-html-report/report.html"})
public class TestRunner {

}
