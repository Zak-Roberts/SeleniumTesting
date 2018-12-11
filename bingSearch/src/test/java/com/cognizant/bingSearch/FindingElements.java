package com.cognizant.bingSearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FindingElements {

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
	public void bingSearch() throws InterruptedException {
		driver.get("https://www.bing.com/");
		BingLandingPage bingLandingPage = PageFactory.initElements(driver, BingLandingPage.class);
		BingSearchedPage bingSearchedPage = PageFactory.initElements(driver, BingSearchedPage.class);
		
		bingLandingPage.searchBing("Selenium");
		
		Assert.assertEquals("Selenium", bingSearchedPage.getSearch().getText());	
	}
	
}
