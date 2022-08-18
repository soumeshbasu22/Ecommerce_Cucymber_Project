package com.learncucumber.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learncucumber.baseclass.BaseClass;
import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition extends BaseClass {
	public WebDriver driver;
	
	PageObjects_HomePage poh;
	@Given("^I open browser and login$")
	public void i_open_browser_and_login() throws Throwable {
	   	
	    	}

	@When("I have correct username {string} and password {string}")
	public void i_have_correct_username_and_password(String username,String pwd) throws Throwable {
		driver=super.setUp();
		poh=new PageObjects_HomePage(driver);
	    poh.login(username, pwd);
	    
	}

	@Then("^I should be able to login successfully$")
	public void i_should_be_able_to_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete action;
		Thread.sleep(5000);
		//driver=BrowserFactory.browser(driver);	
		poh=new PageObjects_HomePage(driver);
		driver.findElement(By.xpath("//button[span='Login']")).click();
	    	}
	
}
