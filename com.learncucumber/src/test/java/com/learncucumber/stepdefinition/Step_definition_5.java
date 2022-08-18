package com.learncucumber.stepdefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition_5 {
	WebDriver driver;
	Step_definition std;
	ExcelDataProvider edp;
	PageObjects_HomePage ph;
	Helper help;
	
	public Step_definition_5() throws Throwable{
		
		this.driver=BrowserFactory.browser(driver);
	}
	
	@Given("I am logged in to the application")
	public void i_am_logged_in_to_the_application() throws Throwable {
		edp=new ExcelDataProvider();
		int rownum=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
		ph=new PageObjects_HomePage(driver);
		
		for(int i=1;i<=rownum;i++) {
			
			String uname=edp.username(i);
			String pwd=edp.password(i);
		    ph.login(uname, pwd);
		    ph.loginclick();
		}edp.wb.close();
	}
	@When("I hover on my account a set of account trelated options open up")
	public void i_hover_on_my_account_a_set_of_account_trelated_options_open_up() throws InterruptedException, Exception {
		
		/*String filepath="C:\\Users\\soumesh\\eclipse-workspace\\com.learncucumber\\target\\Report_Excel.xlsx";
		FileInputStream fi1=new FileInputStream(filepath);
		wb1=new XSSFWorkbook(fi1);
		//XSSFWorkbook wb1=new XSSFWorkbook();
		XSSFSheet sh1=wb1.getSheet("Sheet1");*/
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(ph.myaccount)).build().perform();
		
	}
	@Then("I can verify if all the account related items are populating")
	public void i_can_verify_if_all_the_account_related_items_are_populating() throws Exception {
	   System.out.println("i am fine");
	   ArrayList<String>acclist=new ArrayList<>();
		acclist.add("Profile");
		acclist.add("SuperCoin");
		acclist.add("Flipkart");
		acclist.add("Orders");
		acclist.add("Wishlist");
		List<WebElement>myacclist=driver.findElements(ph.myacclist);
		int count=0;
		for(int i=0;i<=myacclist.size()-1;i++) {
			String k=myacclist.get(i).getText();
			for(int j=0;j<=acclist.size()-1;j++) {
				if(k.contains(acclist.get(j))) {
					System.out.println(k + " is present");
					count+=1;
				}
			}
		
		}
		System.out.println(count);	
		help=new Helper();
		int rownum1=help.sh1.getLastRowNum()-help.sh1.getFirstRowNum();
		if(count>=5) {
			for(int l=1;l<=rownum1;l++) {
				help.newcell(l, 2, "P");
			
			
		}
		}help.wb1.close();
	}
	
	
}
