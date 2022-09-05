package com.learncucumber.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	//WebDriver driver;
	public static WebDriver browser(WebDriver driver) throws Throwable{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumesh\\git\\Ecommerce_Cucymber_Project\\com.learncucumber\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	    driver.get("https://www.flipkart.com/");
	    return driver;
	}


}
