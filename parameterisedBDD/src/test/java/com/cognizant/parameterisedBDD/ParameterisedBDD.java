package com.cognizant.parameterisedBDD;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParameterisedBDD {

	WebDriver driver;

//	static int counter = 0;
//	@Before
//	public static void initial () {
//		if (counter == 0) {
//			// do BeforeClass logic
//			counter++;
//		}
//	}
	
	String arg;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) {
		driver.get(arg1);
		
		Assert.assertEquals("not gone to specified website!",arg1, driver.getCurrentUrl());
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {

		WebElement searchBox = driver.findElement(By.id("sb_form_q"));
		searchBox.sendKeys(arg1);
		searchBox.submit();
		Thread.sleep(1000);
		arg = arg1;

	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() {

		WebElement searchBox2 = driver.findElement(By.id("sb_form_q"));
		String searchBox3 = searchBox2.getAttribute("value");
		
		Assert.assertEquals("not searched for search term!", arg , searchBox3);
		
	}
}