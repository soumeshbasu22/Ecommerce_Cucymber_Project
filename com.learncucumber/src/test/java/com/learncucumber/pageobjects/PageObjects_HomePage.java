package com.learncucumber.pageobjects;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpConnection;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.learncucumber.stepdefinition.BaseClass;
import com.learncucumber.utility.ExcelDataProvider;
import com.learncucumber.utility.ExcelDataProvider_2;
import com.learncucumber.utility.Helper;

public class PageObjects_HomePage {
	public WebDriver driver;
	
	public By myaccount=By.xpath("//*[text()='My Account']");
	public By myprofile=By.xpath("//*[text()='My Profile']");
	public By myacclist=By.xpath("//*[@class='_3vhnxf']");
	public By category=By.xpath("//*[@class='xtXmba']");
	public static By uname=By.xpath("//input[@autocomplete='off'][@class='_2IX_2- VJZDxU']");
	public static By pwd=By.xpath("//input[@type='password']");
	By loginbutton=By.xpath("//button[span='Login']");
	public static By searchbar=By.xpath("//*[@name='q']");
	public static By searchbutton=By.xpath("//*[@class='L0Z3Pu']");
	public By add_to_cart=By.xpath("//*[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	public By place_order_button=By.xpath("//*[text()='Place Order']");
	public int flag;
	public List<WebElement> product(String prod_name) {
		return driver.findElements(By.xpath("//*[contains(@href,'"+prod_name.toLowerCase()+"')]"));
	}
	//public By categoryimg=By.xpath("//*[@class='_396cs4  _3exPp9']");
	Helper help;
	BaseClass bc;
	ExcelDataProvider_2 edp2;
	public PageObjects_HomePage(WebDriver driver) throws Throwable {
		this.driver=driver;
	}
	
	public void login(String user,String password) {
		driver.findElement(uname).sendKeys(user);
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void loginclick() {
		driver.findElement(loginbutton).click();
	}
	
	public int click() throws Exception {
		int flag=0;
		List<WebElement>categoryclick=driver.findElements(category);
		for(int i=0;i<=categoryclick.size()-1;i++) {
			try {
			categoryclick.get(i).click();
			Thread.sleep(5000);
			driver.navigate().back();
			flag=1;
			}
			catch(Exception e){
				System.out.println("in catch block");
				help=new Helper();
				help.newcell(19, 3, "F");
				flag=2;
				
			}
			
			
			
		}
		return flag;
	}
	
	public boolean landingpage(String username,String myacc ) throws Exception {
		driver.navigate().refresh();
		Thread.sleep(2000);
		boolean bo;
	    try{
	    	driver.findElement(By.xpath("//*[text()="+"'"+username+"'"+"]")).isDisplayed(); 
	    	System.out.println("Login was successful");
	    	bo=true;
	    }
	    catch(Exception e) {
	    	driver.findElement(By.xpath("//*[text()="+"'"+myacc+"'"+"]") ).isDisplayed();
	    	System.out.println("Login was successful for member with no sign up information");
	    	bo=true;
	    }
	   return bo;
	}
	
	public void search_to_order() throws Throwable {
		driver.navigate().refresh();
		edp2=new ExcelDataProvider_2();
		PageObjects_HomePage poh=new PageObjects_HomePage(driver);
		int rownum=edp2.sh1.getLastRowNum()-edp2.sh1.getFirstRowNum();
		System.out.println(rownum);
		String element_to_search="Watches";
		driver.findElement(searchbar).sendKeys(element_to_search);
		Thread.sleep(5000);
		driver.findElement(searchbutton).submit();
		Thread.sleep(3000);
		for(int i=1;i<=rownum;i++) {
			String brand=edp2.brand_name(i);
			for(int j=0;j<10;j++) {
				
			try {
			
			List<WebElement>prods=poh.product(brand);
			
			if(prods.get(0).isDisplayed()) {
				prods.get(0).click();
				
			}
			
			Thread.sleep(5000);
			break;
			}
			catch(Exception e) {
				System.out.println(brand+" not found in this page");
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				
			}
			
		}
		}
	}
	
	public void order() {
		driver.findElement(add_to_cart).click();
		driver.findElement(place_order_button).click();
	}
	
	public int verifylink(String linkurl) throws Exception {
		int count=0;
		try {
		URL url=new URL(linkurl);
		HttpURLConnection http=(HttpURLConnection)url.openConnection();
		http.setConnectTimeout(2000);
		http.connect();
		
		if(http.getResponseCode()==200) {
			System.out.println("Not broken link");
			count+=1;
			System.out.println(count);
			
		}
		
		}
		catch(Exception e) {
			
		}
		System.out.println(count);
		return count;
	}
	}
