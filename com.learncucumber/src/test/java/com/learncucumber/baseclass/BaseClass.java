package com.learncucumber.baseclass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import com.learncucumber.stepdefinition.Step_definition;

import io.cucumber.java.AfterStep;

public class BaseClass {
	public WebDriver driver;
	
	
	
	public  WebDriver setUp() throws Throwable {
		
		  return driver=BrowserFactory.browser(driver);
	}
	@org.testng.annotations.AfterClass
	public void tearDown() {
		
		driver.quit();
		
	}
	
	@AfterMethod
	public void reporting() {
		System.out.println("inside report");
	}

}
