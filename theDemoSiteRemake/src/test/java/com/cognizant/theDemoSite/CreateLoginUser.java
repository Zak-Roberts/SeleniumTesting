package com.cognizant.theDemoSite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateLoginUser {

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

	@Test
	// creates user then tries to login as created user
	public void createLoginUser() throws InterruptedException {
		
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/addauser.php");
		
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		createUserPage.createUser("ZakRoberts", "password");
		
		driver.get("http://thedemosite.co.uk/login.php");
		LoginUserPage loginUserPage = PageFactory.initElements(driver, LoginUserPage.class);
		loginUserPage.enterUser("ZakRoberts", "password");
		
		String login = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText();
		Assert.assertEquals("Login not successful", true, login.contains("**Successful Login**"));
	}

}
