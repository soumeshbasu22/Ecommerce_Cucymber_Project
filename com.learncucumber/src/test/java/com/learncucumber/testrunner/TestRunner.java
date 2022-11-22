package com.learncucumber.testrunner;

import java.io.File;

import org.testng.annotations.AfterClass;
//import managers.FileReaderManager;

/********************************Runs with TestNG********************************************/

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
//import com.cucumber.listener.Reporter;
import com.learncucumber.stepdefinition.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="Features", glue={"com.learncucumber.stepdefinition"},
tags="not @ignore"
//plugin={"html:target/cucumber-html-report/report.html"}
)
@Listeners({ExtentITestListenerClassAdapter.class})
public class TestRunner extends AbstractTestNGCucumberTests {
	

}



