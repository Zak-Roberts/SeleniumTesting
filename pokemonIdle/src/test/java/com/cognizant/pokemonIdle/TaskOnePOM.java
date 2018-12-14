package com.cognizant.pokemonIdle;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TaskOnePOM {
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@Test
	public void TaskOneTest() throws InterruptedException {
		
		WebDriver driver = TestRunner.driver;
		driver.get("http://ishadijcks.github.io/");
		Thread.sleep(1000);
		
		TaskOneFirstPage taskOneFirstPage = PageFactory.initElements(driver, TaskOneFirstPage.class);
		taskOneFirstPage.startAdventure();
		
	}
	
}
