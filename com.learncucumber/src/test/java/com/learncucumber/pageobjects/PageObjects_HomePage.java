package com.learncucumber.pageobjects;

import java.util.List;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.learncucumber.baseclass.BaseClass;
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
	//public By categoryimg=By.xpath("//*[@class='_396cs4  _3exPp9']");
	Helper help;
	BaseClass bc;
	public PageObjects_HomePage(WebDriver driver) throws Throwable {
		//bc=new BaseClass();
		this.driver=driver;
	}
	
	public void login(String user,String password) {
		driver.findElement(uname).sendKeys(user);
		driver.findElement(pwd).sendKeys(password);
	}
	
	public void loginclick() {
		driver.findElement(loginbutton).click();
	}
	
	public void click() throws Exception {
		List<WebElement>categoryclick=driver.findElements(category);
		for(int i=0;i<=categoryclick.size()-1;i++) {
			try {
			categoryclick.get(i).click();
			Thread.sleep(5000);
			driver.navigate().back();
			}
			catch(Exception e){
				System.out.println("in catch block");
				help=new Helper();
				help.newcell(5, 2, "F");
				
				
			}
			
			
			
		}
	}
	}
