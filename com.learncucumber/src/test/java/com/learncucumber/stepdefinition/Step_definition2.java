package com.learncucumber.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_definition2 {
	WebDriver driver;
	
	@Given("^I open browser and login to flipkart$")
	public void i_open_browser_and_login_to_flipkart() throws Throwable {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumesh\\eclipse-workspace\\com.learncucumber\\chromedriver1.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	    driver.get("https://www.flipkart.com/");
	    	}

	@Given("I tried logging in with my credentials {string},{string}")
	public void i_tried_logging_in_with_my_credentials(String uname,String pwd) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@autocomplete='off'][@class='_2IX_2- VJZDxU']")).sendKeys(uname);
	    driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
	    //driver.findElement(By.xpath("//button[span='Login']")).click();
	}
	@When("^I get an error$")
	public void i_get_an_error() {
	    
	    if(driver.findElement(By.xpath("//span[contains(text(),'incorrect')]")).isDisplayed()) {
	    	System.out.println("Error in credentials");
	    	//bo=true;
	    	
	    }
	    //else {
		//	bo=false;
		//}
	   //return bo; 
	}
	@Then("I try login with OTP option {string},{string},{string},{string},{string},{string},{string}")
	public void i_try_login_with_otp_option(String uname,String otp1,String otp2,String otp3,String otp4,String otp5,String otp6) {
		
			System.out.println("Logging in with OTP");
			driver.findElement(By.xpath("//button[contains(text(),'OTP')]")).click();
			try{
			String st=driver.findElement(By.xpath("//span[@class='_2eL2SZ']")).getText();
			if(st.contains(uname)) {
			Thread.sleep(50000);
			List<WebElement>otps=driver.findElements(By.xpath("//input[@class='_2IX_2- _1WRfas']"));
			otps.get(0).sendKeys(otp1);
			otps.get(1).sendKeys(otp2);
			otps.get(2).sendKeys(otp3);
			otps.get(3).sendKeys(otp4);
			otps.get(4).sendKeys(otp5);
			otps.get(5).sendKeys(otp6);
			Thread.sleep(15000);
			}
			else {
				System.out.println("Logging in with wrong uname");
			}
			}
			catch(Exception e){
				List<WebElement>otps=driver.findElements(By.xpath("//input[@class='_2IX_2- _1WRfas']"));
				otps.get(0).sendKeys(otp1);
				otps.get(1).sendKeys(otp2);
				otps.get(2).sendKeys(otp3);
				otps.get(3).sendKeys(otp4);
				otps.get(4).sendKeys(otp5);
				otps.get(5).sendKeys(otp6);
			}
		}
	@Then("OTP login was sucessful {string} or {string}")
	public void otp_login_was_sucessful(String user_name,String my_acc) throws Exception,NoSuchElementException {
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
	    try{
	    	driver.findElement(By.xpath("//*[text()="+"'"+user_name+"'"+"]")).isDisplayed(); 
	    	System.out.println("Login was successful");
	    }
	    catch(Exception e) {
	    	driver.findElement(By.xpath("//*[text()="+"'"+my_acc+"'"+"]") ).isDisplayed();
	    	System.out.println("Login was successful for member with no sign up information");
	    }
	}


}
