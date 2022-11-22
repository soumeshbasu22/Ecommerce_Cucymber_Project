package com.learncucumber.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_FlipKartPlus;
import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Step_definition_9 extends BaseClass{
	Helper help;
	PageObjects_HomePage poh;
	ExcelDataProvider edp;
	PageObjects_FlipKartPlus pofp;
	BaseClass_withCucumber bcc;
	@Test(priority=11,groups="Scenario9")
	@When("^I am logged in to flipkart site$")
	public void i_am_logged_in_to_flipkart_site() throws Throwable {
		bcc=new BaseClass_withCucumber();
		edp=new ExcelDataProvider();
		driver=bcc.setUp();
		int rownum2=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
		poh=new PageObjects_HomePage(driver);
		for(int i=1;i<=rownum2;i++) {
			String username=edp.username(i);
			String password=edp.password(i);
			poh.login(username, password);
			poh.loginclick();
			Thread.sleep(4000);
		}
	}
	@Test(priority=12,groups="Scenario9")
	@Then("I am able to see the Explore Plus option")
	public void i_am_able_to_see_the_explore_plus_option() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("To implement");
	    
	    pofp=new PageObjects_FlipKartPlus(driver);
	    boolean PresenceofPlusLink=driver.findElement(pofp.explorePlus_link).isDisplayed();
	    Assert.assertEquals(PresenceofPlusLink, true);
	}
	@Test
	@Then("I am able to see my coin details")
	public void i_am_able_to_see_my_coin_details() {
		pofp.flipkart_plus();
		boolean coinPresence=driver.findElement(pofp.coin_balance_display).isDisplayed();
		Assert.assertEquals(coinPresence, true);
	}

}
