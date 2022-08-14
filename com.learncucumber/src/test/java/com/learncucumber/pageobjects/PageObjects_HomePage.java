package com.learncucumber.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageObjects_HomePage {
	WebDriver driver;
	public By myaccount=By.xpath("//*[text()='My Account']");
	public By myprofile=By.xpath("//*[text()='My Profile']");
	public By myacclist=By.xpath("//*[@class='_3vhnxf']");
	public By category=By.xpath("//*[@class='xtXmba']");
	//public By categoryimg=By.xpath("//*[@class='_396cs4  _3exPp9']");
	
	public PageObjects_HomePage(WebDriver driver){
		
		this.driver=driver;
		
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
				//categoryclick.get(i).click();
				//categoryclick.get(i).click();
				//Thread.sleep(5000);
				//driver.navigate().refresh();
				Thread.sleep(5000);
				Actions a=new Actions(driver);
				a.moveToElement(categoryclick.get(i)).build().perform();
				categoryclick.get(i).click();
				Thread.sleep(5000);
				driver.navigate().back();
				
			}
			
			
			
		}
	}
}
