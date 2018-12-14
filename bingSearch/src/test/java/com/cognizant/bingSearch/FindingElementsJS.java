package com.cognizant.bingSearch;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindingElementsJS {

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
	public void bingSearch() throws InterruptedException, IOException {
		
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
		driver.findElement(By.id("sb_form_q")).sendKeys("hello");
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("document.getElementById(\"sb_form_q\").value = 'changed' ;");	// changes value in search 
//		can't print this as it returns an object (not a string or anything printable)
		
	}

	
}
