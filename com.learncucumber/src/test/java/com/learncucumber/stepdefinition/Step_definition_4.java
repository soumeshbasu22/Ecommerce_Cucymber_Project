package com.learncucumber.stepdefinition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Step_definition_4 {
	Step_definition std;
	ExcelDataProvider edp;
	WebDriver driver;
	PageObjects_HomePage poh;
	Helper help;
	public int tc_no=0;
	public Step_definition_4() throws Throwable {
		
		this.driver=BrowserFactory.browser(driver);
	}
	@Given("I get logged in successfully with username and password {string},{string}")
	public void i_get_logged_in_successfully_with_username_and_password(String uname,String pwd) throws Throwable {
	   tc_no=12;
		edp=new ExcelDataProvider();
	   poh=new PageObjects_HomePage(driver);
	   int rownum=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
	   for(int i=1;i<=rownum;i++) {
		   
		   uname=edp.username(i);
		   pwd=edp.password(i);
		   poh.login(uname, pwd);
		   poh.loginclick();
		   
	   }edp.wb.close();
	}
	@Then("Ishould be able to search for products")
	public void ishould_be_able_to_search_for_products() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		//System.out.println("pass");
		help=new Helper();
		tc_no=13;
		Thread.sleep(4000);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("watches");
		Thread.sleep(18000);
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		System.out.println("pass");
		Thread.sleep(18000);
		if(driver.findElement(By.xpath("//*[text()='Watches'][@class='_2whKao']")).isDisplayed()) {
			help.newcell(tc_no, 3, "P");
		}
		}
	@Then("I should be able to sort the products")
	public void i_should_be_able_to_sort_the_products() throws Exception {
		tc_no=14;
		help=new Helper();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'Low to High')]")));
		driver.findElement(By.xpath("//*[contains(text(),'Low to High')]")).click();
		Thread.sleep(9000);
		ArrayList<WebElement>PriceSort=new ArrayList<>(driver.findElements(By.xpath("//*[@class='_30jeq3']")));
		int count=0;
		for(int i=0;i<PriceSort.size()-1;i++) {
			
			//System.out.println(PriceSort.get(i).getText());
			String price=PriceSort.get(i).getText().substring(1);
			String price1=PriceSort.get(i+1).getText().substring(1);
			int m=Integer.parseInt(price);
			System.out.println(m);
			int n=Integer.parseInt(price1);
			if(m<=n) {
				count+=1;
			}
			}
		if(count>1) {
			help.newcell(tc_no, 3, "P");
		}
		System.out.println(count+1+" Products are sorted");
	}
	//@AfterMethod
	public void response(ITestResult result) throws Exception {
		help=new Helper();
		if(result.getStatus()==ITestResult.SUCCESS) {
			help.newcell(tc_no, 3, "P");
		}
	}

}
