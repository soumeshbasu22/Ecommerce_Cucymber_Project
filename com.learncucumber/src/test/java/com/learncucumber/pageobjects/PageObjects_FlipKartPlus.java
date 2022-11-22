package com.learncucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjects_FlipKartPlus {
	
	public WebDriver driver;
	public static By explorePlus_link=By.xpath("//a[@class='_21ljIi']");
	public static By coin_bal_link=By.xpath("//img[@src='https://rukminim1.flixcart.com/lockin/100/11/images/Non-Member_02_DT_post_upgrade.jpg?q=50']");
	public static By coin_balance_display=By.xpath("//div[text()='SuperCoin Balance']");
	
	public PageObjects_FlipKartPlus(WebDriver driver) {
		this.driver=driver;
	}
	
	public void flipkart_plus() {
		driver.findElement(explorePlus_link).click();
		driver.findElement(coin_bal_link).click();
	}
}
