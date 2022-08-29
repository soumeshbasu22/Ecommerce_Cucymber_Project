package com.learncucumber.baseclass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learncucumber.stepdefinition.Step_definition;
import com.learncucumber.utility.Helper;

import io.cucumber.java.AfterStep;

public class BaseClass {
	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports report;
	Helper help;
	
	@BeforeClass
	public  WebDriver setUp() throws Throwable {
		
		help=new Helper();
		String reportpath="C:\\Users\\soumesh\\git\\Ecommerce_Cucymber_Project\\com.learncucumber\\Reports\\Extent-html-Report\\extentreport"+help.getcurrentdate()+".html";
		ExtentHtmlReporter html=new ExtentHtmlReporter(reportpath);
		report=new ExtentReports();
		report.attachReporter(html);
		return driver=BrowserFactory.browser(driver);
	}
	@org.testng.annotations.AfterClass
	public void tearDown() throws Throwable {
		
		driver.quit();
		
	}
	
	@AfterMethod
	public void reporting(ITestResult result) {
		System.out.println("inside report");
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "TestCase Passed");
		}
		else {
			test.log(Status.FAIL, "TestCse failed");
		}
		report.flush();
	}

}
