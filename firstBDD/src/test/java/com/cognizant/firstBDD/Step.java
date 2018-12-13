package com.cognizant.firstBDD;

import java.util.List;

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

public class Step {

	WebDriver driver;

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

	@Given("^the correct web address$")
	public void the_correct_web_address() {

		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		Assert.assertEquals("Home website not correct!", "http://automationpractice.com/index.php",
				driver.getCurrentUrl());

	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() {

		WebElement menuButton = driver.findElement(By.linkText("Women"));
		menuButton.click();

		Assert.assertEquals("Menu website not correct!",
				"http://automationpractice.com/index.php?id_category=3&controller=category", driver.getCurrentUrl());

	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {

		WebElement list = driver.findElement(By.cssSelector("ul[class=\"product_list grid row\""));
		List<WebElement> list1 = driver.findElements(By.cssSelector("ul[class=\"product_list grid row\""));

		Assert.assertEquals("no product list found!", list1.size() > 0, list.isDisplayed());

	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {

		WebElement cart = driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a"));
		cart.click();

	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {

		Assert.assertEquals("You've not gone to the cart!", "http://automationpractice.com/index.php?controller=order",
				driver.getCurrentUrl());

	}

}
