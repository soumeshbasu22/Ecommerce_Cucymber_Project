package com.learncucumber.stepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.learncucumber.baseclass.BaseClass;
import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition_7 extends BaseClass {
	
	//WebDriver driver;
	ExcelDataProvider edp;
	PageObjects_HomePage poh;
	Helper help;
	@Test(priority=1)
	@Given("I am in my home page and I searched a product")
	public void i_am_in_my_home_page_and_i_searched_a_product() throws Throwable {
	    //driver=super.setUp();
		test=report.createTest("I am in home page");
	    edp=new ExcelDataProvider();
	    poh=new PageObjects_HomePage(driver);
	    int rownum=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
	    for(int i=1;i<=rownum;i++) {
	    	String uname=edp.username(i);
	    	String pwd=edp.password(i);
	    	poh.login(uname, pwd);
	    	poh.loginclick();
	    }
	}
	@Test(priority=2)
	@When("I click on the desired product")
	public void i_click_on_the_desired_product() throws Throwable {
		test=report.createTest("Searching for products");
		help=new Helper();
		poh=new PageObjects_HomePage(driver);
		poh.search_to_order();
		
			Set<String>open_windows=driver.getWindowHandles();
			int no_of_windows=open_windows.size();
			if(no_of_windows>1) {
				help.newcell(20, 3, "P");
				help.newcell(21, 3, "P");
			}
			else {
			help.newcell(20, 3, "F");
			help.newcell(21, 3, "F");
		}
		
	}
	@Test(priority=3)
	@Then("I can click on add to cart button")
	public void i_can_click_on_add_to_cart_button() throws Throwable {
		test=report.createTest("I am in home page");
		poh=new PageObjects_HomePage(driver);
		help=new Helper();
		Set<String>windows=driver.getWindowHandles();
		System.out.println("I AM HERE");
		for(String i:windows) {
			driver.switchTo().window(i);
			String title=driver.getTitle();
			if(title.contains("Allen Solly")){
				System.out.println("In 2nd window");
				poh.order();
				try {
					driver.findElement(By.xpath("//*[text()='Price details']")).isDisplayed();
					help.newcell(22, 3, "P");
				}
				catch(Exception e) {
					help.newcell(22, 3, "F");
				}
			}
		}
		}


}
