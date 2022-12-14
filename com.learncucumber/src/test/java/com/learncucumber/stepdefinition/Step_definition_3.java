package com.learncucumber.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition_3 {
	Step_definition std;
	Step_definition2 std2;
	WebDriver driver;
	PageObjects_HomePage poh;
	public Step_definition_3() throws Throwable{
		
		this.driver=BrowserFactory.browser(driver);
	}
	@Given("I try to login with a new number")
	public void i_try_to_login_with_a_new_number() throws Throwable {
		System.out.println("pass");
		poh=new PageObjects_HomePage(driver);
		poh.login("9339534464", "kjgdd");
	    poh.loginclick();
	}
	@When("The number should display as not registered")
	public void the_number_should_display_as_not_registered() throws Throwable {
		
	    if(driver.findElement(By.xpath("//*[contains(text(),'Looks')]")).isDisplayed()) {
	    	driver.findElement(By.xpath("//*[text()='CONTINUE']")).click();
	    	Thread.sleep(10000);
	    	
	    }
	}
	@Then("I should be able to sign up to flipkart with {string},{string}")
	public void i_should_be_able_to_sign_up_to_flipkart_with(String otp,String pwd) throws Throwable {
		//std=new Step_definition();
		driver.findElement(By.xpath("//*[@maxlength='6']")).sendKeys(otp);
		Thread.sleep(8000);
	    driver.findElement(By.xpath("//*[@type='password']")).sendKeys(pwd);
	    driver.findElement(By.xpath("//*[text()='Signup']")).click();
	}

}
