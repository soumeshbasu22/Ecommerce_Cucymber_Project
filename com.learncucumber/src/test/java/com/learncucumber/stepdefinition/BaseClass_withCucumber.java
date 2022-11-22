package com.learncucumber.stepdefinition;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.Helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass_withCucumber {
	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports report;
	Helper help;
	PageObjects_HomePage poh;
	
	//@Before
	public  WebDriver setUp() throws Throwable {
		
		return driver=BrowserFactory.browser(driver);
	}
	


}
