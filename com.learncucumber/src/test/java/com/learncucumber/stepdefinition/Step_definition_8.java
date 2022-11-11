package com.learncucumber.stepdefinition;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learncucumber.baseclass.BaseClass;
import com.learncucumber.baseclass.BrowserFactory;
import com.learncucumber.pageobjects.PageObjects_HomePage;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.ExcelDataProvider_2;
import com.learncucumber.utility.Helper;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**************This class is able to run with both TestNG.xml and TestRunner class********/

public class Step_definition_8 extends BaseClass{
	
	//WebDriver driver;
	PageObjects_HomePage poh;
	ExcelDataProvider edp;
	ExcelDataProvider_2 edp2;
	/*ExtentTest test;
	ExtentReports report;*/
	int flag;
	
	//we can run it as TestNG tests through testng.xml file as well.For that we can just extend the base class and ignore @beforestep/@afterstep
	
	@Before
	public void before_test() throws Throwable {
		
		Helper help=new Helper();
		System.out.println("before each test");
		driver=BrowserFactory.browser(driver);
		String filepath="C:\\Users\\soumesh\\git\\Ecommerce_Cucymber_Project\\com.learncucumber\\Reports\\Extent-html-Report\\extentreport"+help.getcurrentdate()+".html";
		ExtentHtmlReporter html=new ExtentHtmlReporter(filepath);
		report=new ExtentReports();
		report.attachReporter(html);
	}
	
	@Test(priority=4)
	@Given("I open flipkart")
	public void i_open_flipkart() throws Throwable {
		Helper help=new Helper();
		test=report.createTest("Login successfully");
		flag=0;
		poh=new PageObjects_HomePage(driver);
		edp=new ExcelDataProvider();
		int rownum=edp.sh.getLastRowNum()-edp.sh.getFirstRowNum();
		for(int i=1;i<=rownum;i++) {
			String username=edp.username(i);
			String password=edp.password(i);
			poh.login(username, password);
			poh.loginclick();
	}edp.wb.close();
	flag=1;
	help.newcell(23, 3, "P");
	}
	
	@Test(priority=5)
	@When("I search a product")
	public void i_search_a_product() throws Exception{
		
		test=report.createTest("I can search the product");
		driver.navigate().refresh();
		edp2=new ExcelDataProvider_2();
		int rownum=edp2.sh1.getLastRowNum()-edp2.sh1.getFirstRowNum();
		Helper help=new Helper();
		for(int i=0;i<=rownum;i++) {
			
			String brand=edp2.brand_name(i);
			if(brand.equalsIgnoreCase("allen-solly")) {
				driver.findElement(poh.searchbar).sendKeys(brand);
				break;
			}
		}driver.findElement(poh.searchbutton).submit();
		try {
			driver.findElement(By.xpath("//*[@class='_10Ermr']")).isDisplayed();
			
			flag=1;
			test.log(Status.PASS, "Test Case is passed");
			help.newcell(24, 3, "P");
		}
		catch(Exception e) {
			flag=2;
			test.log(Status.FAIL, "Test Case is failed");
			help.newcell(24, 3, "F");
		}
	}
	
	@Test(priority=6)
	@Then("I should be able to fetch brand and price")
	public void i_should_be_able_to_fetch_brand_and_price() throws Exception {
		
		flag=0;
		
		test=report.createTest("Brand and price details fetched successfully");
		driver.navigate().refresh();
		Helper help=new Helper();
		XSSFSheet sh2=help.wb1.createSheet("ScappedData");
		List<WebElement>products=driver.findElements(By.xpath("//*[contains(text(),'Allen Solly ')]"));
		List<WebElement>prices=driver.findElements(By.xpath("//*[contains(@class,'_30')]"));
		int rownum=products.size();
		System.out.println(rownum);
		for(int i=0;i<=rownum-2;i++) {
			try {
			sh2.createRow(i+1);
			Row currentrow=sh2.getRow(i+1);
			Cell currentcell=currentrow.createCell(0);
			currentcell.setCellValue(products.get(i).getText());
			Cell currentcell1=currentrow.createCell(1);
			currentcell1.setCellValue(prices.get(i).getText());
			FileOutputStream fo=new FileOutputStream(help.filepath1);
			help.wb1.write(fo);
			flag=1;
			help.newcell(25, 3, "P");
			}
			catch(Exception e) {
				help.newcell(25, 3, "F");
				flag=2;
			}
		}help.wb1.close();
	}
	
	@AfterStep
	
	public void after_step() throws Throwable {
		
		
		System.out.println("after each step");
		if(flag==1) {
			test.log(Status.PASS, "Test case is passed");
		}
		else {
			test.log(Status.FAIL, "Test case is failed");
		}report.flush();
		
	}
	
	
	@After
	public void after() {
		driver.quit();
	}
	}
	
	

