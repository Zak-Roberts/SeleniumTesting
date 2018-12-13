package com.cognizant.cookieClicker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CCJS {

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
	public void click() throws InterruptedException {
		
		driver.get("http://orteil.dashnet.org/cookieclicker");
		Thread.sleep(2000);
		
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("Game.RuinTheFun();");
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
		Thread.sleep(2000);
		while (true) {}
	}
}
