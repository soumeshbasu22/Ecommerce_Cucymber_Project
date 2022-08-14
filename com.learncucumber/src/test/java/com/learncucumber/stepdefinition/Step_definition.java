package com.learncucumber.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition {
	public WebDriver driver;
	//public Step_definition(WebDriver driver) {
		//this.driver=driver;
	//}
	@Given("^I open browser and login$")
	public WebDriver i_open_browser_and_login() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumesh\\eclipse-workspace\\com.learncucumber\\chromedriver2.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	    driver.get("https://www.flipkart.com/");
	    return driver;
	    	}

	@When("I have correct username {string} and password {string}")
	public void i_have_correct_username_and_password(String username,String pwd) throws Throwable {
	    driver.findElement(By.xpath("//input[@autocomplete='off'][@class='_2IX_2- VJZDxU']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
	    
	}

	@Then("^I should be able to login successfully$")
	public void i_should_be_able_to_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete action;
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[span='Login']")).click();
	    	}
	
}
