package com.learncucumber.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.Messages.StepDefinition;

public class Step_definition_6 {
	
	ExcelDataProvider edp;
	Helper help;
	Step_definition std;
	WebDriver driver;
	PageObjects_HomePage poh;
	public Step_definition_6() throws Throwable{
		std=new Step_definition();
		this.driver=std.i_open_browser_and_login();
	}
	
	@Given("I am logged in to flipkart")
	public void i_am_logged_in_to_flipkart() throws Throwable {
	    
		edp=new ExcelDataProvider();
		int rownum2=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
		for(int i=1;i<=rownum2;i++) {
			String username=edp.username(i);
			String password=edp.password(i);
			std.i_have_correct_username_and_password(username, password);
			std.i_should_be_able_to_login_successfully();
		}
	}
	@Then("I will be able to view and click on all the categories of product")
	public void i_will_be_able_to_view_and_click_on_all_the_categories_of_product() throws Throwable {
		Thread.sleep(4000);
		driver.navigate().refresh();
	   poh=new PageObjects_HomePage(driver);
	   List<WebElement>categories=driver.findElements(poh.category);
	   ArrayList<String>cat=new ArrayList<>();
	   cat.add("Mobile");
	   cat.add("Fashion");
	   cat.add("Electronics");
	   cat.add("Beauty");
	   cat.add("Home");
	   cat.add("Appliances");
	   cat.add("Furniture");
	   cat.add("Travel");
	   cat.add("Grocery");
	   
	   int count=0;
	   for(int i=0;i<=categories.size()-1;i++) {
		   
		   String k=categories.get(i).getText();
		   for(int j=0;j<=cat.size()-1;j++) {
			   if(k.contains(cat.get(j))) {
				   System.out.println(k);
				   count+=1;
				   
				   
			   }
		   }
	   }
	   System.out.println(count);
	   if(count==8) {
		   poh.click();
	   }
		}


}
