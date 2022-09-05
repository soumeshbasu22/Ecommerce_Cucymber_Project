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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.learncucumber.baseclass.BaseClass;
import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.Helper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Step_definition_4 extends BaseClass {
	Step_definition std;
	ExcelDataProvider edp;
	//WebDriver driver;
	PageObjects_HomePage poh;
	Helper help;
	public int tc_no=0;
	
	@Test(priority=-6)
	
	@Given("I get logged in successfully with username and password {string},{string}")
	public void i_get_logged_in_successfully_with_username_and_password() throws Throwable {
	   tc_no=12;
	   
	   //driver=super.setUp(); //to be used when run from TestRunner class
	   test=report.createTest("Test Case 12");
	   help=new Helper();
	   edp=new ExcelDataProvider();
	   poh=new PageObjects_HomePage(driver);
	   int rownum=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
	   for(int i=1;i<=rownum;i++) {
		   
		   String uname=edp.username(i);
		   String pwd=edp.password(i);
		   poh.login(uname, pwd);
		   poh.loginclick();
		   
	   }edp.wb.close();
	}
	@Test(priority=-5)
	@Then("I can verify all the links in home page if anything is broken")
	public void i_can_verify_all_the_links_in_home_page_if_anything_is_broken() throws Exception  {
	    // Write code here that turns the phrase above into concrete actions
		test=report.createTest("Test to find broken links");
		driver.navigate().refresh();
	    System.out.println("into new method");
	    List<WebElement>links=driver.findElements(By.tagName("a"));
	    int count=0;
	    for(int i=0;i<15;i++) {
	    	String url=links.get(i).getAttribute("href");
	    	if(poh.verifylink(url)==1){
	    		
	    		count+=1;
	    		System.out.println(count);
	    	}
	    	else {
	    		System.out.println(links.get(i).getAttribute("id"));
	    		//test.log(Status.FAIL, "TC Failed");
	    	}
	    }
	    System.out.println(count);
	    System.out.println(links.size());
	    if(count==14) {
	    	System.out.println("No proken link");
	    }
	    else {
	    	test.info("There are broken links in the page");
	    	test.log(Status.FAIL, "Some links are broken");
	    }
	}

	@Test(priority = -4)
	@Then("Ishould be able to search for products")
	public void ishould_be_able_to_search_for_products() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		//System.out.println("pass");
		help=new Helper();
		tc_no=13;
		test=report.createTest("Searching the products");
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
		else {
			help.newcell(tc_no, 3, "F");
		}
		}
	@Test(priority = -3)
	@Then("I should be able to sort the products")
	public void i_should_be_able_to_sort_the_products() throws Exception {
		tc_no=14;
		test=report.createTest("Sorting of thr search results");
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
	/*@AfterMethod
	public void response(ITestResult result) throws Exception {
		help=new Helper();
		if(result.getStatus()==ITestResult.SUCCESS) {
			help.newcell(tc_no, 3, "P");
		}
	}*/

}
